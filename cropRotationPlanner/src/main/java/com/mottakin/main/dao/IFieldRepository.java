package com.mottakin.main.dao;

import com.mottakin.main.model.Crop;
import com.mottakin.main.model.Field;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface IFieldRepository extends JpaRepository<Field, Long> {
    List<Field> findByFieldNameContaining(String fieldName);
}
