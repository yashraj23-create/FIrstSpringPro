package com.example.demo.Service;

import com.example.demo.DTO.UserIdentityDTO;
import com.example.demo.Entity.UserIdentity;
import com.example.demo.Mapper.IdentityMapper;
import com.example.demo.Repositary.IdentityRepository;
import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.security.core.userdetails.UserDetailsService;
//import org.springframework.security.core.userdetails.UsernameNotFoundException;
//import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class IdentityService  {
    @Autowired
    private IdentityRepository identityRepository;
   // @Autowired
   // private PasswordEncoder passwordEncoder;
    public UserIdentityDTO Register(UserIdentityDTO userIdentityDTO){

        UserIdentity userIdentity = IdentityMapper.toEntity(userIdentityDTO);
        //userIdentity.setPassword(passwordEncoder.encode(userIdentity.getPassword()));
        userIdentity = identityRepository.save(userIdentity);
        return IdentityMapper.toDTO(userIdentity);
    }

}
