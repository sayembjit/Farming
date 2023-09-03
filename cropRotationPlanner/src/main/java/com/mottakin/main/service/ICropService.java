package com.mottakin.main.service;

import com.mottakin.main.model.Crop;
import com.mottakin.main.model.Field;

import java.util.List;
import java.util.Optional;

public interface ICropService {
    List<Crop> getAllCrops();
    List<Field> getAllFields();
    Optional<Crop> getId(Long id);
    public void saveCrop(Crop crop);

}
