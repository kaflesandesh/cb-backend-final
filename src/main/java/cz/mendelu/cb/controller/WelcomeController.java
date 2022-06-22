package cz.mendelu.cb.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class WelcomeController {
    @RequestMapping({"/", "/cb"})
    String home() {
        return "Hello user! welcome to the system.";
    }
}
