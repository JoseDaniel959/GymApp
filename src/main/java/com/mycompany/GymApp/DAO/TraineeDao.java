package com.mycompany.GymApp.DAO;

import java.util.HashMap;
import java.util.Optional;
import java.util.Map.Entry;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.DependsOn;
import org.springframework.stereotype.Component;

import com.mycompany.GymApp.model.users.Trainee;

@Component
@DependsOn("traineeMemory")
public class TraineeDao implements IDao<Trainee> {

   private HashMap<Long, Trainee> traineeMemory;

   @Override
   public Trainee get(Long id) throws Exception {
      if (!Optional.ofNullable(traineeMemory.get(id)).isPresent()) {
         throw new Exception("Trainee con id " + id + "no se encuentra en la bd");
      }
      return traineeMemory.get(id);
   }

   @Override
   public Trainee save(Long id, Trainee object) throws Exception {
      if (Optional.ofNullable(traineeMemory.get(id)).isPresent()) {

         throw new Exception("Trainee con id" + id + "ya creado en la bd");

      }
      return traineeMemory.put(id, object);
   }

   @Override
   public void delete(Long id) throws Exception {
      if (!Optional.ofNullable(traineeMemory.get(id)).isPresent()) {
         throw new Exception("Trainee con id" + id + "no se encuentra en la bd");
      }
      traineeMemory.remove(id);
   }

   @Override
   public Trainee update(Long id, Trainee object) throws Exception {
      if (!Optional.ofNullable(traineeMemory.get(id)).isPresent()) {
         throw new Exception("Trainee con id" + id + "no se encuentra en la bd");
      }
      return traineeMemory.get(id);
   }

   public boolean isUsernameSelected(String usernameToSearch) {
      boolean isPresent = false;

      for (Entry<Long, Trainee> trainee : traineeMemory.entrySet()) {
         if (trainee.getValue().getUsername().equals(usernameToSearch)) {
            isPresent = true;
         }
      }
      return isPresent;
   }

   public Integer getTotalOfTrainee() {
      return traineeMemory.size();
   }

   public HashMap<Long, Trainee> getTraineeMemory() {
      return traineeMemory;
   }

   @Autowired
   public void setTraineeMemory(HashMap<Long, Trainee> traineeMemory) {
      this.traineeMemory = traineeMemory;
   }

}
