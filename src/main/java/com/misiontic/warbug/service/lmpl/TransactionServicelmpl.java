package com.misiontic.warbug.service.lmpl;

import com.misiontic.warbug.models.Enterprise;
import com.misiontic.warbug.models.Transaction;
import com.misiontic.warbug.repository.ITransactionRepository;
import com.misiontic.warbug.service.ITransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Objects;

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
        Transaction enDB = repo.findById(id).get();

        if (Objects.nonNull(transaction.getConcept()) && !"".equalsIgnoreCase(transaction.getConcept())) {
            enDB.setConcept(transaction.getConcept());
        }
        /* Validar esta condición porque no permite convertir float en String. Se parsea?*/
        if (Objects.nonNull(transaction.getAmount()) && transaction.getAmount() != 0.0f) {
            enDB.setAmount(transaction.getAmount());
        }

        enDB.setUpdatedAt(LocalDateTime.now());
        enDB.setCreatedAt(enDB.getCreatedAt());

        return repo.save(enDB);
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

    @Override
    public float sumTotalTransaction() {
        List<Transaction> transactions = repo.findAll();
        float total = 0.0f;
        for (Transaction transation:transactions) {
            total += transation.getAmount();
        }
        return total;
    }

}
