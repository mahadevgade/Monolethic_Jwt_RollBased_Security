package com.MySociety.Owner.serviceimpl;

import com.MySociety.Entity.Flat;
import com.MySociety.Entity.Owner;
import com.MySociety.Owner.repository.OwnerRepo;
import com.MySociety.Owner.service.Ownerservice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class Ownerserviceimpl implements Ownerservice {
@Autowired
    OwnerRepo Or;
//save owner
    @Override
    public Owner save(Owner o) {
        return Or.save(o);
    }
//get owner
    @Override
    public List<Owner> getowner() {
        return Or.findAll();
    }

    //get by id
    @Override
    public Owner getbyid(int id) {
        Optional<Owner> owner=Or.findById(id);
       return owner.get();
    }

    //upadte owner
    @Override
    public Owner updateowner(Owner owner,int id) {
        Owner updateowner=this.Or.findById(id).orElseThrow(()->new NullPointerException("Owner not found"));
        updateowner.setFirstname(owner.getFirstname());
        updateowner.setLastname(owner.getLastname());
        updateowner.setCity(owner.getCity());
        updateowner.setEmail(owner.getEmail());
        updateowner.setMobno(owner.getMobno());
        updateowner.setAddress(owner.getAddress());

        String flatno=owner.getFlat().getFlatno();
        char wing=owner.getFlat().getWing();

        Flat flat=new Flat();
        flat.setFlatno(flatno);
        flat.setWing(wing);

        updateowner.setFlat(flat);

        return Or.save(updateowner);
    }

    //delete onwer
    @Override
    public void deletedata(int id) {
        Or.deleteById(id);
    }


}
