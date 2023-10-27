package com.learning.BankingApp.DTO;

import javax.validation.constraints.NotNull;

import com.learning.BankingApp.Common.constants.ActiveStatus;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;



@Data
@AllArgsConstructor(staticName="build")
@NoArgsConstructor
public class BeneficiaryRequest {
   

    @NotNull(message = "Type should not be null")
    private Long beneficiaryAccountNo;

    @NotNull(message = "Type should not be null")
    private String beneficiaryName;

    @NotNull(message = "Type should not be null")
    private String beneficiaryType;
    
    @NotNull(message = "Approved should not be null")
    private ActiveStatus active;


	
	}
