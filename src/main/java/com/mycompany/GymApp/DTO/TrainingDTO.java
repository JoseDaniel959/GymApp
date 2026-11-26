package com.mycompany.GymApp.DTO;

import java.time.LocalDate;

import com.mycompany.GymApp.model.TrainingType;

public record TrainingDTO(
        Long traineeId,
        Long trainerId,
        String trainerName,
        TrainingType trainingType,
        LocalDate trainingDate,
        Long trainingDuration) {
}