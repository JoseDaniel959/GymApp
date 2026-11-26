package com.mycompany.GymApp.model.users;

public class Trainer extends User {
    private String Specialization;

    public Trainer(
        Long userId, String firstName, String lastName, String userName, String password, Boolean isActive, 
            String specialization) {
        super(userId,firstName, lastName,userName,password, isActive);
        this.Specialization = specialization;
    }

 
    public String getSpecialization() {
        return Specialization;
    }

    public void setSpecialization(String specialization) {
        Specialization = specialization;
    }

}
