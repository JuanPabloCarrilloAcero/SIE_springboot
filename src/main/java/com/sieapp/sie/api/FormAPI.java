package com.sieapp.sie.api;

import com.sieapp.sie.model.Formulario;
import org.springframework.data.repository.CrudRepository;

public interface FormAPI extends CrudRepository<Formulario, Long> {

}
