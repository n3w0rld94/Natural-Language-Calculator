/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ncr.natural_language_calculator;

import java.util.Scanner;

/**
 *
 * @author Ilyasse Fakhreddine
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        /* parameters */
        String command, answer, operands, operators;
        String[] units;
        double result;
        operators = "+-*/";
        operands = "0 1 2 3 4 5 6 7 8 9 10";
        Scanner keyboard;
        CmdParser parser = new CmdParser();
        ICalculator calculator = new Calculator();
        
        keyboard = new Scanner(System.in);
        parser = new CmdParser();
        
        /* menu */
        System.out.println("Natural Language Calculator 2017.\n");
        System.out.println("Operators list:\n add, plus, subtract, less, minus, "
                          +"multiplied-by, times, divided-by, over.\n");
        System.out.println("Operands list:\n zero, one, two, three, four, five, "
                          +"six, seven, eight, nine, ten.\n");
        
        do{
            System.out.println("\nInsert your command: ");
            command = keyboard.nextLine();
            
            command = command.toLowerCase();
            units = command.split(" ");
            units = parser.translate(units);
            units = parser.validate(units, operators, operands);
            if(units != null){
                result = calculator.compute(units, operators, operands);
                System.out.println("\nResult: ");
                System.out.print(result + "\n");
            }
            
            System.out.println("\nTry again? (y/n): ");
            answer = keyboard.nextLine();
            
        }while(answer.equals("y"));
    }
    
}