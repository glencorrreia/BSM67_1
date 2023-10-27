package com.learning.BankingApp.model;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.learning.BankingApp.Common.constants.ActiveStatus;

import lombok.Data;

	@Data
	@Entity
	@Table(
	    name = "beneficiary",
	    uniqueConstraints = {
	        @UniqueConstraint(columnNames = "beneficiaryAccountNo")
	    }
	)
	public class Beneficiary {

	    @Id
	    private Long beneficiaryAccountNo;

	    @NotBlank
	    private String beneficiaryName;
	    
	    @NotBlank
	    private String beneficiaryType;

	    @Enumerated(EnumType.STRING) 
	    private ActiveStatus active; 
	   

	    @ManyToOne
	    @JoinColumn(name = "userid")
	    @JsonIgnore
	    private User user;
	    
	    


		public Beneficiary(Long beneficiaryAccountNo, @NotBlank String beneficiaryName, ActiveStatus active,String beneficiaryType,
				User user) {
			super();
			this.beneficiaryAccountNo = beneficiaryAccountNo;
			this.beneficiaryName = beneficiaryName;
			this.active = active;
			this.user = user;
			this.beneficiaryType = beneficiaryType;

		}




		public Beneficiary() {
			super();
			// TODO Auto-generated constructor stub
		}

	


		
	    
	    
}
