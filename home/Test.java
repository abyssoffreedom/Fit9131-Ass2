/**
 * The Test class that tests class Player.
 *
 *@author Shuyang Yan
 *@version ver1.0.0
 */
public class Test
{

    /**
     * Default constructor which creates the object of the class Test.
     */
    public Test()
    {

    }

    // public static void main(String[] args)
    // {
    //     Test test = new Test();
    //     test.testDefaultConstructor();
    //     test.testConstructorOneWithValidArgument();
    //     test.testConstructorOneWithNullName();
    //     test.testConstructorTwoWithValidArgument();
    //     test.testConstructorTwoWithNullName();
    //     test.testDisplay();
    //     test.testGetPlayerName();
    //     test.testSetPlayerNameWithValidArgument();
    //     test.testSetPlayerNameWithInvalidArgument();
    // }

    /**
     * Tests the default constructor of the class Player.
     */
    public void testDefaultConstructor()
    {
        System.out.println("Create a Forward object with the default constructor");
        try
        {
            Forward forward = new Forward();
            forward.display();
        }
        catch (Exception e)
        {
            System.out.println(e.getMessage());
        }
    }

    /**
     * Tests the first non-default constructor of the class Player with valid values.
     */
    public void testConstructorOneWithValidArgument()
    {
        System.out.println("Create a Forward object with the first non-default constructor with valid field values");
        try
        {
            Forward forward = new Forward("playerA1", "Forward", 0, null, 0, 0, 0, 0, false, false, false);
            forward.display();
        }
        catch (Exception e)
        {
            System.out.println(e.getMessage());
        }
    }

    /**
     * Tests the first non-default constructor of the class Player with invalid values.
     */
    public void testConstructorOneWithNullName()
    {
        System.out.println("Create a Forward object with the first non-default constructor with invalid field values");
        try
        {
            Forward forward = new Forward(null, "Forward", 0, null, 0, 0, 0, 0, false, false, false);
            forward.display();
        }
        catch (Exception e)
        {
            System.out.println(e.getMessage());
        }
    }

    /**
     * Tests the second non-default constructor of the class Player with valid values.
     */
    public void testConstructorTwoWithValidArgument()
    {
        System.out.println("Create a Forward object with the second non-default constructor with valid field values");
        try
        {
            Forward forward = new Forward("playerA1", "Forward", 0, null);
            forward.display();
        }
        catch (Exception e)
        {
            System.out.println(e.getMessage());
        }
    }

    /**
     * Tests the second non-default constructor of the class Player with invalid values.
     */
    public void testConstructorTwoWithNullName()
    {
        System.out.println("Create a Forward object with the second non-default constructor with invalid field values");
        try
        {
            Forward forward = new Forward(null, "Forward", 0, null);
            forward.display();
        }
        catch (Exception e)
        {
            System.out.println(e.getMessage());
        }
    }

    /**
     * Tests the display method of the class Player.
     */
    public void testDisplay()
    {
        System.out.println("Test display method");
        Forward forward = new Forward("playerA1", "Forward", 0, null, 0, 0, 0, 0, false, false, false);
        forward.display();
    }

    /**
     * Tests the getPlayName method of the class Player.
     */
    public void testGetPlayerName()
    {
        System.out.println("Test getPlayerName method");
        Forward forward = new Forward("playerA1", "Forward", 0, null, 0, 0, 0, 0, false, false, false);
        System.out.println("playerName: " + forward.getPlayerName());
    }

    /**
     * Tests the setPlayName method of the class Player with valid values.
     */
    public void testSetPlayerNameWithValidArgument()
    {
        System.out.println("Test setPlayerName method with valid argument");
        Forward forward = new Forward();
        System.out.println("Argument is valid: " + forward.setPlayerName("playerA1"));
    }

    /**
     * Tests the setPlayName method of the class Player with invalid values.
     */
    public void testSetPlayerNameWithInvalidArgument()
    {
        System.out.println("Test setPlayerName method with invalid argument");
        Forward forward = new Forward();
        System.out.println("Argument is valid: " + forward.setPlayerName(null));
    }
    
}
