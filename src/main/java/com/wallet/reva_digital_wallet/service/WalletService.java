package com.wallet.reva_digital_wallet.service;

import com.wallet.reva_digital_wallet.entity.*;
import com.wallet.reva_digital_wallet.exception.*;
import com.wallet.reva_digital_wallet.exception.ResourceNotFoundException;
import com.wallet.reva_digital_wallet.repository.TransactionRepository;
import com.wallet.reva_digital_wallet.repository.WalletRepository;

import org.springframework.stereotype.Service;
import java.time.LocalDateTime;

@Service
public class WalletService {

    private final WalletRepository walletRepository;
    private final TransactionRepository transactionRepository;

    public WalletService(WalletRepository walletRepository,
                         TransactionRepository transactionRepository) {
        this.walletRepository = walletRepository;
        this.transactionRepository = transactionRepository;
    }

    public Wallet addMoney(Long walletId, double amount) {
        Wallet wallet = walletRepository.findById(walletId)
                .orElseThrow(() -> new ResourceNotFoundException("Wallet not found"));

        wallet.setBalance(wallet.getBalance() + amount);

        transactionRepository.save(new Transaction(
                null, amount, "CREDIT", "Money Added",
                LocalDateTime.now(), wallet
        ));

        return walletRepository.save(wallet);
    }

    public Wallet spendMoney(Long walletId, double amount) {
        Wallet wallet = walletRepository.findById(walletId)
                .orElseThrow(() -> new ResourceNotFoundException("Wallet not found"));

        if (wallet.getBalance() < amount) {
            throw new InsufficientBalanceException("Insufficient balance");
        }

        wallet.setBalance(wallet.getBalance() - amount);

        transactionRepository.save(new Transaction(
                null, amount, "DEBIT", "Money Spent",
                LocalDateTime.now(), wallet
        ));

        return walletRepository.save(wallet);
    }
}
