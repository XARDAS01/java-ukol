package com.example.demo.domain;

import java.math.BigDecimal;
import java.util.List;

import lombok.Getter;
import lombok.Setter;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "bank_accounts")
@EqualsAndHashCode(of = "id")
@Getter
@Setter
@NoArgsConstructor
public class BankAccount {

  @Id
  @GeneratedValue
  private Long id;

  private String prefix;
  private String suffix;

  private boolean applyForLoan;

  private BigDecimal balance;

  @ManyToOne
  @JoinColumn(name = "subject")
  private Subject subject;

  @OneToMany
  @JoinColumn(name = "transactions")
  private List<Transaction> transactions;
}
