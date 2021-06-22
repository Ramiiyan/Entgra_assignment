package com.engratcp.demo.Controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController("/")
public class restAPIController {
    @GetMapping("test")
    public String Test(){
        return "Testing.";
    }

}
