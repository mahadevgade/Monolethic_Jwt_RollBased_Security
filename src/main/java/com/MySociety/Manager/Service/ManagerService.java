package com.MySociety.Manager.Service;

import com.MySociety.Entity.Manager;

import java.util.List;

public interface ManagerService {

    // Insert Manager Details Record

    public Manager addDetails(Manager manager);

    // Get All Manager Details Record

    public List<Manager> getAllDetails();

    // Get By ID Manager Details Record

    public Manager getByIdDetails(Integer id);

    // Update Manager Details Record

    public Manager updateDetails(Manager manager,Integer id);

    // Delete Manager Details Record

    public void deleteDetails(Integer id);





}
