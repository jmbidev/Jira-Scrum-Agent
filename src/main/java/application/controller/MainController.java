package application.controller;

import com.atlassian.connect.spring.AtlassianHostUser;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class MainController {

    @RequestMapping(value = "/home/home", method = RequestMethod.GET)
    @ResponseBody
    public String helloWorld(@AuthenticationPrincipal AtlassianHostUser hostUser){
        return "Hello world";
    }


}
