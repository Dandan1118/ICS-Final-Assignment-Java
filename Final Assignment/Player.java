import processing.core.PApplet;
import processing.core.PImage;

public class Player {
    boolean idle;
    public float playerX = 370;
    public float playerY = 400;
    private float speed; // Player's movement speed
    private float boundaryLeft; // Left boundary
    private float boundaryRight; // Right boundary
    private float boundaryTop; // Top boundary
    private float boundaryBottom; // Bottom boundary
    private PApplet sketch;
    private PImage[][] images = new PImage[2][4];

    /**
     * Constructs a new Player object with the specified parameters.
     *
     * @param applet      The PApplet object to associate the player with.
     * @param speed       The movement speed of the player.
     * @param left        The left boundary of the player's movement.
     * @param right       The right boundary of the player's movement.
     * @param top         The top boundary of the player's movement.
     * @param bottom      The bottom boundary of the player's movement.
     */
    public Player(PApplet applet, int speed, int left, int right, int top, int bottom) {
        this.sketch = applet;
        this.speed = speed; // Set the player's movement speed
        this.boundaryLeft = left; // Set the left boundary
        this.boundaryRight = right; // Set the right boundary
        this.boundaryTop = top; // Set the top boundary
        this.boundaryBottom = bottom; // Set the bottom boundary
        loadImages();
    }

    /**
     * Returns the speed of the player.
     *
     * @return The speed of the player.
     */
    public float getSpeed() {
        return this.speed;
    }

    /**
     * Loads the images of the player animation.
     * The images are loaded from specific file paths and stored in the 'images' array.
     */
        private void loadImages() {
        for (int c = 0; c < images[0].length; c++) {
            String filename = "Images/Slime/slime-idle-" + c + ".png";
            images[0][c] = sketch.loadImage(filename);
        }

        for (int c = 0; c < images[1].length; c++) {
            String filename = "Images/Slime/slime-move-" + c + ".png";
            images[1][c] = sketch.loadImage(filename);
        }
    }
    
    /**
     * Moves the player by the specified amounts in the x and y directions.
     * @param dx The amount to move the player in the x direction.
     * @param dy The amount to move the player in the y direction.
     */
    public void move(float dx, float dy) {
        this.playerX += dx;
        this.playerY += dy;
    }

    /**
     * Displays the current frame of the player's animation at the player's position.
     * The animation frames are based on the player's state (idle or moving).
     * The animation speed can be adjusted by changing the divisor value.
     */
    public void display() {
        int row = idle ? 0 : 1;
        int numFrames = images[row].length;
        int frameIndex = (sketch.frameCount / 5) % numFrames; // Adjust the divisor to control the delay
        PImage currentImage = images[row][frameIndex];
        sketch.image(currentImage, playerX, playerY);
    }

    /**
     * Displays the player's position information on the screen.
     * The position coordinates are shown in text format.
     */
    public void displayInfo() {
        sketch.fill(255,255,0);
        sketch.textSize(10);
        sketch.text("Position X: " + this.playerX, 10, 60);
        sketch.text("Position Y: " + this.playerY, 10, 80);
    }

    /**
     * Displays custom information on the screen.
     *
     * @param str1 The first string to display.
     * @param str2 The second string to display.
     * @param val1 The value associated with the first string.
     * @param val2 The value associated with the second string.
     */
    public void displayInfo(String str1, String str2, int val1, int val2) {
        sketch.fill(255,255,0);
        sketch.textSize(10);
        sketch.text(str1 + val1, 10, 60);
        sketch.text(str2 + val2, 10, 80);
    }

    /**
     * Returns the X-coordinate of the player's position.
     *
     * @return The X-coordinate of the player.
     */
    public float getPlayerX() {
        return this.playerX;
    }

    /**
     * Returns the Y-coordinate of the player's position.
     *
     * @return The Y-coordinate of the player.
     */
    public float getPlayerY() {
        return this.playerY;
    }

    /**
     * Sets the X-coordinate of the player's position.
     *
     * @param playerX The new X-coordinate of the player.
     */
    public void setPlayerX(float playerX) {
        this.playerX = playerX;
    }

    /**
     * Sets the Y-coordinate of the player's position.
     *
     * @param playerY The new Y-coordinate of the player.
     */
    public void setPlayerY(float playerY) {
        this.playerY = playerY;
    }
    
    /**
     * Returns the width of the player's image.
     *
     * @return The width of the player's image.
     */
    public int getWidth(){
        return this.images[0][0].width;
    }

    /**
     * Returns the height of the player's image.
     *
     * @return The height of the player's image.
     */
    public int getHeight() {
        return this.images[0][0].height;
    } 


}
