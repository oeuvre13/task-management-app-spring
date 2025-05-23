package com.bni.taskmgtapp.util;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.stereotype.Service;

import javax.crypto.spec.SecretKeySpec;
import java.security.Key;
import java.util.Base64;

@Service
public class JwtUtil {
    private static final String SECRET = "ahhhhhmbatukammmmmmambasinggggggambadablowwwwwuwoooooooghhhhhhhhh";
    private static final Key SIGNING_KEY = new SecretKeySpec(
            Base64.getDecoder().decode(SECRET),
            SignatureAlgorithm.HS256.getJcaName()
    );

    public String createToken(String username) {
        return Jwts.builder()
                .setSubject(username)
                .signWith(SIGNING_KEY)
                .compact();
    }

    public String validateToken(String token) {
        return Jwts.parserBuilder()
                .setSigningKey(SIGNING_KEY)
                .build()
                .parseClaimsJws(token)
                .getBody()
                .getSubject();
    }

}
