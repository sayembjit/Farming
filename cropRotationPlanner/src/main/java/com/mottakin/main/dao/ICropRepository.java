package com.mottakin.main.dao;

import com.mottakin.main.model.Crop;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository

public interface ICropRepository extends JpaRepository<Crop, Long> {
    List<Crop> findByCropNameContaining(String cropName);
}
