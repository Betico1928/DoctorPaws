package com.javeriana.drpaws.proyecto.security;


import java.security.Key;
import java.util.Collection;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.stereotype.Component;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;

@Component
public class JWTGenerator {
    
    public static final Long EXPIRATION_TIME = 7000000L;

    public static final Key key = Keys.secretKeyFor(SignatureAlgorithm.HS512);

    public String generateToken(Authentication authentication){
        String username = authentication.getName();
        Date currentDate = new Date();
        Date expireDate = new Date(currentDate.getTime()+EXPIRATION_TIME);
        
        Collection<? extends GrantedAuthority> authorities = authentication.getAuthorities();
        
        // Extract roles from authorities
        String roles = authorities.stream()
                .map(GrantedAuthority::getAuthority)
                .collect(Collectors.joining(","));

        /*Crear el JWT */
        String token = Jwts.builder().setSubject(username)
            .setIssuedAt(currentDate)
            .claim("roles",roles)
            .setExpiration(expireDate)
            .signWith(key,SignatureAlgorithm.HS512)
            .compact();
        
        return token;
    }

    public String getUserFromJwt(String token){
        return Jwts.parserBuilder().setSigningKey(key).build().parseClaimsJws(token).getBody().getSubject();
    }

    public boolean validateToken(String token){
        try {
            Jwts.parserBuilder().setSigningKey(key).build().parseClaimsJws(token);
            return true;
        } catch (Exception e) {
            return false;
        }
    }



}
