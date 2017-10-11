package hu.elte.alkfejl.service;

import hu.elte.alkfejl.entity.User;
import hu.elte.alkfejl.repository.UserRepository;
import java.util.Optional;
import jdk.nashorn.internal.runtime.UnwarrantedOptimismException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.context.annotation.SessionScope;

@Service
@SessionScope // ha pédányosítja az osztályt a mubnkamenetben eltárolódik, később innen elő tudja venni
// más élettartamuk lesz az objektumoknak
public class UserService {
 
    private User user;
    
    @Autowired
    private UserRepository userRepository ;
    
    public User register(User user){
        
        user.setRole(User.Role.USER);
        return this.user = userRepository.save(user);
        
    }
    
     public User login(User user) throws UserNotValidException{
        
         if(isValid(user)){
             return this.user = userRepository.findByUsername(user.getUsername());
         }
         throw new UserNotValidException();
    }
     
     private boolean isValid(User user){
        return  userRepository.findByUsernameAndPassword(user.getUsername(), user.getPassword()).isPresent(); 
         //isPresent: megnézi hogy a visszatért értek nem-e null
     }
     
     public boolean isLoggedIn(){ // ha a sessionben benne van a user. 
         //this.user-ben benne van e
         
         return user != null;
     }
     
     public User getLoggedInUser(){
         return user;
     }
}
