import java.util.ArrayList;

/**
 * The Team class that stores the data in a team.
 *
 *@author Shuyang Yan
 *@version ver1.0.0
 */
public class Team
{

    private String teamName;
    private ArrayList<Player> players;
    private int goals;
    private int behinds;
    private int points;

    /**
     * Default constructor which creates the object of the class Team.
     */
    public Team()
    {
        teamName = "default name";
        players = new ArrayList<>();
        goals = 0;
        behinds = 0;
        points = 0;
    }

    /**
     * Non-default constructor which creates the object of the class Team.
     *
     *@param teamName    the name of a team.
     *@param players     the ArrayList that collects all players in the team.
     */
    public Team(String teamName, ArrayList<Player> players)
    {
        this.teamName = teamName;
        this.players = players;
        goals = 0;
        behinds = 0;
        points = 0;
    }

    /**
     * Non-default constructor which creates the object of the class Team.
     *
     *@param teamName    the name of a team.
     *@param players     the ArrayList that collects all players in the team.
     *@param goals       the number of goals scored by the team.
     *@param behinds     the number of behinds scored by the team.
     *@param points      the total points of the team.
     */
    public Team(String teamName, ArrayList<Player> players, int goals, int behinds, int points)
    {
        this.teamName = teamName;
        this.players = players;
        this.goals = goals;
        this.behinds = behinds;
        this.points = points;
    }

    /**
     * Increments the number of behinds by 1 and adds 1 point to the team's score.
     */
    public void addAbehind()
    {
        behinds++;
        addPoints(1);
    }

    /**
     * Increments the number of goals by 1 and adds 6 point to the team's score.
     */
    public void addAGoal()
    {
        goals++;
        addPoints(6);
    }

    /**
     * Adds points to the team's score.
     *
     *@param points   the number of points to add.
     */
    public void addPoints(int points)
    {
        this.points += points;
    }

    /**
     * Display the team's information.
     */
    public void display()
    {
        System.out.println("\n" + teamName);
        System.out.println(" Total goals: " + goals);
        System.out.println(" Total behinds " + behinds);
        System.out.println(" Total score " + points);
        System.out.println(" Who has the greatest number of kicks?");
        for (Player player : getPlayersWithMostKicks())
            System.out.println("   " + player.getPlayerName() + " kicked the ball " + player.getKicks() + " times");
        System.out.println(" Who kicked the most goals?");
        for (Player player : getPlayersWithMostGoals())
            System.out.println("   " + player.getPlayerName() + " kicked " + player.getGoals() + " goals");
        System.out.println(" Individual statics:");
        System.out.printf("%-20s %-8s %-8s %-10s %-10s %-12s %-15s", "Name", "Kicks", "Goals", "Behinds", "Pass", "Percent", "Position");
        System.out.println();
        for (Player player : players)
            System.out.println(player);
    }

    /**
     * Displays all injured players in the team.
     */
    public void displayInjuredPlayers()
    {
        System.out.println("Team: " + teamName);
        for (Player player : players)
        {
            if (player.getIsInjured())
                System.out.println("  " + player.getPlayerName() + " (" + player.getFieldPosition() + ")");
        }
    }

    /**
     * Displays all reported players in the team.
     */
    public void displayReportedPlayers()
    {
        System.out.println("Team: " + teamName);
        for (Player player : players)
        {
            if (player.getIsReported())
                System.out.println("  " + player.getPlayerName() + " (" + player.getFieldPosition() + ")");
        }
    }

    /**
     * Generates a random player from a specified field position.
     *
     *@param fieldPosition   the position of the player.
     *@return                a randomly selected player playing the given position.
     */
    public Player generateARandomPlayer(String fieldPosition)
    {
        //Use this ArrayList to store all players in specific positions in one team.
        ArrayList<Player> playersInSpecificPosition = new ArrayList<>();
        for (Player player : players)
        {
            //The randomly selected player must not be injured.
            if (player.getFieldPosition().equals(fieldPosition) && !player.getIsInjured())
                playersInSpecificPosition.add(player);
        }
        int randomIndex = RandomNumber.generateARandomNumber(playersInSpecificPosition.size()) - 1;
        return playersInSpecificPosition.get(randomIndex);
    }

    /**
     * Generates a random player from a specified field position except the current player.
     *
     *@param fieldPosition   the position of the player.
     *@param currentPlayer   the current player who is kicking the ball.
     *@return                a randomly selected player playing the given position except the current player.
     */
    public Player generateARandomPlayerExceptCurrentPlayer(String fieldPosition, Player currentPlayer)
    {
        //Use this ArrayList to store all players in specific positions in one team.
        ArrayList<Player> playersInSpecificPosition = new ArrayList<>();
        for (Player player : players)
        {
            //The randomly selected player must not be injured.
            if (player.getFieldPosition().equals(fieldPosition) && !player.getIsInjured())
                playersInSpecificPosition.add(player);
        }
        //Only when the ball is passed to the same position, is there need to remove the current player from the collection.
        if (fieldPosition.equals(currentPlayer.getFieldPosition()))
            playersInSpecificPosition.remove(currentPlayer);
        int randomIndex = RandomNumber.generateARandomNumber(playersInSpecificPosition.size()) - 1;
        return playersInSpecificPosition.get(randomIndex);
    }

    /**
     * Accessor method to get all players.
     *
     *@return    the ArrayList of players.
     */
    public ArrayList<Player> getPlayers()
    {
        return players;
    }

    /**
     * Accessor method to get the number of behinds.
     *
     *@return    the number of behinds.
     */
    public int getBehinds()
    {
        return behinds;
    }

    /**
     * Accessor method to get the number of goals.
     *
     *@return    the number of goals.
     */
    public int getGoals()
    {
        return goals;
    }

    /**
     * Gets the players who have scored the most goals.
     *
     *@return    an ArrayList of players with the most goals.
     */
    public ArrayList<Player> getPlayersWithMostGoals()
    {
        ArrayList<Player> playersWithMostGoals = new ArrayList<>();
        int theGreatestNumberOfGoals = 0;
        for (Player player : players)
        {
            if (player.getGoals() > theGreatestNumberOfGoals)
                theGreatestNumberOfGoals = player.getGoals();
        }
        for (Player player : players)
        {
            if (player.getGoals() == theGreatestNumberOfGoals)
                playersWithMostGoals.add(player);
        }
        return playersWithMostGoals;
    }

    /**
     * Gets the players who have kicked the most balls.
     *
     *@return    an ArrayList of players with the most kicks.
     */
    public ArrayList<Player> getPlayersWithMostKicks()
    {
        ArrayList<Player> playersWithMostKicks = new ArrayList<>();
        int theGreatestNumberOfKicks = 0;
        for (Player player : players)
        {
            if (player.getKicks() > theGreatestNumberOfKicks)
                theGreatestNumberOfKicks = player.getKicks();
        }
        for (Player player : players)
        {
            if (player.getKicks() == theGreatestNumberOfKicks)
                playersWithMostKicks.add(player);
        }
        return playersWithMostKicks;
    }

    /**
     * Accessor method to get the total points.
     *
     *@return    the total points.
     */
    public int getPoints()
    {
        return points;
    }

    /**
     * Accessor method to get the name of the team.
     *
     *@return    the name of the team.
     */
    public String getTeamName()
    {
        return teamName;
    }

    /**
     * Mutator method to set the number of behinds.
     *
     *@param behinds    the number of behinds to set.
     *@return           true if the value is valid, false otherwise.
     */
    public boolean setBehinds(int behinds)
    {
        if (behinds < 0)
            return false;
        this.behinds = behinds;
        return true;
    }

    /**
     * Mutator method to set the number of goals.
     *
     *@param goals      the number of goals to set.
     *@return           true if the value is valid, false otherwise.
     */
    public boolean setGoals(int goals)
    {
        if (goals < 0)
            return false;
        this.goals = goals;
        return true;
    }

    /**
     * Mutator method to set the players.
     *
     *@param newPlayers    the new collection of players to set.
     */
    public void setPlayers(ArrayList<Player> newPlayers)
    {
        players = newPlayers;
    }

    /**
     * Mutator method to set the total points.
     *
     *@param points     the total points to set.
     *@return           true if the value is valid, false otherwise.
     */
    public boolean setPoints(int points)
    {
        if (points < 0)
            return false;
        this.points = points;
        return true;
    }

    /**
     * Mutator method to set the team name.
     *
     *@param newTeamName    the new name of the team.
     *@return               true if the value is valid, false otherwise.
     */
    public boolean setTeamName(String newTeamName)
    {
        if (newTeamName == null || newTeamName.isEmpty())
            return false;
        teamName = newTeamName;
        return true;
    }
    
    /**
     * Generates a string representation of the team.
     *
     *@return          a String representing the team.
     */
    @Override
    public String toString()
    {
        String teamInformation = "";
        teamInformation += teamName + "\n";
        for (Player player : players)
            teamInformation += player.toString();
        return teamInformation;
    }
    
}
