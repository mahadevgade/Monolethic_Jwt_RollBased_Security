package com.MySociety.Admin;

import com.MySociety.Entity.Admin;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class adminServiceImpl implements adminService{

    @Autowired
 public adminRepository adminRepo;

    @Override
    public Admin postAdminData(Admin admin) {
        return adminRepo.save(admin);
    }

    @Override
    public List getallAdminData() {
        return adminRepo.findAll();
    }

    @Override
    public Admin getAdminDatabyId(int id) {
        return adminRepo.findById(id).orElseThrow();
    }

    @Override
    public void deleteAdminData(int id) {

        this.adminRepo.deleteById(id);
    }

    @Override
    public Admin updateAdminData(Admin admin, int id)
    {
            Admin newadmin =adminRepo.findById(id).orElseThrow(()->new NullPointerException());

            newadmin.setFirstname(admin.getFirstname());
            newadmin.setLastname(admin.getLastname());
            newadmin.setEmailId(admin.getEmailId());
            newadmin.setMobileNumber(admin.getMobileNumber());
            newadmin.setAddress(admin.getAddress());
            newadmin.setCity(admin.getCity());

           Admin admin1= adminRepo.save(newadmin);

            return admin1;
    }




}
