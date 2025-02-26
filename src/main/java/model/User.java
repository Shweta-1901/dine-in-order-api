package model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;

import java.time.LocalDate;
@Entity
@Table(name="users")
@Inheritance(strategy = InheritanceType.JOINED)
@Getter
@Setter
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="userid")
    private long userid;

    @Column(name="username")
    private String username;

    @Column(name="email")
    private String email;

    @Column(name="password")
    private int password;

    @Column(name="ph_no")
    private  long phoneNo;

    @Column(name="user_role")
    private String userRole;

    @Column(name="created_at")
    private LocalDate createAt;

    @Column(name="lastmodified_at")
    private LocalDate lastModifiedAt;

}
