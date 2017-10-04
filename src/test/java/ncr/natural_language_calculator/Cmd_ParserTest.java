/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ncr.natural_language_calculator;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Squirrel69
 */
public class Cmd_ParserTest {
    
    public Cmd_ParserTest() {
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
     * Test of validate method, of class CmdParser.
     */
    @org.junit.Test
    public void testValidate_validUnitOperation() {
        System.out.println("validate");
        String[] units = {"1", "+", "1"};
        String operators = "+-*/";
        String operands = "0 1 2 3 4 5 6 7 8 9 10";
        CmdParser instance = new CmdParser();
        String[] expResult = {"1", "+", "1"};
        String[] result = instance.validate(units, operators, operands);
        assertArrayEquals(expResult, result);
    }
    
    @Test
    public void testValidate_validChainOperation() {
        System.out.println("validate");
        String[] units = {"1", "+", "1", "*", "5", "/", "3"};
        String operators = "+-*/";
        String operands = "0 1 2 3 4 5 6 7 8 9 10";
        CmdParser instance = new CmdParser();
        String[] expResult = {"1", "+", "1", "*", "5", "/", "3"};
        String[] result = instance.validate(units, operators, operands);
        assertArrayEquals(expResult, result);
    }
    
    @Test
    public void testValidate_invalidKeyword() {
        System.out.println("validate");
        String[] units = {"3", "/", null};
        String operators = "+-*/";
        String operands = "0 1 2 3 4 5 6 7 8 9 10";
        CmdParser instance = new CmdParser();
        String[] expResult = null;
        String[] result = instance.validate(units, operators, operands);
        assertArrayEquals(expResult, result);
    }
    
    @Test
    public void testValidate_lessThanThreeWords() {
        System.out.println("validate");
        String[] units = {"1", "+"};
        String operators = "+-*/";
        String operands = "012345678910";
        CmdParser instance = new CmdParser();
        String[] expResult = null;
        String[] result = instance.validate(units, operators, operands);
        assertArrayEquals(expResult, result);
    }
    
    @Test
    public void testValidate_startsWithOperator() {
        System.out.println("validate");
        String[] units = {"+", "4", "-", "3"};
        String operators = "+-*/";
        String operands = "0 1 2 3 4 5 6 7 8 9 10";
        CmdParser instance = new CmdParser();
        String[] expResult = null;
        String[] result = instance.validate(units, operators, operands);
        assertArrayEquals(expResult, result);
    }
    
    @Test
    public void testValidate_endsWithOperator() {
        System.out.println("validate");
        String[] units = {"3", "/", "0", "-"};
        String operators = "+-*/";
        String operands = "0 1 2 3 4 5 6 7 8 9 10";
        CmdParser instance = new CmdParser();
        String[] expResult = null;
        String[] result = instance.validate(units, operators, operands);
        assertArrayEquals(expResult, result);
    }
    
    @Test
    public void testValidate_consecutiveOperands() {
        System.out.println("validate");
        String[] units = {"3", "/", "3", "4", "+", "3"};
        String operators = "+-*/";
        String operands = "0 1 2 3 4 5 6 7 8 9 10";
        CmdParser instance = new CmdParser();
        String[] expResult = null;
        String[] result = instance.validate(units, operators, operands);
        assertArrayEquals(expResult, result);
    }    
    
    @Test
    public void testValidate_consecutiveOperators() {
        System.out.println("validate");
        String[] units = {"3", "/", "-", "5", "+", "7"};
        String operators = "+-*/";
        String operands = "0 1 2 3 4 5 6 7 8 9 10";
        CmdParser instance = new CmdParser();
        String[] expResult = null;
        String[] result = instance.validate(units, operators, operands);
        assertArrayEquals(expResult, result);
    }
    
    @Test
    public void testValidate_divideByZero() {
        System.out.println("validate");
        String[] units = {"3", "/", "0"};
        String operators = "+-*/";
        String operands = "0 1 2 3 4 5 6 7 8 9 10";
        CmdParser instance = new CmdParser();
        String[] expResult = null;
        String[] result = instance.validate(units, operators, operands);
        assertArrayEquals(expResult, result);
    }
}
