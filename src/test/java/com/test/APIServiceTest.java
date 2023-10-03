package com.test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.demo.inject.ApiService;
import com.demo.inject.EmailService;
import com.demo.inject.SMSService;

@ExtendWith(MockitoExtension.class)
public class APIServiceTest {
	
	@Mock
	EmailService emailService;
	@Mock
	SMSService smsService;
	//on top of mock annotation
	@InjectMocks
	ApiService apiService;
	
	@Test
	public void testApi() {
		when(apiService.sendEmail("Email")).thenReturn(true);
		when(apiService.sendEmail(anyString())).thenReturn(false);
		
		assertTrue(apiService.sendEmail("Email"));
		assertFalse(apiService.sendSMS("Welcome"));

	}
	
}
