package com.mycompany.GymApp.DAO;

import java.util.HashMap;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.DependsOn;
import org.springframework.stereotype.Component;

import com.mycompany.GymApp.model.Training;

@Component
@DependsOn("trainingMemory")
public class TrainingDao implements IDao<Training> {

   private HashMap<Long, Training> trainingMemory;

   @Override
   public Training get(Long id) throws Exception {
      if (!Optional.ofNullable(trainingMemory.get(id)).isPresent()) {
         throw new Exception("Training con id " + id + "no se encuentra en la bd");
      }
      return trainingMemory.get(id);
   }

   @Override
   public Training save(Long id, Training object) throws Exception {
      if (Optional.ofNullable(trainingMemory.get(id)).isPresent()) {
         throw new Exception("Training con id" + id + "ya creado en la bd");
      }

      return trainingMemory.put(id, object);
   }

   @Override
   public void delete(Long id) throws Exception {
      if (!Optional.ofNullable(trainingMemory.get(id)).isPresent()) {
         throw new Exception("Training con id" + id + "no se encuentra en la bd");
      }
      trainingMemory.remove(id);
   }

   @Override
   public Training update(Long id, Training object) throws Exception {
      if (!Optional.ofNullable(trainingMemory.get(id)).isPresent()) {
         throw new Exception("Training con id" + id + "no se encuentra en la bd");
      }
      return trainingMemory.get(id);
   }

   public Integer getTotalOfTraining() {
      return trainingMemory.size();
   }

   public HashMap<Long, Training> getTrainingMemory() {
      return trainingMemory;
   }

   @Autowired 
   public void setTrainingMemory(HashMap<Long, Training> trainingMemory) {
      this.trainingMemory = trainingMemory;
   }

   

}