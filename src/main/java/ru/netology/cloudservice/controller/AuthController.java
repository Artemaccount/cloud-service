package ru.netology.cloudservice.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import ru.netology.cloudservice.model.User;
import ru.netology.cloudservice.service.UserService;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;


@RestController
public class AuthController {
    private UserService userService;
    public AuthController(UserService userService) {
        this.userService = userService;
        userService.save(new User().setUsername("ivan").setPassword("1234").setToken("token blyat"));
    }

    private static final Logger log = LoggerFactory.getLogger(AuthController.class);

    @PostMapping(value = "/login")
    public ResponseEntity<?> createAuthenticationToken(@RequestBody User user, HttpServletRequest request) {
        var ip = request.getRemoteAddr();
        var hostname = request.getRemoteHost();
        var useragent = request.getHeader("User-Agent");
        log.info("Login attempt. ip:" + ip + " hostname:" + hostname + " User-Agent:" + useragent);
        User expectedUser = userService.findByUsername(user.getUsername());
        if (user.getUsername().equals(expectedUser.getUsername()) &&
                user.getPassword().equals(expectedUser.getPassword())) {
            HashMap<String, String> map = new HashMap<>();
            map.put("auth-token", "Eto Token");
            return ResponseEntity.status(200).body(map);
        }
        log.info("Failure login attempt. Access denied for: ip:" + ip + " hostname:" + hostname + " User-Agent:" + useragent);
        return ResponseEntity.status(HttpStatus.FORBIDDEN).body("such user not found");

    }

    @GetMapping(value = "/hi")
    public String login() {
        return "login";
    }

}
