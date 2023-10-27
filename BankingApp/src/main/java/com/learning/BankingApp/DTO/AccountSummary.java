package com.learning.BankingApp.DTO;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;





import com.learning.BankingApp.Common.constants.AccountStatus;
import com.learning.BankingApp.Common.constants.AccountType;

@Data
@AllArgsConstructor(staticName="build")
@NoArgsConstructor
public class AccountSummary {
   
	private Long accountid;
	
    private String accountType;

    private Double accountBalance;

    private String accountStatus;

   
    

	
	}