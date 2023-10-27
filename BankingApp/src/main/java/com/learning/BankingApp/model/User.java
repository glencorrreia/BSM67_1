package com.learning.BankingApp.model;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.util.List;

@Entity
@Table(
    name = "user",
    uniqueConstraints = {
        @UniqueConstraint(columnNames = "username")
    }
)
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long userid;

    @NotBlank
    private String username;

    @NotBlank
    @Size(max = 120)
    private String password;

    @NotBlank
    private String fullname;

    @OneToMany(mappedBy = "user", fetch = FetchType.LAZY)
    private List<Account> accounts; // Corrected the typo in the field name

    @OneToMany(mappedBy = "user", fetch = FetchType.LAZY)
    private List<Beneficiary> beneficiaryaccount;

    public User() {
    }

    public User(String username, String fullname, String password) {
        this.username = username;
        this.password = password;
        this.fullname = fullname;
    }

    public Long getUserid() {
        return userid;
    }

    public void setUserid(Long userid) {
        this.userid = userid;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getFullname() {
        return fullname;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
    }

    public List<Account> getAccounts() {
        return accounts;
    }

    public void setAccounts(List<Account> accounts) {
        this.accounts = accounts;
    }
}
