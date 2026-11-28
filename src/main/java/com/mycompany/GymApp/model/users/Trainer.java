package com.mycompany.GymApp.model.users;

import java.util.ArrayList;
import java.util.List;

import com.mycompany.GymApp.model.Training;
import com.mycompany.GymApp.model.TrainingType;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;

@Entity
public class Trainer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    @OneToOne 
    User user;

    @ManyToOne
    @JoinColumn(name = "specialization_id")
    List<TrainingType> Specialization;

    @ManyToMany 
    @JoinTable(
        name = "trainerXTrainee",
        joinColumns = @JoinColumn(name = "trainer_id"),
        inverseJoinColumns = @JoinColumn(name = "trainee_id")
    )
    List<Trainee> trainees;

    @OneToMany(mappedBy = "trainingType")
    List<Training> trainings; 



}
