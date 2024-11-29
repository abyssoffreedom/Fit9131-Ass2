/**
 * The Validation class that validates the data.
 *
 *@author Shuyang Yan
 *@version ver1.0.0
 */
public class Validation
{

    /**
     * Default constructor which creates the object of the class Test.
     */
    public Validation()
    {
        
    }

    /**
     * Validates whether the number is within certain range.
     *
     *@param number  the number to be tested.
     *@param min     the lower limit.
     *@param max     the upper limit.
     *@return        whether the number is within the given range
     */
    public static boolean integerInRange(int number, int min, int max)
    {
        if(number >= min && number <= max)
            return true;
        return false;
    }
    
}
