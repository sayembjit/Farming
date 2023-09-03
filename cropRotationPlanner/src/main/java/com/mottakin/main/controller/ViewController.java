package com.mottakin.main.controller;
import com.mottakin.main.dao.ICropRepository;
import com.mottakin.main.model.Crop;
import com.mottakin.main.service.impl.CropService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@Controller
public class ViewController {
    @Autowired
    private CropService cropService;
    @Autowired
    private ICropRepository iCropRepository;
    @GetMapping("/crops")
    public String listCrops(Model model)
    {
        model.addAttribute("crops",cropService.getAllCrops());
        return "crops.html";
    }
    @GetMapping("/home")
    public String home(Model model){
        model.addAttribute("allFields", cropService.getAllFields());
        return "home.html";
    }
    @PostMapping("/save")
    public String saveObj(Crop crop) {
        cropService.saveCrop(crop);
        return "redirect:/home";
    }
    @GetMapping("/delete/{id}")
    public String deleteCrop(@PathVariable Long id, Model model) {
        cropService.deleteCropById(id);
        return "redirect:/crops";
    }
    @GetMapping("/update/{id}")
    public String showUpdateForm(@PathVariable Long id, Model model) {
        Crop crop = iCropRepository.findById(id).get();
        if (crop != null) {
            model.addAttribute("crop", crop);
            return "update";
        }
        return "redirect:/crops";
    }

    @PostMapping("/update/{id}")
    public String updateCrop(@PathVariable Long id, @ModelAttribute Crop updatedCrop) {
        Crop crop = iCropRepository.findById(id).get();
        if (crop != null) {
            crop.setCropName(updatedCrop.getCropName());
            crop.setGrowthRequirements(updatedCrop.getGrowthRequirements());
            crop.setDiseaseSusceptibility(updatedCrop.getDiseaseSusceptibility());
            iCropRepository.save(crop);
            return "redirect:/crops";
        }
        return "redirect:/crops";
    }


}
