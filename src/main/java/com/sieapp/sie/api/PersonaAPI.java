package com.sieapp.sie.api;

import com.sieapp.sie.model.Persona;
import org.springframework.data.repository.CrudRepository;

public interface PersonaAPI extends CrudRepository<Persona, Long> {

}
