package controller;

import com.wallet.reva_digital_wallet.entity.Wallet;
import com.wallet.reva_digital_wallet.service.WalletService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/wallets")
public class WalletController {

    private final WalletService service;

    public WalletController(WalletService service) {
        this.service = service;
    }

    @PostMapping("/{id}/add")
    public Wallet add(@PathVariable Long id, @RequestParam double amount) {
        return service.addMoney(id, amount);
    }

    @PostMapping("/{id}/spend")
    public Wallet spend(@PathVariable Long id, @RequestParam double amount) {
        return service.spendMoney(id, amount);
    }
}
