package org.example.springmvc.services.minitest1;

import org.example.springmvc.model.minitest1.Tour;

import javax.transaction.SystemException;
import java.util.List;

public interface ITourService {
    List<Tour> findAll();

    void save(Tour tour) throws SystemException;

    Tour findById(int id);

    void remove(int id);
}
