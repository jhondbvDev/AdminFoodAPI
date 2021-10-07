package com.udea.adminfood.api.dto;

public class InputDto {
    
    private Integer id;
    private String description;
    private Integer quantity;
    private Integer id_unit_measurement;
	private Integer id_input_type;
    
    public InputDto(Integer id, String description, Integer quantity, Integer id_unit_measurement,
            Integer id_input_type) {
        this.id = id;
        this.description = description;
        this.quantity = quantity;
        this.id_unit_measurement = id_unit_measurement;
        this.id_input_type = id_input_type;
    }
    public InputDto() {
    }
    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
    }
    public String getDescription() {
        return description;
    }
    public void setDescription(String description) {
        this.description = description;
    }
    public Integer getQuantity() {
        return quantity;
    }
    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }
    public Integer getId_unit_measurement() {
        return id_unit_measurement;
    }
    public void setId_unit_measurement(Integer id_unit_measurement) {
        this.id_unit_measurement = id_unit_measurement;
    }
    public Integer getId_input_type() {
        return id_input_type;
    }
    public void setId_input_type(Integer id_input_type) {
        this.id_input_type = id_input_type;
    }
    

}
