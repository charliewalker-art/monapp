package com.example.monapp.entity;

import jakarta.persistence.*;

@Entity
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    //attributes the entity User
    private String name;

    private String email;

    private String password;



    public User() {}

    //functions of the entity User

    //function to get and  to set attribute id
    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
    }

    //function to get and  to set attribute name
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    //function to get and  to set attribute email
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }

    //function to get and  to set attribute password
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }


}