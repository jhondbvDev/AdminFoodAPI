package com.udea.adminfood.api.service;

import java.util.List;
import java.util.Optional;

import com.udea.adminfood.api.exception.BusinessException;
import com.udea.adminfood.api.model.Plate;
import com.udea.adminfood.api.repository.IPlateRepository;

import org.springframework.stereotype.Service;

@Service
public class PlateService {

	private IPlateRepository _plateRepository;
	
	public PlateService(IPlateRepository plateRepository) {
		_plateRepository=plateRepository;

	}
	
	public List<Plate> getPlates(){
		return _plateRepository.findAll();
	}
	

    public Plate getPlate(Integer id)  {
        Optional<Plate> plate =_plateRepository.findById(id);
        if(!plate.isPresent())
            {throw new BusinessException("exception.data_not_found.plate");}
        return plate.get();
    }


    public List<Plate> search(String term) {
        return _plateRepository.findAll();
    }

    public Plate createUpdatePlate(Plate plate)
    {
    	return _plateRepository.save(plate);
    }

    public void deletePlate(Integer Id) 
    {
        Optional<Plate> OPlate =_plateRepository.findById(Id);
        if(!OPlate.isPresent())
            {throw new BusinessException("exception.data_not_found.plate");}
        _plateRepository.deleteById(Id);
        _plateRepository.flush();
    } 
}