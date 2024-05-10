package com.MySociety.Admin;

import com.MySociety.Entity.Admin;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController()
@RequestMapping("/admin")
public class adminController {

    @Autowired
    private adminService adminservice;

    @PostMapping("/postAdminData")
    public ResponseEntity<Admin> postAdminData(@RequestBody Admin admin)
    {
        Admin a=adminservice.postAdminData(admin);


        return new ResponseEntity<Admin>(a, HttpStatus.CREATED);

    }

    @GetMapping("/getallAdminData")
    public ResponseEntity<List<Admin>> getallAdminData()
    {
        List allData=adminservice.getallAdminData();
        return new ResponseEntity<List<Admin>>(allData,HttpStatus.OK );

    }

    @GetMapping("/getAdminData/{id}")
    public ResponseEntity<Admin> getAdminDatabyId(@PathVariable int id)
    {
       Admin databyid= adminservice.getAdminDatabyId(id);
       return new ResponseEntity<Admin>(databyid,HttpStatus.OK);
    }

    @DeleteMapping("/deleteAdminData/{id}")
    public ResponseEntity<String> deleteAdminData(@PathVariable("id") int id)
    {
       adminservice.deleteAdminData(id);
        return  ResponseEntity.ok("Admin Data Deleted Successfully");
    }

    @PutMapping("/updateAdminData/{id}")
    public  ResponseEntity<Admin> updateAdminData(@RequestBody Admin admin, @PathVariable("id") int id)
    {

        Admin updatedata = adminservice.updateAdminData(admin,id);
        return  new ResponseEntity<Admin>(updatedata, HttpStatus.OK);

    }



}