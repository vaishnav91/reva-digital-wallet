package controller;

import com.wallet.reva_digital_wallet.entity.Transaction;
import com.wallet.reva_digital_wallet.service.TransactionService;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/transactions")
public class TransactionController {

    private final TransactionService service;

    public TransactionController(TransactionService service) {
        this.service = service;
    }

    @GetMapping("/{walletId}")
    public List<Transaction> getAll(@PathVariable Long walletId) {
        return service.getTransactions(walletId);
    }
}
