package com.example.account.web;

import com.example.account.client.CustomerRestClient;
import com.example.account.entities.BankAccount;
import com.example.account.repository.AccountRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class accountController {
    private CustomerRestClient customerRestClient;
    private AccountRepository accountRepository;

    public accountController(CustomerRestClient customerRestClient, AccountRepository accountRepository) {
        this.customerRestClient = customerRestClient;
        this.accountRepository = accountRepository;
    }

    @GetMapping("/accounts")
    public List<BankAccount> accountList() {
        List<BankAccount> accountList = accountRepository.findAll();
        accountList.forEach(acc -> {
            acc.setCustomer(customerRestClient.findCustomerById(acc.getCustomerId()));
        });
        return accountList;
    }
}

