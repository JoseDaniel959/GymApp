package com.mycompany.GymApp.Service;


import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDate;
import java.util.HashMap;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import com.mycompany.GymApp.DAO.TraineeDao;
import com.mycompany.GymApp.DTO.TraineeDTO;
import com.mycompany.GymApp.model.users.Trainee;
import com.mycompany.GymApp.service.TraineeService;

class TraineeServiceTest {

    private TraineeService traineeService;
    private HashMap<Long, Trainee> memory;
    private Trainee trainee;

    // Single place to adjust if the TraineeDTO constructor is different.
    private TraineeDTO createDto(String firstName, String lastName, LocalDate dateOfBirth, String address) {
        return new TraineeDTO(firstName, lastName, dateOfBirth, address);
    }

    @BeforeEach
    void setUp() {
        memory = new HashMap<>();
        TraineeDao traineeDao = new TraineeDao();
        traineeDao.setTraineeMemory(memory);

        // The field is package-private, and this test is in the same package.
        traineeService = new TraineeService();
        traineeService.setTraineeDao(traineeDao);
        
        trainee = new Trainee(1L, "John", "Doe", "John.Doe", "secret123",
                true, LocalDate.of(1995, 5, 20), "123 Main Street");
        memory.put(1L, trainee);
    }

    @Test
    @DisplayName("select returns a DTO when the trainee exists")
    void select_existingId_returnsDto() {
        TraineeDTO result = traineeService.select(1L);

        assertNotNull(result);
        assertEquals("John", result.firstName());
        assertEquals("Doe", result.lastName());
    }

    @Test
    @DisplayName("select returns null when the trainee does not exist")
    void select_missingId_returnsNull() {
        assertNull(traineeService.select(99L));
    }

    @Test
    @DisplayName("update changes the trainee's data and returns the updated DTO")
    void update_existingId_updatesTrainee() {
        TraineeDTO newData = createDto("Jane", "Smith", LocalDate.of(2000, 1, 1), "456 Another Avenue");

        TraineeDTO result = traineeService.update(1L, newData);

        assertNotNull(result);
        assertEquals("Jane", result.firstName());
        assertEquals("Smith", result.lastName());
        assertEquals("Jane", memory.get(1L).getFirstName());
        assertEquals("456 Another Avenue", memory.get(1L).getAddress());
    }

    @Test
    @DisplayName("update returns null when the trainee does not exist")
    void update_missingId_returnsNull() {
        TraineeDTO newData = createDto("Jane", "Smith", LocalDate.of(2000, 1, 1), "456 Another Avenue");

        assertNull(traineeService.update(99L, newData));
    }

    @Test
    @DisplayName("delete removes the trainee from the DAO")
    void delete_existingId_removesTrainee() {
        traineeService.delete(1L);

        assertFalse(memory.containsKey(1L));
    }

    @Test
    @DisplayName("delete does not throw when the trainee does not exist")
    void delete_missingId_doesNotThrow() {
        assertDoesNotThrow(() -> traineeService.delete(99L));
        assertEquals(1, memory.size());
    }
}