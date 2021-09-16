package com.udea.adminfood;

import com.udea.adminfood.api.dto.InputPlateDto;
import com.udea.adminfood.api.dto.PlateDto;
import com.udea.adminfood.api.model.InputPlate;
import com.udea.adminfood.api.model.Plate;

import org.modelmapper.ModelMapper;
import org.modelmapper.config.Configuration.AccessLevel;
import org.modelmapper.convention.NamingConventions;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ApplicationConfig {
    
    @Bean
	public ModelMapper modelMapper(){
        ModelMapper modelmapper = new ModelMapper();

		modelmapper.getConfiguration()
		.setFieldMatchingEnabled(true)
		.setFieldAccessLevel(AccessLevel.PRIVATE)
		.setSourceNamingConvention(NamingConventions.JAVABEANS_MUTATOR);

        modelmapper.typeMap(Plate.class, PlateDto.class).addMappings(m->m.map(src->src.getInputPlate(),PlateDto::setInputs));
        modelmapper.typeMap(InputPlate.class,InputPlateDto.class).addMappings(mapper ->{
			mapper.map(src->src.getPlate().getId(),InputPlateDto::setId_plate);
			mapper.map(src->src.getInput().getId(),InputPlateDto::setId_input);
		});
		return modelmapper;
	}
}
