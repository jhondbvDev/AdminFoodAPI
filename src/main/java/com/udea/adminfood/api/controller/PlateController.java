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

import com.udea.adminfood.api.model.Plate;
import com.udea.adminfood.api.service.PlateService;

@RestController
@RequestMapping("/plates")
public class PlateController {

	PlateService _service;
	
	@Autowired
	public PlateController(PlateService plateService) {
		_service=plateService;
	}
	
	@GetMapping()
	public List<Plate> getPlates()
	{
		List<Plate> plates = _service.getPlates();
		return plates;
	}
	
	 @GetMapping("{id}")
	    public ResponseEntity<Plate> getHero(@PathVariable Integer id) throws Exception
	    {
	        return ResponseEntity.ok(_service.getPlate(id)) ;
	    }
	    
	    @RequestMapping("consultar404")
	    public String getPlateNotFound404(Integer id )
	    {
	        return "";
	    }

	    @RequestMapping("buscar")
	    public ResponseEntity<List<Plate>> searchHeroes(String term)
	    {
	        return ResponseEntity.ok(_service.getPlates());
	    }

	    @PutMapping
	    @RequestMapping("actualizar")
	    public void updateHero(@RequestBody Plate plate) throws Exception
	    {
	        Plate OPlate = _service.getPlate(plate.getId());
	        
	            OPlate.setDescription(plate.getDescription());
	            _service.createUpdatePlate(plate);
	    }

	    @PostMapping
	    @RequestMapping("crear")
	    public void addHero(@RequestBody Plate plate)
	    {
	        _service.createUpdatePlate(plate);
	    }

	    @DeleteMapping
	    @RequestMapping("borrar")
	    public void deletehero( Plate plate) throws Exception
	    {
	        _service.deletePlate(plate);
	    }

	
}
