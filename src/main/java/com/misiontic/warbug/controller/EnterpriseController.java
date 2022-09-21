package com.misiontic.warbug.controller;

import com.misiontic.warbug.models.Employee;
import com.misiontic.warbug.models.Enterprise;
import com.misiontic.warbug.service.IEnterpriseService;
import net.bytebuddy.asm.Advice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/enterprises")
public class EnterpriseController {

    @Autowired
    private IEnterpriseService service;

    @GetMapping
    public String empresas(Model model) throws Exception {
        model.addAttribute("Empresas", service.readAll());
        return "empresas/listar";
    }
    @GetMapping("/nueva")
    public String crearEmpresa(Model model) throws Exception {
        Enterprise enterprise = new Enterprise();
        model.addAttribute("enterprise",enterprise);
        return "empresas/agregar";
    }

    @PostMapping("/guardarEmpresa")
    public String guardarEmpresa(@ModelAttribute("enterprise") Enterprise enterprise) throws Exception {
        //Guardar Empresa en la base de datos
        //Enterprise enterprice = Eservice.readById(1l);
        //enterprise.setEnterprise(enterprice);
        service.create(enterprise);
        return "redirect:/enterprises";
    }

    /*
    @PostMapping
    public Enterprise create(@RequestBody Enterprise enterprise) throws Exception {
        return service.create(enterprise);
    }*/

    @GetMapping("/{id}")
    public Enterprise readById(@PathVariable("id") Long id) throws Exception {
        return service.readById(id);
    }

    @PatchMapping("/{id}")
    public Enterprise update(@RequestBody Enterprise enterprise, @PathVariable("id") Long id) throws Exception {
        return service.update(enterprise, id);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable("id") Long id) throws Exception {
        service.delete(id);

    }
}