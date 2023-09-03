package com.mottakin.main.model;

import jakarta.persistence.*;
import org.springframework.stereotype.Component;

import java.util.Set;

@Entity
@Component
public class Field {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String fieldName;
    private String location;
    /*@ManyToMany(mappedBy = "fields", fetch = FetchType.LAZY)*/
    /*private Set<Crop> crops;*/

    public Field() {
    }

    public Field(Long id, String fieldName, String location) {
        this.id = id;
        this.fieldName = fieldName;
        this.location = location;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFieldName() {
        return fieldName;
    }

    public void setFieldName(String fieldName) {
        this.fieldName = fieldName;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }


}
