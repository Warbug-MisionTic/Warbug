package com.misiontic.warbug.controller;

import com.misiontic.warbug.models.Enterprise;
import com.misiontic.warbug.service.IEnterpriseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/enterprises")
public class EnterpriseController {

    @Autowired
    private IEnterpriseService service;

    @GetMapping
    public List<Enterprise> readAll() throws Exception {
        return service.readAll();
    }

    @PostMapping
    public Enterprise create(@RequestBody Enterprise enterprise) throws Exception {
        //return service.create(enterprise);
        return service.saveTransactional(enterprise, enterprise.getDetailsEmployees());
    }

    @GetMapping("/{id}")
    public Enterprise readById(@PathVariable("id") Long id) throws Exception {
        return service.readById(id);
    }

    @PutMapping("/{id}")
    public Enterprise update(@RequestBody Enterprise enterprise, @PathVariable("id") Long id) throws Exception {
        return service.update(enterprise, id);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable("id") Long id) throws Exception {
        service.delete(id);

    }
}