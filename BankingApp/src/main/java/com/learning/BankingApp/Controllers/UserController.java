package com.learning.BankingApp.Controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.learning.BankingApp.DTO.AccountRequest;
import com.learning.BankingApp.DTO.AccountSummary;
import com.learning.BankingApp.DTO.BeneficiaryRequest;
import com.learning.BankingApp.DTO.BeneficiarySummary;
import com.learning.BankingApp.DTO.ResponseResult;
import com.learning.BankingApp.model.Account;
import com.learning.BankingApp.service.UserService;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/customer")
public class UserController {
    @Autowired
	private UserService userService;

    @PostMapping("/{userid}/account")
    public ResponseResult<?> createAccount(@PathVariable Long userid, @RequestBody @Valid AccountRequest accountRequest) {
       return ResponseResult.okResult(userService.createAccountByUserId(userid, accountRequest).toString());

    }
    
    @GetMapping("/{userid}/account")
    public ResponseEntity<List<AccountSummary>> getAllAccountUsers(@PathVariable("userid") Long userid){
    	List<AccountSummary> sum = userService.getAllAccountSummaryByUserId(userid);
		return ResponseEntity.ok(sum);
    }
    
    @PostMapping("/{userid}/beneficiary")
    public ResponseResult<?> addBeneficiary(@PathVariable Long userid, @RequestBody @Valid BeneficiaryRequest beneficiaryRequest) {
    	return ResponseResult.okResult(userService.addBeneficiaryByUserId(userid, beneficiaryRequest).toString());
    }
    
    @GetMapping("/{userid}/beneficiary")
    public ResponseEntity<List<BeneficiarySummary>> getAllBeneficiaryAccount(@PathVariable("userid") Long userid){
    	List<BeneficiarySummary> sum = userService.getAllBeneficiarySummaryByUserId(userid);
		return ResponseEntity.ok(sum);
    }
    
}