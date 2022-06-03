package com.sieapp.sie.impl;

import com.sieapp.sie.api.FormAPI;
import com.sieapp.sie.commons.GenericServiceImpl;
import com.sieapp.sie.model.Formulario;
import com.sieapp.sie.service.api.FormServiceAPI;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;


@Service
public class FormServiceImpl  extends GenericServiceImpl<Formulario, Long> implements FormServiceAPI {
    /*
    @Autowired
    private FormAPI formAPI;

    */
    private final FormAPI formAPI;

    public FormServiceImpl(FormAPI formAPI) {
        this.formAPI = formAPI;
    }

    @Override
    public CrudRepository<Formulario, Long> getDao() {
        return formAPI;
    }
}