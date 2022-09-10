package com.misiontic.warbug.controller;

import com.misiontic.warbug.models.Transaction;
import com.misiontic.warbug.service.ITransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/transaction")
public class TransactionController {

    @Autowired
    private ITransactionService service;

    @GetMapping
    public List<Transaction> readAll() throws Exception {
        return service.readAll();
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
