package com.mycompany.GymApp.DAO;


public interface IDao<T> {
    T get(Long id) throws Exception;
    T save(Long id, T object) throws Exception;
    void delete(Long id) throws Exception;
    T update(Long id, T object) throws Exception;

}
