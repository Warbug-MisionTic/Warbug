package com.misiontic.warbug.service.lmpl;

import com.misiontic.warbug.models.Transaction;
import com.misiontic.warbug.repository.ITransactionRepository;
import com.misiontic.warbug.service.ITransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TransactionServicelmpl implements ITransactionService {


    @Autowired
    private ITransactionRepository repo;

    @Override
    public Transaction create(Transaction transaction) throws Exception {
        return repo.save(transaction);
    }

    @Override
    public Transaction update(Transaction transaction, Long id) throws Exception {
        return null;
    }

    @Override
    public List<Transaction> readAll() throws Exception {
        return repo.findAll();
    }

    @Override
    public Transaction readById(Long id) throws Exception {
        return repo.findById(id).orElse(null);
    }

    @Override
    public void delete(Long id) throws Exception {
        repo.deleteById(id);
    }
}
