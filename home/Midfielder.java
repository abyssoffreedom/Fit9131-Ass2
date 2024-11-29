/**
 * The Midfielder class inherits from Player class.
 *
 *@author Shuyang Yan
 *@version ver1.0.0
 */
public class Midfielder extends Player
{

    /**
     * Default constructor which creates the object of the class Midfielder.
     *
     */
    public Midfielder()
    {
        super();
    }

    /**
     * Non-default constructor which creates the object of the class Midfielder.
     *
     *@param playerName     the name of the player.
     *@param fieldPosition  the field position of the player.
     *@param seasonGoals    the goals scored in a total season.
     *@param team           the team of the player.
     */
    public Midfielder(String playerName, String fieldPosition, int seasonGoals, Team team)
    {
        super(playerName, fieldPosition, seasonGoals, team);
    }

    /**
     * Non-default constructor which creates the object of the class Midfielder.
     *
     *@param playerName     the name of the player.
     *@param fieldPosition  the field position of the player.
     *@param seasonGoals    the goals scored in a total season.
     *@param team           the team of the player.
     *@param kicks          the number of kicks.
     *@param goals          the number of goals.
     *@param behinds        the number of behinds.
     *@param pass           the number of pass.
     *@param isStar         whether the player is a star player.
     *@param isInjured      whether the player is currently injured.
     *@param isReprted      whether the player has been reported.
     */
    public Midfielder(String playerName, String fieldPosition, int seasonGoals, Team team, int kicks, int goals, int behinds, int pass, boolean isStar, boolean isInjured, boolean isReported)
    {
        super(playerName, fieldPosition, seasonGoals, team, kicks, goals, behinds, pass, isStar, isInjured, isReported);
    }

    /**
     * Abstract method to record the outcome of the action of kicking a ball.
     *
     *@return    the string array storing the outcome of the action.
     */
    public String[] kickABall()
    {
        String[] outcome = new String[2];
        int number = RandomNumber.generateARandomNumber(100);
        if (getIsStar())
        {
            if (number <= 10)
            {
                outcome[0] = "Goal";
                outcome[1] = null;
            }
            else if (number <= 20)
            {
                outcome[0] = "Behind";
                outcome[1] = null;
            }
            else if (number <= 55)
            {
                outcome[0] = "Pass";
                outcome[1] = "Forward";
            }
            else if (number <= 90)
            {
                outcome[0] = "Pass";
                outcome[1] = "Midfielder";
            }
            else
            {
                outcome[0] = "Turnover";
                outcome[1] = "Midfielder";
            }
        }
        else
        {
            if (number <= 5)
            {
                outcome[0] = "Goal";
                outcome[1] = null;
            }
            else if (number <= 10)
            {
                outcome[0] = "Behind";
                outcome[1] = null;
            }
            else if (number <= 45)
            {
                outcome[0] = "Pass";
                outcome[1] = "Forward";
            }
            else if (number <= 75)
            {
                outcome[0] = "Pass";
                outcome[1] = "Midfielder";
            }
            else
            {
                outcome[0] = "Turnover";
                outcome[1] = "Midfielder";
            }
        }
        return outcome;
    }
    
}
