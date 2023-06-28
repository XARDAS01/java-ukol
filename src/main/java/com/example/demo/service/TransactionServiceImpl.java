package com.example.demo.service;

import com.example.demo.api.PostTransactionRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class TransactionServiceImpl implements TransactionService{
    @Override
    public void createTransaction(Long account, PostTransactionRequest request) {
        System.out.println("some transaction");
    }
}
