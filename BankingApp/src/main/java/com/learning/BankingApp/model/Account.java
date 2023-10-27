package com.learning.BankingApp.model;

import javax.persistence.*;


import com.fasterxml.jackson.annotation.JsonIgnore;
import com.learning.BankingApp.Common.constants.AccountStatus;

import lombok.Data;

import java.sql.Timestamp;
import java.util.List;

@Data
@Entity
@Table(name = "account",
        uniqueConstraints = {
            @UniqueConstraint(columnNames = "accountid"),
        })
public class Account {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long accountid;

    private String accountType;
    private Double accountBalance;
    
    private String approved;
    
    
    private String accountStatus; 
    
    private Timestamp dateOfCreation;

    @ManyToOne
    @JoinColumn(name = "userid")
    @JsonIgnore
    private User user;

	public Account(Long accountid, String accountType, Double accountBalance, String approved, String accountStatus,
			Timestamp dateOfCreation, User user) {
		super();
		this.accountid = accountid;
		this.accountType = accountType;
		this.accountBalance = accountBalance;
		this.approved = approved;
		this.accountStatus = accountStatus;
		this.dateOfCreation = dateOfCreation;
		this.user = user;
	}

	public Account() {
		// TODO Auto-generated constructor stub
	}
    
    

	

}
	

	

	
