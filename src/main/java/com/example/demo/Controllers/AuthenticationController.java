package com.example.demo.Controllers;

import com.example.demo.DTO.UserIdentityDTO;
import com.example.demo.Entity.UserIdentity;
import com.example.demo.Repositary.IdentityRepository;
import com.example.demo.Service.IdentityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
    private IdentityRepository identityRepository;
    @PostMapping("/register")
    public ResponseEntity<?> Register(@RequestBody UserIdentityDTO userIdentityDTO){
        Optional<UserIdentity> userIdentity = identityRepository.findByUsername(userIdentityDTO
                .getUsername());
        if(userIdentity.isPresent()){
            return ResponseEntity.ok("Username Already There");
        }
        else{
            return ResponseEntity.status(HttpStatus.CREATED)
                    .body(identityService.Register(userIdentityDTO));
        }
    }

}
