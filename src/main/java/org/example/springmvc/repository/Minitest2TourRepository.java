package org.example.springmvc.repository;

import org.example.springmvc.model.minitest2.Tour2;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;

public interface Minitest2TourRepository extends JpaRepository<Tour2, Integer> {
    @Modifying
    @Transactional
    @Query("UPDATE Tour b SET b.code = :code, b.destination = :destination, b.start = :start, b.img = :img WHERE b.id = :id")
    void updateTour(@Param("code") String code,
                    @Param("destination") String destination,
                    @Param("start") Date start,
                    @Param("img") String img,
                    @Param("id") int id);
    Page<Tour2> findByCodeContainingIgnoreCase(String query, Pageable pageable);

}
