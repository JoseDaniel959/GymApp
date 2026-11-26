package com.mycompany.GymApp.model.users;
import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDate;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

// Adjust the package/imports to match your project (Trainee, User).
class TraineeTest {

    private static final Long USER_ID = 1L;
    private static final String FIRST_NAME = "John";
    private static final String LAST_NAME = "Doe";
    private static final String USERNAME = "John.Doe";
    private static final String PASSWORD = "secret123";
    private static final Boolean IS_ACTIVE = true;
    private static final LocalDate DATE_OF_BIRTH = LocalDate.of(1995, 5, 20);
    private static final String ADDRESS = "123 Main Street";

    private Trainee trainee;

    @BeforeEach
    void setUp() {
        trainee = new Trainee(USER_ID, FIRST_NAME, LAST_NAME, USERNAME, PASSWORD,
                IS_ACTIVE, DATE_OF_BIRTH, ADDRESS);
    }

    @Test
    @DisplayName("Constructor sets Trainee-specific fields")
    void constructor_setsTraineeFields() {
        assertEquals(DATE_OF_BIRTH, trainee.getDatteOfBirth());
        assertEquals(ADDRESS, trainee.getAddress());
    }

    @Test
    @DisplayName("Constructor passes inherited fields to the parent class")
    void constructor_setsInheritedFields() {
        assertEquals(USER_ID, trainee.getUserId());
        assertEquals(FIRST_NAME, trainee.getFirstName());
        assertEquals(LAST_NAME, trainee.getLastName());
        assertEquals(USERNAME, trainee.getUsername());
        assertEquals(PASSWORD, trainee.getPassWord());
        assertEquals(IS_ACTIVE, trainee.getIsActive());
    }

    @Test
    @DisplayName("Trainee is an instance of User")
    void trainee_isInstanceOfUser() {
        assertInstanceOf(User.class, trainee);
    }

    @Test
    @DisplayName("Constructor accepts null values without throwing")
    void constructor_acceptsNulls() {
        Trainee nullTrainee = new Trainee(null, null, null, null, null, null, null, null);

        assertNull(nullTrainee.getUserId());
        assertNull(nullTrainee.getFirstName());
        assertNull(nullTrainee.getLastName());
        assertNull(nullTrainee.getUsername());
        assertNull(nullTrainee.getPassWord());
        assertNull(nullTrainee.getIsActive());
        assertNull(nullTrainee.getDatteOfBirth());
        assertNull(nullTrainee.getAddress());
    }

    @Test
    @DisplayName("setDateOfBirth updates the value")
    void setDateOfBirth_updatesValue() {
        LocalDate newDate = LocalDate.of(2000, 1, 1);

        trainee.setDatteOfBirth(newDate);
        assertEquals(newDate, trainee.getDatteOfBirth());
    }

    @Test
    @DisplayName("setAddress updates the value")
    void setAddress_updatesValue() {
        trainee.setAddress("456 Another Avenue");
        assertEquals("456 Another Avenue", trainee.getAddress());
    }

    @Test
    @DisplayName("Inherited setters update the values")
    void inheritedSetters_updateValues() {
        trainee.setUserId(2L);
        trainee.setFirstName("Jane");
        trainee.setLastName("Smith");
        trainee.setUsername("Jane.Smith");
        trainee.setPassWord("newPass");
        trainee.setIsActive(false);

        assertEquals(2L, trainee.getUserId());
        assertEquals("Jane", trainee.getFirstName());
        assertEquals("Smith", trainee.getLastName());
        assertEquals("Jane.Smith", trainee.getUsername());
        assertEquals("newPass", trainee.getPassWord());
        assertEquals(false, trainee.getIsActive());
    }
}