package com.sj.algosphere.utilities;

import java.util.Base64;
import java.util.Date;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import com.sj.algosphere.models.entities.User;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

@Component
public class JwtUtil {

    @Value("${app.jwtSecret}")
    private String jwtSecret;
    
    @Value("${app.jwtExpirationMs}")
    private int jwtExpirationMs;
    
    public String generateJwtToken(User user){

        String encodedSecret = Base64.getEncoder().encodeToString(jwtSecret.getBytes());
        Date issueDate = new Date();

        return Jwts.builder()
                .setSubject(user.getEmail())
                    .claim("id", user.getId())
                    .claim("email", user.getEmail())
                    .setIssuedAt(issueDate)
                    .setExpiration(new Date(issueDate.getTime() + jwtExpirationMs))
                .signWith(SignatureAlgorithm.HS512, encodedSecret)
                .compact();

    }

    public Claims getClaims(String token){

        String encodedSecret = Base64.getEncoder().encodeToString(jwtSecret.getBytes());
        
        return Jwts.parser().setSigningKey(encodedSecret).parseClaimsJws(token).getBody();
        
    }
}
