package com.udea.adminfood.api.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.udea.adminfood.api.exception.BusinessException;
import com.udea.adminfood.api.model.Input;
import com.udea.adminfood.api.repository.IInputRepository;

@Service
public class InputService {

	private IInputRepository _repository;
	
	
	public InputService(IInputRepository InputRepository ) {
		_repository=InputRepository;
	}
	
	public List<Input> getInputs(){
		return _repository.findAll();
	}
	

    public Input getInput(Integer id) throws Exception {
        Optional<Input> Input =_repository.findById(id);
        if(!Input.isPresent())
            {throw new Exception("exception.data_not_found.Input");}
        return Input.get();
    }


    public List<Input> search(String term) {
        return _repository.findAll();
    }

    public Input createUpdateInput(Input Input)
    {
    	return _repository.save(Input);
    }

    public void deleteInput(Integer id ) 
    {
        Optional<Input> OInput =_repository.findById(id);
        if(!OInput.isPresent())
            {throw new BusinessException("exception.data_not_found.Input");}
        _repository.deleteById(id);
    }
}