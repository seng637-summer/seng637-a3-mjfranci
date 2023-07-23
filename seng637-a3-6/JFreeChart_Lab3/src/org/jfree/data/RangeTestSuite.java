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
	public void testHashCode() {
		int hashCode = exampleRange.hashCode();
		assertEquals("Hash codes should be same", hashCode, exampleRange.hashCode());
	}

	@Test
	public void testGetLowerBound() {
		double lowerBound = exampleRange.getLowerBound();
		assertEquals("LB should be same", lowerBound, exampleRange.getLowerBound(), 0.01d);
	}
	
	@Test
	public void testGetUpperBound() {
		double upperBound = exampleRange.getUpperBound();
		assertEquals("UB should be same", upperBound, exampleRange.getUpperBound(), 0.01d);
	}
	
	@Test
	public void testGetLength() {
		double length = exampleRange.getLength();
		assertEquals("length should be same", length, exampleRange.getLength(), 0.01d);
	}
	
	@Test
	public void testGetCentralValue() {
		double cv = exampleRange.getCentralValue();
		assertEquals("CV should be same", cv, exampleRange.getCentralValue(), 0.01d);
	}
	
	@Test
	public void testContains() {
		double value = 0;
		assertTrue("Should contain 0", exampleRange.contains(value));
	}

	@Test
	public void testIntersectsDoubleDouble() {
		assertTrue("Should intersect", exampleRange.intersects(-100, 100));
	}

	@Test
	public void testIntersectsRange() {
		Range newRange = new Range(-100,100);
		assertTrue("should intersect", exampleRange.intersects(newRange));
	}

	@Test
	public void testConstrain() {
		assertEquals("Should constrain to value", 1.3, exampleRange.constrain(1.3), 0.01d);
	}

	@Test
	public void testCombine() {
		Range newRange = new Range(100,200);
		Range finalRange = new Range(-100,200);
		assertEquals("Ranges should be equal", finalRange, Range.combine(exampleRange, newRange));
	}

	@Test
	public void testCombineIgnoringNaN() {
		Range negRange = new Range(Double.NEGATIVE_INFINITY, 0);
		Range posRange = new Range(0,Double.POSITIVE_INFINITY);
		Range newRange = new Range(Double.NEGATIVE_INFINITY,Double.POSITIVE_INFINITY);
		assertEquals("Ranges should be equal", newRange, Range.combineIgnoringNaN(posRange, negRange));
	}

	@Test
	public void testExpandToInclude() {
		Range newRange = new Range(-100,101);
		assertEquals("Ranges should be equal", newRange, Range.expandToInclude(exampleRange, 101));
	}

	@Test
	public void testExpand() {
		Range newRange = new Range(-101,101);
		assertEquals("Ranges should be equal", newRange, Range.expand(exampleRange, -101, 101));
	}

	@Test
	public void testShiftRangeDouble() {
		Range newRange = new Range(-95,105);
		assertEquals("Ranges should be equal", newRange, Range.shift(exampleRange, 5));
	}

	@Test
	public void testShiftRangeDoubleBoolean() {
		Range newRange = new Range(-95,105);
		assertEquals("Ranges should be equal", newRange, Range.shift(exampleRange, 5, true));
	}

	@Test
	public void testScale() {
		Range newRange = new Range(-200,200);
		assertEquals("Ranges should be equal", newRange, Range.scale(exampleRange, 2));
	}

	@Test
	public void testEqualsObject() {
		assertTrue("Ranges should be equal", exampleRange.equals(exampleRange));
	}

	@Test
	public void testIsNaNRange() {
		Range newRange = new Range(Double.NEGATIVE_INFINITY, Double.POSITIVE_INFINITY);
		assertTrue("Bounds should not be a number", newRange.isNaNRange());
	}

	@Test
	public void testToString() {
		String rangeString = exampleRange.toString();
		assertSame("Strings should be same", rangeString, exampleRange.toString());
	}

}
