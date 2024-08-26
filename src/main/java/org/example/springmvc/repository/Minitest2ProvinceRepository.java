package org.example.springmvc.repository;

import org.example.springmvc.model.dto.ProvinceDTO;
import org.example.springmvc.model.minitest2.Province;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface Minitest2ProvinceRepository extends JpaRepository<Province, Integer> {
    @Query(value = "SELECT p.name AS name, COUNT(t.id) AS number FROM province p LEFT JOIN tour t ON p.id = t.province_id GROUP BY p.name", nativeQuery = true)
    List<ProvinceDTO> getTourProvinceNumber();

    @Modifying
    @Transactional
    @Query(nativeQuery = true, value = "CALL UpdateAndDeleteProvince(:id)")
    void deleteProvinceById(@Param("id") int id);
}
