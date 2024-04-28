package com.MySociety.Security.service;

import com.MySociety.Security.Repository.UserRepository;
import com.MySociety.Security.config.AuthenticationResponse;
import com.MySociety.Security.model.User;
import com.MySociety.Security.service.JwtService;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.sql.SQLOutput;

@Service
public class AuthenticationService
{
    private final UserRepository userRepository;

    private final PasswordEncoder passwordEncoder;

    private final JwtService jwtService;

    private final AuthenticationManager authenticationManager;



    public AuthenticationService(UserRepository userRepository, PasswordEncoder passwordEncoder, JwtService jwtService, AuthenticationManager authenticationManager) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
        this.jwtService = jwtService;
        this.authenticationManager = authenticationManager;
    }


    public AuthenticationResponse register(User req){

        User user = new User();

        user.setFirstname(req.getFirstname());
        user.setLastName(req.getLastName());
        user.setUserName(req.getUsername());
        System.out.println("password is" + req.getPassword());
        user.setPassword(passwordEncoder.encode(req.getPassword()));

        user.setRole(req.getRole());

        userRepository.save(user);

        String token = jwtService.generateToken(user);
        return new AuthenticationResponse(token);

    }


    public AuthenticationResponse authenticate(User req){
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        req.getUsername() , req.getPassword()
                )
        );
        User user = userRepository.findByuserName(req.getUsername())
                .orElseThrow(()-> new NullPointerException("User is invalid"));
        System.out.println("User is "+user);
        String token = jwtService.generateToken(user);
        System.out.println("Token is " +token);
        return new AuthenticationResponse(token);
    }
}
