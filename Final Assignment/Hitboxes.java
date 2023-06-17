import processing.core.PApplet;
    
public class Hitboxes{
    private float positionX;
    private float positionY;
    private int bufferX;
    private int bufferY;
    private PApplet applet;

    /**
     * Draws the button if the specified condition is true.
     *
     * @param drawOrNot Determines whether to draw the button or not.
     */
    public Hitboxes(PApplet applet, int positionX, int positionY, int bufferX, int bufferY) {
        this.applet = applet;
        this.positionX = positionX;
        this.positionY = positionY;
        this.bufferX = bufferX;
        this.bufferY = bufferY;
    }

    /**
     * Draws the button if the specified condition is true.
     *
     * @param drawOrNot Determines whether to draw the button or not.
     */
    public void draw(boolean drawornot) {
        if (drawornot) {
            applet.fill(255,0,0);
            applet.rect(positionX, positionY, bufferX, bufferY);
        }
    }

    /**
     * Checks if the given position is inside the button's boundaries.
     *
     * @param positionX The X position to check.
     * @param positionY The Y position to check.
     * @return true if the position is inside the button's boundaries, false otherwise.
     */
    public boolean isIn(float positionX, float positionY) {
        if ((positionX < this.positionX + this.bufferX) && (positionX > this.positionX)) {
            if ((positionY < this.positionY + this.bufferY) && (positionY > this.positionY)) {
                return true;
            }
        } 
        else return false;
        return false;
        
    }

    /**
     * Returns the X position of the player button.
     *
     * @return The  position of the player button.
     */
    public float getPositionX() {
        return this.positionX;
    }

    /**
     * Returns the Y position of the player button.
     *
     * @return The Y position of the player button.
     */
    public float getPositionY() {
        return this.positionY;
    }

    /**
     * Returns the buffer size in the X direction.
     *
     * @return The buffer size in the X direction.
     */
    public float getBufferX() {
        return this.bufferX;
    }

    /**
     * Returns the buffer size in the Y direction.
     *
     * @return The buffer size in the Y direction.
     */
    public float getBufferY() {
        return this.bufferY;
    }

   /**
    * Sets the X position of the player button.
    *
    * @param positionY The X position to set for the player button.
    */
    public void setPositionX(float positionX) {
        this.positionX = positionX;
    }

   /**
    * Sets the Y position of the player button.
    *
    * @param positionY The Y position to set for the player button.
    */
    public void setPositionY(float positionY) {
        this.positionY = positionY;
    }

    
}