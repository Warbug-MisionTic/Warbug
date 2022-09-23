package com.misiontic.warbug.controller;

import com.misiontic.warbug.models.Employee;
import com.misiontic.warbug.models.Enterprise;
import com.misiontic.warbug.service.IEmployeeService;
import com.misiontic.warbug.service.IEnterpriseService;
import com.misiontic.warbug.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/employees")
public class EmployeeController {

    @Autowired
    private IEmployeeService service;

    @Autowired
    private UserService userService;

    @Autowired
    private IEnterpriseService Eservice;

    @GetMapping("/lista")
    public String readAllEmployee(Model model) throws Exception {
        model.addAttribute("Usuarios", service.readAll());
        return "usuario/listar";
    }

    @GetMapping("/nuevo")
    public String crearUsuario(Model model) throws Exception {
        Employee employee = new Employee();
        model.addAttribute("employee",employee);
        return "usuario/agregar";
    }

    @PostMapping("/guardarUsuario")
    public String guardarUsuario(@ModelAttribute("employee") Employee employee) throws Exception {
        //Guardar Empleado en la base de datos
        //Enterprise enterprice = Eservice.readById(1l);
        //employee.setEnterprise(enterprice);
        Authentication loggedInUser = SecurityContextHolder.getContext().getAuthentication();
        Employee user = userService.findByUsername(loggedInUser.getName());
        Enterprise enterprice = Eservice.readById(user.getIdEmployee());

        employee.setEnterprise(enterprice);

        System.out.println(employee);
        //service.create(employee);
        return "redirect:/employees";
    }

    /*@PostMapping
    public Employee create(@RequestBody Employee employee) throws Exception {
        return service.create(employee);
    }*/


   /* @GetMapping("/add")
    public String add(@ModelAttribute Employee employee, Model model) {
        model.addAttribute("employee", new Employee());
        return "usuario/agregar";
    }

    @PostMapping("/add")
    public String addEmployee(@ModelAttribute Employee employee, Model model) throws Exception {
        this.service.create(employee);
        return "redirect:/usuario/listar";
    }*/


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
