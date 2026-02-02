package com.wallet.reva_digital_wallet.repository;

import com.wallet.reva_digital_wallet.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
