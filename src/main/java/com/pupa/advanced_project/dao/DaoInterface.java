/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pupa.advanced_project.dao;

import java.util.List;

/**
 *
 * @author regis
 * @param <T>
 */
public interface DaoInterface<T> {
    public void save(T t);
    public void update(T t);
    public List<T> findAll();
    public T findById(int id);
    
}
