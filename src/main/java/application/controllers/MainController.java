package application.controllers;

import application.services.CurrentUserService;
import com.atlassian.connect.spring.AtlassianHostUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/")
public class MainController {
    @Autowired
    CurrentUserService currentUserService;


    @RequestMapping(value = "/home", method = RequestMethod.GET)
    @ResponseBody
    public ModelAndView helloWorld(@AuthenticationPrincipal AtlassianHostUser hostUser){

        currentUserService.setUser(hostUser);

        // TODO: Almacenar ID Usuario en una variable de sesion
        ModelAndView model = new ModelAndView();
        model.setViewName("JiraAngular/index.html");
        return model;
    }
}
