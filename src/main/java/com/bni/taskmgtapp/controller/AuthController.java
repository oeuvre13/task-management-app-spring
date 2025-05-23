package com.bni.taskmgtapp.controller;

import com.bni.taskmgtapp.util.JwtUtil;
import org.springframework.web.bind.annotation.*;

@RestController
public class AuthController {
    private final JwtUtil jwtService;

    public AuthController(JwtUtil jwtService) {
        this.jwtService = jwtService;
    }

    @GetMapping("/get-token/{username}")
    public String getToken(@PathVariable String username) {
        return jwtService.createToken(username);
    }

    @PostMapping("/validate-token")
    public String validateToken(@RequestBody String token) {
        try {
            return "Token is valid for user: " + jwtService.validateToken(token);
        } catch (Exception e) {
            return "Invalid token: " + e.getMessage();
        }
    }

}
