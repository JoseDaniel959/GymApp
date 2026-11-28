package com.mycompany.GymApp.model.users;

import org.hibernate.annotations.GeneratedColumn;

import jakarta.persistence.Column;
import jakarta.persistence.DiscriminatorColumn;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.GenerationType;

import jakarta.persistence.Inheritance;

@Entity 
public class User {

    @Id 
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    Long id;

    @Column(nullable = false)
    String FirstName;
    
    @Column(nullable = false)
    String lastName;
    
    @Column(nullable = false)
    String username;

    @Column(nullable = false)
    Boolean isActive;



    

}
