package com.mycompany.GymApp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mycompany.GymApp.DAO.TraineeDao;
import com.mycompany.GymApp.DTO.Mapper;
import com.mycompany.GymApp.DTO.TraineeDTO;
import com.mycompany.GymApp.Logger.CrudLogger;
import com.mycompany.GymApp.Utils.PasswordGenerator;
import com.mycompany.GymApp.model.users.Trainee;

@Service
public class TraineeService implements IService<TraineeDTO> {

    @Autowired
    private TraineeDao traineeDao;

    private static final CrudLogger logger = CrudLogger.of(TraineeService.class);

    @Override
    public TraineeDTO select(Long id) {
        try {
            Trainee t = traineeDao.get(id);
            logger.selected(id);
            return Mapper.toTraineeDTO(t);

        } catch (Exception e) {
            logger.notFound("select", id);

        }
        return null;
    }

    @Override
    public void create(TraineeDTO traineeDTO) {

        try {

            Long idTrainee = (long) traineeDao.getTotalOfTrainee() +1;
            String traineeUserName = traineeDTO.firstName() + "." + traineeDTO.lastName();
            if (traineeDao.isUsernameSelected(traineeUserName)) {
                traineeUserName = traineeUserName + traineeDao.getTotalOfTrainee();
            }

            // Creación del nuevo trainee que se guardará en la bd
            Trainee newTrainee = new Trainee(
                    idTrainee,
                    traineeDTO.firstName(),
                    traineeDTO.lastName(),
                    traineeUserName,
                    PasswordGenerator.generatePassword(10),
                    false,
                    traineeDTO.dateOfBirth(),
                    traineeDTO.address());

            traineeDao.save(idTrainee, newTrainee);
            logger.created(idTrainee);
        } catch (Exception e) {
            logger.exceptionMessage(e);

        }
    }

    @Override
    public TraineeDTO update(Long id, TraineeDTO traineeDTO) {
        try {
            Trainee traineeToUpdate = traineeDao.get(id);

            traineeToUpdate.setFirstName(traineeDTO.firstName());
            traineeToUpdate.setLastName(traineeDTO.lastName());
            traineeToUpdate.setDatteOfBirth(traineeDTO.dateOfBirth());
            traineeToUpdate.setAddress(traineeDTO.address());

            traineeDao.update(id, traineeToUpdate);
            logger.updated(id);
            return Mapper.toTraineeDTO(traineeToUpdate);
        } catch (Exception e) {
            logger.exceptionMessage(e);
        }
        return null;
    }

    @Override
    public void delete(Long id) {
        try {
            traineeDao.delete(id);
            logger.deleted(id);
        } catch (Exception e) {
            logger.exceptionMessage(e);

        }
    }

    public TraineeDao getTraineeDao() {
        return traineeDao;
    }

    public void setTraineeDao(TraineeDao traineeDao) {
        this.traineeDao = traineeDao;
    }

    
}
