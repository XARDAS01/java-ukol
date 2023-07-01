package com.example.demo.domain;

import java.math.BigDecimal;
import javax.persistence.*;

import lombok.*;

@Entity
@Table(name = "transactions")
@EqualsAndHashCode(of = "id")
@Getter
@Setter
@NoArgsConstructor
public class Transaction {

  @Id
  @GeneratedValue
  private Long id;

  private BigDecimal amount;

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "account")
  private BankAccount bankAccount;

  public Transaction(BigDecimal amount, BankAccount bankAccount) {
    this.amount = amount;
    this.bankAccount = bankAccount;
  }
}
