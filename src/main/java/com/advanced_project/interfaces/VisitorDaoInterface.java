/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.advanced_project.interfaces;

/**
 *
 * @author regis
 * @param <T>
 */
public interface VisitorDaoInterface<T> extends DaoInterface<T> {
    T findByUsername(String username);
}
