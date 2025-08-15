package com.example.demo.Controllers;

import com.example.demo.DTO.UserIdentityDTO;
import com.example.demo.Entity.UserIdentity;
import com.example.demo.Repositary.IdentityRepository;
import com.example.demo.Security.JwtUtil;
import com.example.demo.Service.IdentityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PostAuthorize;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
@RequestMapping("/auth")
public class AuthenticationController {
    @Autowired
    private IdentityService identityService;
    @Autowired
    private JwtUtil jwtUtil;
    @Autowired
    private AuthenticationManager authenticationManager;

    @PostMapping("/login")
    public ResponseEntity<?> LoginUser(@RequestBody UserIdentityDTO userIdentityDTO){
        try {
            authenticationManager.authenticate(new
                    UsernamePasswordAuthenticationToken
                    (userIdentityDTO.getUsername(), userIdentityDTO.getPassword()));
        }
        catch (BadCredentialsException e){
            throw new RuntimeException("Wrong Credential");
        }
        String token = jwtUtil.generateToken(userIdentityDTO.getUsername());
        return ResponseEntity.ok(token);
    }

    @PostMapping("/register")
    public ResponseEntity<?> SignInUser(@RequestBody UserIdentityDTO userIdentityDTO){
        UserIdentityDTO userIdentityDTO1 = identityService.Register(userIdentityDTO);
        String token1 = jwtUtil.generateToken(userIdentityDTO1.getUsername());
        return ResponseEntity.ok(token1);
    }
}
