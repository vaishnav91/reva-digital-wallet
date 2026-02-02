package com.wallet.reva_digital_wallet.entity.controller;

import com.wallet.reva_digital_wallet.entity.User;
import com.wallet.reva_digital_wallet.entity.Wallet;
import com.wallet.reva_digital_wallet.service.UserService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
public class UserController {

    private final UserService service;

    public UserController(UserService service) {
        this.service = service;
    }

    @PostMapping
    public Wallet createUser(@RequestBody User user) {
        return service.createUserWithWallet(user);
    }
}
