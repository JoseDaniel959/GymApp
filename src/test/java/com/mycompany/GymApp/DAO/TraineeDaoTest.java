package com.mycompany.GymApp.DAO;


import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDate;
import java.util.HashMap;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import com.mycompany.GymApp.model.users.Trainee;

class TraineeDaoTest {

    private TraineeDao traineeDao;
    private HashMap<Long, Trainee> memory;
    private Trainee trainee;

    @BeforeEach
    void setUp() {
        memory = new HashMap<>();
        traineeDao = new TraineeDao();
        traineeDao.setTraineeMemory(memory);

        trainee = new Trainee(1L, "John", "Doe", "John.Doe", "secret123",
                true, LocalDate.of(1995, 5, 20), "123 Main Street");
        memory.put(1L, trainee);
    }

    @Test
    @DisplayName("get returns the trainee when the id exists")
    void get_existingId_returnsTrainee() throws Exception {
        Trainee result = traineeDao.get(1L);

        assertSame(trainee, result);
    }

    @Test
    @DisplayName("get throws an exception when the id does not exist")
    void get_missingId_throwsException() {
        Exception exception = assertThrows(Exception.class, () -> traineeDao.get(99L));

        assertTrue(exception.getMessage().contains("99"));
    }

    @Test
    @DisplayName("isUsernameSelected returns true for an existing username and false otherwise")
    void isUsernameSelected_checksUsername() {
        assertTrue(traineeDao.isUsernameSelected("John.Doe"));
        assertFalse(traineeDao.isUsernameSelected("Not.Existing"));
    }

    @Test
    @DisplayName("getTotalOfTrainee returns the number of stored trainees")
    void getTotalOfTrainee_returnsSize() {
        assertEquals(1, traineeDao.getTotalOfTrainee());

        memory.put(2L, new Trainee(2L, "Jane", "Smith", "Jane.Smith", "pass",
                true, LocalDate.of(2000, 1, 1), "456 Another Avenue"));

        assertEquals(2, traineeDao.getTotalOfTrainee());
    }
}