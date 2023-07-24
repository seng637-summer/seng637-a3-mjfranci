package org.jfree.data;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.jfree.data.Range;

public class RangeTestSuite {
	private Range exampleRange; 
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception { exampleRange = new Range(-100.0, 100.0);
	}

	@After
	public void tearDown() throws Exception {
	}



	@Test
	public void testConstrainNotContainingValue() {
		assertEquals("Should return NaN", Double.NaN, exampleRange.constrain(Double.NaN), 0.01d);
	}
	
	@Test
	public void testConstrainReturnUpperBound() {
		assertEquals("Should return upper bound of 100", 100.0, exampleRange.constrain(101), 0.01d);
	}
	
	@Test
	public void testConstrainReturnUpperBoundRobust() {
		assertEquals("Should return upper bound of 100", 100.0, exampleRange.constrain(1000), 0.01d);
	}
	
	@Test
	public void testConstrainReturnLowerBound() {
		assertEquals("Should return lower bound of -100", -100.0, exampleRange.constrain(-101), 0.01d);
	}
	
	@Test
	public void testConstrainReturnLowerBoundRobust() {
		assertEquals("Should return lower bound of -100", -100.0, exampleRange.constrain(-1000), 0.01d);
	}
	
	@Test
	public void testConstrainReturnInnerValue() {
		assertEquals("Should return the input value of 0", 0.0, exampleRange.constrain(0), 0.01d);
	}
	
	@Test
	public void testConstrainReturnInnerValueRobust() {
		assertEquals("Should return the input value of 50", 50.0, exampleRange.constrain(50), 0.01d);
	}


}