package com.udea.adminfood.api.controller;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import com.udea.adminfood.api.dto.PlateDto;
import com.udea.adminfood.api.model.Input;
import com.udea.adminfood.api.model.InputPlate;
import com.udea.adminfood.api.model.Plate;
import com.udea.adminfood.api.service.InputService;
import com.udea.adminfood.api.service.PlateService;

import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/plates")
public class PlateController {

	PlateService _service;
	InputService _inputService;
	@Autowired
	ModelMapper mapper;

	@Autowired
	public PlateController(PlateService plateService, InputService inputService) {
		_service = plateService;
		_inputService = inputService;
	}

	@GetMapping()
	public ResponseEntity<List<PlateDto>> getPlates() {

		List<Plate> plates = _service.getPlates();
		List<PlateDto> platesDto =  mapper.map(plates,new TypeToken<List<PlateDto>>() {}.getType());

		return ResponseEntity.ok(platesDto);
	}

	@GetMapping("{id}")
	public ResponseEntity<PlateDto> getPlate(@PathVariable Integer id) throws Exception {


		Plate plate = _service.getPlate(id);
		PlateDto plateDto = mapper.map(plate, PlateDto.class);
		//Way 1 in ApplicationConfig.java

		//Way2
		//plateDto.setInputs(mapper.map(plate.getInputPlate(),new TypeToken<List<InputPlateDto>>() {}.getType()));
		
		//Way3
		// List<InputPlateDto> inputPlateDto = plate.getInputPlate().stream()
		// 		.map(e -> new InputPlateDto(e.getId(), e.getPlate().getId(), e.getInput().getId(), e.getQuantity()))
		// 		.collect(Collectors.toList());
		// plateDto.setInputs(inputPlateDto);
		return ResponseEntity.ok(plateDto);
	}

	@RequestMapping("get404")
	public String getPlateNotFound404(Integer id) {
		return "";
	}

	@RequestMapping("search")
	public ResponseEntity<List<Plate>> searchPlates(String term) {
		return ResponseEntity.ok(_service.getPlates());
	}

	@PutMapping
	public void updatePlate(@RequestBody Plate plate) throws Exception {
		_service.createUpdatePlate(plate);
	}

	@PostMapping
	public void addPlate(@RequestBody Plate plate) {
		_service.createUpdatePlate(plate);
	}

	@DeleteMapping
	@RequestMapping("{id}")
	public void deletePlate(@PathVariable Integer id) {
		_service.deletePlate(id);
	}

	@GetMapping
	@RequestMapping("test")
	public void test() {

		Plate plate = new Plate(0, "Delicioso Burrito de carne", "Burrito de carne", 12300, null);
		Input input = new Input(0, "Queso", 30, null, null);
		Input pan = new Input(0, "Pan", 10, null, null);

		input = _inputService.createUpdateInput(input);
		pan = _inputService.createUpdateInput(pan);
		// plate = _service.createUpdatePlate(plate);
		InputPlate inputPlate = new InputPlate(null, plate, input, 3);
		Set<InputPlate> setInputPlate = new HashSet<>();
		setInputPlate.add(inputPlate);
		setInputPlate.add(new InputPlate(0, plate, pan, 5));

		plate.setInputPlate(setInputPlate);

		_service.createUpdatePlate(plate);
	}

}
