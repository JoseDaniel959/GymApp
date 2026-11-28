package com.mycompany.GymApp.model;

import java.time.LocalDate;

import com.mycompany.GymApp.model.users.Trainee;
import com.mycompany.GymApp.model.users.Trainer;

import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;


public class Training {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne 
    @JoinColumn(name = "trainee_id")
    private Trainee trainee;
    
    @ManyToOne 
    @JoinColumn(name = "trainer_id")
    private Trainer trainer;

    @Column(nullable = false)
    private String trainerName;

    @ManyToOne
    @JoinColumn(name = "training_id")
    private TrainingType trainingType;
    
    
    @Column(nullable = false)
    private LocalDate trainingDate;
    
    @Column(nullable = false)
    private Long trainingDuration;
    
    
    

}
