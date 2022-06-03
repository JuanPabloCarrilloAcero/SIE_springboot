package com.sieapp.sie.impl;

import com.sieapp.sie.api.PersonaAPI;
import com.sieapp.sie.commons.GenericServiceImpl;
import com.sieapp.sie.model.Persona;
import com.sieapp.sie.service.api.PersonaServiceAPI;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

@Service
public class PersonaServiceImpl  extends GenericServiceImpl<Persona, Long> implements PersonaServiceAPI {
/*
    @Autowired
    private PersonaAPI personaAPI;

 */

    private final PersonaAPI personaAPI;

    public PersonaServiceImpl(PersonaAPI personaAPI) {
        this.personaAPI = personaAPI;
    }

    @Override
    public CrudRepository<Persona, Long> getDao() {
        return personaAPI;
    }
}
