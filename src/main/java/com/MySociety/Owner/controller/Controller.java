package com.MySociety.Owner.controller;


import com.MySociety.Entity.Owner;
import com.MySociety.Owner.service.Ownerservice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("Owner")
public class Controller {
@Autowired
Ownerservice s;


//save owner
@PostMapping("/Save")
    public ResponseEntity<Owner> Saveowner(@RequestBody Owner o)
{
    Owner O1=s.save(o);
     return new ResponseEntity<Owner>(O1, HttpStatus.ACCEPTED);
}

//get owner
@GetMapping("/get")
    public ResponseEntity<List<Owner>> getowner()
{
    List<Owner> O2=s.getowner();
 return new ResponseEntity<List<Owner>>(O2,HttpStatus.OK);
}

//get owner by id
@GetMapping("/getbyid/{id}")
    public ResponseEntity<Owner> getbyid(@PathVariable int id)
{
    Owner O3=s.getbyid(id);
    return new ResponseEntity<Owner>(O3,HttpStatus.OK);
}

//update owner
@PutMapping("/updatedata/{id}")
    public ResponseEntity<Owner> updateowner(@PathVariable("id") int id,@RequestBody Owner owner)
{
    owner.setId(id);
    Owner  O4=s.updateowner(owner,id);
    return  new ResponseEntity<Owner>(O4,HttpStatus.ACCEPTED);
}

//delete owner 
@DeleteMapping("/deleteowner/{id}")
    public ResponseEntity<String> deletedata(@PathVariable("id") int id)
{
    s.deletedata(id);
    return new ResponseEntity<String>("Delete data Successfully of ID:"+id,HttpStatus.OK);
}




}
