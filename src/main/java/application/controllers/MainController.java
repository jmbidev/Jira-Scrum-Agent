package application.controllers;

import com.atlassian.connect.spring.AtlassianHost;
import com.atlassian.connect.spring.AtlassianHostRepository;
import com.atlassian.connect.spring.AtlassianHostUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/")
public class MainController {

    @RequestMapping(value = "/home", method = RequestMethod.GET)
    public ResponseEntity<String> home(@AuthenticationPrincipal AtlassianHostUser hostUser){
        return new ResponseEntity<>(hostUser.toString(), HttpStatus.OK);
    }

}