package com.example.demo.domain;

import java.util.List;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "subjects")
@EqualsAndHashCode(of = "id")
@Getter
@Setter
public class Subject {

  @Id
  @GeneratedValue
  private Long id;

  private String name;
  private String lastName;

  @OneToMany(mappedBy = "subject")
  private List<BankAccount> accounts;
}
