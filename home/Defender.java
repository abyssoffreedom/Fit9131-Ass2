/**
 * The Defender class inherits from Player class.
 *
 *@author Shuyang Yan
 *@version ver1.0.0
 */
public class Defender extends Player
{

    /**
     * Default constructor which creates the object of the class Defender.
     *
     */
    public Defender()
    {
        super();
    }

    /**
     * Non-default constructor which creates the object of the class Defender.
     *
     *@param playerName     the name of the player.
     *@param fieldPosition  the field position of the player.
     *@param seasonGoals    the goals scored in a total season.
     *@param team           the team of the player.
     */
    public Defender(String playerName, String fieldPosition, int seasonGoals, Team team)
    {
        super(playerName, fieldPosition, seasonGoals, team);
    }

    /**
     * Non-default constructor which creates the object of the class Player.
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
    public Defender(String playerName, String fieldPosition, int seasonGoals, Team team, int kicks, int goals, int behinds, int pass, boolean isStar, boolean isInjured, boolean isReported)
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
            if (number <= 95)
            {
                outcome[0] = "Pass";
                outcome[1] = "Midfielder";
            }
            else
            {
                outcome[0] = "Turnover";
                outcome[1] = "Forward";
            }
        }
        else
        {
            if (number <= 80)
            {
                outcome[0] = "Pass";
                outcome[1] = "Midfielder";
            }
            else
            {
                outcome[0] = "Turnover";
                outcome[1] = "Forward";
            }
        }
        return outcome;
    }
    
}
