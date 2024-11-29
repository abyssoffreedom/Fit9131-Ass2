/**
 * The Player class is an abstract class that represents a player in an AFL team.
 *
 *@author Shuyang Yan
 *@version ver1.0.0
 */
public abstract class Player
{

    private String playerName;
    private String fieldPosition;
    private int seasonGoals;
    private Team team;
    private int kicks;
    private int goals;
    private int behinds;
    private int pass;
    private boolean isStar;
    private boolean isInjured;
    private boolean isReported;

    /**
     * Default constructor which creates the object of the class Player.
     *
     */
    protected Player()
    {
        playerName = "default name";
        fieldPosition = "default position";
        seasonGoals = 0;
        team = null;
        kicks = 0;
        goals = 0;
        behinds = 0;
        pass = 0;
        isStar = false;
        isInjured = false;
        isReported = false;
    }

    /**
     * Non-default constructor which creates the object of the class Player.
     *
     *@param playerName     the name of the player.
     *@param fieldPosition  the field position of the player.
     *@param seasonGoals    the goals scored in a total season.
     *@param team           the team of the player.
     */
    protected Player(String playerName, String fieldPosition, int seasonGoals, Team team)
    {
        if (playerName == null || playerName.isEmpty())
            throw new IllegalArgumentException("Name cannot be null or empty");
        this.playerName = playerName;
        if (!fieldPosition.equals("Forward") && !fieldPosition.equals("Midfielder") && !fieldPosition.equals("Defender") && !fieldPosition.equals("Reserve"))
            throw new IllegalArgumentException("Field positon cannot be other than Forward, Midfielder, Defender or Reserve");
        this.fieldPosition = fieldPosition;
        if (seasonGoals < 0)
            throw new IllegalArgumentException("Season goals cannot be less than 0");
        this.seasonGoals = seasonGoals;
        this.team = team;
        kicks = 0;
        goals = 0;
        behinds = 0;
        pass = 0;
        isStar = false;
        isInjured = false;
        isReported = false;
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
    protected Player(String playerName, String fieldPosition, int seasonGoals, Team team, int kicks, int goals, int behinds, int pass, boolean isStar, boolean isInjured, boolean isReported)
    {
        if (playerName == null || playerName.isEmpty())
            throw new IllegalArgumentException("Name cannot be null or empty");
        this.playerName = playerName;
        if (!fieldPosition.equals("Forward") && !fieldPosition.equals("Midfielder") && !fieldPosition.equals("Defender") && !fieldPosition.equals("Reserve"))
            throw new IllegalArgumentException("Field positon cannot be other than Forward, Midfielder, Defender or Reserve");
        this.fieldPosition = fieldPosition;
        if (seasonGoals < 0)
            throw new IllegalArgumentException("Season goals cannot be less than 0");
        this.seasonGoals = seasonGoals;
        this.team = team;
        if (kicks < 0)
            throw new IllegalArgumentException("Kicks cannot be less than 0");
        this.kicks = kicks;
        if (goals < 0)
            throw new IllegalArgumentException("Goals cannot be less than 0");
        this.goals = goals;
        if (behinds < 0)
            throw new IllegalArgumentException("Behinds cannot be less than 0");
        this.behinds = behinds;
        if (pass < 0)
            throw new IllegalArgumentException("Pass cannot be less than 0");
        this.pass = pass;
        this.isStar = isStar;
        this.isInjured = isInjured;
        this.isReported = isReported;
    }

    /**
     * Increments the number of behinds by 1.
     */
    protected void addABehind()
    {
        behinds++;
    }

    /**
     * Increments the number of goals by 1.
     */
    protected void addAGoal()
    {
        goals++;
    }

    /**
     * Increments the number of kicks by 1.
     */
    protected void addAKick()
    {
        kicks++;
    }

    /**
     * Increments the number of pass by 1.
     */
    protected void addAPass()
    {
        pass++;
    }

    /**
     * Calculates and returns the percentage representation of successful kicks.
     *
     *@return    the string of the percentage.
     */
    protected String calculatePercent()
    {
        //Convert the sum of goals, behinds and pass into a double first.
        double result =  (double)(goals + behinds + pass) / kicks;
        //math.round() can return an int, and when this int is divided by 100.0
        //the result will be in the format of two decimal point.
        result = Math.round(result * 10000.0) / 100.0;
        //This step automatically convert the double into a string.
        return result + "%";
    }

    /**
     * Displays the player's details.
     */
    protected void display()
    {
        System.out.println("playerName   : " + playerName);
        System.out.println("fieldPosition: " + fieldPosition);
        System.out.println("seasonGoals  : " + seasonGoals);
        System.out.println("team         : " + team);
        System.out.println("kicks        : " + kicks);
        System.out.println("goals        : " + goals);
        System.out.println("behinds      : " + behinds);
        System.out.println("pass         : " + pass);
        System.out.println("isStar       : " + isStar);
        System.out.println("isInjured    : " + isInjured);
        System.out.println("isReported   : " + isReported);
    }

    /**
     * Accessor method to get the number of behinds.
     *
     *@return    the number of behinds.
     */
    protected int getBehinds()
    {
        return behinds;
    }

    /**
     * Accessor method to get the player's field position.
     *
     *@return    the player's field position.
     */
    protected String getFieldPosition()
    {
        return fieldPosition;
    }

    /**
     * Accessor method to get the number of goals.
     *
     *@return    the number of goals.
     */
    protected int getGoals()
    {
        return goals;
    }

    /**
     * Changes the state of a player into being reported.
     */
    protected void getReported()
    {
        isReported = true;
    }

    /**
     * Changes the state of a player into being injured.
     */
    protected void getInjured()
    {
        isInjured = true;
    }

    /**
     * Accessor method to get the flag of whether injured.
     *
     *@return    the flag of whether injured.
     */
    protected boolean getIsInjured()
    {
        return isInjured;
    }

    /**
     * Accessor method to get the flag of whether being reported.
     *
     *@return    the flag of whether being reported.
     */
    protected boolean getIsReported()
    {
        return isReported;
    }

    /**
     * Accessor method to get the flag of whether being star player.
     *
     *@return    the flag of whether being star player.
     */
    protected boolean getIsStar()
    {
        return isStar;
    }

    /**
     * Accessor method to get the number of kicks.
     *
     *@return    the number of kicks.
     */
    protected int getKicks()
    {
        return kicks;
    }

    /**
     * Accessor method to get the number of pass.
     *
     *@return    the number of pass.
     */
    protected int getPass()
    {
        return pass;
    }

    /**
     * Accessor method to get the name of player.
     *
     *@return    the name of player.
     */
    protected String getPlayerName()
    {
        return playerName;
    }

    /**
     * Accessor method to get the number of season goals.
     *
     *@return    the number of season goals.
     */
    protected int getSeasonGoals()
    {
        return seasonGoals;
    }

    /**
     * Accessor method to get the team.
     *
     *@return    the team.
     */
    protected Team getTeam()
    {
        return team;
    }

    /**
     * Abstract method to record the outcome of the action of kicking a ball.
     *
     *@return    the string array storing the outcome of the action.
     */
    protected abstract String[] kickABall();

    /**
     * Mutator method to set the number of behinds.
     *
     *@param newBehinds  new number of behinds to set.
     *@return            true if the value is valid, false otherwise.
     */
    protected boolean setBehinds(int newBehinds)
    {
        if (newBehinds < 0)
            return false;
        behinds = newBehinds;
        return true;
    }

    /**
     * Mutator method to set the player's field position.
     *
     *@param newFieldPosition  new field position.
     *@return                  true if the value is valid, false otherwise.
     */
    protected boolean setFieldPosition(String newFieldPosition)
    {
        if (newFieldPosition == null || newFieldPosition.isEmpty())
            return false;
        fieldPosition = newFieldPosition;
        return true;
    }

    /**
     * Mutator method to set the number of goals.
     *
     *@param newGoals     new number of goals to set.
     *@return            true if the value is valid, false otherwise.
     */
    protected boolean setGoals(int newGoals)
    {
        if (newGoals < 0)
            return false;
        goals = newGoals;
        return true;
    }

    /**
     * Mutator method to set the flag of whether injured.
     *
     *@param newIsInjured  new flag to set.
     *@return              true if the value is valid, false otherwise.
     */
    protected boolean setIsInjured(boolean newIsInjured)
    {
        if (newIsInjured != true && newIsInjured != false)
            return false;
        isInjured = newIsInjured;
        return true;
    }

    /**
     * Mutator method to set the flag of whether being reported.
     *
     *@param newIsReported  new flag to set.
     *@return               true if the value is valid, false otherwise.
     */
    protected boolean setIsReported(boolean newIsReported)
    {
        if (newIsReported != true && newIsReported != false)
            return false;
        isReported = newIsReported;
        return true;
    }

    /**
     * Mutator method to set the flag of whether being star player.
     *
     *@param newIsStar     new flag to set.
     *@return              true if the value is valid, false otherwise.
     */
    protected boolean setIsStar(boolean newIsStar)
    {
        if (newIsStar != true && newIsStar != false)
            return false;
        isStar = newIsStar;
        return true;
    }

    /**
     * Mutator method to set the number of kicks.
     *
     *@param newKicks    new number of kicks to set.
     *@return            true if the value is valid, false otherwise.
     */
    protected boolean setKicks(int newKicks)
    {
        if (newKicks < 0)
            return false;
        kicks = newKicks;
        return true;
    }

    /**
     * Mutator method to set the number of pass.
     *
     *@param newPass     new number of pass to set.
     *@return            true if the value is valid, false otherwise.
     */
    protected boolean setPass(int newPass)
    {
        if (newPass < 0)
            return false;
        pass = newPass;
        return true;
    }

    /**
     * Mutator method to set the name of player.
     *
     *@param newPlayerName    new name of player to set.
     *@return                 true if the value is valid, false otherwise.
     */
    protected boolean setPlayerName(String newPlayerName)
    {
        if (newPlayerName == null || newPlayerName.isEmpty())
            return false;
        playerName = newPlayerName;
        return true;
    }

    /**
     * Mutator method to set the number of season goals.
     *
     *@param newSeasonGoals     new number of season goals to set.
     *@return                   true if the value is valid, false otherwise.
     */
    protected boolean setSeasonGoals(int newSeasonGoals)
    {
        if (newSeasonGoals < 0)
            return false;
        seasonGoals = newSeasonGoals;
        return true;
    }

    /**
     * Mutator method to set the team.
     *
     *@param newTeam     new team to set.
     */
    protected void setTeam(Team newTeam)
    {
        team = newTeam;
    }

    /**
     * Generates a string representation of the player.
     *
     *@return          a String representing the player.
     */
    @Override
    public String toString()
    {
        String star = (isStar) ? "*" : "";
        String outputName = playerName + star;
        String injury = (isInjured) ? " (injured)" : "";
        String report = (isReported) ? " (reported)" : "";
        String outputFieldPosition = fieldPosition + injury + report;
        return String.format("%-20s %-8d %-8d %-10d %-10d %-12s %-15s", outputName, kicks, goals, behinds, pass, calculatePercent(), outputFieldPosition);
    }
    
}
