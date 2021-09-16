package com.udea.adminfood.api.dto;

import java.util.List;

public class PlateDto{

    private Integer id;
    private String name;
    private String description;
    private List<InputPlateDto> inputs;
    private double price;

    public PlateDto() {
    }

    
    public PlateDto(Integer id, String name, String description, List<InputPlateDto> inputs, double price) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.inputs = inputs;
        this.price = price;
    }


    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getDescription() {
        return description;
    }
    public void setDescription(String description) {
        this.description = description;
    }
    public List<InputPlateDto> getInputs() {
        return inputs;
    }
    public void setInputs(List<InputPlateDto> inputs) {
        this.inputs = inputs;
    }
    public double getPrice() {
        return price;
    }
    public void setPrice(double price) {
        this.price = price;
    }


}