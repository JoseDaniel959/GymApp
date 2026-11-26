package com.mycompany.GymApp;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.mycompany.GymApp.service.TraineeService;
import com.mycompany.GymApp.service.TrainerService;
import com.mycompany.GymApp.service.TrainingService;

@Component 
public class Facade {
    TraineeService traineeService;
    TrainerService trainerService;
    TrainingService trainingService;
    
    @Autowired 
    public Facade(TraineeService traineeService, TrainerService trainerService, TrainingService trainingService) {
        this.traineeService = traineeService;
        this.trainerService = trainerService;
        this.trainingService = trainingService;
    }

    public TraineeService getTraineeService() {
        return traineeService;
    }

    public void setTraineeService(TraineeService traineeService) {
        this.traineeService = traineeService;
    }

    public TrainerService getTrainerService() {
        return trainerService;
    }

    public void setTrainerService(TrainerService trainerService) {
        this.trainerService = trainerService;
    }

    public TrainingService getTrainingService() {
        return trainingService;
    }

    public void setTrainingService(TrainingService trainingService) {
        this.trainingService = trainingService;
    }

    
}
