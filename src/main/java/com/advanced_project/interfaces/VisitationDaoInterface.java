/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.advanced_project.interfaces;

import com.advanced_project.domain.Museum;
import com.advanced_project.domain.VisitationOccurrenceStatus;
import com.advanced_project.domain.VisitationRequestStatus;
import java.util.List;

/**
 *
 * @author regis
 */
public interface VisitationDaoInterface<T> extends DaoInterface<T> {
    List<T> findAllVisitationsByRequestStatus(VisitationRequestStatus vrs, Museum museum);
    List<T> findAllVisitationByOccurrenceStatus(VisitationOccurrenceStatus vos, Museum museum);
    List<T> findAllTodayVisitation(Museum museum);
}
