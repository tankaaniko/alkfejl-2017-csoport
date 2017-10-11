package hu.elte.alkfejl.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Issue {
    
    //visszaút az issuehoz    (melyik osztály, name lehet null-tartozni kell egy userhez)
    @JoinColumn
    @ManyToOne(targetEntity = User.class, optional = false)
    private User user; // aki felvette az issuet
    
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    
    private String location;
    private String description;
    
    
    
}
