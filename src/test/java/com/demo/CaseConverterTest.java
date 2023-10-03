package com.demo;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

public class CaseConverterTest {

	CaseConverter cc;

	@BeforeEach
	void init() {
		cc = new CaseConverter();
	}

	@Test
	void testnull() {
		assertEquals(cc.convertCase(null), "");
		// if assertsEquals return true, test case pass, and if return false, test case
		// will go on red face
	}

	
	 
	   @Test void testsinglenumber() { assertEquals(cc.convertCase("1"), "1"); 
	  }
	  
//	  @Test void testmultiplenumbers() { assertEquals(cc.convertCase("10001"), "10001"); 
//	  }
	  
	  
	  @Test void empty() {  assertEquals(cc.convertCase(""), ""); 
	  }
	  
	  @Test void lowertoUpper() {  assertEquals(cc.convertCase("hello"), "HELLO"); } 
	  
	  
//	  @Test void upper() {  assertEquals(cc.convertCase("WORLD"), "WORLD"); } 
	  
	 
}
