package com.udea.adminfood.api.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.udea.adminfood.api.model.Plate;
import com.udea.adminfood.api.repository.IPlateRepository;

@Service
public class PlateService {

	private IPlateRepository _plateRepository;
	
	public PlateService(IPlateRepository plateRepository ) {
		_plateRepository=plateRepository;
	}
	
	public List<Plate> getPlates(){
		return _plateRepository.findAll();
	}
	

    public Plate getPlate(Integer id) throws Exception {
        Optional<Plate> plate =_plateRepository.findById(id);
        if(!plate.isPresent())
            {throw new Exception("exception.data_not_found.plate");}
        return plate.get();
    }


    public List<Plate> search(String term) {
        return _plateRepository.findAll();
    }

    public void createUpdatePlate(Plate plate)
    {
    	_plateRepository.save(plate);
    }

    public void deletePlate(Plate plate) throws Exception
    {
        Optional<Plate> OPlate =_plateRepository.findById(plate.getId());
        if(!OPlate.isPresent())
            {throw new Exception("exception.data_not_found.plate");}
        _plateRepository.deleteById(plate.getId());
    }
}
