package com.example.dio.model;
import com.example.dio.enums.UserRole;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import java.time.LocalDateTime;
@Entity
@Table(name = "users")
@Inheritance(strategy = InheritanceType.JOINED)
@Getter
@Setter
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="user_id")
    private long userId;

    @Column(name="username")
    private String userName;

    @Column(name="email")
    private String email;

    @Column(name="password")
    private String password;

    @Column(name="ph_no")
    private String phoneNo;

    @Column(name="user_role")
    @Enumerated(EnumType.STRING)
    private UserRole userRole;

    @Column(name="created_at")
    private LocalDateTime createdAt;

    @Column(name="lastmodied_at")
    private LocalDateTime lastModifiedAt;


}

