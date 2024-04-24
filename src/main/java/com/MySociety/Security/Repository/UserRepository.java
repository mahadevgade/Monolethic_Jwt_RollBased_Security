package com.MySociety.Security.Repository;

import com.MySociety.Security.model.Role;
import com.MySociety.Security.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User , Integer>
{

}
