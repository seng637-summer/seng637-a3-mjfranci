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

	/**
     * ********************** contains() test ************************
     * public boolean contains(double value)
     * Returns true if the specified value is within the range and false otherwise
     * Parameters:
     * value - the value to be tested
     * Returns:
     * true if the range contains the specified value.
     */
    
    
    /**
     * This tests if contains() functions correctly for a range of values  from BLB to AUB
     */
    @Test
    public void containsValueJustBelowLowerBound() {
        assertFalse("The result should be false when input value is just below the lower bound of the range",
        exampleRange.contains(-100.00001));
    }
    
    
    /**
     * This tests if contains() functions correctly for a range of values  from BLB to AUB
     */
    @Test
    public void containsLowerBound() {
    	assertTrue("The result should be true when input value is the lower bound of the range",
                exampleRange.contains(-100));
    }
    
    
    /**
     * This tests if contains() functions correctly for a range of values  from BLB to AUB
     */
    @Test
    public void containsValueJustAboveLowerBound() {
    	assertTrue("The result should be true when input value is just above the lower bound",
                exampleRange.contains(-99.99999));
    }
    
    
    /**
     * This tests if contains() functions correctly for a range of values  from BLB to AUB
     */
    @Test
    public void containsNominalValue() {
    	assertTrue("The result should be true when input value is a nominal value within the range",
                exampleRange.contains(50));
    }
    
    
    /**
     * This tests if contains() functions correctly for a range of values  from BLB to AUB
     */
    @Test
    public void containsValueJustBelowUpperBound() {
    	assertTrue("The result should be true when input value is just below the upper bound of the range",
                exampleRange.contains(99.99999));
    }
    
    
    /**
     * This tests if contains() functions correctly for a range of values  from BLB to AUB
     */
    @Test
    public void containsUpperBound() {
    	assertTrue("The result should be true when input value is the upper bound of the range",
                exampleRange.contains(100));
    }
    
    
    /**
     * This tests if contains() functions correctly for a range of values  from BLB to AUB
     */
    @Test
    public void containsValueJustAboveUpperBound() {
    	assertFalse("The result should be false when input value is just above the upper bound of the range",
                exampleRange.contains(100.00001));
    }
    
    
    /**
     * This tests if contains() functions correctly for a range of values  from BLB to AUB
     */
    @Test
    public void containsNotANumber() {
    	assertFalse("The result should be false when input value is not a number",
                exampleRange.contains(Double.NaN));
    }
    
    
    /**
     * This tests if contains() functions correctly for a range of values  from BLB to AUB
     */
    @Test
    public void containsACharacter() {
    	assertFalse("The result should be false when input value is a character",
                exampleRange.contains('n'));
    }
    
    
    /**
     * This tests if contains() functions correctly for a range of values  from BLB to AUB
     */
    @Test
    public void containsValueInRangeWithNegativeBoundaries() {
    	Range testRange = new Range(-10, -5);
    	assertTrue("The result should be true when input value is within a range with negative boundary values",
                testRange.contains(-7));
    }
    
    
    /**
     * This tests if contains() functions correctly for a range of values  from BLB to AUB
     */
    @Test
    public void containsValueEqualToBothLowerAndUpperBoundaries() {
    	Range testRange = new Range(5, 5);
    	assertTrue("The result should be true when input value is equal to the lower and upper boundaries of the range",
                testRange.contains(5));
    }
    
    
    /**
     * NEW TEST ADDED
     * This tests if contains() functions correctly for a range of values  from BLB to AUB
     */
    @Test
    public void containsValueLessThanLowerBoundAndGreaterThanUpperBound() {
    	try {
    		Range testRange = new Range(4, -1);
        	testRange.contains(3);
        	fail("IllegalArgumentException should be thrown when the input value is lower than the lower bound "
        			+ "but higher than the upper bound!");
    	} catch (IllegalArgumentException e){
    		// Asserts that runnable throws an exception of type expectedThrowable when executed.
    		
    	} catch (Exception e) {
    		fail("IllegalArgumentException should be thrown when the input value is lower than the lower bound "
    				+ "but higher than the upper bound, not throw a " + e.toString() + " exception");
    	}
    	
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

	/**
     * **********************intersects () test ************************
     * public boolean intersects(double lower,double upper)
     * Returns true if the range intersects (overlaps) with the specified range, 
     * and false otherwise.
     * Parameters:
     * lower - the lower bound (should be <= upper bound).
     * upper - the upper bound (should be >= lower bound).
     * Returns:
     * true if the ranges intersect.
     */
    
    
    /**
     * This tests if intersects() functions correctly for a range of values  between the BLB and LB
     */
    @Test
    public void intersectsWithBLBAndLB() {
    	assertTrue("Should return true due to intercept with LB",this.exampleRange.intersects(-100.00001, -100.0));
    }
    
    
    /**
     * This tests if intersects() functions correctly for a range of values  between the BLB and ALB
     */
    @Test
    public void intersectsWithBLBAndALB() {
    	assertTrue("Should return true due to intercept with LB",
    			this.exampleRange.intersects(-100.00001,-99.99999));
    }
    
    
    /**
     * This tests if intersects() functions correctly for a range of values  between the BLB and AUB
     */
    @Test
    public void intersectsWithBLBAndAUB() {
    	assertTrue("Should return true due to intercept with LB and UB",
    			this.exampleRange.intersects(-100.00001, 100.00001));
    }
    
    
    /**
     * This tests if intersects() functions correctly for a range of values  between the LB and ALB
     */
    @Test
    public void intersectsWithLBAndALB() {
    	assertTrue("Should return true due to intercept with LB",
    			this.exampleRange.intersects(-100.0, -99.99999));
    }
    
    
    /**
     * This tests if intersects() functions correctly for a range of values  between the LB and UB
     */
    @Test
    public void intersectsWithLBAndUB() {
    	assertTrue("Should return true due to intercept with the entire range",
    			this.exampleRange.intersects(-100.0, 100.0));
    }
    
    
    /**
     * This tests if intersects() functions correctly for a range of values that fall with in the normal range
     */
    @Test
    public void intersectsWithNormalAndNormal() {
    	assertTrue("Should return true due to intercept with nominal range",
    			this.exampleRange.intersects(-99, 99));
    }
    
    
    /**
     * This tests if intersects() functions correctly for a range of values  between the BUB and UB
     */
    @Test
    public void intersectsWithBUBAndUB() {
    	assertTrue("Should return true due to intercept with UB",
    			this.exampleRange.intersects(99.99999, 100.0));
    } //fail
    
    
    /**
     * This tests if intersects() functions correctly for a range of values  between the BUB and AUB
     */
    @Test
    public void intersectsWithBUBAndAUB() {
    	assertTrue("Should return true due to intercept with UB",
    			this.exampleRange.intersects(99.99999, 100.00001));
    } //fail
    
    
    /**
     * This tests if intersects() functions correctly for a range of values  between the UB and AUB
     */
    @Test
    public void intersectsWithUBAndAUB() {
    	assertTrue("Should return true due to intercept with UB",
    			this.exampleRange.intersects(100.0, 100.00001));
    }//fail
    
   
    /**
     * This tests if intersects() functions correctly for a range of values  above the UB
     */
    @Test
    public void intersectsWithInputAUBAndMAX() {
        assertFalse("Should return False because value of out of range",
        		this.exampleRange.intersects(100.00001, Double.MAX_VALUE));
    }

    
    /**
     * This tests if intersects() functions correctly for a range of values below the LB
     */
    @Test
    public void intersectsWithInputBLBAndMIN() {
        assertFalse("Should return False because value of out of range",
        		this.exampleRange.intersects(-999.00, -100.00001));
    }//fail
    
    
    /**
     * This tests if intersects() functions correctly for an invalid input
     */
    @Test
    public void intersectsWithInputNaNAnd1() {
        assertFalse("Should return False due to invalid input",
        		this.exampleRange.intersects(Double.NaN, 1));
    }
    
    /**
     * NEW TEST CASE ADDED
     * This tests if intersects() witht the lower bound > upper bound
     */
    @Test
    public void intersectsWithTestingBUBAndALB() {
    	assertFalse("Should return false due to LB>UB",
    			this.exampleRange.intersects(99.99999,-99.99999));
    }
    /**
     * ********************** shift () test ************************
     * Returns a range the size of the input range, which has been moved
     * positively (to the right) by the delta value. If allowZeroCrossing is
     * false, any bound which crosses the zero mark after shifting (either
     * from negative to positive or positive to negative), will become zero.
     * Parameters:
     * base - the base range (null not permitted).
     * delta - the shift amount.
     * allowZeroCrossing - a flag that determines whether or not the bounds of
     * the range are allowed to cross zero after adjustment
     * Returns:
     * A range representing the base range shifted by the delta.
     * Throws:
     * InvalidParameterException - if null base object is passed in.
     */
    
    
    /**
     * This method tests if the shift() function correctly shifts the range positively by delta
     */
    @Test
    public void positiveShiftRangeRight() {
        double delta = 50;
        Range expectedRange = new Range(-50,150);
        Range shiftedRange = Range.shift(this.exampleRange, delta);

        // Assertion
        assertEquals("Shift the range right (should not trigger Zero Crossing)", expectedRange,shiftedRange);
    }

    /**
     * This method tests if the shift() function correctly shifts the range negatively by delta
     */
    @Test
    public void negativeShiftRangeLeft() {
        double delta = -75.0;
        Range expectedRange = new Range(-175,25);
        Range shiftedRange = Range.shift(this.exampleRange, delta);

        // Assertion
        assertEquals("Shift the range left (should not trigger Zero Crossing)", expectedRange,shiftedRange);
    }

    /**
     * This method tests if the shift() function correctly shifts the range negatively by a delta of 0.0.
     */
    @Test
    public void zeroDeltaNoShiftRange() {
        double delta = 0.0;
        Range shiftedRange = Range.shift(this.exampleRange, delta);

        // Assertion
        assertEquals("Should not shift range ", exampleRange,shiftedRange);
    }
    /**
     * This method tests if the shift() function correctly shifts the range positively by delta where the LB crosses the 0.
     */
    @Test
    public void positiveShiftLbZeroCrossing() {
        double delta = 100.00001;
        Range expectedRange = new Range(0.0, 200.00001);
        Range shiftedRange = Range.shift(this.exampleRange, delta);

        // Assertion
        assertEquals("Shift the range right with only LB crossing zero ", expectedRange,shiftedRange);
    }
    
    /**
     * This method tests if the shift() function correctly shifts the range positively by delta where the LB and UB crosses the 0.
     */
    @Test
    public void positiveShiftLbAndUbZeroCrossing() {
        double delta = 100.00001;
        this.exampleRange = new Range(-100,-50);
        Range expectedRange = new Range(0.0,0.0);
        Range shiftedRange = Range.shift(exampleRange, delta);

        // Assertion
        assertEquals("Shift the range right with LB and UB crossing zero ", expectedRange,shiftedRange);

    }

    /**
     * This method tests if the shift() function correctly shifts the range negatively by delta where the UB crosses the 0.
     */
    @Test
    public void negativeShiftUbZeroCrossing() {
        double delta = -100.00001;
        this.exampleRange = new Range(100,150);
        Range expectedRange = new Range(0.0, 49.99999);
        Range shiftedRange = Range.shift(this.exampleRange, delta);

        // Assert
        assertEquals("Shift the range left with only LB zero crossing ", expectedRange,shiftedRange);


    }
    
    /**
     * This method tests if the shift() function correctly shifts the range negatively by delta where the LB and UB cross the 0.
     */
    @Test
    public void negativeShiftLbAndUbZeroCrossing() {
    	double delta = -100.00001;
        this.exampleRange = new Range(50,100);
        Range expectedRange = new Range(0.0,0.0);
        Range shiftedRange = Range.shift(this.exampleRange, delta);

       
        // Assertion
        assertEquals("Shift the range left with LB and UB crossing zero", expectedRange, shiftedRange);
    }
    
    /**
     * This method tests if the shift() function gets a null parameter and gets an InvalidParameterException.
     */
    @Test
    public void nullBaseInvalidParameterException() {
        Range base = null;
        double delta = 10.0;

        try {
            Range shiftedRange = Range.shift(base, delta);
            fail("nullBase should return an InvalidParameterException");
        } catch (InvalidParameterException e) {
            // Expecting InvalidParameterException, test will pass.
        } catch (Exception e) {
            fail("nullBase should return an InvalidParameterException, not throw a " + e.toString() + " exception");
        }
    }
    
    // NEW Test Case Added to Assignment 3
    // Added test since shift(double, double) uses shift(double, double, boolean). This test method
    // allows the upper or lower bound to cross the zero line.
    
    @Test
    public void withLbCrossingZero() {
    	double delta = 150;
        Range expectedRange = new Range(50.0,250.0);
        Range shiftedRange = Range.shift(this.exampleRange, delta, true);

       
        // Assertion
        assertEquals("Shift the range left with LB crossing zero (allowed)", expectedRange, shiftedRange);
    }
    
    // NEW Test Case Added to Assignment 3
    // This test case shifts the range so that the ub ends up at zero.
    @Test
    public void ubShiftedtoZero() {
    	double delta = -100;
        Range expectedRange = new Range(-200,0.0);
        Range shiftedRange = Range.shift(this.exampleRange, delta);

       
        // Assertion
        assertEquals("Shift the range right with LB crossing zero (allowed)", expectedRange, shiftedRange);
    }
    
    // NEW Test Case Added to Assignment 3
    // This test case shifts the range so that the lb ends up at zero.
    @Test
    public void lbShiftedtoZero() {
    	double delta = 100;
        Range expectedRange = new Range(0.0,200.0);
        Range shiftedRange = Range.shift(this.exampleRange, delta);

       
        // Assertion
        assertEquals("Shift the range left with UB crossing zero (allowed)", expectedRange, shiftedRange);
    }

    


}
