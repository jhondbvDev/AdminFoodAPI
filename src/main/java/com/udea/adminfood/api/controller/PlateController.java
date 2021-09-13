package com.udea.adminfood.api.controller;

import java.util.List;

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

import com.udea.adminfood.api.model.Input;
import com.udea.adminfood.api.model.InputPlate;
import com.udea.adminfood.api.model.Plate;
import com.udea.adminfood.api.service.InputService;
import com.udea.adminfood.api.service.PlateService;

@RestController
@RequestMapping("/plates")
public class PlateController {

	PlateService _service;
	InputService _inputService;
	
	@Autowired
	public PlateController(PlateService plateService,InputService inputService) {
		_service=plateService;
		_inputService= inputService;
	}
	
	@GetMapping()
	public List<Plate> getPlates()
	{
		List<Plate> plates = _service.getPlates();
		return plates;
	}
	
	 @GetMapping("{id}")
	    public ResponseEntity<Plate> getPlate(@PathVariable Integer id) throws Exception
	    {
	        return ResponseEntity.ok(_service.getPlate(id)) ;
	    }
	    
	    @RequestMapping("get404")
	    public String getPlateNotFound404(Integer id )
	    {
	        return "";
	    }

	    @RequestMapping("search")
	    public ResponseEntity<List<Plate>> searchPlates(String term)
	    {
	        return ResponseEntity.ok(_service.getPlates());
	    }

	    @PutMapping
	    @RequestMapping("update")
	    public void updatePlate(@RequestBody Plate plate) throws Exception
	    {
	        Plate OPlate = _service.getPlate(plate.getId());
	        
	            OPlate.setDescription(plate.getDescription());
	            _service.createUpdatePlate(plate);
	    }

	    @PostMapping
	    @RequestMapping("create")
	    public void addPlate(@RequestBody Plate plate)
	    {
	        _service.createUpdatePlate(plate);
	    }

	    @DeleteMapping
	    @RequestMapping("delete/{id}")
	    public void deletePlate( @PathVariable Integer id) 
	    {
	        _service.deletePlate(id);
	    }
	    
	    @GetMapping
	    @RequestMapping("test")
	    public void test() {
	    
		Plate plate = new Plate(0, "Delicioso Burrito de carne", "Burrito de carne", 12300, null);
		Input input = new Input(0, "Queso", 30, null, null);
		
		input =_inputService.createUpdateInput(input);
		//plate = _service.createUpdatePlate(plate);
		InputPlate inputPlate = new InputPlate(null, plate, input, 3);
		plate.setInputPlate(inputPlate);

		_service.createUpdatePlate(plate);
	    }

	
}
