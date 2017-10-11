package hu.elte.alkfejl.repository;

import hu.elte.alkfejl.entity.User;
import java.util.Optional;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User,Long>{ 
   // id típusa long
    
    
    //loginhoz
    //optional nullable valuet becsomagolja, könnyű vele keresni
    Optional<User> findByUsernameAndPassword(String username, String password);
    
    
    User findByUsername(String username);
}
