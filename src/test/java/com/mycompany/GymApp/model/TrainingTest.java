package com.mycompany.GymApp.model;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDate;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

// Adjust the package/imports to match your project (Training, TrainingType).
public class TrainingTest {

    private static final Long TRAINING_ID = 1L;
    private static final Long TRAINEE_ID = 10L;
    private static final Long TRAINER_ID = 20L;
    private static final String TRAINER_NAME = "John Smith";
    private static final LocalDate TRAINING_DATE = LocalDate.of(2026, 11, 26);
    private static final Long TRAINING_DURATION = 60L;

    // Uses the first enum constant so the test doesn't depend on specific names.
    private final TrainingType trainingType = TrainingType.values()[0];

    private Training training;

    @BeforeEach
    void setUp() {
        training = new Training(TRAINING_ID, TRAINEE_ID, TRAINER_ID, TRAINER_NAME,
                trainingType, TRAINING_DATE, TRAINING_DURATION);
    }

    @Test
    @DisplayName("Constructor sets all fields correctly")
    void constructor_setsAllFields() {
        assertEquals(TRAINING_ID, training.getTrainingId());
        assertEquals(TRAINEE_ID, training.getTraineeId());
        assertEquals(TRAINER_ID, training.getTrainerid());
        assertEquals(TRAINER_NAME, training.getTrainerName());
        assertEquals(trainingType, training.getTrainingType());
        assertEquals(TRAINING_DATE, training.getTrainingDate());
        assertEquals(TRAINING_DURATION, training.getTrainingDuration());
    }

    @Test
    @DisplayName("Constructor accepts null values without throwing")
    void constructor_acceptsNulls() {
        Training nullTraining = new Training(null, null, null, null, null, null, null);

        assertNull(nullTraining.getTrainingId());
        assertNull(nullTraining.getTraineeId());
        assertNull(nullTraining.getTrainerid());
        assertNull(nullTraining.getTrainerName());
        assertNull(nullTraining.getTrainingType());
        assertNull(nullTraining.getTrainingDate());
        assertNull(nullTraining.getTrainingDuration());
    }

    @Test
    @DisplayName("setTrainingId updates the value")
    void setTrainingId_updatesValue() {
        training.setTrainingId(99L);
        assertEquals(99L, training.getTrainingId());
    }

    @Test
    @DisplayName("setTraineeId updates the value")
    void setTraineeId_updatesValue() {
        training.setTraineeId(88L);
        assertEquals(88L, training.getTraineeId());
    }

    @Test
    @DisplayName("setTrainerid updates the value")
    void setTrainerid_updatesValue() {
        training.setTrainerid(77L);
        assertEquals(77L, training.getTrainerid());
    }

    @Test
    @DisplayName("setTrainerName updates the value")
    void setTrainerName_updatesValue() {
        training.setTrainerName("Jane Doe");
        assertEquals("Jane Doe", training.getTrainerName());
    }

    @Test
    @DisplayName("setTrainingType updates the value")
    void setTrainingType_updatesValue() {
        TrainingType[] types = TrainingType.values();
        TrainingType other = types[types.length - 1];

        training.setTrainingType(other);
        assertEquals(other, training.getTrainingType());
    }

    @Test
    @DisplayName("setTrainingDate updates the value")
    void setTrainingDate_updatesValue() {
        LocalDate newDate = LocalDate.of(2027, 1, 15);

        training.setTrainingDate(newDate);
        assertEquals(newDate, training.getTrainingDate());
    }

    @Test
    @DisplayName("setTrainingDuration updates the value")
    void setTrainingDuration_updatesValue() {
        training.setTrainingDuration(120L);
        assertEquals(120L, training.getTrainingDuration());
    }

}