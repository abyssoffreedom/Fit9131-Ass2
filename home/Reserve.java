/**
 * The Reserve class inherits from Player class.
 *
 *@author Shuyang Yan
 *@version ver1.0.0
 */
public class Reserve extends Player
{

    /**
     * Default constructor which creates the object of the class Reserve.
     *
     */
    public Reserve()
    {
        super();
    }

    /**
     * Non-default constructor which creates the object of the class Reserve.
     *
     *@param playerName     the name of the player.
     *@param fieldPosition  the field position of the player.
     *@param seasonGoals    the goals scored in a total season.
     *@param team           the team of the player.
     */
    public Reserve(String playerName, String fieldPosition, int seasonGoals, Team team)
    {
        super(playerName, fieldPosition, seasonGoals, team);
    }

    /**
     * Non-default constructor which creates the object of the class Reserve.
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
    public Reserve(String playerName, String fieldPosition, int seasonGoals, Team team, int kicks, int goals, int behinds, int pass, boolean isStar, boolean isInjured, boolean isReported)
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
        Player player = null;
        String fieldPosition = getFieldPosition();
        if (fieldPosition.equals("Forward"))
            player= new Forward();
        else if (fieldPosition.equals("Midfielder"))
            player = new Midfielder();
        else
            player = new Defender();
        return player.kickABall();
    }

    /**
     * Substitutes the injured player with a reserve player from the same team.
     *
     *@param theInjuredPlayer     the injured player.
     */
    public void substitute(Player theInjuredPlayer)
    {
        setFieldPosition(theInjuredPlayer.getFieldPosition());
    }

    /**
     * Generates a string representation of the reserve player.
     *
     *@return          a String representing the reserve player.
     */
    @Override
    public String toString()
    {
        String star = (getIsStar()) ? "*" : "";
        String playerName = getPlayerName() + star;
        String injury = (getIsInjured()) ? " (injured)" : "";
        String report = (getIsReported()) ? " (reported)" : "";
        String originalPosition = (getFieldPosition().equals("Reserve")) ? "" :" (Reserve)";
        String fieldPosition = getFieldPosition() + originalPosition + injury + report;
        return String.format("%-20s %-8d %-8d %-10d %-10d %-12s %-15s", playerName, getKicks(), getGoals(), getBehinds(), getPass(), calculatePercent(), fieldPosition);
    }
    
}
