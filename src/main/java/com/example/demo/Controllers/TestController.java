package com.example.demo.Controllers;

import com.example.demo.domain.BankAccount;
import com.example.demo.domain.Subject;
import com.example.demo.repository.BankAccountRepository;
import com.example.demo.repository.SubjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.transaction.Transactional;

@RestController
public class TestController {
    @Autowired(required = false)
    private SubjectRepository subjectRepository;

    @Autowired(required = false)
    private BankAccountRepository bankAccountRepository;

    @GetMapping("/test")
    public String test () {
        return "test mess";
    }

    @GetMapping("/createBank")
    @Transactional
    public String createBank () {
        BankAccount bankAccount = new BankAccount();
        bankAccountRepository.save(bankAccount);
        return "createBank";
    }

    @GetMapping("/createAccount")
    @Transactional
    public String createAccount () {
        Subject subject = new Subject();
        subjectRepository.save(subject);
        return "createAccount";
    }
}
