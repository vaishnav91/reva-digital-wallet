package com.wallet.reva_digital_wallet.service;

import com.wallet.reva_digital_wallet.entity.Transaction;
import com.wallet.reva_digital_wallet.repository.TransactionRepository;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class TransactionService {

    private final TransactionRepository repository;

    public TransactionService(TransactionRepository repository) {
        this.repository = repository;
    }

    public List<Transaction> getTransactions(Long walletId) {
        return repository.findByWalletId(walletId);
    }
}
