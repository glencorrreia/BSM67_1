package com.learning.BankingApp.DTO;	

	import lombok.AllArgsConstructor;
	import lombok.Data;
	import lombok.NoArgsConstructor;


import javax.validation.constraints.*;



import com.learning.BankingApp.Common.constants.AccountStatus;
import com.learning.BankingApp.Common.constants.Approved;

	@Data
	@AllArgsConstructor(staticName="build")
	@NoArgsConstructor
	public class AccountRequest {
	   

	    @NotNull(message = "Type should not be null")
	    private String accountType;

	    @NotNull(message = "Balance should not be null")
	    private Double accountBalance;

	    @NotNull(message = "Approved should not be null")
	    private String approved;

	   
	    

		
		}
	



