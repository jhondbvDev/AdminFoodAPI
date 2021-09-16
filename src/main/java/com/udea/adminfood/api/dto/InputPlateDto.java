package com.udea.adminfood.api.dto;

public class InputPlateDto {
    
    private Integer id;
    private Integer id_plate;
    private Integer id_input;
    private Integer quantity;
    public InputPlateDto() {
    }
    public InputPlateDto(Integer id, Integer id_plate, Integer id_input,Integer quantity) {
        this.id = id;
        this.id_plate = id_plate;
        this.id_input = id_input;
        this.quantity=quantity;
    }
    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
    }
    public Integer getId_plate() {
        return id_plate;
    }
    public void setId_plate(Integer id_plate) {
        this.id_plate = id_plate;
    }
    public Integer getId_input() {
        return id_input;
    }
    public void setId_input(Integer id_input) {
        this.id_input = id_input;
    }
    public Integer getQuantity() {
        return quantity;
    }
    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    
}
