/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import java.util.ArrayList;

/**
 *
 * @author wiemhjiri
 */
public interface IService<T> {
    
    void insert(T t);
    void delete(T t,int id);
    void update(T t,int id);
    ArrayList<T> getAll();
    T getById(int id);
    
}
