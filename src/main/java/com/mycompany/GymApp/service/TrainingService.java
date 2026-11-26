package com.mycompany.GymApp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mycompany.GymApp.DAO.TrainingDao;
import com.mycompany.GymApp.DTO.Mapper;
import com.mycompany.GymApp.DTO.TrainingDTO;
import com.mycompany.GymApp.Logger.CrudLogger;
import com.mycompany.GymApp.model.Training;

@Service
public class TrainingService implements IService<TrainingDTO> {

    @Autowired
    private TrainingDao trainingDao;

    private static final CrudLogger logger = CrudLogger.of(TrainingService.class);

    @Override
    public TrainingDTO select(Long id) {
        try {
            Training training = trainingDao.get(id);
            logger.selected(id);
            return Mapper.toTrainingDTO(training);

        } catch (Exception e) {
            logger.notFound("select", id);

        }
        return null;
    }

    @Override
    public void create(TrainingDTO trainingDTO) {
        try {
            Long idTraining = (long) trainingDao.getTotalOfTraining();

            Training newTraining = new Training(
                idTraining,
                trainingDTO.traineeId(),
                trainingDTO.trainerId(),
                trainingDTO.trainerName(),
                trainingDTO.trainingType(),
                trainingDTO.trainingDate(),
                trainingDTO.trainingDuration()
            );

            trainingDao.save(idTraining, newTraining);
            logger.created(idTraining);
        } catch (Exception e) {
            logger.exceptionMessage(e);

        }
    }

    @Override
    public TrainingDTO update(Long id, TrainingDTO trainingDTO) {
        try {

            Training trainingToUpdate = trainingDao.get(id);

            trainingToUpdate.setTraineeId(trainingDTO.traineeId());
            trainingToUpdate.setTrainerid(trainingDTO.trainerId());
            trainingToUpdate.setTrainerName(trainingDTO.trainerName());
            trainingToUpdate.setTrainingType(trainingDTO.trainingType());
            trainingToUpdate.setTrainingDuration(trainingDTO.trainingDuration());

            trainingDao.update(id, trainingToUpdate);
            logger.updated(id);
            return Mapper.toTrainingDTO(trainingToUpdate);
        } catch (Exception e) {
            logger.exceptionMessage(e);
        }

        return null;
    }

    @Override
    public void delete(Long id) {
        try {
            trainingDao.delete(id);
            logger.deleted(id);
        } catch (Exception e) {
            logger.exceptionMessage(e);

        }
    }

    public TrainingDao getTrainingDao() {
        return trainingDao;
    }

    public void setTrainingDao(TrainingDao trainingDao) {
        this.trainingDao = trainingDao;
    }



}
