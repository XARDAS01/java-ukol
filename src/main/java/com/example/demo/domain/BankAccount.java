package com.example.demo.domain;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.List;

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

  public BankAccount(Long id) {
    this.id = id;
  }
}
