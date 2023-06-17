import processing.core.PApplet;


public class Button {
  public static int numButtons = 0;
  public int positionX = 0;
  public int positionY = 0;
  public int bufferX = 0;
  public int bufferY = 0;
  public PApplet applet;

  /**
   * Constructs a new Button object.
   * @param applet The PApplet instance.
   * @param positionX The X position of the button.
   * @param positionY The Y position of the button.
   * @param bufferX The width of the button.
   * @param bufferY The height of the button.
   */
  public Button(PApplet applet, int positionX, int positionY, int bufferX, int bufferY) {
    this.applet = applet;
    this.positionX = positionX;
    this.positionY = positionY;
    this.bufferX = bufferX;
    this.bufferY = bufferY;
  }

  /**
   * Constructs a new Button object.
   * @param applet The PApplet instance.
   * @param positionX The X position of the button.
   * @param positionY The Y position of the button.
   */
  public Button(PApplet applet, int positionX, int positionY) {
    this.applet = applet;
    this.positionX = positionX;
    this.positionY = positionY;
    this.bufferX = 50;
    this.bufferY = 50;
  }
  
  /**
   * Moves the rectangle by the specified amounts.
   * @param dx The amount to move in the X direction.
   * @param dy The amount to move in the Y direction.
   */
  public void move(int dx, int dy) {
    positionX += dx;
    positionY += dy;
  }

  /**
   * Draws the box on the screen.
   */
  public void drawbox() {
    applet.fill(255,0,0);
    applet.rect(positionX, positionY, bufferX, bufferY);
  }

  /**
   * Checks if the specified area is clicked.
   *
   * @param mouseX       The X-coordinate of the mouse.
   * @param mouseY       The Y-coordinate of the mouse.
   * @param mousePressed The state of the mouse button (pressed or not).
   * @return `true` if the specified area is clicked, `false` otherwise.
   */
  public boolean isClicked(int mouseX, int mouseY, boolean mousePressed) {
    return ((mouseX>this.positionX&&mouseX<this.positionX+this.bufferX) && mousePressed && (mouseY>this.positionY&&mouseY<this.positionY+this.bufferY));
  }
  
  /**
   * Displays information about the mouse position and mouse press state.
   *
   * @param mouseX       The X-coordinate of the mouse.
   * @param mouseY       The Y-coordinate of the mouse.
   * @param mousePressed The state of the mouse button (pressed or not).
   */
  public void displayInfo(int mouseX, int mouseY, boolean mousePressed) {
    applet.fill(255,0,0);
    applet.textSize(10);
    applet.text("Mouse X: " + mouseX, 10, 20);
    applet.text("Mouse Y: " + mouseY, 10, 40);
    // applet.text("Position X: " + positionX, 10, 60);
    // applet.text("Position Y: " + positionY, 10, 80);
    applet.text("mousePressed: " + mousePressed, 10, 100);
  }
  
  /**
   * Displays the X-coordinate of a mouse click.
   *
   * @param mouseX  The X-coordinate of the mouse click.
   */
  public void displayClick(int mouseX) {
    applet.fill(255,0,0);
    applet.textSize(10);
    applet.text("Clicked: " + mouseX, 10, 200);
  }

  /**
   * Returns the X position of the player button.
   *
   * @return The X position of the player button.
   */
  public int getPositionX() {
    return positionX;
  }

  /**
  * Sets the X position of the player button.
  *
  * @param positionY The X position to set for the player button.
  */
  public void setPositionX(int positionX) {
    this.positionX = positionX;
  }

  /**
   * Returns the Y position of the player button.
   *
   * @return The Y position of the player button.
   */
  public int getPositionY() {
    return positionY;
  }

  /**
  * Sets the Y position of the player button.
  *
  * @param positionY The Y position to set for the player button.
  */
  public void setPositionY(int positionY) {
    this.positionY = positionY;
  }
}



