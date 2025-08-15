package com.example.demo.Service;

import com.example.demo.DTO.UserIdentityDTO;
import com.example.demo.EXceptionHandling.UserAlreadyThere;
import com.example.demo.Entity.UserIdentity;
import com.example.demo.Mapper.IdentityMapper;
import com.example.demo.Repositary.IdentityRepository;
import com.example.demo.Security.UserPrinciple;
import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.security.core.userdetails.UserDetailsService;
//import org.springframework.security.core.userdetails.UsernameNotFoundException;
//import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class IdentityService implements UserDetailsService {
    @Autowired
    private IdentityRepository identityRepository;
    @Autowired
    private PasswordEncoder passwordEncoder;
      public UserIdentityDTO Register(UserIdentityDTO userIdentityDTO){
          UserIdentity userIdentity = IdentityMapper.toEntity(userIdentityDTO);
          Optional<UserIdentity> userIdentity1 = identityRepository.findByUsername(userIdentityDTO.getUsername());
          if(userIdentity1.isPresent()){
              throw new UserAlreadyThere("Username Already there");
          }
          userIdentity.setPassword(passwordEncoder.encode(userIdentity.getPassword()));
          userIdentity = identityRepository.save(userIdentity);
          return IdentityMapper.toDTO(userIdentity);
        }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
          Optional<UserIdentity> userIdentity = identityRepository.findByUsername(username);
          if(userIdentity.isEmpty()){
              throw new UsernameNotFoundException("Username Not There");
          }
          else{
              return new UserPrinciple(userIdentity.get());
          }
    }
}
