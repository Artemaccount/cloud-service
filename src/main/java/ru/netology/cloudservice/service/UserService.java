package ru.netology.cloudservice.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;
import ru.netology.cloudservice.model.User;
import ru.netology.cloudservice.repository.UserRepository;

@Service
public class UserService {
    private UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User findByUsername(String username){
        return userRepository.findByUsername(username);
    }

    public User save(User user){
        return userRepository.save(user);
    }

//    public void addTokenToUser(String login, String token) {
//        userRepository.addTokenToUser(login, token);
//    }
//
//    public void deleteTokenByUsername(String username) {
//        userRepository.deleteTokenByUsername(username);
//    }
}
