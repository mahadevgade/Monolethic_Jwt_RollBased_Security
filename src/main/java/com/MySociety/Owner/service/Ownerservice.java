package com.MySociety.Owner.service;

import com.MySociety.Entity.Owner;

import java.util.List;

public interface Ownerservice {

//save owner
   public  Owner save(Owner o);

   //get owner
     public List<Owner> getowner();

     //get owner by id
     public Owner getbyid(int id);

     //update owner
   public Owner updateowner(Owner owner,int id);

   //delete owner
     public void deletedata(int id);
}
