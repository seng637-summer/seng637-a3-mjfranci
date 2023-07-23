package org.jfree.data;

import static org.junit.Assert.*;

import java.security.InvalidParameterException;

import org.jfree.data.Range; import org.junit.*;

public class RangeTest {
    private Range exampleRange;
    @BeforeClass public static void setUpBeforeClass() throws Exception {
    }
    
    
    /**
     * This method sets up the exampleRange object of the Range class to be tested
     */
    @Before
    public void setUp() throws Exception { exampleRange = new Range(-100.0, 100.0);
    }
    
    
    /**
     * ********************** expandToInclude() test ************************
     * public static Range expandToInclude(Range range, double value)
     * Returns a range that includes all the values in the specified range AND contains the specified value.
     * Parameters:
     * range - the range (null permitted).
     * value - the value that must be included
     * Returns:
     * A range which spans over the input range, and has been expanded to contain the input value.
     */
    
    
    /**
     * expandToIncludeBelowLowerBound.
     * 
     * This will test if expandToInclude() correctly includes a values below the lower bound of the range
     */
	@Test
	public void expandToIncludeBelowLowerBound() {
		Range expectedRange = new Range(-100.00001, 100.0);
		Range newRange = Range.expandToInclude(this.exampleRange, -100.00001);
		assertEquals("Expanding range to include a value below the lower bound", expectedRange, newRange);
	}
	
	
	/**
     * expandToIncludeLowerBound.
     * 
     * This will test if expandToInclude() correctly handles including a value at the lower bound of the range. 
     * There should be no change to the range
     */
	@Test
	public void expandToIncludeLowerBound() {
	    try {
	    	Range newRange = Range.expandToInclude(this.exampleRange, -100.0);
			assertEquals("Expanding range to include a value at the lower bound should not change the range", this.exampleRange, newRange);
	    } catch (Exception e) {
			fail("expandToInclude should return an unchanged range, not thrown an exception: " + e.toString());
	    }
	}

	
	/**
     * expandToIncludeAboveLowerBound.
     * 
     * This will test if expandToInclude() correctly includes a values above the lower bound of the range
     */
	@Test
	public void expandToIncludeAboveLowerBound() {
		Range newRange = Range.expandToInclude(this.exampleRange, -99.99999
);
		assertEquals("Expanding range to include a value below the lower bound", this.exampleRange, newRange);
	}
	
	
	/**
     * expandToIncludeNominalValue.
     * 
     * This will test if expandToInclude() correctly includes a nominal value
     */
	@Test
	public void expandToIncludeNominalValue() {
		Range newRange = Range.expandToInclude(this.exampleRange, 10.0);
		assertEquals("Expanding range to include a nominal value", this.exampleRange, newRange);
	}
	
	
	/**
     * expandToIncludeBelowUpperBound.
     * 
     * This will test if expandToInclude() correctly includes a values below the upper bound of the range
     */
	@Test
	public void expandToIncludeBelowUpperBound() {
		Range newRange = Range.expandToInclude(this.exampleRange, 99.99999
);
		assertEquals("Expanding range to include a value below the upper bound", this.exampleRange, newRange);
	}
	
	
	/**
     * expandToIncludeUpperBound.
     * 
     * This will test if expandToInclude() correctly handles including a value at the upper bound of the range. 
     * There should be no change to the range
     */
	@Test
	public void expandToIncludeUpperBound() {
		Range newRange = Range.expandToInclude(this.exampleRange, 100.0);
		assertEquals("Expanding range to include a value at the upper bound", this.exampleRange, newRange);
	}
    
	
	/**
     * expandToIncludeAboveUpperBound.
     * 
     * This will test if expandToInclude() correctly includes a values above the upper bound of the range
     */
	@Test
	public void expandToIncludeAboveUpperBound() {
		Range expectedRange = new Range(-100.0, 100.00001);
		Range newRange = Range.expandToInclude(this.exampleRange, 100.00001);
		assertEquals("Expanding range to include a value below the lower bound doesn't change ", expectedRange, newRange);
	}
	
	
	/**
     * expandToIncludeMaxValue.
     * 
     * This will test if expandToInclude() correctly includes the maximum double value
     */
	@Test
	public void expandToIncludeMaxValue() {
		Range expectedRange = new Range(-100.0, Double.MAX_VALUE);
		Range newRange = Range.expandToInclude(this.exampleRange, Double.MAX_VALUE);
		assertEquals("Expanding range to include the maximum double value", expectedRange, newRange);
	}
	
	
	/**
     * expandToIncludeMinValue.
     * 
     * This will test if expandToInclude() correctly includes the minimum double value
     */
	@Test
	public void expandToIncludeMinValue() {
		Range expectedRange = new Range(-100.0, Double.MIN_VALUE);
		Range newRange = Range.expandToInclude(this.exampleRange, Double.MIN_VALUE);
		assertEquals("Expanding range to include the minimum double value", expectedRange, newRange);
	}

	
	/**
     * expandToIncludeNullRange.
     * 
     * This will test if expandToInclude() correctly handles a null range. 
     * Null is a permissible range, and should return a range consisting of only the given value
     */
	@Test
	public void expandToIncludeNullRange() {
		Range expectedRange = new Range(20.0, 20.0);
		Range newRange = Range.expandToInclude(null, 20.0);
		assertEquals("Expanding a null range to include a value", expectedRange, newRange);
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
     * ********************** constrain() test ************************
     * public double constrain(double value)
     * Returns the value within the range that is closest to the specified value.
     * Parameters:
     * value - the value to find the closest in-range value of.
     * Returns:
     * The constrained value. If value is within the range, will return the input value.
     */
    
    
    /**
     * This tests if constrain() functions correctly for a range of values  from BLB to AUB
     */
    @Test
    public void constrain_Should_Be_Max() {
        assertEquals("The constrained value above the range should be the range's max value",
        100,
        exampleRange.constrain(100.00001),
        .000000001d);
    }
    
    
    /**
     * This tests if constrain() functions correctly for a range of values  from BLB to AUB
     */
    @Test
    public void constrain_Should_Be_Input() {
    	assertEquals("The constrained value should be the input",
    	-1.4,
    	exampleRange.constrain(-1.4),
    	.00000001d);
    }
    
    
    /**
     * This tests if constrain() functions correctly for a range of values  from BLB to AUB
     */
    @Test
    public void constrain_Should_Be_Min() {
    	assertEquals("The constrained value below the range should be the range's min value",
    	-100,
    	exampleRange.constrain(-100.00001),
    	.00000001d);
    }
    
    
    /**
     * This tests if constrain() functions correctly for a range of values  from BLB to AUB
     */
    @Test
    public void constrain_Should_Be_Value() {
    	assertEquals("The constrained value of a character should be some value",
    	'a',
    	exampleRange.constrain('a'),
    	.00000001d);
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
        
        System.out.println("Expected lower: "+ expectedRange.getLowerBound() + "\nExpected Upper: "+ expectedRange.getUpperBound());
        System.out.println("\nExampleRange lower: "+ this.exampleRange.getLowerBound() + "\nShifted Upper: "+ this.exampleRange.getUpperBound());
        System.out.println("\nShifted lower: "+ shiftedRange.getLowerBound() + "\nShifted Upper: "+ shiftedRange.getUpperBound());

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
    @Test(expected = InvalidParameterException.class)
    public void nullBaseInvalidParameterException() {
        Range base = null;
        double delta = 10.0;

        Range shiftedRange = Range.shift(base, delta);

        // Expecting InvalidParameterException
    }
    
    
    @After
    public void tearDown() throws Exception {
    }

    @AfterClass
    public static void tearDownAfterClass() throws Exception {
    }
}