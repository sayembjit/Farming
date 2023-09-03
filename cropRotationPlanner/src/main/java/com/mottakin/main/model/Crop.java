package com.mottakin.main.model;

import jakarta.persistence.*;
import jdk.jfr.DataAmount;
import org.springframework.stereotype.Component;

import java.util.Set;

@Entity
@Component
public class Crop {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String cropName;
    private String growthRequirements;
    private String diseaseSusceptibility;
    @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.PERSIST)
    @JoinTable(
            name = "crop_field_mapping",
            joinColumns = {
                    @JoinColumn(name = "crop_id")
            },
            inverseJoinColumns = {
                    @JoinColumn(name = "field_id")
            }
    )

    private Set<Field> fields;

    public Crop() {
    }

    public Crop(Long id, String cropName, String growthRequirements, String diseaseSusceptibility, Set<Field> fields) {
        this.id = id;
        this.cropName = cropName;
        this.growthRequirements = growthRequirements;
        this.diseaseSusceptibility = diseaseSusceptibility;
        this.fields = fields;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCropName() {
        return cropName;
    }

    public void setCropName(String cropName) {
        this.cropName = cropName;
    }

    public String getGrowthRequirements() {
        return growthRequirements;
    }

    public void setGrowthRequirements(String growthRequirements) {
        this.growthRequirements = growthRequirements;
    }

    public String getDiseaseSusceptibility() {
        return diseaseSusceptibility;
    }

    public void setDiseaseSusceptibility(String diseaseSusceptibility) {
        this.diseaseSusceptibility = diseaseSusceptibility;
    }

    public Set<Field> getFields() {
        return fields;
    }

    public void setFields(Set<Field> fields) {
        this.fields = fields;
    }

}
