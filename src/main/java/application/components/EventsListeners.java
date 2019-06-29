package application.components;

import application.json.Project;
import application.services.RestService;
import com.atlassian.connect.spring.AddonInstalledEvent;
import org.codehaus.jackson.map.DeserializationConfig;
import org.codehaus.jackson.map.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

import java.util.List;


@Component
public class EventsListeners {
    @Autowired
    RestService rs;

    @EventListener
    public void addonInstalled(AddonInstalledEvent event) {
        System.out.println(event.toString());
        List<Project> projects = rs.getProjects(event.getHost().getBaseUrl());
        System.out.println(projects);

        ObjectMapper mapper = new ObjectMapper();
        mapper.configure(DeserializationConfig.Feature.ACCEPT_SINGLE_VALUE_AS_ARRAY, true);
        mapper.configure(DeserializationConfig.Feature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        String projectsAndRoles = new String();
        projectsAndRoles = "{";
        try {
            projectsAndRoles += "\"projects\":" + mapper.writeValueAsString(projects);
            projectsAndRoles += ",";
        } catch (Exception e){
        }

        String allProjectsRolesData = rs.getAllProjectsRoles(event.getHost().getBaseUrl());
        projectsAndRoles += allProjectsRolesData;
        projectsAndRoles += "}";

        System.out.println(projectsAndRoles);

        String issues = rs.getAllIssues(event.getHost().getBaseUrl());
        System.out.println(issues);

    }
}
