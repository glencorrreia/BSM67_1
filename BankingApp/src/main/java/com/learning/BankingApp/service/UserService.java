package com.learning.BankingApp.service;

import java.util.List;

import com.learning.BankingApp.DTO.AccountRequest;
import com.learning.BankingApp.DTO.AccountSummary;
import com.learning.BankingApp.DTO.BeneficiaryRequest;
import com.learning.BankingApp.DTO.BeneficiarySummary;

public interface UserService {

	Object createAccountByUserId(Long userid, AccountRequest accountRequest);


	List <AccountSummary> getAllAccountSummaryByUserId(Long userid);


	Object addBeneficiaryByUserId(Long userid, BeneficiaryRequest beneficiaryRequest);

	List<BeneficiarySummary> getAllBeneficiarySummaryByUserId(Long userid);
}
