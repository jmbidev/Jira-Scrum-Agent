package application.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;


@Controller
@RequestMapping("/")
public class EventsController {

    @RequestMapping(value = "/installed")
    @ResponseBody
    public ResponseEntity installed(@RequestBody String body){
        System.out.println("Estoy en installed");
        System.out.println(body);
        return ResponseEntity.status(HttpStatus.OK).body(null);
    }

    @RequestMapping(value = "/webhooks/issue")
    @ResponseBody
    public ResponseEntity issue(@RequestBody String body){
        System.out.println("Estoy en issue");
        System.out.println(body);
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
