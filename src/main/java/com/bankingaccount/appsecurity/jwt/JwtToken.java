package com.bankingaccount.appsecurity.jwt;

import com.bankingaccount.appsecurity.dtos.AuthRequest;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.crypto.spec.SecretKeySpec;
import java.security.Key;
import java.time.Instant;
import java.util.Date;
import java.util.UUID;

@Component
public class JwtToken {

    public static final long JWT_TOKEN_VALIDITY = 24 * 60 * 60;

    @Value("${jwt.secret}")
    private String secret;

    public String generateToken(AuthRequest authRequest){
        Key hmacKey = new SecretKeySpec(secret.getBytes(), SignatureAlgorithm.HS256.getJcaName());
        Instant now = Instant.now();
        String jwtToken = Jwts.builder()
                .claim("user", authRequest.getUserName())
                .setSubject(authRequest.getUserName())
                .setId(UUID.randomUUID().toString())
                .setIssuedAt(Date.from(now))
                .setExpiration(new Date(System.currentTimeMillis() + JWT_TOKEN_VALIDITY * 1000))
                .signWith(hmacKey)
                .compact();
        return jwtToken;
    }
}
