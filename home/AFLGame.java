import java.util.ArrayList;

/**
 * The AFLGame class simulates the game flow.
 *
 *@author Shuyang Yan
 *@version ver1.0.0
 */
public class AFLGame
{

    private Team[] twoTeams;

    /**
     * Default constructor which creates the object of the class AFLGame.
     *
     */
    public AFLGame()
    {
        twoTeams = new Team[2];
    }

    /**
     * Non-default constructor which creates the object of the class AFLGame.
     *
     *@param newTwoTeams    the array of two teams to participate in the game.
     */
    public AFLGame(Team[] newTwoTeams)
    {
        twoTeams = newTwoTeams;
    }

    /**
     * Handles the event when a player scores a behind.
     *
     *@param event    the current game event.
     *@return         the next game event.
     */
    public Event behind(Event event)
    {
        event.getCurrentPlayer().addABehind();
        getTheSameTeam(event).addAbehind();
        event.setNextPlayer(getTheOtherTeam(event).generateARandomPlayer("Defender"));
        displaySingleInformation(event.getCurrentPlayer(), "got a behind, scored 1 point");
        return endOfAnEvent(event,false);
    }

    /**
     * Checks whether the current player is injured based on a 2% probability.
     *
     *@param event    the current game event.
     *@return         true if injured, false otherwise.
     */
    public boolean checkInjury(Event event)
    {
        int number = RandomNumber.generateARandomNumber(100);
        if (number <= 2)
        {
            Player player = event.getCurrentPlayer();
            displaySingleInformation(player, "is injured");
            player.getInjured();
            return true;
        }
        return false;
    }

    /**
     * Checks whether the current player needs to be reported for violating game rules on a 1% probability.
     *
     *@param event    the current game event.
     */
    public void checkReport(Event event)
    {
        int number = RandomNumber.generateARandomNumber(100);
        if (number <= 1)
        {
            Player player = event.getCurrentPlayer();
            displaySingleInformation(player, "has violated a game rule and is reported by an umpire");
            player.getReported();
        }
    }

    /**
     * Displays the current state of the game.
     */
    public void display()
    {
        System.out.println(toString());
    }

    /**
     * Displays the result of the game.
     *
     *@param event    the final game event.
     */
    public void displayGameResult(Event theLastEvent)
    {
        displayInformationHead("Game result");
        if (!theLastEvent.getEndDueToNoReserve())
        {
            if (getWinningTeam() != null)
                System.out.println(getWinningTeam().getTeamName() + " has won the game with " +getWinningTeam().getPoints() + " score");
            else
                System.out.println("The game is a draw");
        }
        else
        {
            System.out.println("Game has finished");
            System.out.println(getTheOtherTeam(theLastEvent).getTeamName() + " has won the game due to the other team has no remaining reserve players");
        }

        for (Team team : twoTeams)
            team.display();
        System.out.println();

        displayInformationHead("Injured Players");
        for (Team team : twoTeams)
            team.displayInjuredPlayers();
        System.out.println();

        displayInformationHead("Reported Players");
        for (Team team : twoTeams)
            team.displayReportedPlayers();
        System.out.println();
        
        System.out.println("Writing output files...\nGoodbye");
    }

    /**
     * Displays information for two players involved in an event.
     *
     *@param event    the current game event.
     *@param informationType   the information showed during the event.
     */
    public void displayDoubleInformation(Event event, String informationType)
    {
        Player currentPlayer = event.getCurrentPlayer();
        Player nextPlayer = event.getNextPlayer();
        System.out.println(currentPlayer.getPlayerName() + " (" + currentPlayer.getFieldPosition() + "," + currentPlayer.getTeam().getTeamName() + ") " +informationType + " the ball to " + nextPlayer.getPlayerName() + " (" + nextPlayer.getFieldPosition() + "," + nextPlayer.getTeam().getTeamName() + ")");
    }

    /**
     * Displays a header for information output during the game.
     *
     *@param informationType   the header to be displayed.
     */
    public void displayInformationHead(String informationType)
    {
        System.out.println(informationType);
        for (int i = 1 ; i <= informationType.length() ; i++)
            System.out.print("=");
        System.out.println();
    }

    /**
     * Displays information for single-player in an event.
     *
     *@param player    the current playert.
     *@param informationType   the information showed during the event.
     */
    public void displaySingleInformation(Player player, String informationType)
    {
        System.out.println(player.getPlayerName() + " (" + player.getFieldPosition() + "," + player.getTeam().getTeamName() + ") " + informationType);
    }

    /**
     * Processes the end of an event.
     *
     *@param event    the current game event.
     *@param endWithAGoal  whether the event includes a goal.
     *@return         the next event.
     */
    public Event endOfAnEvent(Event currentEvent, boolean endWithAGoal)
    {
        Event nextEvent = new Event();
        //If the current event is a goal, the next event must start from centre.
        //Thus the flag startFromCentre is set to true.
        if (endWithAGoal)
            nextEvent = new Event(currentEvent.getIndex() + 1, null, true);
        else
        {
            displaySingleInformation(currentEvent.getNextPlayer(), "has the ball");
            nextEvent = new Event(currentEvent.getIndex() + 1, currentEvent.getNextPlayer(), false);
        }

        checkReport(currentEvent);

        if (checkInjury(currentEvent))
        {
            try
            {
                //If there's no remaining reserve in the same team,
                //this function would raise an IndexOutOfBoundsException.
                substitute(currentEvent);
            }
            catch (IndexOutOfBoundsException e)
            {
                System.out.println(getTheSameTeam(currentEvent).getTeamName() + " has no remaining reserve players");
                currentEvent.setEndDueToNoReserve(true);
                //If there's no reserve left, the event ends and the whole game ends.
                return currentEvent;
            }
        }

        return nextEvent;
    }

    /**
     * Generates a random team from the two teams.
     *
     *@return   a randomly selected team.
     */
    public Team generateARandomTeam()
    {
        int randomIndex = RandomNumber.generateARandomNumber(twoTeams.length) - 1;
        return twoTeams[randomIndex];
    }

    /**
     * Retrives the team that the opposing player belongs to.
     *
     *@param event    the current game event.
     *@return         the opposing team.
     */
    public Team getTheOtherTeam(Event event)
    {
        for (Team team : twoTeams)
        {
            if (team != getTheSameTeam(event))
                return team;
        }
        return null;
    }

    /**
     * Retrives the team that the current player belongs to.
     *
     *@param event    the current game event.
     *@return         the player's team.
     */
    public Team getTheSameTeam(Event event)
    {
        return event.getCurrentPlayer().getTeam();
    }

    /**
     * Retrives the team that has the higher points.
     *
     *@return         the winning team.
     */
    public Team getWinningTeam()
    {
        if (twoTeams[0].getPoints() > twoTeams[1].getPoints())
            return twoTeams[0];
        else if (twoTeams[0].getPoints() == twoTeams[1].getPoints())
            return null;
        return twoTeams[1];
    }

    /**
     * Accessor method to get the twoTeams.
     *
     *@return         twoTeams.
     */
    public Team[] getTwoTeams()
    {
        return twoTeams;
    }

    /**
     * Processes the event when a player scores a goal.
     *
     *@param event    the current event
     *@return         the next event.
     */
    public Event goal(Event event)
    {
        event.getCurrentPlayer().addAGoal();
        getTheSameTeam(event).addAGoal();
        displaySingleInformation(event.getCurrentPlayer(), "got a goal, scored 6 points");
        return endOfAnEvent(event, true);
    }

    /**
     * Prompts the user to input the number of star players for a given team.
     *
     *@param team     the team to nominate star players.
     *@return         the valid integer input for the number of star players.
     */
    public int inputNumberOfStars(Team team)
    {
        int integerInput = 0;
        while (true)
        {
            System.out.print("Enter number of star players in " + team.getTeamName() + " [0-8]: ");
            String stringInput = Input.acceptStringInput();
            try
            {
                integerInput = Integer.parseInt(stringInput);
            }
            catch (Exception e)
            {
                System.out.println("Error: value is not a number: " + stringInput);
                //Return to the loop if input is invalid.
                continue;
            }
            if (Validation.integerInRange(integerInput, 0, 8))
                break;
            System.out.println("Error: number not in range: 0 to 8");
        }
        return integerInput;
    }

    /**
     * Handles the outcome of a player kicking the ball.
     *
     *@param event     the current event.
     *@return          the next event.
     */
    public Event kickABall(Event event)
    {
        Player player = event.getCurrentPlayer();
        //The Array outcome includes a String to represent the type of event
        //and another String representing the next player's field position.
        String[] outcome = player.kickABall();
        player.addAKick();
        if (outcome[0].equals("Goal"))
            return goal(event);
        else if (outcome[0].equals("Behind"))
            return behind(event);
        else if (outcome[0].equals("Pass"))
            return passTheBall(outcome[1], event);
        return turnoverTheBall(outcome[1], event);
    }

    /**
     * Load teams from files to initialize the game.
     */
    public void loadTeams()
    {
        twoTeams[0] = FileIO.readFile(FileIO.INPUT_FILE_A);
        twoTeams[1] = FileIO.readFile(FileIO.INPUT_FILE_B);
    }

    /**
     * Main method to begin the program.
     *
     *@param args     an array of Strings representing command line arguments.
     */
    public static void main(String[] args)
    {
        AFLGame agame = new AFLGame();
        agame.startAGame();
    }

    /**
     * Nominates a number of star players for each team.
     */
    public void nominateStarPlayers()
    {
        for (Team team : twoTeams)
        {
            int numberOfStars = inputNumberOfStars(team);
            //Use playersIndexes to store the total indexes of players in a team.
            ArrayList<Integer> playersIndexes = new ArrayList<>();
            for (int i = 0 ; i < team.getPlayers().size() ; i++)
                playersIndexes.add(i);
            
            //For each iteration, one player's index will be randomly selected and deleted from the ArrayList.
            for (int i = 1 ; i <= numberOfStars ; i++)
            {
                int index = RandomNumber.generateARandomNumber(playersIndexes.size()) - 1;
                team.getPlayers().get(playersIndexes.get(index)).setIsStar(true);
                playersIndexes.remove(index);
            }
        }
    }

    /**
     * Handles the event when a player passes the ball to another player on the same team.
     *
     *@param fieldPosition   the field position for the next player.
     *@param event     the current event.
     *@return          the next event.
     */
    public Event passTheBall(String fieldPosition, Event event)
    {
        Player currentPlayer = event.getCurrentPlayer();
        currentPlayer.addAPass();
        //When passing the ball, the next player cannot be the same as the current player.
        event.setNextPlayer(getTheSameTeam(event).generateARandomPlayerExceptCurrentPlayer(fieldPosition, currentPlayer));
        displayDoubleInformation(event, "passed");
        return endOfAnEvent(event, false);
    } 

    /**
     * Mutator method to set the two teams.
     *
     *@param newTwoTeams    a new Array of two teams.
     */
    public void setTwoTeams(Team[] newTwoTeams)
    {
        twoTeams = newTwoTeams;
    }

    /**
     * Starts the AFL game.
     *
     */
    public void startAGame()
    {
        loadTeams();
        displayInformationHead("Welcome to the Australian Rules Football Simulation");
        nominateStarPlayers();
        Event theLastEvent = startQuarters(4);
        displayGameResult(theLastEvent);
        updateFiles();
    }

    /**
     * Starts specified number of quarters.
     *
     *@param numberOfQuarters     the number of quarters to play in the game.
     *@return          the final event.
     */
    public Event startQuarters(int numberOfQuarters)
    {
        Event theLastEvent = new Event();
        for (int i = 1 ; i <= numberOfQuarters ; i++)
        {
            System.out.println("*** Quarter #" + i + " ***");
            theLastEvent = startEvents(80);
            //If the event ends due to no reserve left, the quarter also ends.
            if (theLastEvent.getEndDueToNoReserve())
            {
                System.out.println("\nQuarter has finished due to no remaining reserve players\n");
                break;
            }
            System.out.println("\nQuarter has finished\n");
            System.out.println("Quarter summary");
            System.out.println("  Team A has " + twoTeams[0].getPoints() + " points");
            System.out.println("  Team B has " + twoTeams[1].getPoints() + " points\n");
        }
        return theLastEvent;
    }

    /**
     * Starts specified number of events.
     *
     *@param numberOfEvents     the number of events to be played in a quarter.
     *@return          the final event after a quarter.
     */
    public Event startEvents(int numberOfEvents)
    {
        Event currentEvent = new Event(1, null, true);

        while (currentEvent.getIndex() <= numberOfEvents)
        {
            if (currentEvent.getEndDueToNoReserve())
                break;
            
            System.out.println("#" + currentEvent.getIndex() + ":");
            if (currentEvent.getStartFromCentre())
            {
                currentEvent.setCurrentPlayer(generateARandomTeam().generateARandomPlayer("Midfielder"));
                System.out.println("Starting from the centre circle");
                displaySingleInformation(currentEvent.getCurrentPlayer(), "got the ball in the centre circle");
            }
            currentEvent = kickABall(currentEvent);
        }
        return currentEvent;
    }

    /**
     * Substitutes the current player with a reserve player from the same team.
     *
     *@param event     the current event.
     */
    public void substitute(Event event)
    {
        Player reserve = getTheSameTeam(event).generateARandomPlayer("Reserve");
        Reserve sameReserve = (Reserve) reserve;
        sameReserve.substitute(event.getCurrentPlayer());
        System.out.println("Found a replacement player: " + reserve.getPlayerName() + " who is playing the " + reserve.getFieldPosition() + " field position");
    }

    /**
     * Generates a string representation of the game.
     *
     *@return          a String representing the game.
     */
    @Override
    public String toString()
    {
        for (Team team : twoTeams)
            return "AFLGame{" + team.toString() + "}";
        return null;
    }

    /**
     * Handles the turnover event where the ball is passed to a opposing player.
     *
     *@param fieldPosition  the field position for the next player.
     *@param event     the current event.
     *@return          the next event.
     */
    public Event turnoverTheBall(String fieldPosition, Event event)
    {
        event.setNextPlayer(getTheOtherTeam(event).generateARandomPlayer(fieldPosition));
        displayDoubleInformation(event, "lost");
        return endOfAnEvent(event,false);
    }

    /**
     * Updates the game files.
     */
    public void updateFiles()
    {
        FileIO.writeFile(twoTeams[0], FileIO.OUTPUT_FILE_A);
        FileIO.writeFile(twoTeams[1], FileIO.OUTPUT_FILE_B);
    }
    
}
