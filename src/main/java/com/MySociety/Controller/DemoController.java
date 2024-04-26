package com.MySociety.Controller;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DemoController {

    @GetMapping("/demo")
    public ResponseEntity<String> getMessage(){
        return new ResponseEntity<String>("this is secured access", HttpStatus.OK);
    }

    @GetMapping("/status")
    public ResponseEntity<String> getStatus(){
        return new ResponseEntity<String>("This is status msg", HttpStatus.OK);
    }
}
