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
        int index = body.indexOf("{field=");
        if (index > 0) {
            body = body.substring(0, index);
        }
        ObjectMapper mapper = new ObjectMapper();
        mapper.configure(DeserializationConfig.Feature.ACCEPT_SINGLE_VALUE_AS_ARRAY, true);
        mapper.configure(DeserializationConfig.Feature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        try {
            Issue issue = mapper.readValue(body, Issue.class);
            String mapped = "{ \"issue\":" + mapper.writeValueAsString(issue);
            mapped += ",";
            mapped += restService.getAllProjectsRoles(issue.getHost());
            mapped += "}";
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
