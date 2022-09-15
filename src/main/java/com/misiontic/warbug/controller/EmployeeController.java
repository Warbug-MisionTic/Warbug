package com.misiontic.warbug.controller;

import com.misiontic.warbug.models.Employee;
import com.misiontic.warbug.models.EmployeeProfile;
import com.misiontic.warbug.service.IEmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/employees")
public class EmployeeController {

    @Autowired
    private IEmployeeService service;

    @GetMapping
    public String readAllEmployee(Model model){
        model.addAttribute("Usuarios", service.readAllEmployee());
        return "usuario/listar";
    }

    @PostMapping
    public Employee create(@RequestBody Employee employee) throws Exception {
        return service.create(employee);
    }

    @GetMapping("/{id}")
    public Employee readById(@PathVariable("id") Long id) throws Exception {
        return service.readById(id);
    }

    @PatchMapping("/{id}")
    public Employee update(@RequestBody Employee employee, @PathVariable("id") Long id) throws Exception {
        return service.update(employee, id);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable("id") Long id) throws Exception {
        service.delete(id);
    }
}
