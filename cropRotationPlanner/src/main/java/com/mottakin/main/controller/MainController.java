package com.mottakin.main.controller;

import com.mottakin.main.dao.ICropRepository;
import com.mottakin.main.dao.IFieldRepository;
import com.mottakin.main.model.Crop;
import com.mottakin.main.model.Field;
import com.mottakin.main.service.impl.CropService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import java.util.Collections;
import java.util.List;
@RestController
public class MainController {
    private ICropRepository iCropRepository;
    private IFieldRepository iFieldRepository;
    public MainController(ICropRepository iCropRepository, IFieldRepository iFieldRepository) {
        this.iCropRepository = iCropRepository;
        this.iFieldRepository = iFieldRepository;
    }
    private CropService cropService;
    @Autowired
    public MainController(CropService cropService) {
        this.cropService = cropService;
    }
    @GetMapping("/id/{id}")
    public ResponseEntity<?> getCropById(@RequestBody Long id)
    {
        return new ResponseEntity<>(cropService.getId(id), HttpStatus.OK);
    }
   /* *//*@PostMapping("/save")
    public Crop saveCropWithField(@RequestBody Crop crop)
    {

        return iCropRepository.save(crop);
    }*/
    /*@GetMapping("/get")
    public List<Crop> findAllCrops()
    {
        return iCropRepository.findAll();
    }*/
    @GetMapping("/{cropId}")
    public Crop findCrop(@PathVariable Long cropId)
    {
        return iCropRepository.findById(cropId).orElse(null);
    }

    @GetMapping("find/{cropName}")
    public List<Crop> findCropsByName(@PathVariable String cropName){
        return iCropRepository.findByCropNameContaining(cropName);
    }
    @GetMapping("find/field/{fieldName}")
    public List<Field> findFieldByName(@PathVariable String fieldName)
    {
        return iFieldRepository.findByFieldNameContaining(fieldName);
    }

}
