package com.learning.BankingApp.service;

import java.sql.Timestamp;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.learning.BankingApp.Common.constants.ActiveStatus;
import com.learning.BankingApp.DTO.AccountRequest;
import com.learning.BankingApp.DTO.AccountSummary;
import com.learning.BankingApp.DTO.BeneficiaryRequest;
import com.learning.BankingApp.DTO.BeneficiarySummary;
import com.learning.BankingApp.Repository.AccountRepository;
import com.learning.BankingApp.Repository.BeneficiaryRepository;
import com.learning.BankingApp.Repository.UserRepository;
import com.learning.BankingApp.model.Account;
import com.learning.BankingApp.model.Beneficiary;
import com.learning.BankingApp.model.User;

@Service
public class UserServiceImpl implements UserService{
	
	@Autowired
	private AccountRepository accountRepository;
	
	@Autowired
	private UserRepository userRepository;

	@Autowired
	private BeneficiaryRepository beneficiaryRepository;

	
	@Override
	public Account createAccountByUserId(Long userid, AccountRequest accountRequest) {
	    Account account = new Account();
	    account.setAccountType(accountRequest.getAccountType());
	    account.setAccountBalance(accountRequest.getAccountBalance());
	    account.setApproved(accountRequest.getApproved());
	    account.setDateOfCreation(new Timestamp(0));

	    Optional<User> userOptional = userRepository.findById(userid);

	        User user = userOptional.get();
	        account.setUser(user);
	        Account savedAccount = accountRepository.save(account);
	        return savedAccount;
	    }


	
	@Override
	public List<AccountSummary> getAllAccountSummaryByUserId(Long userid) {
		// TODO Auto-generated method stub
		List<Account> accounts = accountRepository.findByUser_Userid(userid);
	        return accounts.stream()
	                .map(account -> {
	                    AccountSummary accountSummaryDTO = new AccountSummary();
	                    accountSummaryDTO.setAccountid(account.getAccountid());
	                    accountSummaryDTO.setAccountType(account.getAccountType());
	                    accountSummaryDTO.setAccountBalance(account.getAccountBalance());
	                    accountSummaryDTO.setAccountStatus(account.getAccountStatus());
	                    return accountSummaryDTO;
	                })
	                .collect(Collectors.toList());
	}

	@Override
	public Object addBeneficiaryByUserId(Long userid, BeneficiaryRequest beneficiaryRequest) {
		
		Beneficiary benefic = new Beneficiary();
		benefic.setBeneficiaryType(beneficiaryRequest.getBeneficiaryType());
		benefic.setBeneficiaryName(beneficiaryRequest.getBeneficiaryName());
		benefic.setBeneficiaryAccountNo(beneficiaryRequest.getBeneficiaryAccountNo());
		benefic.setActive(ActiveStatus.YES);
		
		Optional<User> userOptional = userRepository.findById(userid);
		
        User user = userOptional.get();
		benefic.setUser(user);
		Beneficiary ben = beneficiaryRepository.save(benefic);    
		return ben;
	}
	

	@Override
	public List<BeneficiarySummary> getAllBeneficiarySummaryByUserId(Long userid) {
         
		List<Beneficiary> beneficiarys = beneficiaryRepository.findByUser_Userid(userid);
        return beneficiarys.stream()
                .map(bene -> {
                    BeneficiarySummary beneficarySummaryDTO = new BeneficiarySummary();
                    beneficarySummaryDTO.setBeneficiaryAccountNo(bene.getBeneficiaryAccountNo());
                    beneficarySummaryDTO.setBeneficiaryName(bene.getBeneficiaryName());
                    beneficarySummaryDTO.setActive(bene.getActive());
                    return beneficarySummaryDTO;
                })
                .collect(Collectors.toList());
           
	}


	
	        
	}




