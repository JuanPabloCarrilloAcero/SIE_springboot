package com.sieapp.sie.controller;

import com.sieapp.sie.model.Persona;
import com.sieapp.sie.service.api.PersonaServiceAPI;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/api/v1")
@CrossOrigin("*")
public class PersonaRestController {

    //@Autowired
    private final PersonaServiceAPI personaServiceAPI; //private PersonaServiceAPI personaServiceAPI;

    public PersonaRestController(PersonaServiceAPI personaServiceAPI) { //DIDN'T EXISTED
        this.personaServiceAPI = personaServiceAPI;
    }

    @GetMapping(value = "/all")
    public List<Persona> getAll(){
        return personaServiceAPI.getAll();
    }

    @GetMapping(value = "/find/{id}")
    public Persona find(@PathVariable Long id){
        return personaServiceAPI.get(id);
    }

    @PostMapping(value = "/save")
    public ResponseEntity<Persona> save(@RequestBody Persona persona){
        Persona obj = personaServiceAPI.save(persona);
        return new ResponseEntity<>(obj, HttpStatus.OK); //ResponseEntity<Persona>(obj, HttpStatus.OK);
    }

    @GetMapping(value = "/delete/{id}")
    public ResponseEntity<Persona> delete(@PathVariable Long id){
        Persona persona = personaServiceAPI.get(id);
        if(persona != null){
            personaServiceAPI.delete(id);
        } else {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR); //ResponseEntity<Persona>(persona, HttpStatus.INTERNAL_SERVER_ERROR); persona => null
        }
        return new ResponseEntity<>(persona, HttpStatus.OK); //ResponseEntity<Persona>(persona, HttpStatus.OK);
    }
}
