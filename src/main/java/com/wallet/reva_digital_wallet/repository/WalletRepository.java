package com.wallet.reva_digital_wallet.repository;

import com.wallet.reva_digital_wallet.entity.Wallet;
import org.springframework.data.jpa.repository.JpaRepository;

public interface WalletRepository extends JpaRepository<Wallet, Long> {
}
