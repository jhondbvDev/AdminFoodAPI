package com.udea.adminfood.api.controller;

import java.util.List;

import com.udea.adminfood.api.dto.InputDto;
import com.udea.adminfood.api.model.Input;
import com.udea.adminfood.api.service.InputService;

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
@RequestMapping("api/inputs")
public class InputController {
    InputService _service;
    @Autowired
    ModelMapper mapper;

    @Autowired
    public InputController(InputService inputService) { 
        _service = inputService;
    }

    @GetMapping()
	public ResponseEntity<List<InputDto>> getInputs() {

		List<Input> inputs = _service.getInputs();
		List<InputDto> inputsDto =  mapper.map(inputs,new TypeToken<List<InputDto>>() {}.getType());

		return ResponseEntity.ok(inputsDto);
	}

	@GetMapping("{id}")
	public ResponseEntity<InputDto> getInput(@PathVariable Integer id) throws Exception {


		Input input = _service.getInput(id);
		InputDto inputDto = mapper.map(input, InputDto.class);
		return ResponseEntity.ok(inputDto);
	}

	@RequestMapping("get404")
	public String getInputNotFound404(Integer id) {
		return "";
	}

	@RequestMapping("search")
	public ResponseEntity<List<Input>> searchInputs(String term) {
		return ResponseEntity.ok(_service.getInputs());
	}

	@PutMapping
	public void updateInput(@RequestBody Input input) throws Exception {
		_service.createUpdateInput(input);
	}

	@PostMapping
	public void addInput(@RequestBody Input input) {
		_service.createUpdateInput(input);
	}

	@DeleteMapping
	@RequestMapping("{id}")
	public void deleteInput(@PathVariable Integer id) {
		_service.deleteInput(id);
	}
}
