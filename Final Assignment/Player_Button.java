import processing.core.PApplet;
import processing.core.PImage;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.sql.Date;
import java.util.Calendar;
import java.util.Scanner;

/**
 * A subclass of Button that represents a player button.
 * It extends the functionality of the Button class by adding player position coordinates.
 */
public class Player_Button extends Button {
  protected float playerPositionX;
  protected float playerPositionY;
  protected PApplet applet;

    /**
     * Constructs a Player_Button object with the specified parameters.
     *
     * @param applet           The PApplet object to which the button belongs.
     * @param positionX        The X coordinate of the button's position.
     * @param positionY        The Y coordinate of the button's position.
     * @param bufferX          The buffer value for the button's X coordinate hitbox.
     * @param bufferY          The buffer value for the button's Y coordinate hitbox.
     * @param playerPositionX  The X coordinate of the player's position.
     * @param playerPositionY  The Y coordinate of the player's position.
     */
    public Player_Button (PApplet applet, int positionX, int positionY, int bufferX, int bufferY, float playerPositionX, float playerPositionY) {
        super(applet, positionX,positionY,bufferX,bufferY);
        this.playerPositionX = playerPositionX;
        this.playerPositionY = playerPositionY;
        this.applet = applet;
    }

    /**
     * Draws a colored rectangle representing the button's hitbox on the screen.
    * The rectangle is filled with the color (255, 0, 0) (red).
    */
    public void drawbox() {
        applet.fill(255,0,0);
        applet.rect(positionX, positionY, bufferX, bufferY);
    }

    /**
     * Adds a run to the "runcount.txt" file. The run count is appended to the file,
     * along with the current date.
     */
    public void addRun() {
        try {
            Writer output;
            output = new BufferedWriter(new FileWriter("runcount.txt", true));
            java.util.Date today = Calendar.getInstance().getTime();
            String day = Integer.toString(04022004);
            output.append(day);
        } catch (IOException e) { System.out.println("error:" + e); }
    }

    /**
     * Counts the number of lines in the specified file.
     *
     * @param fileName the name of the file to count lines from
     * @return the number of lines in the file
     */
    public static int countLine(String fileName) {
        int lines = 0;
        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
        while (reader.readLine() != null) lines++;
        } catch (IOException e) { e.printStackTrace(); }
        return lines;
    }

    /**
     * Reads the run count from the "runcount.txt" file and returns the value.
     *
     * @return the run count value
     */
    public int readRun() {
        int runNum = countLine("runcount.txt");
        int i = 0;
        try {
        Scanner fileInput = new Scanner(new File("runcount.txt"));
            while (fileInput.hasNext()) {
            String line = fileInput.nextLine();
            i++;
            }
        fileInput.close();
        } catch (IOException ioException) {System.err.println("Java Exception: " + ioException);}
        return runNum;
    }
    
    /**
     * Retrieves the X position of the player button.
     *
     * @return The X position of the player button.
     */
    public float getPlayerButtonX() {
        return this.playerPositionX; 
    }
    
    /**
     * Retrieves the Y position of the player button.
     *
     * @return The Y position of the player button.
     */
    public float getPlayerButtonY() {
    return this.playerPositionY; 
  }
  
}