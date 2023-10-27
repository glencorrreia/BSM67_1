package com.learning.BankingApp.DTO;

import com.learning.BankingApp.Common.constants.ActiveStatus;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor(staticName="build")
@NoArgsConstructor
public class BeneficiarySummary {
    private Long beneficiaryAccountNo;
    private String beneficiaryName;
    private ActiveStatus active;

}
