package com.example.demo.service;

import com.example.demo.api.PostTransactionRequest;
import com.example.demo.domain.BankAccount;
import com.example.demo.domain.Subject;
import com.example.demo.domain.Transaction;
import com.example.demo.repository.BankAccountRepository;
import com.example.demo.repository.SubjectRepository;
import com.example.demo.repository.TransactionRepository;
import lombok.RequiredArgsConstructor;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigDecimal;
import java.util.List;
import java.util.NoSuchElementException;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@RequiredArgsConstructor
class TransactionServiceImplTest {

    private final TransactionRepository transactionRepository;
    private final SubjectRepository subjectRepository;
    private final BankAccountRepository bankAccountRepository;
    private final TransactionServiceImpl transactionService;

    @Test
    void createTransaction() {
        PostTransactionRequest request = new PostTransactionRequest();
        request.setAmount(new BigDecimal(1000));

        Assertions.assertDoesNotThrow(() -> transactionService.createTransaction(600L, request));

        Transaction transaction = transactionRepository.findById(600L)
                .orElseThrow(() -> new NoSuchElementException("Transaction not found"));

        Assertions.assertTrue(transaction.getAmount().compareTo(BigDecimal.valueOf(1000)) == 0);
    }

    @Test
    void createTransactionCheckAmount () {
        PostTransactionRequest request = new PostTransactionRequest();
        request.setAmount(new BigDecimal(0));

        Assertions.assertThrows(IllegalStateException.class,
                () -> transactionService.createTransaction(600L, request));
    }

    @BeforeEach
    void testBefore () {
        BankAccount bankAccount = new BankAccount();
        bankAccount.setId(600L);

        Subject subject = new Subject();
        subject.setId(600L);
        subject.setAccounts(List.of(bankAccount));

        subjectRepository.save(subject);
        bankAccountRepository.save(bankAccount);
    }

    @AfterEach
    void testAfter () {
        subjectRepository.deleteById(600L);
        bankAccountRepository.deleteById(600L);
    }
}