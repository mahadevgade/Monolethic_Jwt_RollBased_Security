package com.MySociety.Controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/admin")
public class AdminController {


    @GetMapping("/adminDetails")
    public ResponseEntity<String> getAdminDetails(){
        return ResponseEntity.ok("This is Admin API, only admin can access it");
    }
}
