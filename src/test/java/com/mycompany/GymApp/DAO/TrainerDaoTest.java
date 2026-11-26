package com.mycompany.GymApp.DAO;


import static org.junit.jupiter.api.Assertions.*;

import java.util.HashMap;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import com.mycompany.GymApp.model.users.Trainer;

class TrainerDaoTest {

    private TrainerDao trainerDao;
    private HashMap<Long, Trainer> memory;
    private Trainer trainer;

    // Single place to adjust if the Trainer constructor is different.
    private Trainer createTrainer(Long id, String username) {
        return new Trainer(id, "John", "Smith", username, "secret123", true, null);
    }

    @BeforeEach
    void setUp() {
        memory = new HashMap<>();
        trainerDao = new TrainerDao();
        trainerDao.setTrainerMemory(memory);

        trainer = createTrainer(1L, "John.Smith");
        memory.put(1L, trainer);
    }

    @Test
    @DisplayName("get returns the trainer when the id exists")
    void get_existingId_returnsTrainer() throws Exception {
        Trainer result = trainerDao.get(1L);

        assertSame(trainer, result);
    }

    @Test
    @DisplayName("get throws an exception when the id does not exist")
    void get_missingId_throwsException() {
        Exception exception = assertThrows(Exception.class, () -> trainerDao.get(99L));

        assertTrue(exception.getMessage().contains("99"));
    }

    @Test
    @DisplayName("isUsernameSelected returns true for an existing username and false otherwise")
    void isUsernameSelected_checksUsername() {
        assertTrue(trainerDao.isUsernameSelected("John.Smith"));
        assertFalse(trainerDao.isUsernameSelected("Not.Existing"));
    }

    @Test
    @DisplayName("getTotalOfTrainer returns the number of stored trainers")
    void getTotalOfTrainer_returnsSize() {
        assertEquals(1, trainerDao.getTotalOfTrainer());

        memory.put(2L, createTrainer(2L, "Jane.Doe"));

        assertEquals(2, trainerDao.getTotalOfTrainer());
    }
}