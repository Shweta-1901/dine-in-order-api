package com.example.dio.repository;

import com.example.dio.dto.response.UserResponse;
import com.example.dio.model.User;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
//import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {






    // Optional<User>updateById(long userId, User updatedUser);
//    @Modifying
//  @Transactional
//    @Query("UPDATE User u SET u.name = :name, u.email = :email WHERE u.id = :id")
//    int updateUserById(@Param("id") long userId, @Param("name") String userName, @Param("email") String email);

    //Optional<User> updateUserById(long userId);
}


