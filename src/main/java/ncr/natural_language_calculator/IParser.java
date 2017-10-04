package ncr.natural_language_calculator;
/**
 *
 * @author Ilyasse Fakhreddine
 */

public interface IParser {

    /**
     * Evaluates if the units form a valid command by checking lexicon
     * and syntax;
     * NOTE: A word is a sequence characters preceded and followed by a white 
     * space.
     * 
     * @param units   the units of the command to be validated.
     * @param operators a collection of accepted operators (e.g. plus).
     * @param operands  a collection of accepted operands (e.g one).
     * @return on success an array of strings containing parsed words,
     * otherwise NULL.
     */
    String[] validate(String[] units, String operators, String operands);
    
	
    /**
     * Translates the natural language notation into symbolic 
     * infix notation.
     *
     * @param units the units of command to be translated.
     * @return the translated string array. if on or more 
     * translation were unsuccessful, a null is assigned to units[i].
     */
    String[] translate(String[] units);
    
}
