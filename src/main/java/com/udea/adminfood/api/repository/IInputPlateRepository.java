package com.udea.adminfood.api.repository;

import com.udea.adminfood.api.model.InputPlate;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IInputPlateRepository extends JpaRepository<InputPlate, Integer> {
    
}
