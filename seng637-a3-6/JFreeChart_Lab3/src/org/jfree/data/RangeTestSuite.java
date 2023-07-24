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
    


}
