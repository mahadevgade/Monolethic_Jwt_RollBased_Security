package com.MySociety.Admin;

import com.MySociety.Entity.Admin;

import java.util.List;

public interface adminService {

    //Insert Admin Data

    public Admin postAdminData(Admin admin);

    //Retrive all Data of Admin

    public List getallAdminData();

    //Retrive Admin Data by id

    public Admin getAdminDatabyId(int id);

    //Delete Admin Data

    public void   deleteAdminData(int id);

    //Update Admin Data
    public Admin updateAdminData(Admin admin,int id);
}
