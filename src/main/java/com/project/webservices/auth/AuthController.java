package com.project.webservices.auth;

import com.project.webservices.config.JwtUtil;
import com.project.webservices.entities.User;
import com.project.webservices.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
public class AuthController {

    @Autowired
    private UserRepository userRepository;

    @PostMapping("/login")
    public String login(@RequestBody LoginRequest request) {

        User user = userRepository.findByEmail(request.getEmail());

        if (user != null && user.getPassword().equals(request.getPassword())) {

            String token = JwtUtil.generateToken(user.getEmail());

            return token;
        }

        return "Login inválido";
    }
}