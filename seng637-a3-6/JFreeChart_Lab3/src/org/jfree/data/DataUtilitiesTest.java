package org.jfree.data;

import static org.junit.Assert.*;

import java.security.InvalidParameterException;
import java.util.Arrays;

import org.jfree.data.DataUtilities;
import org.jfree.data.DefaultKeyedValues;
import org.jfree.data.KeyedValues;
import org.jfree.data.Values2D;
import org.jmock.Expectations;
import org.jmock.Mockery;
import org.junit.*;

public class DataUtilitiesTest {
    
	private Mockery mockingContext;
	private KeyedValues keyedValues;
	private Values2D values;
	
	@BeforeClass public static void setUpBeforeClass() throws Exception {
    }


    @Before
    public void setUp() throws Exception {
        this.mockingContext = new Mockery();
        this.keyedValues = mockingContext.mock(KeyedValues.class);
        // Mock Value2D object that contains values 
	    this.values = mockingContext.mock(Values2D.class);
    }
    
    
    /****************************************************************
     * **************************************************************
     * ********* calculateColumnTotal() test*************************
     * **************************************************************
     * **************************************************************
     * public static double calculateColumnTotal(Values2D data, int column)
     * Returns the sum of the values in one column of the supplied data table. With invalid
     * input, a total of zero will be returned.
     */
    
    
    /**
     * calculateColumnTotalOneRow.
     * 
     * This will test if calculateColumnTotal correctly calculates the total column value with a Values2D object that has 1 row
     */
    @Test 
    public void calculateColumnTotalOneRow() {
        mockingContext.checking(new Expectations() {
            {
                one(values).getRowCount();
                will(returnValue(1));
                one(values).getValue(0, 0);
                will(returnValue(7));
        
            }
        });

        double result = DataUtilities.calculateColumnTotal(values, 0);
        assertEquals("The sum of the values in the first column with a single row", 7.0, result, .000000001d);
    }
    
    
    /**
     * calculateColumnTotalFirstColTwoRows.
     * 
     * This will test if calculateColumnTotal correctly calculates the total column value of the first column
     * of a Values2D object that has 2 rows
     */
	@Test
	public void calculateColumnTotalFirstColTwoRows() {
	    mockingContext.checking(new Expectations() {
	        {
	            one(values).getRowCount();
	            will(returnValue(2));
	            one(values).getValue(0, 0);
	            will(returnValue(7));
	            one(values).getValue(1, 0);
	            will(returnValue(3));
	        }
	    });
	    double result = DataUtilities.calculateColumnTotal(values, 0);
	    assertEquals("The total value of the first column with two rows", 10.0, result, .000000001d);
	}
	
	/**
     * calculateColumnTotalSecondColTwoRows.
     * 
     * This will test if calculateColumnTotal correctly calculates the total column value of the second column
     * of a Values2D object that has 2 rows
     */
	@Test
	public void calculateColumnTotalSecondColTwoRows() {
	    mockingContext.checking(new Expectations() {
	        {
	            one(values).getRowCount();
	            will(returnValue(2));
	            one(values).getValue(0, 1);
	            will(returnValue(7));
	            one(values).getValue(1, 1);
	            will(returnValue(3));
	        }
	    });
	    double result = DataUtilities.calculateColumnTotal(values, 1);
	    assertEquals("The total value of the second column with two rows", 10.0, result, .000000001d);
	}

	/**
     * calculateColumnTotalFirstColThreeRows.
     * 
     * This will test if calculateColumnTotal correctly calculates the total column value of the second column
     * of a Values2D object that has 3 rows
     */
	@Test
	public void calculateColumnTotalFirstColThreeRows() {
	    mockingContext.checking(new Expectations() {
	        {
	            one(values).getRowCount();
	            will(returnValue(3));
	            one(values).getValue(0, 0);
	            will(returnValue(7));
	            one(values).getValue(1, 0);
	            will(returnValue(3));
	            one(values).getValue(2, 0);
	            will(returnValue(2));
	        }
	    });
	    double result = DataUtilities.calculateColumnTotal(values, 0);
	    assertEquals("The total value of the first column with three rows", 12.0, result, .000000001d);
	}
	
	/**
     * calculateColumnTotalFirstColThreeRows.
     * 
     * This will test if calculateColumnTotal correctly calculates the total column value of the middle column
     * of a Values2D object that has 3 rows
     */
	@Test
	public void calculateColumnTotalMiddleColThreeRows() {
	    mockingContext.checking(new Expectations() {
	        {
	            one(values).getRowCount();
	            will(returnValue(3));
	            one(values).getValue(0, 1);
	            will(returnValue(7));
	            one(values).getValue(1, 1);
	            will(returnValue(3));
	            one(values).getValue(2, 1);
	            will(returnValue(2));
	        }
	    });
	    double result = DataUtilities.calculateColumnTotal(values, 1);
	    assertEquals("The total value of the middle column with three rows", 12.0, result, .000000001d);
	}

	/**
     * calculateColumnTotalFirstColThreeRows.
     * 
     * This will test if calculateColumnTotal() correctly calculates the total column value of the last column
     * of a Values2D object that has 3 rows
     */
	@Test
	public void calculateColumnTotalLastColThreeRows() {
	    mockingContext.checking(new Expectations() {
	        {
	            one(values).getRowCount();
	            will(returnValue(3));
	            one(values).getValue(0, 2);
	            will(returnValue(7));
	            one(values).getValue(1, 2);
	            will(returnValue(3));
	            one(values).getValue(2, 2);
	            will(returnValue(0));
	        }
	    });
	    double result = DataUtilities.calculateColumnTotal(values, 2);
	    assertEquals("The total value of the last column with three rows", 10.0, result, .000000001d);
	}
	
	/**
	 * calculateColumnTotalNegativeOneRows.
	 * 
	 * This will test if calculateColumnTotal() correctly calculates the total column value
     * of a Values2D object that has -1 rows, 
	 */
	 @Test
	    public void calculateColumnTotalNegativeOneRows() {
	        mockingContext.checking(new Expectations() {
	            {
	                one(values).getRowCount();
	                will(returnValue(-1)); // negative number of rows
	                one(values).getValue(0, 0);
	                will(returnValue(3.5));
	        
	            }
	        });

	        double result = DataUtilities.calculateColumnTotal(values, 0);
	        assertEquals("The total value of the first column with negative number of rows is 0.0 ", 0.0, result, .000000001d);
	    }

	/**
     * calculateColumnTotalInvalidDataObject.
     * 
     * This will test passing an invalid data object (null) to calculateColumnTotal() to see if it
     * throws the correct exception.
     */
	@Test 
   	public void calculateColumnTotalInvalidDataObject() {
		try {
			// call calculateColumnTotal with a null value
	   	    double result = DataUtilities.calculateColumnTotal(null, 0);
			fail("calculateColumnTotal should have thrown an exception");

		} catch (Exception e) {
			assertEquals("calculateColumnTotal throws an exception", 
					InvalidParameterException.class, 
						e.getClass());
		}
   	}


	/**
	 * calculateColumnTotalZeroRows.
	 * 
	 * This will test if calculateColumnTotal() correctly calculates the total column value 
	 * an empty Values2D object that has contains no rows or values
	 */
    @Test
    public void calculateColumnTotalZeroRows() {
        mockingContext.checking(new Expectations() {
            {
                one(values).getRowCount();
                will(returnValue(0)); // zero rows
            }
        });

        double result = DataUtilities.calculateColumnTotal(values, 0);
        assertEquals("The calculated total value of an empty data object should be 0", 0.0, result, .000000001d);
    }
    
	/**
     * calculateColumnTotalNegativeValue.
     * 
     * This will test if calculateColumnTotal correctly calculates the total column value 
     * of a Values2D object that contains a negative value
     */
	@Test
	public void calculateColumnTotalNegativeValue() {
	    mockingContext.checking(new Expectations() {
	        {
	            one(values).getRowCount();
	            will(returnValue(3));
	            one(values).getValue(0, 0);
	            will(returnValue(7));
	            one(values).getValue(1, 0);
	            will(returnValue(3));
	            one(values).getValue(2, 0);
	            will(returnValue(-1)); // negative value
	        }
	    });
	    double result = DataUtilities.calculateColumnTotal(values, 0);
	    assertEquals("Correctly calculate the total column value of data containing a negative value", 9.0, result, .000000001d);
	}
	
	/**
     * calculateColumnTotalNullValue.
     * 
     * This will test if calculateColumnTotal correctly calculates the total column value 
     * of a Values2D object that contains a null value
     */
    @Test 
   	public void calculateColumnTotalNullValue() {
   	    mockingContext.checking(new Expectations() {
   	        {
   	            one(values).getRowCount();
   	            will(returnValue(3));
   	            one(values).getValue(0, 0);
   	            will(returnValue(7));
   	            one(values).getValue(1, 0);
	            will(returnValue(3));
   	            one(values).getValue(2, 0);
   	            will(returnValue(null)); // null value
   	        }
   	    });
   	    double result = DataUtilities.calculateColumnTotal(values, 0);
   	    assertEquals("Correctly calculate the total column value of data containing a null value", 10.0, result, .000000001d);
   	}
	
	/**
     * calculateColumnTotalMinimumValue.
     * 
     * This will test if calculateColumnTotal correctly calculates the total column value 
     * of a Values2D object that contains the minimum value possible
     */
	@Test
	public void calculateColumnTotalMinimumValue() {
	    mockingContext.checking(new Expectations() {
	        {
	            one(values).getRowCount();
	            will(returnValue(3));
	            one(values).getValue(0, 0);
	            will(returnValue(7));
	            one(values).getValue(1, 0);
	            will(returnValue(3));
	            one(values).getValue(2, 0);
	            will(returnValue(Integer.MIN_VALUE)); // minimum integer value
	        }
	    });
	    double result = DataUtilities.calculateColumnTotal(values, 0);
	    assertEquals("Correctly calculate the total column value of data containing the minimum integer value possible", Integer.MIN_VALUE + 10.0, result, .000000001d);
	}
	
	/**
     * calculateColumnTotalMaximumValue.
     * 
     * This will test if calculateColumnTotal correctly calculates the total column value 
     * of a Values2D object that contains the maximum value possible
     */
	@Test
	public void calculateColumnTotalMaximumValue() {
	    mockingContext.checking(new Expectations() {
	        {
	            one(values).getRowCount();
	            will(returnValue(3));
	            one(values).getValue(0, 0);
	            will(returnValue(7));
	            one(values).getValue(1, 0);
	            will(returnValue(3));
	            one(values).getValue(2, 0);
	            will(returnValue(Integer.MAX_VALUE)); // maximum integer value
	        }
	    });
	    double result = DataUtilities.calculateColumnTotal(values, 0);
	    assertEquals("Correctly calculate the total column value of data containing the maximum integer value possible", Integer.MAX_VALUE + 10.0, result, .000000001d);
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
    
    
    /***************************************************************
     * *************************************************************
     * ********* createNumberArray2D() test*************************
     * *************************************************************
     * *************************************************************
     * public static java.lang.Number[][] createNumberArray2D(double[][] data)
     * Constructs an array of arrays of Number objects from a 
     * corresponding structure containing double primitives.
     */
    
    
    @Test
    public void createNumberArray2D_Creates_Second_Row_Second_Column() {
    	double[][] testInput = { {1.1 , 2.2 , 3.3} , {4.4 , 5.5 , 6.6} , {7.7 , 8.8 , 9.9} };
    	Number[][] testOutput = { {1.1 , 2.2 , 3.3} , {4.4 , 5.5 , 6.6} , {7.7 , 8.8 , 9.9} };
        assertEquals("Element [1,1] should be equal",
        				testOutput[1][1],
        				DataUtilities.createNumberArray2D(testInput)[1][1]);
    }
    
    @Test
    public void createNumberArray2D_Creates_Third_Row_Third_Column() {
    	double[][] testInput = { {1.1 , 2.2 , 3.3} , {4.4 , 5.5 , 6.6} , {7.7 , 8.8 , 9.9} };
    	Number[][] testOutput = { {1.1 , 2.2 , 3.3} , {4.4 , 5.5 , 6.6} , {7.7 , 8.8 , 9.9} };
        assertEquals("Element [2,2] should be equal",
        				testOutput[2][2],
        				DataUtilities.createNumberArray2D(testInput)[2][2]);
    }
    
    
    @Test(expected = InvalidParameterException.class)
    public void createNumberArray2D_Throws_Exception_For_Null_Object() {
    	double[][] testInput = { {(Double)null} , {2.2} , {3.3} };
    	Number[][] testOuput = DataUtilities.createNumberArray2D(testInput);
    }
    
    /************************************************************************************
     * **********************************************************************************
     * ********* getCumulativePercentages(KeyedValues data) test*************************
     * **********************************************************************************
     * **********************************************************************************
     * public static KeyedValues getCumulativePercentages(KeyedValues data)
     * Returns a KeyedValues instance that contains the cumulative percentage values for the data 
     * in another KeyedValues instance. The cumulative percentage is each value's cumulative 
     * sum's portion of the sum of all the values.
     */
    
    
    /**
     * This method tests the getCumulativePercentages() with one valid value in KeyedValues object
     */
	@Test
    public void getCumulativePercentagesWithOneRowKeyedValue() {
        mockingContext.checking(new Expectations() {
            {
                allowing(keyedValues).getItemCount();
                will(returnValue(1));
                allowing(keyedValues).getKey(0);
                will(returnValue(0));
                allowing(keyedValues).getValue(0);
                will(returnValue(1.0));
            }
        });

        KeyedValues result = DataUtilities.getCumulativePercentages(keyedValues);
        assertEquals("The Cumulative Percentage of 1 value should be 1.0", 1.0, result.getValue(0));
    }
    
	
	
	/**
     * This method tests the getCumulativePercentages() with no value in KeyedValues object (empty object)
     */
    @Test
    public void getCumulativePercentagesWithNoKeyedValues() {
        KeyedValues noValues = new DefaultKeyedValues();

        KeyedValues result = DataUtilities.getCumulativePercentages(noValues);
        KeyedValues expected = new DefaultKeyedValues();
        assertEquals(
                "The Cumulative Percentage of an empty KeyedValues object should return an empty",
                expected, result);
    }
    
    
    /**
     * This method tests the getCumulativePercentages() with one element in KeyedValues object with value of zero 
     */
    @Test
    public void getCumulativePercentagesWithOneKeyedValueOfZero() {
        mockingContext.checking(new Expectations() {
            {
                allowing(keyedValues).getItemCount();
                will(returnValue(1));
                allowing(keyedValues).getKey(0);
                will(returnValue(0));
                allowing(keyedValues).getValue(0);
                will(returnValue(0));
            }
        });

        KeyedValues result = DataUtilities.getCumulativePercentages(keyedValues);
        assertEquals("The cumulative percentage of a single KeyedValue of 0 should result in 0/0", 0.0 / 0.0,
                result.getValue(0));
    }
    
    /**
     * This method tests the getCumulativePercentages() with one element in KeyedValues object with a null value 
     */
    @Test
    public void test_getCumulativePercentagesOneKeyedValueOfNull() {
        mockingContext.checking(new Expectations() {
            {
                allowing(keyedValues).getItemCount();
                will(returnValue(1));
                allowing(keyedValues).getKey(0);
                will(returnValue(0));
                allowing(keyedValues).getValue(0);
                will(returnValue(null));
            }
        });

        KeyedValues result = DataUtilities.getCumulativePercentages(keyedValues);
        assertEquals("The cumulative percentage of a single KeyedValue of null value should be NaN", Double.NaN, result.getValue(0));
    }
    
    
    /**
     * This method tests the getCumulativePercentages() of the first element in two-element in KeyedValues object 
     */
	  @Test
	  public void getCumulativePercentagesFirstPercentageInTwoElementKV() {
	      mockingContext.checking(new Expectations() {
	          {
	              allowing(keyedValues).getItemCount();
	              will(returnValue(2));
	              allowing(keyedValues).getKey(0);
	              will(returnValue(0));
	              allowing(keyedValues).getKey(1);
	              will(returnValue(1));
	              allowing(keyedValues).getValue(0);
	              will(returnValue(5));
	              allowing(keyedValues).getValue(1);
	              will(returnValue(5));
	
	          }
	      });
	
	      KeyedValues result = DataUtilities.getCumulativePercentages(keyedValues);
	
	      assertEquals("The cumulative percentage of 5 in 2 KeyedValue with sum of 10 should be 0.5", 0.5,
	              result.getValue(0).doubleValue(), 0.000000001d);     
	  }
  
  /**
   * This method tests the getCumulativePercentages() of the second element in two-element in KeyedValues object 
   */
	@Test
	public void getCumulativePercentagesSecondPercentageInTwoElementKV() {
	    mockingContext.checking(new Expectations() {
	        {
	            allowing(keyedValues).getItemCount();
	            will(returnValue(2));
	            allowing(keyedValues).getKey(0);
	            will(returnValue(0));
	            allowing(keyedValues).getKey(1);
	            will(returnValue(1));
	            allowing(keyedValues).getValue(0);
	            will(returnValue(5));
	            allowing(keyedValues).getValue(1);
	            will(returnValue(5));
	
	        }
	    });
	
	    KeyedValues result = DataUtilities.getCumulativePercentages(keyedValues);
	
	    assertEquals("The cumulative percentage of the second 5 in 2 KeyedValue with sum of 10 should be 1.0", 1.0,
	            result.getValue(1).doubleValue(), 0.000000001d);     
	}
    

	/**
	 * This method tests the getCumulativePercentages() of the first element in three-element KeyedValues object 
	 */
	@Test
	public void getCumulativePercentagesFirstPercentageInThreeElementKV() {
	  mockingContext.checking(new Expectations() {
	      {
	          allowing(keyedValues).getItemCount();
	          will(returnValue(3));
	          allowing(keyedValues).getKey(0);
	          will(returnValue(0));
	          allowing(keyedValues).getKey(1);
	          will(returnValue(1));
	          allowing(keyedValues).getKey(2);
	          will(returnValue(2));
	          allowing(keyedValues).getValue(0);
	          will(returnValue(5));
	          allowing(keyedValues).getValue(1);
	          will(returnValue(5));
	          allowing(keyedValues).getValue(2);
	          will(returnValue(5));
	
	      }
	  });
	
	  KeyedValues result = DataUtilities.getCumulativePercentages(keyedValues);
	
	  assertEquals("The cumulative percentage of the first 5 in 3 KeyedValue with sum of 15 should be 0.333", 0.3,
	          result.getValue(0).doubleValue(), 0.000000001d);     
	}


	/**
	 * This method tests the getCumulativePercentages() of the first element in three-element KeyedValues object 
	 */
	@Test
	public void getCumulativePercentagesSecondPercentageInThreeElementKV() {
	  mockingContext.checking(new Expectations() {
	      {
	          allowing(keyedValues).getItemCount();
	          will(returnValue(3));
	          allowing(keyedValues).getKey(0);
	          will(returnValue(0));
	          allowing(keyedValues).getKey(1);
	          will(returnValue(1));
	          allowing(keyedValues).getKey(2);
	          will(returnValue(2));
	          allowing(keyedValues).getValue(0);
	          will(returnValue(5));
	          allowing(keyedValues).getValue(1);
	          will(returnValue(5));
	          allowing(keyedValues).getValue(2);
	          will(returnValue(5));
	
	      }
	  });
	
	  KeyedValues result = DataUtilities.getCumulativePercentages(keyedValues);
	
	  assertEquals("The cumulative percentage of the second 5 in 3 KeyedValue with sum of 15 should be 0.666667", 0.66667,
	          result.getValue(1).doubleValue(), 0.000000001d);     
	}


	/**
	 * This method tests the getCumulativePercentages() of the third element in three-element KeyedValues object 
	 */
	@Test
	public void getCumulativePercentagesThirdPercentageInThreeElementKV() {
	  mockingContext.checking(new Expectations() {
	      {
	          allowing(keyedValues).getItemCount();
	          will(returnValue(3));
	          allowing(keyedValues).getKey(0);
	          will(returnValue(0));
	          allowing(keyedValues).getKey(1);
	          will(returnValue(1));
	          allowing(keyedValues).getKey(2);
	          will(returnValue(2));
	          allowing(keyedValues).getValue(0);
	          will(returnValue(5));
	          allowing(keyedValues).getValue(1);
	          will(returnValue(5));
	          allowing(keyedValues).getValue(2);
	          will(returnValue(5));
	
	      }
	  });
	
	  KeyedValues result = DataUtilities.getCumulativePercentages(keyedValues);
	
	  assertEquals("The cumulative percentage of the third 5 in 3 KeyedValue with sum of 15 should be 1.0", 1.0,
	          result.getValue(2).doubleValue(), 0.000000001d);     
	}
	
	
	/**
     * ********************** createNumberArray() test ************************
     * public static java.lang.Number[] createNumberArray(double[] data)
     * Constructs an array of Number objects from an array of double primitives
     * Parameters:
     * data - An array of double primitives (null not permitted).
     * Returns:
     * An array of Number objects
     * Throws:
     * InvalidParameterException - if invalid edata objects is passed in.
     */
	
	
	/**
     * This method tests if the createNumberArray() function correctly creates a Number array with a single int.
     */
    @Test
    public void createNumberArrayValidInputSingleInt() {
    	
    	double[] data = {1};
        Number[] result = DataUtilities.createNumberArray(data);
        Number[] expected = {1};
        assertArrayEquals(expected, result);
    }
    /**
     * This method tests if the createNumberArray() function correctly creates a Number array with a multiple doubles.
     */
    @Test
    public void createNumberArrayValidInputMultiDouble() {
    	
    	double[] data = { 1.5, 2.7, 3.8 };
        Number[] result = DataUtilities.createNumberArray(data);
        Number[] expected = { 1.5, 2.7, 3.8 };
        assertArrayEquals(expected, result);
    }
    /**
     * This method tests if the createNumberArray() function correctly creates a Number array with a blank data input.
     */
    @Test
    public void createNumberArrayEmptyArray() {
        double[] data = {};
        Number[] expected = {};
        Number[] result = DataUtilities.createNumberArray(data);
        assertArrayEquals(expected, result);
    }
    /**
     * This method tests if the createNumberArray() function correctly creates a Number array with a null double array parameter passed.
     */
    @Test(expected = IllegalArgumentException.class)
    public void createNumberArrayNullArray() {
        double[] data = null;
        DataUtilities.createNumberArray(data);
    }
    /**
     * This method tests if the createNumberArray() function correctly creates a Number array with all double 0.0's passed.
     */
    @Test
    public void createNumberArrayAllZeroes() {
        double[] data = { 0.0, 0.0, 0.0 };
        Number[] result = DataUtilities.createNumberArray(data);
        Number[] expected = { 0.0, 0.0, 0.0 };
        assertArrayEquals(expected, result);
    }
    /**
     * This method tests if the createNumberArray() function correctly creates a Number array with positive and negative doubles passed.
     */
    @Test
    public void createNumberArrayPositiveAndNegativeValues() {
        double[] data = { -1.5, 0.0, 2.7, -3.8 };
        Number[] result = DataUtilities.createNumberArray(data);
        Number[] expected = { -1.5, 0.0, 2.7, -3.8 };
        assertArrayEquals(expected, result);
    }
    
    /**
     * This method tests if the createNumberArray() function correctly creates a Number array with a large double passed.
     */
    @Test
    public void createNumberArrayLargeValues() {
        double[] data = { Double.MAX_VALUE};
        Number[] result = DataUtilities.createNumberArray(data);
        Number[] expected = { Double.MAX_VALUE};
        System.out.println("Expected: " + Arrays.toString(expected));
        System.out.println("Actual: " + Arrays.toString(result) );
        assertArrayEquals(expected, result);
    }
    /**
     * This method tests if the createNumberArray() function correctly creates a Number array with a small double passed.
     */
    @Test
    public void createNumberArraySmallValues() {
        double[] data = { Double.MIN_VALUE};
        Number[] result = DataUtilities.createNumberArray(data);
        Number[] expected = { Double.MIN_VALUE};
        System.out.println("Expected: " + Arrays.toString(expected));
        System.out.println("Actual: " + Arrays.toString(result) );
        assertArrayEquals(expected, result);
    }
    
    /**
     * This method tests if the createNumberArray() function correctly creates a Number array with a NaN passed in the data array.
     */
    @Test
    public void createNumberArrayNaNValues() {
        double[] data = { Double.NaN, 2.0 };
        Number[] result = DataUtilities.createNumberArray(data);
        Number[] expected = { Double.NaN, 2.0 };
        assertArrayEquals(expected, result);
    }
    /**
     * This method tests if the createNumberArray() function correctly creates a Number array with negative and positive infinity in the data array.
     */
    @Test
    public void createNumberArrayInfinityValues() {
        double[] data = { Double.POSITIVE_INFINITY, Double.NEGATIVE_INFINITY };
        Number[] result = DataUtilities.createNumberArray(data);
        Number[] expected = { Double.POSITIVE_INFINITY, Double.NEGATIVE_INFINITY };
        assertArrayEquals(expected, result);
    }
    
    /**
     * This method tests if the createNumberArray() function correctly creates a Number array with an array of 10,000 doubles.
     */
    @Test
    public void createNumberArrayLargeArray() {
        double[] data = new double[10000];
        Arrays.fill(data, 1.0);
        Number[] result = DataUtilities.createNumberArray(data);
        Number[] expected = new Number[10000];
        Arrays.fill(expected, 1.0);
        assertArrayEquals(expected, result);
    }
    
    
    @After
    public void tearDown() throws Exception {
    }

    @AfterClass
    public static void tearDownAfterClass() throws Exception {
    }
}