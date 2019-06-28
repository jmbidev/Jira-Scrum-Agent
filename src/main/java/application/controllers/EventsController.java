package application.controllers;

import application.json.Issue;
import application.json.Project;
import application.json.ProjectRole;
import application.services.CurrentUserService;
import application.services.RestService;

import org.codehaus.jackson.map.DeserializationConfig;
import org.codehaus.jackson.map.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.LinkedList;
import java.util.List;


@Controller
@RequestMapping("/")
public class EventsController {
    @Autowired
    RestService restService;

    @Autowired
    CurrentUserService currentUserService;

    @RequestMapping(value = "/webhooks/issue", consumes = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody ResponseEntity issue(@RequestBody String body){
        System.out.println("Estoy en issue");
        ObjectMapper mapper = new ObjectMapper();
        mapper.configure(DeserializationConfig.Feature.ACCEPT_SINGLE_VALUE_AS_ARRAY, true);
        mapper.configure(DeserializationConfig.Feature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        try {
            Issue issue = mapper.readValue(body, Issue.class);
            //System.out.println(issue.getId());
            String mapped = "{ \"issue\":" + mapper.writeValueAsString(issue);
            //System.out.println(mapped);
            List<ProjectRole> roles = restService.getAllRoles(issue.getHost());
            System.out.println(roles);
            List<Project> projects = restService.getProjects(issue.getHost());
            System.out.println(projects);
            mapped+= ",\"usersByProjectRole\":[";
            for (ProjectRole role : roles ) {
                if (role != null && !role.getName().equals("atlassian-addons-project-access")) {
                    for (Project project : projects) {
                        mapped += restService.getUsersInProjectByRol(issue.getHost(), project.getId(), role.getId());
                        mapped += ",";
                    }
                }
            }
            mapped = mapped.substring(0, mapped.length()-1);
            mapped += "]}";
            System.out.println(mapped);
        } catch(Exception e){
            e.printStackTrace();
        }
        return ResponseEntity.status(HttpStatus.OK).body(null);
    }

    @RequestMapping(value = "/webhooks/project")
    @ResponseBody
    public ResponseEntity project(@RequestBody String body) {
        System.out.println("Estoy en project");
        System.out.println(body);
        return ResponseEntity.status(HttpStatus.OK).body(null);
    }

    @RequestMapping(value = "/webhooks/user")
    @ResponseBody
    public ResponseEntity user(@RequestBody String body) {
        System.out.println("Estoy en user");
        System.out.println(body);
        return ResponseEntity.status(HttpStatus.OK).body(null);
    }

    @RequestMapping(value = "/webhooks/sprint")
    @ResponseBody
    public ResponseEntity sprint(@RequestBody String body) {
        System.out.println("Estoy en sprint");
        System.out.println(body);
        return ResponseEntity.status(HttpStatus.OK).body(null);
    }
}
