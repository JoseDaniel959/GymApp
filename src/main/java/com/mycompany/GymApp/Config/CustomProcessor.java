package com.mycompany.GymApp.Config;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;

import com.mycompany.GymApp.model.Training;
import com.mycompany.GymApp.model.TrainingType;
import com.mycompany.GymApp.model.users.Trainee;
import com.mycompany.GymApp.model.users.Trainer;
import com.mycompany.GymApp.model.users.User;

public class CustomProcessor implements BeanPostProcessor {

    ArrayList<Trainee> traineeArray = new ArrayList<>(Arrays.asList(
        new Trainee(1L, "Tom", "Ray", "Tom.Ray", "k#9Tz@Lq2!", true, LocalDate.of(1995, 4, 12), "12 Oak Street, Medellín"),
        new Trainee(2L, "Valeria", "Gómez", "Valeria.Gomez", "Xp4$mR8vNb", true, LocalDate.of(1991, 9, 30), "45 Laureles Avenue, Medellín"),
        new Trainee(3L, "Carlos", "Mejía", "Carlos.Mejia", "w7Qe!Zc2Ly", true, LocalDate.of(1988, 1, 17), "8 El Poblado Road, Medellín"),
        new Trainee(4L, "Emma", "Stone", "Emma.Stone", "Hn3&bT9uKd", true, LocalDate.of(2000, 6, 5), "77 Pine Lane, Envigado"),
        new Trainee(5L, "Lucas", "Ortiz", "Lucas.Ortiz", "j5Vr@Ma8Ws", false, LocalDate.of(1983, 11, 22), "3 Sabaneta Plaza, Sabaneta"),
        new Trainee(6L, "Nina", "Patel", "Nina.Patel", "Gd2#fY6xPc", true, LocalDate.of(1997, 2, 28), "19 Maple Court, Itagüí"),
        new Trainee(7L, "Andrés", "Restrepo", "Andres.Restrepo", "sB8!nL4qTe", true, LocalDate.of(1993, 8, 14), "60 Calle 10, Medellín"),
        new Trainee(8L, "Julia", "Novak", "Julia.Novak", "Rz6%cH1mUv", true, LocalDate.of(1999, 12, 1), "5 Birch Road, Bello")));

   ArrayList<Trainer> trainerArray = new ArrayList<Trainer>(Arrays.asList(
        new Trainer(1L, "Ann", "Lee", "Ann.Lee", "Tq7#vK2mXe", true, "Yoga"),
        new Trainer(2L, "Marcus", "Cole", "Marcus.Cole", "bN4!rW9cZp", true, "Strength"),
        new Trainer(3L, "Sofia", "Reyes", "Sofia.Reyes", "Yd8$hL3tQa", true, "Cardio"),
        new Trainer(4L, "David", "Kim", "David.Kim", "mF5&xS6jVu", false, "Crossfit"),
        new Trainer(5L, "Laura", "Petit", "Laura.Petit", "Cw2@pE7nGk", true, "Pilates")

));

    ArrayList<Training> trainingArray = new ArrayList<>(Arrays.asList(
            new Training(1L, 1L, 1L, "Ann Lee", TrainingType.YOGA, LocalDate.parse("2025-03-03"), 60L),
            new Training(2L, 2L, 1L, "Ann Lee", TrainingType.YOGA, LocalDate.parse("2025-03-04"), 90L),
            new Training(3L, 3L, 2L, "Marcus Cole", TrainingType.STRENGTH, LocalDate.parse("2025-03-05"), 60L),
            new Training(4L, 4L, 3L, "Sofia Reyes", TrainingType.CARDIO, LocalDate.parse("2025-03-06"), 45L),
            new Training(5L, 1L, 2L, "Marcus Cole", TrainingType.STRENGTH, LocalDate.parse("2025-03-10"), 75L),
            new Training(6L, 5L, 4L, "David Kim", TrainingType.CROSSFIT, LocalDate.parse("2025-03-11"), 60L),
            new Training(7L, 6L, 5L, "Laura Petit", TrainingType.PILATES, LocalDate.parse("2025-03-12"), 60L),
            new Training(8L, 7L, 3L, "Sofia Reyes", TrainingType.CARDIO, LocalDate.parse("2025-03-13"), 30L),
            new Training(9L, 8L, 1L, "Ann Lee", TrainingType.YOGA, LocalDate.parse("2025-03-14"), 60L),
            new Training(10L, 2L, 5L, "Laura Petit", TrainingType.PILATES, LocalDate.parse("2025-03-17"), 90L),
            new Training(11L, 3L, 3L, "Sofia Reyes", TrainingType.CARDIO, LocalDate.parse("2025-03-18"), 45L),
            new Training(12L, 4L, 2L, "Marcus Cole", TrainingType.STRENGTH, LocalDate.parse("2025-03-19"), 60L)));

    public <T extends User> void initUserMemory(HashMap<Long, T> mapBean, ArrayList<T> dataArray) {
        for (T t : dataArray) {
            mapBean.put(t.getUserId(), t);
        }
    }

    public void initTrainigMemory(HashMap<Long, Training> mapBean, ArrayList<Training> dataArray) {
        for (Training training : dataArray) {

            mapBean.put(training.getTrainingId(), training);
        }
    }

    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        if (beanName.equals("traineeMemory"))
            initUserMemory((HashMap<Long, Trainee>) bean, traineeArray);
        else if (beanName.equals("trainerMemory")) {
            initUserMemory((HashMap<Long, Trainer>) bean, trainerArray);

        } else if (beanName.equals("trainingMemory"))
            initTrainigMemory((HashMap<Long, Training>) bean, trainingArray);

        return bean;
    }

}
