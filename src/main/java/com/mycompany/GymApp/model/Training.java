package com.mycompany.GymApp.model;

import java.time.LocalDate;


public class Training {
    private Long trainingId;
    private Long traineeId;
    private Long trainerid;
    private String trainerName;
    private TrainingType trainingType;
    private LocalDate trainingDate;
    private Long trainingDuration;
    
    
    public Training(Long trainingId, Long traineeId, Long trainerid, String trainerName, TrainingType trainingType,
            LocalDate trainingDate, Long trainingDuration) {
        this.trainingId = trainingId;
        this.traineeId = traineeId;
        this.trainerid = trainerid;
        this.trainerName = trainerName;
        this.trainingType = trainingType;
        this.trainingDate = trainingDate;
        this.trainingDuration = trainingDuration;
    }


    public Long getTrainingId() {
        return trainingId;
    }


    public void setTrainingId(Long trainingId) {
        this.trainingId = trainingId;
    }


    public Long getTraineeId() {
        return traineeId;
    }


    public void setTraineeId(Long traineeId) {
        this.traineeId = traineeId;
    }


    public Long getTrainerid() {
        return trainerid;
    }


    public void setTrainerid(Long trainerid) {
        this.trainerid = trainerid;
    }


    public String getTrainerName() {
        return trainerName;
    }


    public void setTrainerName(String trainerName) {
        this.trainerName = trainerName;
    }


    public TrainingType getTrainingType() {
        return trainingType;
    }


    public void setTrainingType(TrainingType trainingType) {
        this.trainingType = trainingType;
    }


    public LocalDate getTrainingDate() {
        return trainingDate;
    }


    public void setTrainingDate(LocalDate trainingDate) {
        this.trainingDate = trainingDate;
    }


    public Long getTrainingDuration() {
        return trainingDuration;
    }


    public void setTrainingDuration(Long trainingDuration) {
        this.trainingDuration = trainingDuration;
    }

    

}
