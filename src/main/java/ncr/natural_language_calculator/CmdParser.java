/**
 * Translate the command from Natural Language to symbolic infix notation and 
 * validates it according to below rules:
 * 1.There must be at least three words in a valid command;
 * 2.The command line must start and end with an operand;
 * 3.Operands and operators must alternate in the command line;
 * 4.Dividing-by zero is forbidden;
 *
 * @param command the command to parse.
 * @param operators set of accepted operators.
 * @param operands set of accepted operands.
 */
package ncr.natural_language_calculator;

import java.util.HashMap;

/**
 * @author Ilyasse Fakhreddine
 */
public class CmdParser implements IParser {
    private HashMap<String,String> symbol;
    /* Mapping natural language keywords to symbolic notations symbols. */
    public CmdParser(){
        this.symbol = new HashMap<>();
        symbol.put("zero", "0");
        symbol.put("one", "1");
        symbol.put("two", "2");
        symbol.put("three", "3");
        symbol.put("four", "4");
        symbol.put("five", "5");
        symbol.put("six", "6");
        symbol.put("seven", "7");
        symbol.put("eight", "8");
        symbol.put("nine", "9");
        symbol.put("ten", "10");
        
        symbol.put("add", "+");
        symbol.put("plus", "+");
        symbol.put("subtract", "-");
        symbol.put("minus", "-");
        symbol.put("less", "-");
        symbol.put("multiply-by", "*");
        symbol.put("times", "*");
        symbol.put("divide-by", "/");
        symbol.put("over", "/");
    }
    
    public String[] translate(String[] units){
        for(int i = 0; i < units.length; i++){
            units[i] = symbol.get(units[i]);
        }
        
        return units;
    }
    
    @Override
    public String[] validate(String[] units, String operators, String operands){
        
        /* checks lexicology */
        for(String unit:units){
            if(unit == null){
                System.out.println("\nError: Invalid keywords used.");
                return null;
            }
        }
        
        /* long at least 3 words */
        if(units.length < 3){
            System.out.println("\nError: Command must be at least three words.");
            return null;
        }
        
        /* begins and ends with an operand */
        if(!operands.contains(units[0]) || 
                                   !operands.contains(units[units.length - 1])){
            System.out.println("\nError: Command must start/end with an operand.");
            return null;
        }
        
        /* it alternates operands and operators */
        for(int i = 0; i < units.length - 1; i++){           
            if(operators.contains(units[i]) == !operands.contains(units[i+1])){
                System.out.println("\nError: Two consecutive operators/operands.");
                return null;
            }
        }
        
        /* no zero division */
        for(int i = 0; i < units.length - 1; i++){
            if("/".equals(units[i]) && "0".equals(units[i + 1])){
                System.out.println("\nError: Dividing by zero.");
                return null;
            }
        }
        
        return units;
    }
}
