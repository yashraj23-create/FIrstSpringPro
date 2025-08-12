package com.example.demo.Service;

import com.example.demo.DTO.UserDTO;
import com.example.demo.EXceptionHandling.UserAlreadyThere;
import com.example.demo.EXceptionHandling.UserNotThere;
import com.example.demo.Entity.User;
import com.example.demo.Entity.Destination;
import com.example.demo.Mapper.UserMapper;
import com.example.demo.Repositary.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    public UserDTO createUser(UserDTO userDTO) {
        Optional<User> userCheck = userRepository.findByEmail(userDTO.getEmail());
        if(userCheck.isPresent()){
            throw new UserAlreadyThere("UserAlready There");
        }
        User user = UserMapper.toEntity(userDTO);
        User savedUser = userRepository.save(user);
        return UserMapper.toDTO(savedUser);
    }
    public UserDTO getUserById(Long id) {
        User user = userRepository.findById(id)
                .orElseThrow(() -> new UserNotThere("User not found"));
        return UserMapper.toDTO(user);
    }
    public List<UserDTO> getAllUsers() {
        return userRepository.findAll()
                .stream()
                .map(UserMapper::toDTO)
                .collect(Collectors.toList());
    }

    public void deleteUser(Long id) {
        if (!userRepository.existsById(id)) {
            throw new RuntimeException("User not found");
        }
        userRepository.deleteById(id);
    }
}
