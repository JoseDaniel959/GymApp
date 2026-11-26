package com.mycompany.GymApp.DTO;

import com.mycompany.GymApp.model.Training;
import com.mycompany.GymApp.model.users.Trainee;
import com.mycompany.GymApp.model.users.Trainer;

public class Mapper {

    public static TraineeDTO toTraineeDTO(Trainee trainee){
        return new TraineeDTO(
            trainee.getFirstName(),
            trainee.getLastName(),
            trainee.getDatteOfBirth(),
            trainee.getAddress());
    }

    public static TrainerDTO toTrainerDTO(Trainer trainer){
        return new TrainerDTO(
            trainer.getFirstName(),
            trainer.getLastName(),
            trainer.getSpecialization()
        );
    }

    public static TrainingDTO toTrainingDTO(Training trainig){
        return new TrainingDTO(
            trainig.getTraineeId(),
            trainig.getTrainerid(),
            trainig.getTrainerName(),
            trainig.getTrainingType(),
            trainig.getTrainingDate(),
            trainig.getTrainingDuration());
    }


}
