import java.io.FileReader;
import java.io.FileWriter;
import java.util.Scanner;
import java.util.ArrayList;

/**
 * The FileIO class which writes and reads files.
 *
 *@author Shuyang Yan
 *@version ver1.0.0
 */
public class FileIO
{

    public static final String INPUT_FILE_A = "teamA.txt";
    public static final String INPUT_FILE_B = "teamB.txt";
    public static final String OUTPUT_FILE_A = "teamAUpdated.txt";
    public static final String OUTPUT_FILE_B = "teamBUpdated.txt";

    /**
     * Default constructor which creates the object of the class FileIO.
     *
     */
    public FileIO()
    {

    }

    /**
     * Reads file into a team.
     *
     *@param fileName    the name of the file to read.
     *@return            the team which stores all the data in file.
     */
    public static Team readFile(String fileName)
    {
        String teamName = "";
        ArrayList<Player> players = new ArrayList<>();
        Team team = null;
        try (Scanner fileInput = new Scanner(new FileReader(fileName)))
        {
            if (fileInput.hasNextLine())
                teamName = fileInput.nextLine();
            team = new Team(teamName, players);
            while (fileInput.hasNextLine())
            {
                String[] lineContents = fileInput.nextLine().split(",");
                String playerName = lineContents[0];
                String fieldPosition = lineContents[1];
                int seasonGoals = 0;
                try
                {
                    seasonGoals = Integer.parseInt(lineContents[2]);
                }
                catch (Exception e)
                {
                    System.out.println("Error in player's season's goals. Skipping.");
                    continue;
                }
                if (fieldPosition.equals("Forward"))
                    players.add(new Forward(playerName, fieldPosition, seasonGoals, team));
                else if (fieldPosition.equals("Midfielder"))
                    players.add(new Midfielder(playerName, fieldPosition, seasonGoals, team));
                else if (fieldPosition.equals("Defender"))
                    players.add(new Defender(playerName, fieldPosition, seasonGoals, team));
                else
                    players.add(new Reserve(playerName, fieldPosition, seasonGoals, team));
            }
        }
        catch (Exception e)
        {
            System.out.println("Error in reading file! Exiting...");
        }
        return team;
    }

    /**
     * Writes data of a team into a file.
     *
     *@param team        the team that stores data.
     *@param fileName    the name of the file to write into.
     */
    public static void writeFile(Team team, String fileName)
    {
        try (FileWriter writer = new FileWriter(fileName))
        {
            writer.write(team.getTeamName() + "\n");
            for (Player player: team.getPlayers())
            {
                if (player.setSeasonGoals(player.getGoals()))
                    writer.write(player.getPlayerName() + ", " + player.getFieldPosition() + ", " + player.getSeasonGoals() + "\n");
            }
        }
        catch (Exception e)
        {
            System.out.println("Error in writing to file! Exiting...");
        }
    }
    
}
