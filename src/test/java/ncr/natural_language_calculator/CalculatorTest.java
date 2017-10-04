/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ncr.natural_language_calculator;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Squirrel69
 */
public class CalculatorTest {
    
    public CalculatorTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of compute method, of class Calculator.
     */
    @Test
    public void testCompute_validUnitOperation() {
        System.out.println("compute");
        String[] units = {"1", "+", "2"};
        String operators = "+-*/";
        String operands = "0 1 2 3 4 5 6 7 8 9 10";
        Calculator instance = new Calculator();
        double expResult = 3.0;
        double result = instance.compute(units, operators, operands);
        assertEquals(expResult, result, 3.0);
    }
    @Test
    public void testCompute_validChainOperation() {
        System.out.println("compute");
        String[] units = {"4", "+", "2", "/", "2", "-", "4"};
        String operators = "+-*/";
        String operands = "0 1 2 3 4 5 6 7 8 9 10";
        Calculator instance = new Calculator();
        double expResult = 1.0;
        double result = instance.compute(units, operators, operands);
        assertEquals(expResult, result, 1.0);
    }
    
}
