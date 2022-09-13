package com.misiontic.warbug.controller;

import com.misiontic.warbug.models.Transaction;
import com.misiontic.warbug.service.ITransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/transaction")
public class TransactionController {

    @Autowired
    private ITransactionService service;

    @GetMapping("/hola")
    public String hola(Model model) throws Exception {
        /*model.addAttribute("Transacciones", service.readAll());*/
        model.addAttribute("mensaje","hola desde thymeleaf");

        return "hola";
    }

    @GetMapping("/greeting")
    public String greeting(@RequestParam(name="name", required=false, defaultValue="World") String name, Model model) {
        model.addAttribute("name", name);
        return "greeting";
    }

    @PostMapping
    public Transaction create(@RequestBody Transaction transaction) throws Exception {
        return service.create(transaction);
    }

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
