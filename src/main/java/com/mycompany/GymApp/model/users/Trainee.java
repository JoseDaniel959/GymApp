package com.mycompany.GymApp.model.users;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import com.mycompany.GymApp.model.Training;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;

@Entity
public class Trainee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)  
    Long id;

    @Column(nullable = true)
    LocalDate DateOfBith;

    @Column(nullable = true)
    String address;

    @OneToOne
    User user;

    @ManyToMany(mappedBy = "trainees")
    List<Trainer> trainers;

    @OneToMany(mappedBy = "trainingType")
    List<Training> trainings;

}
