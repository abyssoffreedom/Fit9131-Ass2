import java.util.Scanner;

/**
 * The Input class that accepts the input from the user.
 *
 *@author Shuyang Yan
 *@version ver1.0.0
 */
public class Input
{

    /**
     * Default constructor which creates the object of the class Input.
     *
     */
    public Input()
    {

    }

    /**
     * Accepts string input.
     *
     *@return     the input content as a string.
     */
    public static String acceptStringInput()
    {
        Scanner console = new Scanner(System.in);
        return console.nextLine();
    }
    
}
