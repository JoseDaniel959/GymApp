package com.mycompany.GymApp.Service;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDate;
import java.util.HashMap;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import com.mycompany.GymApp.DAO.TrainingDao;
import com.mycompany.GymApp.DTO.TrainingDTO;
import com.mycompany.GymApp.model.Training;
import com.mycompany.GymApp.service.TrainingService;

class TrainingServiceTest {

    private TrainingService trainingService;
    private HashMap<Long, Training> memory;
    private Training training;

    // trainingType is null so the test doesn't depend on the TrainingType enum.
    // Single place to adjust if the TrainingDTO constructor is different.
    private TrainingDTO createDto(Long traineeId, Long trainerId, String trainerName, Long duration) {
        return new TrainingDTO(traineeId, trainerId, trainerName, null,
                LocalDate.of(2026, 11, 26), duration);
    }

    @BeforeEach
    void setUp() {
        memory = new HashMap<>();
        TrainingDao trainingDao = new TrainingDao();
        trainingDao.setTrainingMemory(memory);

        trainingService = new TrainingService();
        trainingService.setTrainingDao(trainingDao);

        training = new Training(1L, 10L, 20L, "John Smith", null,
                LocalDate.of(2026, 11, 26), 60L);
        memory.put(1L, training);
    }

    @Test
    @DisplayName("select returns a DTO when the training exists")
    void select_existingId_returnsDto() {
        TrainingDTO result = trainingService.select(1L);

        assertNotNull(result);
        assertEquals("John Smith", result.trainerName());
        assertEquals(60L, result.trainingDuration());
    }

    @Test
    @DisplayName("select returns null when the training does not exist")
    void select_missingId_returnsNull() {
        assertNull(trainingService.select(99L));
    }

    @Test
    @DisplayName("update changes the training's data and returns the updated DTO")
    void update_existingId_updatesTraining() {
        TrainingDTO newData = createDto(11L, 21L, "Jane Doe", 90L);

        TrainingDTO result = trainingService.update(1L, newData);

        assertNotNull(result);
        assertEquals("Jane Doe", result.trainerName());
        assertEquals(90L, result.trainingDuration());
        assertEquals(11L, memory.get(1L).getTraineeId());
        assertEquals(21L, memory.get(1L).getTrainerid());
        assertEquals("Jane Doe", memory.get(1L).getTrainerName());
        assertEquals(90L, memory.get(1L).getTrainingDuration());
    }

    @Test
    @DisplayName("update returns null when the training does not exist")
    void update_missingId_returnsNull() {
        assertNull(trainingService.update(99L, createDto(11L, 21L, "Jane Doe", 90L)));
    }

    @Test
    @DisplayName("delete removes the training from the DAO")
    void delete_existingId_removesTraining() {
        trainingService.delete(1L);

        assertFalse(memory.containsKey(1L));
    }

    @Test
    @DisplayName("delete does not throw when the training does not exist")
    void delete_missingId_doesNotThrow() {
        assertDoesNotThrow(() -> trainingService.delete(99L));
        assertEquals(1, memory.size());
    }
}