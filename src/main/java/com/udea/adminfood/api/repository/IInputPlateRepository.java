package com.udea.adminfood.api.repository;

import java.util.List;

import com.udea.adminfood.api.model.InputPlate;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface IInputPlateRepository extends JpaRepository<InputPlate, Integer> {
    
    @Query("FROM InputPlate p JOIN FETCH p.input i  WHERE p.plate.id = :id")
    // @EntityGraph(value = "plate.inputPlates", type = EntityGraphType.LOAD)
     List<InputPlate> getInputsByPlateId( @Param("id") Integer id);


}
