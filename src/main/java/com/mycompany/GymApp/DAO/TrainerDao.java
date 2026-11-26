package com.mycompany.GymApp.DAO;

import java.util.HashMap;
import java.util.Optional;
import java.util.Map.Entry;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.DependsOn;
import org.springframework.stereotype.Component;
import com.mycompany.GymApp.model.users.Trainer;

@Component
@DependsOn("trainerMemory")
public class TrainerDao implements IDao<Trainer> {

   private HashMap<Long, Trainer> trainerMemory;

   @Override
   public Trainer get(Long id) throws Exception {
      if (!Optional.ofNullable(trainerMemory.get(id)).isPresent()) {
         throw new Exception("Trainer con id " + id + "no se encuentra en la bd");
      }
      return trainerMemory.get(id);
   }

   @Override
   public Trainer save(Long id, Trainer object) throws Exception {
      if (Optional.ofNullable(trainerMemory.get(id)).isPresent()) {
         throw new Exception("Trainer con id" + id + "ya creado en la bd");
      }

      return trainerMemory.put(id, object);
   }

   @Override
   public void delete(Long id) throws Exception {
      if (!Optional.ofNullable(trainerMemory.get(id)).isPresent()) {
         throw new Exception("Trainer con id" + id + "no se encuentra en la bd");
      }
      trainerMemory.remove(id);
   }

   @Override
   public Trainer update(Long id, Trainer object) throws Exception {
      if (!Optional.ofNullable(trainerMemory.get(id)).isPresent()) {
         throw new Exception("Trainer con id" + id + "no se encuentra en la bd");
      }
      return trainerMemory.get(id);
   }

   public Integer getTotalOfTrainer() {
      return trainerMemory.size();
   }

   public boolean isUsernameSelected(String usernameToSearch) {
      boolean isPresent = false;

      for (Entry<Long, Trainer> trainer : trainerMemory.entrySet()) {
         if (trainer.getValue().getUsername().equals(usernameToSearch)) {
            isPresent = true;
         }
      }
      return isPresent;
   }

   public HashMap<Long, Trainer> getTrainerMemory() {
      return trainerMemory;
   }

   @Autowired
   public void setTrainerMemory(HashMap<Long, Trainer> trainerMemory) {
      this.trainerMemory = trainerMemory;
   }

}