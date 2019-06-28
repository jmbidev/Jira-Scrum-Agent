package application.services;

import application.json.Actor;
import application.json.Project;
import application.json.ProjectRole;
import application.json.User;
import com.atlassian.connect.spring.AtlassianHostRestClients;
import org.codehaus.jackson.map.DeserializationConfig;
import org.codehaus.jackson.map.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import java.util.*;


@Service
public class RestService {
    @Autowired
    AtlassianHostRestClients rc;

    @Async
    public void requestUsers(String host){

    }

    public String getUserByUserName(String username, String host){
        try {
            String response = rc.authenticatedAsAddon().getForObject(host + "/rest/api/3/user?username=" + username, String.class);
            return response;
        } catch (Exception e){
            System.out.println("RestService -> getUserByUserName exception: " + e.getMessage());
            return "";
        }
    }

    public User getUserByAccountId(String accountId, String host){
        System.out.println("Bringing user "+ accountId);
        try {
            User response = rc.authenticatedAsAddon().getForObject(host + "/rest/api/3/user?accountId=" + accountId, User.class);
            return response;
        } catch (Exception e){
            System.out.println("RestService -> getUserByAccountId exception: " + e.getMessage());
            return new User();
        }
    }

    public String getUsersInBulk(List<String > idList, String param, String host){
        StringBuilder params = new StringBuilder();
        for (int i = 0; i < idList.size()-1; i++){
            params.append(param).append('=').append(idList.get(i)).append('&');
        }
        if (idList.size() > 0)
            params.append(param).append('=').append(idList.get(idList.size()-1));

        try {
            String response = rc.authenticatedAsAddon().getForObject(host + "/rest/api/3/user/bulk?" + params, String.class);
            return response;
        } catch (Exception e){
            System.out.println("RestService -> getUserByAccountId exception: " + e.getMessage());
            return "";
        }
    }

    public String getProjectByProjectId(String id, String host){
        try {
            String response = rc.authenticatedAsAddon().getForObject(host + "/rest/api/3/project/" + id, String.class);
            return response;
        } catch (Exception e){
            System.out.println("RestService -> getProjectByProjectId exception: " + e.getMessage());
            return "";
        }
    }

    public List<Project> getProjects(String host){
        try {
            String response = rc.authenticatedAsAddon().getForObject(host + "/rest/api/3/project" , String.class);

            ObjectMapper mapper = new ObjectMapper();
            mapper.configure(DeserializationConfig.Feature.ACCEPT_SINGLE_VALUE_AS_ARRAY, true);
            mapper.configure(DeserializationConfig.Feature.FAIL_ON_UNKNOWN_PROPERTIES, false);

            List<LinkedHashMap> list = mapper.readValue(response, List.class);
            LinkedList<Project> result = new LinkedList<>();
            //System.out.println(list);
            for (LinkedHashMap lhm : list){
                Project project = new Project();
                project.setId(lhm.get("id").toString());
                project.setName(lhm.get("name").toString());
                project.setKey(lhm.get("key").toString());
                result.add(project);
            }
            return result;
        } catch (Exception e){
            System.out.println("RestService -> getProjectByProjectId exception: " + e.getMessage());
            return new LinkedList<Project>();
        }
    }

    public String getUsersInProjectByRol(String host, String project, String rol){
        try {
            ProjectRole response = rc.authenticatedAsAddon().getForObject(host + "/rest/api/3/project/"+ project+ "/role/" + rol, ProjectRole.class);

            ObjectMapper mapper = new ObjectMapper();
            mapper.configure(DeserializationConfig.Feature.ACCEPT_SINGLE_VALUE_AS_ARRAY, true);
            mapper.configure(DeserializationConfig.Feature.FAIL_ON_UNKNOWN_PROPERTIES, false);

            for (Actor actor : response.getActors()) {
                actor.setActorUser(getUserByAccountId(actor.getActorUser().getAccountId(), host));
            }

            return mapper.writeValueAsString(response);

        } catch (Exception e){
            System.out.println("RestService -> getProjectByProjectId exception: " + e.getMessage());
            return "";
        }
    }

    public List<ProjectRole> getAllRoles(String host){
        try {
            String response = rc.authenticatedAsAddon().getForObject(host + "/rest/api/3/role", String.class);

            ObjectMapper mapper = new ObjectMapper();
            mapper.configure(DeserializationConfig.Feature.ACCEPT_SINGLE_VALUE_AS_ARRAY, true);
            mapper.configure(DeserializationConfig.Feature.FAIL_ON_UNKNOWN_PROPERTIES, false);

            List<LinkedHashMap> list = mapper.readValue(response, List.class);
            LinkedList<ProjectRole> result = new LinkedList<>();
            //System.out.println(list);
            for (LinkedHashMap lhm : list){
                ProjectRole role = new ProjectRole();
                role.setSelf(lhm.get("self").toString());
                role.setId(lhm.get("id").toString());
                role.setName(lhm.get("name").toString());
                role.setDescription(lhm.get("description").toString());
                result.add(role);
            }
            return result;
        } catch (Exception e){
            System.out.println("RestService -> getProjectByProjectId exception: " + e.getMessage());
            e.printStackTrace();
        }
        return new LinkedList<>();
    }
}
