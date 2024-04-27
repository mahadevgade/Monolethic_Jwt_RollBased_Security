package com.MySociety.Controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class UserController {

    @GetMapping("/userDetails")
    public ResponseEntity<String> getUserDetails(){
        return new ResponseEntity<String>("This is user API , only user can access it" , HttpStatus.OK);
    }
}
