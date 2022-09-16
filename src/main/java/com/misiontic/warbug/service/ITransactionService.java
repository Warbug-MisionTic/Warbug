package com.misiontic.warbug.service;

import com.misiontic.warbug.models.Transaction;

import java.util.List;

public interface ITransactionService {
    Transaction create(Transaction transaction) throws Exception;
    Transaction update(Transaction transaction, Long id) throws Exception;
    List<Transaction> readAll() throws Exception;
    Transaction readById(Long id) throws Exception;
    void delete(Long id) throws Exception;

    float sumTotalTransaction();
}
