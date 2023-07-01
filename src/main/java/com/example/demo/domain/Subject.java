package com.example.demo.domain;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;


@Entity
@Table(name = "subjects")
@EqualsAndHashCode(of = "id")
@Getter
@Setter
@NoArgsConstructor
public class Subject {

  @Id
  @GeneratedValue
  private Long id;

  private String name;
  private String lastName;

  @OneToMany(mappedBy = "subject")
  private List<BankAccount> accounts;
}
