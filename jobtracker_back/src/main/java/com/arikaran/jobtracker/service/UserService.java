package com.arikaran.jobtracker.service;

import com.arikaran.jobtracker.entity.User;
import com.arikaran.jobtracker.repository.UserRepository;
import org.springframework.stereotype.Service;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.List;

@Service
public class UserService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    public UserService(UserRepository userRepository,
                       PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    public User createUser(User user) {
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        return userRepository.save(user);
    }

    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    public User getUserById(Long id) {
        return userRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("User not found"));
    }

    public User updateUser(Long id, User updatedUser) {
        User user = getUserById(id);

        user.setUsername(updatedUser.getUsername());

        if (updatedUser.getPassword() != null &&
                !updatedUser.getPassword().isBlank()) {
            user.setPassword(
                    passwordEncoder.encode(updatedUser.getPassword())
            );
        }

        return userRepository.save(user);
    }

    public void deleteUser(Long id) {
        userRepository.delete(getUserById(id));
    }
}