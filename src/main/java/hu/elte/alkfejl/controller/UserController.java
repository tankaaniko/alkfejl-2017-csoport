package hu.elte.alkfejl.controller;

import hu.elte.alkfejl.entity.User;
import hu.elte.alkfejl.service.UserNotValidException;
import hu.elte.alkfejl.service.UserService;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController // nincsen viewja , RestApihoz RestController
@RequestMapping("/api/user")
public class UserController {
   
    @Autowired
    private UserService userService;
           
    
    @PostMapping("/register")
    public User regiter(@RequestBody User user){ //ARC-ban lévő objektumból
        
        return userService.register(user);
    }
    
    @PostMapping("/login")
    public ResponseEntity<User> login(@RequestBody User user){ //ARC-ban lévő objektumból
        try {
            return ResponseEntity.ok(userService.login(user));
        } catch (UserNotValidException e) {
             return ResponseEntity.badRequest().build();                     
        }
    }
    
    
    @GetMapping("")
    public ResponseEntity<User> user(){         
        if(userService.isLoggedIn()){                  
            return ResponseEntity.ok(userService.getLoggedInUser());
        }
        return ResponseEntity.badRequest().build();
    }
}
