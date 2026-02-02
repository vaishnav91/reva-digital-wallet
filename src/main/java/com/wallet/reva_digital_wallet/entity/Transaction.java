package com.wallet.reva_digital_wallet.entity;

import jakarta.persistence.*;
import lombok.*;
import java.time.LocalDateTime;

@Entity
@Getter @Setter
@NoArgsConstructor @AllArgsConstructor
public class Transaction {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private double amount;
    private String type;
    private String description;
    private LocalDateTime timestamp;

    @ManyToOne
    @JoinColumn(name = "wallet_id")
    private Wallet wallet;
}
