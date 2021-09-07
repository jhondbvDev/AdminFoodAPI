package com.udea.adminfood.api.repository;

import org.springframework.stereotype.Repository;

import com.udea.adminfood.api.model.Plate;

import org.springframework.data.jpa.repository.JpaRepository;

@Repository
public interface IPlateRepository extends JpaRepository<Plate, Integer> {

}
