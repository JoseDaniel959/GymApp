package com.mycompany.GymApp.Service;

import static org.junit.jupiter.api.Assertions.*;

import java.util.HashMap;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import com.mycompany.GymApp.DAO.TrainerDao;
import com.mycompany.GymApp.DTO.TrainerDTO;
import com.mycompany.GymApp.model.users.Trainer;
import com.mycompany.GymApp.service.TrainerService;

class TrainerServiceTest {

    private TrainerService trainerService;
    private HashMap<Long, Trainer> memory;
    private Trainer trainer;

    // Single place to adjust if the Trainer constructor is different.
    // specialization is null so the test doesn't depend on the TrainingType enum.
    private Trainer createTrainer(Long id, String firstName, String lastName, String username) {
        return new Trainer(id, firstName, lastName, username, "secret123", true, null);
    }

    // Single place to adjust if the TrainerDTO constructor is different.
    private TrainerDTO createDto(String firstName, String lastName) {
        return new TrainerDTO(firstName, lastName, null);
    }

    @BeforeEach
    void setUp() {
        memory = new HashMap<>();
        TrainerDao trainerDao = new TrainerDao();
        trainerDao.setTrainerMemory(memory);

        trainerService = new TrainerService();
        trainerService.setTrainerDao(trainerDao);

        trainer = createTrainer(1L, "John", "Smith", "John.Smith");
        memory.put(1L, trainer);
    }

    @Test
    @DisplayName("select returns a DTO when the trainer exists")
    void select_existingId_returnsDto() {
        TrainerDTO result = trainerService.select(1L);

        assertNotNull(result);
        assertEquals("John", result.firstName());
        assertEquals("Smith", result.lastName());
    }

    @Test
    @DisplayName("select returns null when the trainer does not exist")
    void select_missingId_returnsNull() {
        assertNull(trainerService.select(99L));
    }

    @Test
    @DisplayName("update changes the trainer's data and returns the updated DTO")
    void update_existingId_updatesTrainer() {
        TrainerDTO newData = createDto("Jane", "Doe");

        TrainerDTO result = trainerService.update(1L, newData);

        assertNotNull(result);
        assertEquals("Jane", result.firstName());
        assertEquals("Doe", result.lastName());
        assertEquals("Jane", memory.get(1L).getFirstName());
        assertEquals("Doe", memory.get(1L).getLastName());
    }

    @Test
    @DisplayName("update returns null when the trainer does not exist")
    void update_missingId_returnsNull() {
        assertNull(trainerService.update(99L, createDto("Jane", "Doe")));
    }

    @Test
    @DisplayName("delete removes the trainer from the DAO")
    void delete_existingId_removesTrainer() {
        trainerService.delete(1L);

        assertFalse(memory.containsKey(1L));
    }

    @Test
    @DisplayName("delete does not throw when the trainer does not exist")
    void delete_missingId_doesNotThrow() {
        assertDoesNotThrow(() -> trainerService.delete(99L));
        assertEquals(1, memory.size());
    }
}