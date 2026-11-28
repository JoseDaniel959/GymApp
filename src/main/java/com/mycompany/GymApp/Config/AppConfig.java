package com.mycompany.GymApp.Config;

import java.util.HashMap;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import com.mycompany.GymApp.model.Training;
import com.mycompany.GymApp.model.users.Trainee;
import com.mycompany.GymApp.model.users.Trainer;

@Configuration
@ComponentScan(basePackages = "com.mycompany")
public class AppConfig {

}