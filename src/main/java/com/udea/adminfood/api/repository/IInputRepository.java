package com.udea.adminfood.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.udea.adminfood.api.model.Input;

@Repository
public interface IInputRepository extends JpaRepository<Input, Integer> {

}
