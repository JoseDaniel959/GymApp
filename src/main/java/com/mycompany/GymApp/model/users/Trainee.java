package com.mycompany.GymApp.model.users;

import java.time.LocalDate;

public class Trainee extends User {

    private LocalDate DateOfBirth;
    private String Address;

    public Trainee(Long userId, String firstName, String lastName,String username, String password, Boolean isActive, LocalDate dateOfBirth,
            String address) {
        super(userId, firstName, lastName,username, password, isActive);
        this.DateOfBirth = dateOfBirth;
        this.Address = address;
    }

    public LocalDate getDatteOfBirth() {
        return DateOfBirth;
    }

    public void setDatteOfBirth(LocalDate datteOfBirth) {
        DateOfBirth = datteOfBirth;
    }

    public String getAddress() {
        return Address;
    }

    public void setAddress(String address) {
        Address = address;
    }

    @Override
    public String toString() {
        return "Trainee [DateOfBirth=" + DateOfBirth + ", Address=" + Address + ", getUserId()=" + getUserId()
                + ", getFirstName()=" + getFirstName() + ", getLastName()=" + getLastName() + ", getPassWord()="
                + getPassWord() + ", getIsActive()=" + getIsActive() + "]";
    }

}
