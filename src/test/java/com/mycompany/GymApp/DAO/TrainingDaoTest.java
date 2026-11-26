package com.mycompany.GymApp.DAO;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDate;
import java.util.HashMap;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import com.mycompany.GymApp.model.Training;

class TrainingDaoTest {

    private TrainingDao trainingDao;
    private HashMap<Long, Training> memory;
    private Training training;

    // trainingType is null so the test doesn't depend on the TrainingType enum.
    private Training createTraining(Long id) {
        return new Training(id, 10L, 20L, "John Smith", null,
                LocalDate.of(2026, 11, 26), 60L);
    }

    @BeforeEach
    void setUp() {
        memory = new HashMap<>();
        trainingDao = new TrainingDao();
        trainingDao.setTrainingMemory(memory);

        training = createTraining(1L);
        memory.put(1L, training);
    }

    @Test
    @DisplayName("get returns the training when the id exists")
    void get_existingId_returnsTraining() throws Exception {
        Training result = trainingDao.get(1L);

        assertSame(training, result);
    }

    @Test
    @DisplayName("get throws an exception when the id does not exist")
    void get_missingId_throwsException() {
        Exception exception = assertThrows(Exception.class, () -> trainingDao.get(99L));

        assertTrue(exception.getMessage().contains("99"));
    }

    @Test
    @DisplayName("getTotalOfTraining returns the number of stored trainings")
    void getTotalOfTraining_returnsSize() {
        assertEquals(1, trainingDao.getTotalOfTraining());

        memory.put(2L, createTraining(2L));

        assertEquals(2, trainingDao.getTotalOfTraining());
    }

    @Test
    @DisplayName("setTrainingMemory replaces the map returned by getTrainingMemory")
    void setTrainingMemory_replacesMemory() {
        HashMap<Long, Training> newMemory = new HashMap<>();

        trainingDao.setTrainingMemory(newMemory);

        assertSame(newMemory, trainingDao.getTrainingMemory());
        assertEquals(0, trainingDao.getTotalOfTraining());
    }
}