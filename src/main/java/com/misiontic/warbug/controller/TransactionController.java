package com.misiontic.warbug.controller;

import com.misiontic.warbug.models.Employee;
import com.misiontic.warbug.models.Enterprise;
import com.misiontic.warbug.models.Transaction;
import com.misiontic.warbug.service.IEmployeeService;
import com.misiontic.warbug.service.IEnterpriseService;
import com.misiontic.warbug.service.ITransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
@Controller
@RequestMapping("/transaction")
public class TransactionController {

    @Autowired
    private ITransactionService service;
    @Autowired
    private IEnterpriseService Eservice;

    @Autowired
    private IEmployeeService Aservice;


    @GetMapping
    public String transacciones(Model model) throws Exception {
        model.addAttribute("Transacciones", service.readAll());
        model.addAttribute("SumaTotal",service.sumTotalTransaction());
        return "transacciones/listar";
    }

    @GetMapping("/nueva")
    public String crearTransaccion(Model model) throws Exception {
        Transaction transaction = new Transaction();
        model.addAttribute("transaction", transaction);
        return "transacciones/agregar";
    }

    @PostMapping("/guardarTransaccion")
    public String guardarTransaccion(@ModelAttribute("transaction") Transaction transaction) throws Exception {
        //Guardar Transaccion en la base de datos
        Enterprise enterprice = Eservice.readById(1l);
        transaction.setEnterprise(enterprice);

        Employee employee = Aservice.readById(1l);
        transaction.setEmployee(employee);
        service.create(transaction);

        return "redirect:/transaction";
    }
    /*
    @PostMapping
    public Transaction create(@RequestBody Transaction transaction) throws Exception {
        return service.create(transaction);
    }*/


    @GetMapping("/{id}")
    public Transaction TransactionById(@PathVariable("id") Long id) throws Exception {
        return service.readById(id);
    }

    @PatchMapping("/{id}")
    public Transaction update(@RequestBody Transaction transaction, @PathVariable("id") Long id) throws Exception {
        return service.update(transaction, id);
    }
    @DeleteMapping("/{id}")
    public void delete(@PathVariable("id") Long id) throws Exception {
        service.delete(id);
    }

}
