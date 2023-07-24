package org.jfree.data;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class DataUtilitiesTestSuite extends DataUtilities {

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	/**
     * ***********************************************************
     * ***********************************************************
     * ********* calculateRowTotal() test*************************
     * ***********************************************************
     * ***********************************************************
     * public static double calculateRowTotal(Values2D data, int row)
     * Returns the sum of the values in one row of the supplied data table. With invalid
     * input, a total of zero will be returned
     */
    
    
    @Test
	 public void calculateTotalForRowWithOneValue() {

	     // A Mockery creates mock objects and checks expectations that are set upon those 
	     // mock objects. 
	     // By convention the Mockery is stored in an instance variable named context.
	     mockingContext.checking(new Expectations() {
	         {
	             allowing(values).getColumnCount(); // Get number of columns in each row
	             will(returnValue(1)); // Will return 1
	             allowing(values).getValue(0, 0); // Get the first(only) value in the first row
	             will(returnValue(10)); // Will be 10
	         }
	     });
	     
	     // Calculate result of the first row in values
	     double result = DataUtilities.calculateRowTotal(values, 0);
	     assertEquals("The sum of the row that has an input value of 10 is 10", 
	    		 10.0, 
	    		 result, 
	    		 .000000001d);
	 }
   
   @Test
	 public void calculateTotalForTopRowWithTwoValues() {

	     // A Mockery creates mock objects and checks expectations that are set upon those 
	     // mock objects. 
	     // By convention the Mockery is stored in an instance variable named context.
	     mockingContext.checking(new Expectations() {
	         {
	             allowing(values).getColumnCount(); // Get number of columns in each row
	             will(returnValue(2)); // Will return 2
	             allowing(values).getValue(0, 0); // Get the first value in the second row
	             will(returnValue(4)); // Will be 4
	             allowing(values).getValue(0, 1); // Get the second value in the second row
	             will(returnValue(8));  // Will be 8
	         }
	     });
	     
	     // Calculate result of the first row in values
	     double result = DataUtilities.calculateRowTotal(values, 0);
	     assertEquals("The sum of the top row that has inputs values of 4 and 8 is 12", 
	    		 12.0, 
	    		 result, 
	    		 .000000001d);
	 }
   
   @Test
	 public void calculateTotalForBottomRowWithTwoValues() {

	     // A Mockery creates mock objects and checks expectations that are set upon those 
	     // mock objects. 
	     // By convention the Mockery is stored in an instance variable named context.
	     mockingContext.checking(new Expectations() {
	         {
	             allowing(values).getColumnCount(); // Get number of columns in each row
	             will(returnValue(2)); // Will return 2
	             allowing(values).getValue(1, 0); // Get the first value in the second row
	             will(returnValue(3)); // Will be 3
	             allowing(values).getValue(1, 1); // Get the second value in the second row
	             will(returnValue(2));  // Will be 2
	         }
	     });
	     
	     // Calculate result of the first row in values
	     double result = DataUtilities.calculateRowTotal(values, 1);
	     assertEquals("The sum of the bottom row that has inputs values of 3 and 2 is 5", 
	    		 5.0, 
	    		 result, 
	    		 .000000001d);
	 }

	 
	 
	 @Test
	 public void calculateTotalForTopRowWithThreeValues() {

	     // A Mockery creates mock objects and checks expectations that are set upon those 
	     // mock objects. 
	     // By convention the Mockery is stored in an instance variable named context.
	     mockingContext.checking(new Expectations() {
	         {
	             allowing(values).getColumnCount(); // Get number of columns in each row
	             will(returnValue(3)); // Will return 3
	             allowing(values).getValue(0, 0); // Get the first value in the first row
	             will(returnValue(1)); // Will be 1
	             allowing(values).getValue(0, 1); // Get the second value in the first row
	             will(returnValue(2));  // Will be 2
	             allowing(values).getValue(0, 2); // Get the third value in the first row
	             will(returnValue(3));  // Will be 3
	         }
	     });
	     
	     // Calculate result of the first row in values
	     double result = DataUtilities.calculateRowTotal(values, 0);
	     assertEquals("The sum of the top row that has input values of 1, 2, and 3 should be 6", 
	    		 6, 
	    		 result, 
	    		 .000000001d);
	 }
	 
	 @Test
	 public void calculateTotalForMiddleRowWithThreeValues() {

	     // A Mockery creates mock objects and checks expectations that are set upon those 
	     // mock objects. 
	     // By convention the Mockery is stored in an instance variable named context.
	     mockingContext.checking(new Expectations() {
	         {
	             allowing(values).getColumnCount(); // Get number of columns in each row
	             will(returnValue(3)); // Will return 3
	             allowing(values).getValue(1, 0); // Get the first value in the second row
	             will(returnValue(7.5)); // Will be 7.5
	             allowing(values).getValue(1, 1); // Get the second value in the second row
	             will(returnValue(2.5));  // Will be 2.5
	             allowing(values).getValue(1, 2); // Get the third value in the second row
	             will(returnValue(5));  // Will be 5
	         }
	     });
	     
	     // Calculate result of the first row in values
	     double result = DataUtilities.calculateRowTotal(values, 1);
	     assertEquals("The sum of the middle row that has inputs values of 7.5, 2.5, and 5 is 15", 
	    		 15.0, 
	    		 result, 
	    		 .000000001d);
	 }
	 
	 @Test
	 public void calculateTotalForBottomRowWithThreeValues() {

	     // A Mockery creates mock objects and checks expectations that are set upon those 
	     // mock objects. 
	     // By convention the Mockery is stored in an instance variable named context.
	     mockingContext.checking(new Expectations() {
	         {
	             allowing(values).getColumnCount(); // Get number of columns in each row
	             will(returnValue(3)); // Will return 3
	             allowing(values).getValue(2, 0); // Get the first value in the third row
	             will(returnValue(2)); // Will be 2
	             allowing(values).getValue(2, 1); // Get the second value in the third row
	             will(returnValue(4));  // Will be 4
	             allowing(values).getValue(2, 2); // Get the third value in the third row
	             will(returnValue(6));  // Will be 6
	         }
	     });
	     
	     // Calculate result of the first row in values
	     double result = DataUtilities.calculateRowTotal(values, 2);
	     assertEquals("The sum of the bottom row that has inputs values of 2, 4, and 6 is 12", 
	    		 12.0, 
	    		 result, 
	    		 .000000001d);
	 }
	 
	 // NEW TEST CASE ADDED
	 @Test
	 public void singleRowWithPositiveValues() {

	     // A Mockery creates mock objects and checks expectations that are set upon those 
	     // mock objects. 
	     // By convention the Mockery is stored in an instance variable named context.
	     mockingContext.checking(new Expectations() {
	         {
	             allowing(values).getColumnCount(); // Get number of columns in each row
	             will(returnValue(3)); // Will return 3
	             allowing(values).getValue(0, 0); // Get the first value in the first row
	             will(returnValue(10)); // Will be 10
	             allowing(values).getValue(0, 1); // Get the second value in the first row
	             will(returnValue(20));  // Will be 20
	             allowing(values).getValue(0, 2); // Get the third value in the first row
	             will(returnValue(30));  // Will be 30
	         }
	     });
	     
	     // Calculate result of the first row in values
	     double result = DataUtilities.calculateRowTotal(values, 0);
	     assertEquals("The sum of a row that has inputs values of 10, 20, and 30 is 60", 
	    		 60.0, 
	    		 result, 
	    		 .000000001d);
	 }
	 
	// NEW TEST CASE ADDED
	 @Test
	 public void singleRowWithPositiveAndNegativeValues() {

	     // A Mockery creates mock objects and checks expectations that are set upon those 
	     // mock objects. 
	     // By convention the Mockery is stored in an instance variable named context.
	     mockingContext.checking(new Expectations() {
	         {
	             allowing(values).getColumnCount(); // Get number of columns in each row
	             will(returnValue(3)); // Will return 3
	             allowing(values).getValue(0, 0); // Get the first value in the first row
	             will(returnValue(-10)); // Will be -10
	             allowing(values).getValue(0, 1); // Get the second value in the first row
	             will(returnValue(20));  // Will be 20
	             allowing(values).getValue(0, 2); // Get the third value in the first row
	             will(returnValue(-5));  // Will be -5
	         }
	     });
	     
	     // Calculate result of the first row in values
	     double result = DataUtilities.calculateRowTotal(values, 0);
	     assertEquals("The sum of a row that has inputs values of -10, 20, and -5 is 5", 
	    		 5.0, 
	    		 result, 
	    		 .000000001d);
	 }
	 
	// NEW TEST CASE ADDED
	 @Test
	 public void singleRowWithAllNullValues() {

	     // A Mockery creates mock objects and checks expectations that are set upon those 
	     // mock objects. 
	     // By convention the Mockery is stored in an instance variable named context.
	     mockingContext.checking(new Expectations() {
	         {
	             allowing(values).getColumnCount(); // Get number of columns in each row
	             will(returnValue(3)); // Will return 3
	             allowing(values).getValue(0, 0); // Get the first value in the first row
	             will(returnValue(null)); // Will be null
	             allowing(values).getValue(0, 1); // Get the second value in the first row
	             will(returnValue(null));  // Will be null
	             allowing(values).getValue(0, 2); // Get the third value in the first row
	             will(returnValue(null));  // Will be null
	         }
	     });
	     
	     // Calculate result of the first row in values
	     double result = DataUtilities.calculateRowTotal(values, 0);
	     assertEquals("The sum of a row that has inputs values of null is 0", 
	    		 0.0, 
	    		 result, 
	    		 .000000001d);
	 }
	 
	// NEW TEST CASE ADDED
	 @Test
	 public void singleRowWithSomeNullValues() {

	     // A Mockery creates mock objects and checks expectations that are set upon those 
	     // mock objects. 
	     // By convention the Mockery is stored in an instance variable named context.
	     mockingContext.checking(new Expectations() {
	         {
	             allowing(values).getColumnCount(); // Get number of columns in each row
	             will(returnValue(3)); // Will return 3
	             allowing(values).getValue(0, 0); // Get the first value in the first row
	             will(returnValue(10)); // Will be 10
	             allowing(values).getValue(0, 1); // Get the second value in the first row
	             will(returnValue(null));  // Will be null
	             allowing(values).getValue(0, 2); // Get the third value in the first row
	             will(returnValue(30));  // Will be 30
	         }
	     });
	     
	     // Calculate result of the first row in values
	     double result = DataUtilities.calculateRowTotal(values, 0);
	     assertEquals("The sum of a row that has inputs values of 10, null, and 30 is 40", 
	    		 40.0, 
	    		 result, 
	    		 .000000001d);
	 }
	 
	// NEW TEST CASE ADDED
	 @Test
	 public void singleRowWithAllZeroValues() {

	     // A Mockery creates mock objects and checks expectations that are set upon those 
	     // mock objects. 
	     // By convention the Mockery is stored in an instance variable named context.
	     mockingContext.checking(new Expectations() {
	         {
	             allowing(values).getColumnCount(); // Get number of columns in each row
	             will(returnValue(3)); // Will return 3
	             allowing(values).getValue(0, 0); // Get the first value in the first row
	             will(returnValue(10)); // Will be 10
	             allowing(values).getValue(0, 1); // Get the second value in the first row
	             will(returnValue(null));  // Will be null
	             allowing(values).getValue(0, 2); // Get the third value in the first row
	             will(returnValue(30));  // Will be 30
	         }
	     });
	     
	     // Calculate result of the first row in values
	     double result = DataUtilities.calculateRowTotal(values, 0);
	     assertEquals("The sum of a row that has inputs values of 10, null, and 30 is 40", 
	    		 40.0, 
	    		 result, 
	    		 .000000001d);
	 }
	 
	// NEW TEST CASE ADDED
	 @Test
	 public void rowIndexExceedingAvailableRows() {

	     // A Mockery creates mock objects and checks expectations that are set upon those 
	     // mock objects. 
	     // By convention the Mockery is stored in an instance variable named context.
	     mockingContext.checking(new Expectations() {
	         {
	             boolean exceptionThrown = false;
	        	 allowing(values).getColumnCount(); // Get number of columns in each row
	             will(returnValue(3)); // Will return 3
	             allowing(values).getValue(0, 1); // Get the first value in the first row
	             will(returnValue(10)); // Will be 10
	             allowing(values).getValue(0, 2); // Get the second value in the first row
	             will(returnValue(10));  // Will be 10
	             try {
	             allowing(values).getValue(0, 3); // Get the fourth (non-existent) value in the first row
	             will(returnValue(10));  // Will be 10
	             }
	             catch (IndexOutOfBoundsException e) {
	            	 exceptionThrown = true;
	             }
	             assert exceptionThrown : "A row index that exceeded available rows was given!";
	             
	         }
	     });
	 }
	 
	// NEW TEST CASE ADDED
	 @Test
	 public void negativeColumnCountGiven() {

	     // A Mockery creates mock objects and checks expectations that are set upon those 
	     // mock objects. 
	     // By convention the Mockery is stored in an instance variable named context.
	     mockingContext.checking(new Expectations() {
	         {
	        	 allowing(values).getColumnCount(); // Get number of columns in each row
	             will(returnValue(-1)); // Will return 3
	             allowing(values).getValue(0, 0); // Get the first value in the first row
	             will(returnValue(10)); // Will be 10
	             allowing(values).getValue(0, 1); // Get the first value in the first row
	             will(returnValue(null)); // Will be 10
	         }
	     });
	     
	     // Calculate result of the first row in values
	     double result = DataUtilities.calculateRowTotal(values, 0);
	     assertEquals("The sum of a row with a negative column count is 0", 
	    		 0.0, 
	    		 result, 
	    		 .000000001d);
	 }

	@Test
	public void testCalculateColumnTotalValues2DInt() {
		fail("Not yet implemented");
	}

	@Test
	public void testCalculateColumnTotalValues2DIntIntArray() {
		fail("Not yet implemented");
	}

	@Test
	public void testCalculateRowTotalValues2DInt() {
		fail("Not yet implemented");
	}

	@Test
	public void testCalculateRowTotalValues2DIntIntArray() {
		fail("Not yet implemented");
	}

	@Test
	public void testCreateNumberArray() {
		fail("Not yet implemented");
	}

	@Test
	public void testCreateNumberArray2D() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetCumulativePercentages() {
		fail("Not yet implemented");
	}

}
