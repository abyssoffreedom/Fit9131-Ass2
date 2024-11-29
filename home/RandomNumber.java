/**
 * The Random class that generates random number.
 *
 *@author Shuyang Yan
 *@version ver1.0.0
 */
public class RandomNumber
{

    /**
     * Default constructor which creates the object of the class RandomNumber.
     */
    public RandomNumber()
    {

    }

    /**
     * Generates a random number on different decimal.
     *
     *@param maxNumber   the upper limit of the random number to be generated.
     *@return            the randomly generated number.
     */
    public static int generateARandomNumber(int maxNumber)
    {
        return (int)(Math.random() * maxNumber + 1);
    }
    
}
