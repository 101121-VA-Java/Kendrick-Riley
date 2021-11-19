package com.revature;

import com.revature.models.Calculator;

public class CalculatorTest {

	
	private static Calculator cal;
	
	
	
//		Junit Annotations
//
//		
//		before each

public void beforeEach() {
			System.out.println("");
		}

	public void addOneAndOne() {
		double expected = 2;
		double actual = cal.add(1, 1);
		assertEquals(expected, actual);
		
	}
}
