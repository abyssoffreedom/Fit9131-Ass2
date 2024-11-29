/**
 *The event class represents a single event in a quarter of the game.
 *
 *@author Shuyang Yan
 *@version ver1.0.0
 */
public class Event
{

    private int index;
    private Player currentPlayer;
    private Player nextPlayer;
    private boolean startFromCentre;
    private boolean endDueToNoReserve;

    /**
     * Default constructor which creates the object of the class Event.
     */
    public Event()
    {
        index = 0;
        currentPlayer = null;
        nextPlayer = null;
        startFromCentre = false;
        endDueToNoReserve = false;
    }

    /**
     * Non-default constructor which creates the object of the class Event.
     *
     *@param index   the index of the event.
     *@param currentPlayer  the current player participating in the event.
     *@param startFromCentre  whether the event starts from the centre.
     */
    public Event(int index, Player currentPlayer, boolean startFromCentre)
    {
        this.index = index;
        this.currentPlayer = currentPlayer;
        this.startFromCentre = startFromCentre;
        nextPlayer = null;
        endDueToNoReserve = false;
    }

    /**
     * Non-default constructor which creates the object of the class Event.
     *
     *@param index   the index of the event.
     *@param currentPlayer  the current player participating in the event.
     *@param nextPlayer     the next player who will participate.
     *@param startFromCentre  whether the event starts from the centre.
     *@param endDueToNoReserve  whether the event ends due to no reserve players left.
     */
    public Event(int index, Player currentPlayer, Player nextPlayer, boolean startFromCentre, boolean endDueToNoReserve)
    {
        this.index = index;
        this.currentPlayer = currentPlayer;
        this.nextPlayer = nextPlayer;
        this.startFromCentre = startFromCentre;
        this.endDueToNoReserve = endDueToNoReserve;
    }

    /**
     * Accessor method to get the current player.
     *
     *@return         the current player.
     */
    public Player getCurrentPlayer()
    {
        return currentPlayer;
    }

    /**
     * Accessor method to get the flag of whether the event ends due to no reserve players left.
     *
     *@return         the flag.
     */
    public boolean getEndDueToNoReserve()
    {
        return endDueToNoReserve;
    }

    /**
     * Accessor method to get the flag of whether the event starts from the centre.
     *
     *@return         the flag.
     */
    public boolean getStartFromCentre()
    {
        return startFromCentre;
    }

    /**
     * Accessor method to get the index of the event.
     *
     *@return         the index.
     */
    public int getIndex()
    {
        return index;
    }

    /**
     * Accessor method to get the next player who will participate.
     *
     *@return         the next player.
     */
    public Player getNextPlayer()
    {
        return nextPlayer;
    }

    /**
     * Mutator method to set the current player.
     *
     *@param currentPlayer    a new current player.
     */
    public void setCurrentPlayer(Player currentPlayer)
    {
        this.currentPlayer = currentPlayer;
    }

    /**
     * Mutator method to set the flag of whether the event ends due to no reserve players left.
     *
     *@param endDueToNoReserve      a new flag.
     */
    public void setEndDueToNoReserve(boolean endDueToNoReserve)
    {
        this.endDueToNoReserve = endDueToNoReserve;
    }

    /**
     * Mutator method to set the flag of whether the event starts from the centre.
     *
     *@param startFromCentre        a new flag.
     */
    public void setStartFromCentre(boolean startFromCentre)
    {
        this.startFromCentre = startFromCentre;
    }

    /**
     * Mutator method to set the index of the event.
     *
     *@param index        a new index.
     */
    public void setIndex(int index)
    {
        this.index = index;
    }

    /**
     * Mutator method to set the next player.
     *
     *@param nextPlayer    a new next player.
     */
    public void setNextPlayer(Player nextPlayer)
    {
        this.nextPlayer = nextPlayer;
    }
    
}
