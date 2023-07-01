package com.example.demo.service;

import com.example.demo.api.PostTransactionRequest;
import com.example.demo.domain.BankAccount;
import com.example.demo.domain.Transaction;
import com.example.demo.repository.BankAccountRepository;
import com.example.demo.repository.TransactionRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.Optional;

@Component
@RequiredArgsConstructor
public class TransactionServiceImpl implements TransactionService{
    @Autowired
    private TransactionRepository transactionRepository;

    @Autowired
    private BankAccountRepository bankAccountRepository;

    @Override
    public ResponseEntity<Void> createTransaction(Long account, PostTransactionRequest request) {
        if (request.getAmount().compareTo(BigDecimal.ZERO) <= 0) throw new IllegalStateException("Your request will be probably rejected due to low balance");

        Optional<BankAccount> bankAccount = bankAccountRepository.findById(account);
        transactionRepository.save(new Transaction(request.getAmount(), bankAccount.get()));
        return ResponseEntity.accepted().build();
    }
}
