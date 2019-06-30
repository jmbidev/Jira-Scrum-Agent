package application.controllers;

import application.response.*;
import application.services.CurrentUserService;
import com.atlassian.connect.spring.IgnoreJwt;
import org.codehaus.jackson.map.DeserializationConfig;
import org.codehaus.jackson.map.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import application.services.RequestService;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

import application.agentlogic.Agent;


@Controller
@CrossOrigin(origins = "*", methods = {RequestMethod.GET})
public class AgentController {
    @Autowired
    Agent agent;

    @Autowired
    CurrentUserService currentUserService;

    @Autowired
    RequestService requestService;


    @RequestMapping(value = "/agent/assign-issues", method = RequestMethod.GET, produces = "application/json")
    @IgnoreJwt
    public ResponseEntity assignIssues() {
        System.out.println("Estoy en Assign Issues");


        String responseIssues = requestService.sendGetRequest("http://localhost:8080/data/issues/"); // te traes las issues
        String responseUsers = requestService.sendGetRequest("http://localhost:8080/data/users/"); // te traes las issues

        System.out.println(responseIssues);
        System.out.println(responseUsers);

        ObjectMapper mapper = new ObjectMapper();
        mapper.configure(DeserializationConfig.Feature.ACCEPT_SINGLE_VALUE_AS_ARRAY, true);
        mapper.configure(DeserializationConfig.Feature.FAIL_ON_UNKNOWN_PROPERTIES, false);

        List<IssueResponse> issues = new ArrayList<>();
        List<UsuarioResponse> users = new ArrayList<>();
        try {
            issues = mapper.readValue(responseIssues, mapper.getTypeFactory().constructCollectionType(List.class, IssueResponse.class));
            users = mapper.readValue(responseUsers, mapper.getTypeFactory().constructCollectionType(List.class, UsuarioResponse.class));
        } catch (IOException e) {
            e.printStackTrace();
        }


        /** Asignar tareas. Se obtiene un HashMap con pares <IssueID, UserID> **/
        HashMap<IssueResponse, UsuarioResponse> issuesAsignadas = agent.AssignIssues(issues, users);


        /** Pasar de HashMap a una lista de IssueUserResponse **/
        List<IssueUserResponse> response = new LinkedList<>();

        for (IssueResponse issue :
                issuesAsignadas.keySet()) {
            UsuarioResponse user = issuesAsignadas.get(issue);

            IssueUserResponse issueUserResponse = new IssueUserResponse();
            issueUserResponse.setUsuarioResponse(user);
            issueUserResponse.setIssueResponse(issue);

            response.add(issueUserResponse);
        }


        try {
            System.out.println(mapper.writeValueAsString(response));
        } catch (IOException e) {
            e.printStackTrace();
        }

        /** Hacer el json con formato IssueUserResponse  y retornarlo. **/

        return new ResponseEntity(response, HttpStatus.OK);
    }

    //chequear si es developer o no
    @RequestMapping(value = "/agent/check-user-rol",method = RequestMethod.GET, produces = "application/json")
    @IgnoreJwt
    public ResponseEntity checkUserRol() {
        System.out.println("Estoy en agent/check-user-role");

        String responseRol = requestService.sendGetRequest("http://localhost:8080/data/check-role/" + currentUserService.getUser().getUserAccountId() + "/");

        System.out.println(responseRol);


        ObjectMapper mapper = new ObjectMapper();
        mapper.configure(DeserializationConfig.Feature.ACCEPT_SINGLE_VALUE_AS_ARRAY, true);
        mapper.configure(DeserializationConfig.Feature.FAIL_ON_UNKNOWN_PROPERTIES, false);


        RolResponse rolResponse = new RolResponse();

        try {
            rolResponse = mapper.readValue(responseRol, RolResponse.class);
        } catch (IOException e) {
            e.printStackTrace();
        }


        if ((rolResponse.getRol().toLowerCase() == "administrator") || (rolResponse.getRol().toLowerCase() == "administrators"))
            rolResponse.setRol("scrum master");
        if (rolResponse.getRol().toLowerCase() == "member")
            rolResponse.setRol("developer");


        return new ResponseEntity(rolResponse, HttpStatus.OK);
    }

    @RequestMapping(value = "/agent/show-issues",method = RequestMethod.GET, produces = "application/json")
    @IgnoreJwt
    public ResponseEntity showIssues() {
        System.out.println("Estoy en agent/show-issues");
        String response = requestService.sendGetRequest("http://localhost:8080/data/my-issues-not-evaluated/" + currentUserService.getUser().getUserAccountId());

        System.out.println(response);


        ObjectMapper mapper = new ObjectMapper();
        mapper.configure(DeserializationConfig.Feature.ACCEPT_SINGLE_VALUE_AS_ARRAY, true);
        mapper.configure(DeserializationConfig.Feature.FAIL_ON_UNKNOWN_PROPERTIES, false);


        List<IssueResponse> issues = new ArrayList<>();
        try {
            issues = mapper.readValue(response, List.class);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return new ResponseEntity(issues, HttpStatus.OK);
    }


    @RequestMapping(value = "/agent/evaluate/{id}/{puntaje}",method = RequestMethod.GET, produces = "application/json")
    @IgnoreJwt
    public ResponseEntity evaluate(@PathVariable Integer id, @PathVariable Integer puntaje){
        System.out.println("Estoy en agent/evaluate");

       String responseEvaluation = requestService.sendRequest("http://localhost:8080/data/score-issue/" + id + "/" + puntaje + "/", "");


        System.out.println(responseEvaluation);


        ObjectMapper mapper = new ObjectMapper();
        mapper.configure(DeserializationConfig.Feature.ACCEPT_SINGLE_VALUE_AS_ARRAY, true);
        mapper.configure(DeserializationConfig.Feature.FAIL_ON_UNKNOWN_PROPERTIES, false);

        IssueResponse response = new IssueResponse();
        try {
            response = mapper.readValue(responseEvaluation, IssueResponse.class);
        }catch (IOException e){
            e.printStackTrace();
        }

        return new ResponseEntity(response, HttpStatus.OK);
    }


}
