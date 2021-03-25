/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.advanced_project.dao;

import java.util.List;

/**
 *
 * @author regis
 * @param <T>
 */
public interface UserDaoInterface<T> extends DaoInterface<T>{
    public T findByUsername(String username);
    public List<T> findAllStaff();
}
