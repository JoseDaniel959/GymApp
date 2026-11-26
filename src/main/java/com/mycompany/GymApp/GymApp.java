package com.mycompany.GymApp;

import java.time.LocalDate;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.mycompany.GymApp.Config.AppConfig;
import com.mycompany.GymApp.DTO.TraineeDTO;


public class GymApp {
    private static final Logger logger = Logger.getLogger(GymApp.class.getName());

    public static void main(String[] args) throws Exception {
        logger.log(Level.INFO, "Application started");
        ApplicationContext gymApp = new AnnotationConfigApplicationContext(AppConfig.class);
        Facade facade = (Facade) gymApp.getBean("facade");

        //seleccione un trainee
        System.out.println(facade.getTraineeService().select(1L));
        

        // //crea un trainee
        facade.getTraineeService().create(new TraineeDTO("Jose", "Daniel", LocalDate.now(), "Colombia"));

        // //Selecionna el anterior trainee
        System.out.println(facade.getTraineeService().select(9L));
       
    }
}
