package com.example.demo.resource;

import com.example.demo.api.BankAccountResponse;
import com.example.demo.api.PostTransactionRequest;
import com.example.demo.service.BankAccountService;
import com.example.demo.service.TransactionService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/accounts")
@RequiredArgsConstructor
public class BankResource {

  private final BankAccountService bankAccountService;
  private final TransactionService transactionService;

  @GetMapping
  public ResponseEntity<Page<BankAccountResponse>> getLowBalanceAccounts(Pageable pageable) {
    return ResponseEntity.ok(bankAccountService.findAll(pageable));
  }

  @PostMapping("/{id}/transaction")
  public ResponseEntity<Void> addTransaction(@PathVariable Long id, @RequestBody PostTransactionRequest request) {
    transactionService.createTransaction(id, request);

    return ResponseEntity.accepted().build();
  }

  @PostMapping("/`{id}/loanTransaction")
  public ResponseEntity<Void> applyForLoan(@PathVariable Long id) {
    bankAccountService.applyForLoan(id);

    return ResponseEntity.accepted().build();
  }
}
