package com.MySociety.Owner.repository;

import com.MySociety.Entity.Owner;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OwnerRepo  extends JpaRepository<Owner,Integer> {

}
