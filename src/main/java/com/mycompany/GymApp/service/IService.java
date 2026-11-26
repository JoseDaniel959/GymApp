package com.mycompany.GymApp.service;

import com.mycompany.GymApp.DTO.TraineeDTO;

public interface IService<T> {
    T select(Long id);

    void create(T object);

    T update(Long id, T object);

    void delete(Long id);


}
