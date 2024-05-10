package com.MySociety.Manager.Service;

import com.MySociety.Entity.Manager;
import com.MySociety.Manager.Repository.ManagerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ManagerServiceImpl implements ManagerService{

    @Autowired
    private ManagerRepository managerRepo;

    @Override
    public Manager addDetails(Manager manager) {
        Manager managerObj = managerRepo.save(manager);
        return managerObj;
    }

    @Override
    public List<Manager> getAllDetails() {
        return managerRepo.findAll();
    }

    @Override
    public Manager getByIdDetails(Integer id) {
        Optional<Manager> manager = managerRepo.findById(id);
        if (manager.isPresent())
        {
            return manager.get();
        }
        return null;
    }

    @Override
    public Manager updateDetails(Manager manager,Integer id) {

        Manager managerObj = managerRepo.findById(id).orElseThrow(()->new NullPointerException());

        managerObj.setFirstname(manager.getFirstname());
        managerObj.setLastName(manager.getLastName());
        managerObj.setEmail(manager.getEmail());
        managerObj.setAddress(manager.getAddress());
        managerObj.setMobileNo(manager.getMobileNo());
        managerObj.setCity(manager.getCity());

        Manager newManager = managerRepo.save(managerObj);
        return newManager;
    }

    @Override
    public void deleteDetails(Integer id) {

        this.managerRepo.deleteById(id);
    }
}
