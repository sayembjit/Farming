package com.mottakin.main.service.impl;

import com.mottakin.main.dao.ICropRepository;
import com.mottakin.main.dao.IFieldRepository;
import com.mottakin.main.exception.CropNotFoundException;
import com.mottakin.main.model.Crop;
import com.mottakin.main.model.Field;
import com.mottakin.main.service.ICropService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service

public class CropService implements ICropService {
    @Autowired
    private ICropRepository iCropRepository;
    @Autowired
    private IFieldRepository iFieldRepository;
    public CropService(ICropRepository iCropRepository, IFieldRepository iFieldRepository) {
        this.iCropRepository = iCropRepository;
        this.iFieldRepository = iFieldRepository;
    }
    @Override
    public List<Crop> getAllCrops() {
        return iCropRepository.findAll();
    }

    @Override
    public List<Field> getAllFields() {
        return iFieldRepository.findAll();
    }

    @Override
    public Optional<Crop> getId(Long id) throws CropNotFoundException {
        return iCropRepository.findById(id);
    }
    @Override
    public void saveCrop(Crop crop) {
        iCropRepository.save(crop);
    }
    public void deleteCropById(Long id) {
        // Check if the crop exists
        if (iCropRepository.existsById(id)) {
            iCropRepository.deleteById(id);
        } else {
            throw new CropNotFoundException();
        }
    }

    public Optional<Crop> getById(Long id) {
        return iCropRepository.findById(id);
    }
   /* public void updateCrop(Long id, Crop updateCrop) {
        Crop crop = iCropRepository.findById(id).orElse(null);
        if (crop != null) {
            crop.setCropName(updateCrop.getCropName());
            crop.setGrowthRequirements(updateCrop.getGrowthRequirements());
            crop.setDiseaseSusceptibility(updateCrop.getDiseaseSusceptibility());
            crop.setFields(updateCrop.getFields());
            iCropRepository.save(crop);
        }
    }*/

}
