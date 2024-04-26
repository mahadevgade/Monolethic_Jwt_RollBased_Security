package com.MySociety.Security.Repository;

import com.MySociety.Security.model.Role;
import com.MySociety.Security.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User , Integer>
{
    Optional<User> findByuserName(String username);

}
