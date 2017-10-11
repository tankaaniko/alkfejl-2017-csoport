package hu.elte.alkfejl.entity;

import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data // lombok miatt getter setter
@NoArgsConstructor
@AllArgsConstructor
public class User {
    
    @OneToMany(targetEntity = Issue.class, mappedBy = "user") // user mező hivatkozik vissza rám
    private List<Issue> issues;
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
   
    @Column(nullable=false,  unique = true)
    private String username;
   
    @Column(nullable=false)
    private String password;
   
    @Column(nullable=false, unique = true)
    private String email;
    
    @Column(nullable=false)
    @Enumerated(EnumType.STRING)
    private Role role;
    
    public enum Role {
        GUEST,USER,ADMIN
    }
    
    
}
