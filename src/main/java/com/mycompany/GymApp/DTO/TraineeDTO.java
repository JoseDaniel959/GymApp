package com.mycompany.GymApp.DTO;

import java.time.LocalDate;

public record TraineeDTO(String firstName, String lastName,LocalDate dateOfBirth,
            String address) {}
