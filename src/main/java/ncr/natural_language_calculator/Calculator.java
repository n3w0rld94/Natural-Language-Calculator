
package ncr.natural_language_calculator;

import java.util.Stack;
import java.util.regex.Pattern;

/**
 *
 * @author Ilyasse Fakhreddine
 */
public class Calculator implements ICalculator{
    
    /**
     * Rewrites expression in polish postfix notation using the Shunting-Yard 
     * algorithm by Dijkstra.
     * NOTE: Priority is index of operation in operators divided by two, to 
     * obtain same number inside the couples * / and + -;
     * 
     * @param units
     * @param operators accepted operators.
     * @param operands accepted operands.
     * @return the result 
     */
    
    public double compute(String[] units, String operators, String operands){
        Double result;
        
        units = shuntingYard(units, operators, operands);
        
        /* evaluate the expression. buff is formatted with " " as a delimiter.*/
        String buff;
        int countOperands = 0;
        while (units.length != 1) {
            buff = String.join(" ", units);
            for (int i = 0; i < units.length; i++) {
                if (operators.contains(units[i])){
                    if( countOperands >= 2){
                        result = solveUnit(units[i - 2], units[i - 1], units[i]);
                        /* replaces the operation with the result " */
                        buff = buff.replaceFirst(Pattern.quote(units[i - 2].
                        concat(" ").concat(units[i - 1]).concat(" ").
                        concat(units[i])), result.toString());
                    }
                    countOperands = 0;
                }
                else{
                    countOperands++;
                }
            }
            units = buff.split(" ");
            countOperands = 0;
        }
        
        return Double.parseDouble(units[0]);
    }
    
    private static String[] shuntingYard(String[]units, String operators, String operands){
        Stack<String> operatorStack, outputStack;
        operatorStack = new Stack();
        outputStack = new Stack();
        for(int i = 0; i < units.length; i++){
            if(operands.contains(units[i])){
                outputStack.push(units[i]);
            }
            else{
                if(!operatorStack.empty() && operators.indexOf(units[i])/2 
                                   <= operators.indexOf(operatorStack.peek())/2){
                    outputStack.push(operatorStack.pop());
                }
                operatorStack.push(units[i]);
            }
        }
        while(!operatorStack.empty()){
            outputStack.push(operatorStack.pop());
        }
        
        return (String[])outputStack.toArray(new String[outputStack.size()]);
    }
    
    private static double solveUnit(String operand1, String operand2, String operator){
        double result;
        double a, b;
        result = 0;
        a = Double.parseDouble(operand1);
        b = Double.parseDouble(operand2);
        
        switch(operator){
            case "/":
                result = a / b;
                break;
            case "*":
                result = a * b;
                break;
            case "+":
                result = a + b;
                break;
            case "-":
                result = a - b;
                break;
        }
        return result;
    }
}
