package com.MySociety.Manager.Controller;

import com.MySociety.Entity.Manager;
import com.MySociety.Manager.Service.ManagerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/manager")
public class ManagerController {

    @Autowired
    private ManagerService managerService;

    @PostMapping("/save")
    public ResponseEntity<Manager> addDetails(@RequestBody Manager manager)
    {
        Manager status = managerService.addDetails(manager);
        return new ResponseEntity<>(status, HttpStatus.CREATED);
    }

    @GetMapping("/getall")
    public ResponseEntity<List<Manager>> getAllDetails()
    {
        List<Manager> managers = managerService.getAllDetails();
        return new ResponseEntity<>(managers,HttpStatus.OK);
    }

    @GetMapping(value = "/getbyid/{id}",produces = "application/json")
    public ResponseEntity<Manager> getByIdDetails(@PathVariable("id") Integer id)
    {
        Manager manager = managerService.getByIdDetails(id);
       return ResponseEntity.ok(manager);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<Manager> updateDetails(@RequestBody Manager manager, @PathVariable("id") Integer id)
    {
        Manager status = managerService.updateDetails(manager,id);
        return new ResponseEntity<Manager>(status,HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteDetails(@PathVariable("id") Integer id)
    {
        managerService.deleteDetails(id);
        return ResponseEntity.ok("Manager deleted successfully...");
    }
}
