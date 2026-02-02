package com.wallet.reva_digital_wallet.service;

import com.wallet.reva_digital_wallet.entity.*;
import com.wallet.reva_digital_wallet.repository.*;
import com.wallet.reva_digital_wallet.repository.UserRepository;

import org.springframework.stereotype.Service;

@Service
public class UserService {

    private final UserRepository userRepository;
    private final WalletRepository walletRepository;

    public UserService(UserRepository userRepository,
                       WalletRepository walletRepository) {
        this.userRepository = userRepository;
        this.walletRepository = walletRepository;
    }

    public Wallet createUserWithWallet(User user) {
        User savedUser = userRepository.save(user);

        Wallet wallet = new Wallet();
        wallet.setUser(savedUser);
        wallet.setBalance(0.0);

        return walletRepository.save(wallet);
    }
}
