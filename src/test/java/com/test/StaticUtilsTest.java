package com.test;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.MockedStatic;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import com.demo.StaticUtils;

@ExtendWith(MockitoExtension.class)
public class StaticUtilsTest {

	StaticUtils staticUtils;
	
	@BeforeEach
	public void init() {
		staticUtils = new StaticUtils();
	}
	
	@Test
	public void testPrivateMethod() {
		assertEquals(staticUtils.getTest("Hello"), "HelloBuilding");
	}
	
	@Test
	public void testPrivateMethod1() throws NoSuchMethodException, SecurityException, IllegalAccessException,
	IllegalArgumentException, InvocationTargetException{
		
		//Reflection API -- it mainly used to call private method and constructor from outside the class
		
		
		Method method = StaticUtils.class.getDeclaredMethod("privateTest", String.class);
		method.setAccessible(true);
		StaticUtils staticUtils = new StaticUtils();
		String result = (String) method.invoke(staticUtils, "Hello"); //staticUtils.privateTest("Hello")
		assertEquals(result, "HelloBuilding");
	}
	
	@Test
	public void staticTest() {
		//try with resources ... --- without any catch (it id added in jDK 7)
		try (MockedStatic mockStatic = Mockito.mockStatic(StaticUtils.class)){
			mockStatic.when(StaticUtils::range).thenReturn("Welcome");
			
			assertEquals(StaticUtils.range(), "Welcome");
		}
	}
}

