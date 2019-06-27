package application.controllers;

import com.atlassian.connect.spring.AtlassianHostUser;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/")
public class MainController {

    @RequestMapping(value = "/home", method = RequestMethod.GET)
    @ResponseBody
    public ModelAndView helloWorld(@AuthenticationPrincipal AtlassianHostUser hostUser){
        // TODO: Almacenar ID Usuario en una variable de sesion
        ModelAndView model = new ModelAndView();
        model.setViewName("JiraAngular/index.html");
        return model;
    }
}
