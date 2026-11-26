package com.mycompany.GymApp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mycompany.GymApp.DAO.TrainerDao;
import com.mycompany.GymApp.DTO.Mapper;
import com.mycompany.GymApp.DTO.TrainerDTO;
import com.mycompany.GymApp.Logger.CrudLogger;
import com.mycompany.GymApp.Utils.PasswordGenerator;
import com.mycompany.GymApp.model.users.Trainer;

@Service
public class TrainerService implements IService<TrainerDTO> {

    @Autowired
    private TrainerDao trainerDao;

    private static final CrudLogger logger = CrudLogger.of(TrainerService.class);

    @Override
    public TrainerDTO select(Long id) {
        try {
            Trainer t = trainerDao.get(id);
            logger.selected(id);
            return Mapper.toTrainerDTO(t);

        } catch (Exception e) {
            logger.notFound("select", id);

        }
        return null;
    }

    @Override
    public void create(TrainerDTO trainerDTO) {
        try {
            Long idTrainer = (long) trainerDao.getTotalOfTrainer();
            String traineeUserName = trainerDTO.firstName() + "." + trainerDTO.lastName();
            
            if (trainerDao.isUsernameSelected(traineeUserName)) {
                traineeUserName = traineeUserName + trainerDao.getTotalOfTrainer();
            }

            //Creación del nuevo trainerr que se guardará en la bd
            Trainer newTrainee = new Trainer(
                idTrainer,
                trainerDTO.firstName(),
                trainerDTO.lastName(),
                traineeUserName,
                PasswordGenerator.generatePassword(10),
                false,
                trainerDTO.specialization()
             );

            trainerDao.save(idTrainer, newTrainee);
            logger.created(idTrainer);
        } catch (Exception e) {
            logger.exceptionMessage(e);

        }
    }

    @Override
    public TrainerDTO update(Long id, TrainerDTO trainerDTO) {
        try {
            Trainer trainerToUpdate = trainerDao.get(id);

            trainerToUpdate.setFirstName(trainerDTO.firstName());
            trainerToUpdate.setLastName(trainerDTO.lastName());
            trainerToUpdate.setSpecialization(trainerDTO.specialization());

            trainerDao.update(id, trainerToUpdate);
            logger.updated(id);
            return Mapper.toTrainerDTO(trainerToUpdate);
        } catch (Exception e) {
            logger.exceptionMessage(e);
        }

        return null;
    }

    @Override
    public void delete(Long id) {
        try {
            trainerDao.delete(id);
            logger.deleted(id);
        } catch (Exception e) {
            logger.exceptionMessage(e);

        }
    }

    public TrainerDao getTrainerDao() {
        return trainerDao;
    }

    public void setTrainerDao(TrainerDao trainerDao) {
        this.trainerDao = trainerDao;
    }


}
