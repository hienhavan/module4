package org.example.springmvc.services.minitest2;


import org.example.springmvc.model.minitest2.Tour2;
import org.example.springmvc.repository.Minitest2TourRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class Minitest2Service {
    @Autowired
    private Minitest2TourRepository minitest2Repository;

    public Page<Tour2> tour2Page(Pageable pageable) {
        return minitest2Repository.findAll(pageable);
    }

    public Page<Tour2> searchTour(String query, Pageable pageable) {
        return minitest2Repository.findByCodeContainingIgnoreCase(query, pageable);
    }

    public List<Tour2> listTour() {
        return minitest2Repository.findAll();
    }
    public Tour2 findById(int id) {
        return minitest2Repository.findById(id).orElse(null);
    }

    public void saveTour(Tour2 tour2) {
        minitest2Repository.save(tour2);
    }

    public void updateTour(Tour2 tour2) {
        minitest2Repository.save(tour2);
    }

    public Tour2 getTourById(int id) {
        return minitest2Repository.findById(id).orElse(null);
    }

    public void deleteTour(int id) {
        minitest2Repository.deleteById(id);
    }
}
