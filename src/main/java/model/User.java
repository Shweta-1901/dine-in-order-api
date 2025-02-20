package model;

import jakarta.persistence.*;
import org.springframework.data.annotation.Id;

import java.time.LocalDate;
@Entity
@Table(name="users")
@Inheritance(strategy = InheritanceType.JOINED)
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long userid;
    private String username;
    private String email;
    private int password;
    private  long phoneNo;
    private String userRole;
    private LocalDate createAt;
    private LocalDate lastModifiedAt;

}
