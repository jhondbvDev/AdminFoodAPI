package com.udea.adminfood.api.repository;

import java.util.Optional;

import com.udea.adminfood.api.model.Plate;

import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.EntityGraph.EntityGraphType;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface IPlateRepository extends JpaRepository<Plate, Integer> {

    // @Query("FROM Plate p JOIN  p.inputPlates ip  JOIN FETCH  ip.input WHERE p.id = :id")
    // // @EntityGraph(value = "plate.inputPlates", type = EntityGraphType.LOAD)
    //  Plate getPlateFetchInput( @Param("id") Integer id);

}
