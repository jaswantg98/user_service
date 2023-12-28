package com.application.user_service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public User registerUser(String username, String password) {
        //TODO - Try something to encrypt password. See if Spring offers something.
        User user = new User();
        user.setUsername(username);
        user.setPassword(password);

        return userRepository.save(user);
    }

    public User authenticateUser(String username, String password) {
        User user = userRepository.findByUsername(username)
                .orElseThrow(() -> new UsernameNotFoundException("No User Found"));

        if (password.equals(user.getPassword())) {
            return user;
        } else {
            throw new BadCredentialsException("Invalid Password");
        }
    }
}
