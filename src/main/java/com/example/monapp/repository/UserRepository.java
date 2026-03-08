package com.example.monapp.repository;

import com.example.monapp.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface UserRepository extends JpaRepository <User, Integer> {

    @Query("SELECT u.email FROM User u")
    List<String> show_all_mail();

}


