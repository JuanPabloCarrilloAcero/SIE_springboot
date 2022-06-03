package com.sieapp.sie.controller;

import com.sieapp.sie.model.Formulario;
import com.sieapp.sie.model.Persona;
import com.sieapp.sie.service.api.FormServiceAPI;
import com.sieapp.sie.service.api.PersonaServiceAPI;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/api/v1/form")
@CrossOrigin("*")
@EnableJpaAuditing
public class FormRestController {

    //@Autowired
    private final FormServiceAPI formServiceAPI; //private FormServiceAPI formServiceAPI;
    //@Autowired
    private final PersonaServiceAPI personaServiceAPI; //private PersonaServiceAPI personaServiceAPI;

    public FormRestController(FormServiceAPI formServiceAPI, PersonaServiceAPI personaServiceAPI) {
        this.formServiceAPI = formServiceAPI;
        this.personaServiceAPI = personaServiceAPI;
    }


    @GetMapping(value = "/all")
    public List<Formulario> getAll(){
        return formServiceAPI.getAll();
    }

    @GetMapping(value = "/find/{id}")
    public Formulario find(@PathVariable Long id){
        return formServiceAPI.get(id);
    }

    @PostMapping(value = "/save/{id}")
    public ResponseEntity<Formulario> save(@PathVariable Long id, @RequestBody Formulario form){
        Persona persona = personaServiceAPI.get(id);
        form.setPerson(persona);
        Formulario obj = formServiceAPI.save(form);
        return new ResponseEntity<>(obj, HttpStatus.OK); //ResponseEntity<Formulario>(obj, HttpStatus.OK);
    }

    @GetMapping(value = "/delete/{id}")
    public ResponseEntity<Formulario> delete(@PathVariable Long id){
        Formulario form = formServiceAPI.get(id);
        if(form != null){
            formServiceAPI.delete(id);
        } else {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR); //ResponseEntity<Formulario>(form, HttpStatus.INTERNAL_SERVER_ERROR); //form => null
        }
        return new ResponseEntity<>(form, HttpStatus.OK); //ResponseEntity<Formulario>(form, HttpStatus.OK);
    }
}

