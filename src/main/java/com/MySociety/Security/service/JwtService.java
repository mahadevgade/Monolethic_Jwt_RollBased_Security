package com.MySociety.Security.service;

import com.MySociety.Security.model.User;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import javax.crypto.SecretKey;
import java.util.Date;
import java.util.function.Function;

@Service
public class JwtService {

    //secret key
    private String SERCRET_KEY ="6cbb2ad274e59b596c1c23de7ab5a3e2ea2793b15d55a35057f5736d77eb9588";

    //5
    public String extractUserName(String token){
        return extractClaims(token ,Claims::getSubject );
    }

    //6
    public boolean isValid(String token, UserDetails user){
      String userName  = extractUserName(token);
      return userName.equals(user.getUsername()) && !isTokenExpired(token);
    }

    //7
    private boolean isTokenExpired(String token){
        return extractExpiration(token).before(new Date());
    }


    //8
    private Date extractExpiration(String token){
        return extractClaims(token , Claims :: getExpiration);

    }


    //4
    public <T> T extractClaims(String token , Function<Claims , T> resolver){
        Claims claims
                = extractAllClaims(token);
        return resolver.apply(claims);
    }


    //3
    private Claims extractAllClaims(String token){
        return Jwts
                .parser()
                .verifyWith(getSigninKey())
                .build()
                .parseSignedClaims(token)
                .getPayload();
    }


    //1
    public String generateToken(User user){
        String token = Jwts
                .builder()
                .subject(user.getUsername())
                .issuedAt(new Date(System.currentTimeMillis()))
                .expiration(new Date(System.currentTimeMillis() + 24*60*60*1000 ))
                .signWith(getSigninKey())
                .compact();

        return token;
    }
    //2
    private SecretKey getSigninKey(){
        byte[] keyBytes = Decoders.BASE64.decode(SERCRET_KEY);
        return Keys.hmacShaKeyFor(keyBytes);
    }



}
