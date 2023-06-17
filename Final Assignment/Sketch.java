// import packages used in the program
import processing.core.PApplet;
import processing.core.PImage;
import processing.event.KeyEvent;


public class Sketch extends PApplet {
    // Create boolean values for use in the program
    private boolean draw_hits = false;
    private boolean maze = true;
    private boolean mole = true;
    private boolean Molee = true;
    private boolean Mole11 = true;
    private boolean Mole22 = true;
    private boolean Mole33= true;
    private boolean Mole44= true;
    private boolean Cheese = true;
    private boolean Grape = true;
    private boolean Bread = true;
    // Create PImage values for use in the program
    private PImage intromenu;
    private PImage introboard;
    private PImage arrow_keys;
    private PImage space_keys;
    private PImage mouse;
    private PImage back;
    private PImage house;
    private PImage right_arrow;
    private PImage left_arrow;
    private PImage up_arrow;
    private PImage bread;
    private PImage cheese;
    private PImage grape;
    private PImage Mole;
    private PImage Mole1;
    private PImage Mole2;
    private PImage Mole3;
    private PImage Mole4;
    // Create Button values for use in the program
    private Button play_button;
    private Button help_button;
    private Button back_button;
    private Button continue_button;
    private Button ok_button;
    // Create Hitboxes values for use in the program
    private Hitboxes cheeseButton;
    private Hitboxes grapeButton;
    private Hitboxes breadButton;
    private Hitboxes mazeButton;
    private Hitboxes moleButton;
    private Hitboxes exitButton;
    private Hitboxes hitboxes_1;
    private Hitboxes hitboxes_2;
    private Hitboxes hitboxes_3;
    private Hitboxes hitboxes_4;
    private Hitboxes hitboxes_5;
    private Hitboxes hitboxes_6;
    private Hitboxes hitboxes_7;
    private Hitboxes hitboxes_8;
    private Hitboxes hitboxes_9;
    private Hitboxes hitboxes_10;
    private Hitboxes hitboxes_11;
    private Hitboxes hitboxes_12;
    private Hitboxes M1;
    private Hitboxes M2;
    private Hitboxes M3;
    private Hitboxes M4;
    private Hitboxes M5;
    // Create Integer values for use in the program
    private int hitPhase = 4;
    private int menu = 0;
    private int screenwidth = 750;
    private int screenheight = 500;
    private int mapInitialX = -150;
    private int mapInitialY = -270;
    // Create float values for use in the program
    private float worldshiftX = 0;
    private float worldshiftY = 0;
    // Create Integer values for use in the program
    private int c = 0;
    private int mouse_Click;
    private int shiftx = -100;
    private int shifty = 0;
    // Create movement values for use in the program
    private boolean leftPressed = false;
    private boolean rightPressed = false;
    private boolean upPressed = false;
    private boolean downPressed = false;
    private boolean spacePressed = false;
    private Player player;

    /**
    Sets the size of the application window.
    @param screenWidth The width of the application window.
    @param screenHeight The height of the application window.
    */
    public void settings() {
        size(screenwidth, screenheight);
    }

    /**
    Handles the event when a key is pressed.
    Sets the corresponding flag to true based on the key code or key value.
    @see KeyEvent
    */
    public void keyPressed() {
        if (keyCode == UP) {
            upPressed = true; // Set upPressed to true if UP key is pressed
        }
        if (keyCode == DOWN) {
            downPressed = true; // Set downPressed to true if DOWN key is pressed
        }
        if (keyCode == LEFT) {
            leftPressed = true; // Set leftPressed to true if LEFT key is pressed
        }
        if (keyCode == RIGHT) {
            rightPressed = true; // Set rightPressed to true if RIGHT key is pressed
        }
        if (key == ' ') {
            spacePressed = true; // Set spacePressed to true if SPACE key is pressed
        }
    }
  
    /**
    Handles the event when a key is released.
    Sets the corresponding flag to false based on the key code or key value.
    @see KeyEvent
    */
    public void keyReleased() {
        if (keyCode == UP) {
            upPressed = false; // Set upPressed to false if UP key is released
        }
        if (keyCode == DOWN) {
            downPressed = false; // Set downPressed to false if DOWN key is released
        }
        if (keyCode == LEFT) {
            leftPressed = false; // Set leftPressed to false if LEFT key is released
        }
        if (keyCode == RIGHT) {
            rightPressed = false; // Set rightPressed to false if RIGHT key is released
        }
        if (key == ' ') {
            spacePressed = false; // Set spacePressed to false if SPACE key is released
        }
    }

    /**
    Initializes the setup of the game.
    Loads various images and creates instances of objects, such as player, buttons, and hitboxes.
    Sets the frame rate to 60 frames per second.
    */
    public void setup() {
        intromenu = loadImage("Images\\intromenu.jpg", "jpg"); // Load the intromenu image
        introboard = loadImage("Images\\introboard.png", "png"); // Load the introboard image
        arrow_keys = loadImage("Images\\arrow_keys.png", "png"); // Load the arrow_keys image
        space_keys = loadImage("Images\\spacebar_keys.png", "png"); // Load the space_keys image
        mouse = loadImage("Images\\mouse.png", "png"); // Load the mouse image
        back = loadImage("Images\\back.png", "png"); // Load the back image
        house = loadImage("Images\\house.jpg", "jpg"); // Load the house image
        right_arrow = loadImage("Images\\right_arrow.png","png"); // Load the right_arrow image
        left_arrow = loadImage("Images\\left_arrow.png","png"); // Load the left_arrow image
        up_arrow = loadImage("Images\\up_arrow.png","png"); // Load the up_arrow image
        grape = loadImage("Images\\grape.jpg"); // Load the grape image
        bread = loadImage("Images\\bread.png", "png"); // Load the bread image
        cheese = loadImage("Images\\cheese.png", "png"); // Load the cheese image

        player = new Player(this,5, 30, 700, 0, 480);
        play_button = new Button(this, 225, 320, 140, 60);
        help_button = new Button(this, 380, 320, 140, 60);
        back_button = new Button(this, 150, 50, 50, 30);
        continue_button = new Button(this, 100, 320, 90, 50);
        ok_button = new Button(this, 330, 350, 90, 50);
        frameRate(60); // Set a lower frame rate to slow down the animation

        // Hitboxes
        hitboxes_1 = new Hitboxes(this, 330, 350, 1400, 10); // Create hitbox 1
        hitboxes_2 = new Hitboxes(this, 330, 350, 1400, 10); // Create hitbox 2
        hitboxes_3 = new Hitboxes(this, 330, 350, 10, 800); // Create hitbox 3
        hitboxes_4 = new Hitboxes(this, 330, 350, 10, 800); // Create hitbox 4

        // Maze
        hitboxes_5 = new Hitboxes(this, 0, 0, 1400, 10); // Create hitbox 5
        hitboxes_6 = new Hitboxes(this, 0, 0, 10, 1400); // Create hitbox 6
        hitboxes_7 = new Hitboxes(this, 0, 490, 1400, 10); // Create hitbox 7
        hitboxes_8 = new Hitboxes(this, 740, 0, 10, 1400); // Create hitbox 8
        hitboxes_9 = new Hitboxes(this, 330, 100, 10, 1400); // Create hitbox 9
        hitboxes_10 = new Hitboxes(this, 470, 350, 1400, 10); // Create hitbox 10
        hitboxes_11 = new Hitboxes(this, 430, 180, 10, 800); // Create hitbox 11
        hitboxes_12 = new Hitboxes(this, 90, 90, 600, 10); // Create hitbox 12

        // Buttons
        cheeseButton = new Hitboxes(this, 350, 420, 60, 60); // Create cheese button hitbox
        breadButton = new Hitboxes(this, 70, 250, 150, 150); // Create bread button hitbox
        grapeButton = new Hitboxes(this, 634, 256, 50, 50); // Create grape button hitbox
        exitButton = new Hitboxes(this, 0, 0, 80, 100); // Create exit button hitbox
        moleButton = new Hitboxes(this, 0, 0, 80, 60); // Create mole button hitbox
        mazeButton = new Hitboxes(this, 0, 0, 80, 60); // Create maze button hitbox

        // Moles
        M1 = new Hitboxes(this, 375, 100, 50, 50); // Create mole 1 hitbox
        M2 = new Hitboxes(this, 130, 235, 50, 50); // Create mole 2 hitbox
        M3 = new Hitboxes(this, 160, 380, 50, 50); // Create mole 3 hitbox
        M4 = new Hitboxes(this, 630, 300, 50, 50); // Create mole 4 hitbox
        M5 = new Hitboxes(this, 670, 100, 50, 50); // Create mole 5 hitbox

        // Load moles images
        Mole = loadImage("Images\\mole.png", "png"); // Load mole image
        Mole1 = loadImage("Images\\mole.png", "png"); // Load mole1 image
        Mole2 = loadImage("Images\\mole.png", "png"); // Load mole2 image
        Mole3 = loadImage("Images\\mole.png", "png"); // Load mole3 image
        Mole4 = loadImage("Images\\mole.png", "png"); // Load mole4 image

    }

    /**
    Recursively converts the initial color code to a white color code.
    If the initial color code is greater than 255, it is returned as is.
    Otherwise, the function calls itself with the incremented color code.
    @param initial_color_code The initial color code to be converted to white.
    @return The white color code.
    */
    public int screentowhite (int initial_color_code) { 
        if (initial_color_code>255) {
            return initial_color_code;
        }
        else return screentowhite(initial_color_code+1);
    }

    /**
     * This method is the main drawing loop of the program.
     * It updates the visual display based on the current state of the program.
     */
    public void draw() {
        if (menu == 999) {
            if (c < 255) {
            c += 1;
            background(c);
            } else menu = 4;    
        }

        if (menu == 0) {
            menuZero();
            textSize(40);
            fill(0);
            text("Food farmer\n   simulator" , 250, 160);
        }

        if (menu == 1) {
            menuOne();
            textSize(40);
            fill(0);
            text("  Created By:\nDandan Yang" , 250, 160);
        }

        if (menu == 2) {
            menuTwo();
            textSize(40);
            fill(0);
            text("OK" , 115, 360);
        }

        if (menu == 3) {
            menuThree();
            textSize(40);
            fill(0);
            text("OK" , 345, 390);
            }

        if (menu == 4) {
            menuFour();
            hitboxes_1.draw(draw_hits); // Draw hitbox 1
            hitboxes_2.draw(draw_hits); // Draw hitbox 2
            hitboxes_3.draw(draw_hits); // Draw hitbox 3
            hitboxes_4.draw(draw_hits); // Draw hitbox 4
            exitButton.draw(draw_hits); // Draw exit button hitbox
            mazeButton.draw(draw_hits); // Draw maze button hitbox
            moleButton.draw(draw_hits); // Draw mole button hitbox
        }
        
        if (menu == 70) {
            background(0);
            textSize(50);
            fill(255);
            text("Contratulations", 50, 100);
            fill(255, 0, 0);
            text("                        stranger...", 50, 100);
            fill(255);
            textSize(25);
            text("You have completed this simulated world.", 50, 170);
            textSize(25);
            text("You should have realized it by right now, \nthat getting food is difficult.", 50, 220);

            continue_button.drawbox();
            textSize(40);
            fill(0);
            text("OK" , 115, 360);
            if (continue_button.isClicked(mouseX, mouseY, mousePressed)) {
                menu = 71;
            }
        }
        if (menu == 71) {
            background(0);
            textSize(50);
            fill(255, 0, 0);
            text("Stranger...", 50, 100);
            fill(255);
            textSize(25);
            text("Although the simulated world is highly rudimentary.", 50, 170);
            textSize(25);
            text("It should have demonstrated to you, \nthe difficulties of a farmer.", 50, 220);

            ok_button.drawbox();
            textSize(40);
            fill(0);
            text("OK" , 345, 390);
            if (ok_button.isClicked(mouseX, mouseY, mousePressed)) {
                menu = 72;
            }
        }
        if (menu == 72) {
            background(0);
            textSize(50);
            fill(255, 0, 0);
            text("If you havent realized...", 50, 100);
            fill(255);
            textSize(25);
            text("What youve just experienced was food collection", 50, 170);
            textSize(25);
            text("and predator deterrance.", 50, 220);

            continue_button.drawbox();
            textSize(40);
            fill(0);
            text("OK" , 115, 360);
            if (continue_button.isClicked(mouseX, mouseY, mousePressed)) {
                menu = 83;
            }
        }
        if (menu == 83) {
            background(0);
            textSize(50);
            fill(255, 0, 0);
            text("If you havent realized...", 50, 100);
            fill(255);
            textSize(25);
            text("You had to struggle to find", 50, 170);
            textSize(25);
            text("the food you needed to survive.", 50, 220);

            ok_button.drawbox();
            textSize(40);
            fill(0);
            text("OK" , 345, 390);
            if (continue_button.isClicked(mouseX, mouseY, mousePressed)) {
                menu = 73;
            }
        }
        if (menu == 73) {
            background(0);
            textSize(50);
            fill(255, 0, 0);
            text("Stranger...", 50, 100);
            fill(255);
            textSize(25);
            text("At the same time, Those moles you smited were", 50, 170);
            textSize(25);
            text("not just any animal but a threat to your survival.", 50, 220);

            continue_button.drawbox();
            textSize(40);
            fill(0);
            text("OK" , 115, 360);
            if (continue_button.isClicked(mouseX, mouseY, mousePressed)) {
                menu = 84;
            }
        }
        if (menu == 84) {
            background(0);
            textSize(50);
            fill(255, 0, 0);
            text("Stranger...", 50, 100);
            fill(255);
            textSize(25);
            text("You had to struggle to get rid of them", 50, 170);
            textSize(25);
            text("or else they would destripy your crop", 50, 220);

            ok_button.drawbox();
            textSize(40);
            fill(0);
            text("OK" , 345, 390);
            if (ok_button.isClicked(mouseX, mouseY, mousePressed)) {
                menu = 74;
            }
        }
        
        if (menu == 74) {
            background(0);
            textSize(50);
            fill(255, 0, 0);
            text("The POINT is...", 50, 100);
            fill(255);
            textSize(25);
            text("Being a farmer is difficult.", 50, 170);
            textSize(25);
            text("You have to face many challenges to find \nthe food you need to survive.", 50, 220);

            continue_button.drawbox();
            textSize(40);
            fill(0);
            text("OK" , 115, 360);
            if (continue_button.isClicked(mouseX, mouseY, mousePressed)) {
                menu = 39;
            }
        }
        if (menu == 39) {
            background(0);
            textSize(50);
            fill(255);
            text("Well then ", 50, 100);
            fill(255, 0, 0);
            text("               Stranger...", 50, 100);
            fill(255);
            textSize(25);
            text("It been nice.", 50, 170);
            textSize(25);
            text("I sure hope you've learned something.\nUntil next time...", 50, 220);

            ok_button.drawbox();
            textSize(40);
            fill(0);
            text("OK" , 345, 390);
            if (ok_button.isClicked(mouseX, mouseY, mousePressed)) {
                menu = 13;
            }
        }

        if (menu == 11) {
            menuEleven(); // Call menuEleven() function
            playermovement(); // Call playermovement() function
            update_hitboxes(11); // Update hitboxes for menu 11
            hitboxes_5.draw(true); // Draw hitbox 5 with true parameter for drawing
            hitboxes_6.draw(true); // Draw hitbox 6 with true parameter for drawing
            hitboxes_7.draw(true); // Draw hitbox 7 with true parameter for drawing
            hitboxes_8.draw(true); // Draw hitbox 8 with true parameter for drawing
            hitboxes_9.draw(true); // Draw hitbox 9 with true parameter for drawing
            hitboxes_10.draw(true); // Draw hitbox 10 with true parameter for drawing
            hitboxes_11.draw(true); // Draw hitbox 11 with true parameter for drawing
            hitboxes_12.draw(true); // Draw hitbox 12 with true parameter for drawing
            player.display(); // Display the player
            
            if (cheeseButton.isIn(player.getPlayerX(),player.getPlayerY())) {
                if (Cheese){
                textSize(100);
                fill(255);
                text("+1" , 250, 210);}
                Cheese = false;
            }
            if (grapeButton.isIn(player.getPlayerX(),player.getPlayerY())) {
                if (Grape){
                textSize(100);
                fill(255);
                text("+1" , 250, 210);}
                Grape = false;
            }
            if (breadButton.isIn(player.getPlayerX(),player.getPlayerY())) {
                if (Bread){
                textSize(100);
                fill(255);
                text("+1" , 250, 210);}
                Bread = false;
            }

            if (Cheese == true) {
               image(cheese,360,420,40,40); 
            }
            if (Bread) {
                image(bread,70,250,150,150);
            }
            if (Grape) {
                image(grape,640,260,50,50);
            } 
            
            if (!Grape && !Cheese && !Bread) {
                maze = false;
                menu = 4;
            }

        }

        if (menu == 12) {
            menuTwelve();
            playermovement();
            update_hitboxes(11);
            hitboxes_5.draw(true);
            hitboxes_6.draw(true);
            hitboxes_7.draw(true);
            hitboxes_8.draw(true);
            hitboxes_9.draw(true);
            hitboxes_10.draw(true);
            hitboxes_11.draw(true);
            hitboxes_12.draw(true);
            if (M1.isIn(player.getPlayerX(),player.getPlayerY())) Molee = false;
            if (M2.isIn(player.getPlayerX(),player.getPlayerY())) Mole11 = false;
            if (M3.isIn(player.getPlayerX(),player.getPlayerY())) Mole22 = false;
            if (M4.isIn(player.getPlayerX(),player.getPlayerY())) Mole33 = false;
            if (M5.isIn(player.getPlayerX(),player.getPlayerY())) Mole44 = false;
            
            player.display();  
            if (Molee) image(Mole,375,100,50,50);
            if (Mole11) image(Mole1,130,235,50,50);
            if (Mole22) image(Mole,160, 380,50,50);
            if (Mole33) image(Mole,630,300,50,50);
            if (Mole44) image(Mole,670,100,50,50);
             
            
            
            player.display();
            if (!Molee && !Mole11 && !Mole22 && !Mole33 && !Mole44) {menu = 4; mole = false;}
        }

        if (menu == 13) {
            if (c > 0) {
            c -= 1;
            background(c);
            } else menu = 0;    
        }

        // play_button.displayInfo(mouseX, mouseY, mousePressed);
        // player.displayInfo();
    }

    public void menuZero(){
        player.setPlayerX(100);
        player.setPlayerY(460);
        background(intromenu);
        image(introboard, 0, 0, 750, 500);

        play_button.drawbox();
        help_button.drawbox();
        textSize(30);
        fill(255);
        text("Start", 260, 360);
        text("Credits", 400, 360);
        

        if (play_button.isClicked(mouseX, mouseY, mousePressed)) {
            play_button.displayClick(mouseX);
            // MENU SKIPPED TO 4 FROM 2 FOR TROUBLESHOOTING
            menu = 2;
        }
        if (help_button.isClicked(mouseX, mouseY, mousePressed)) {
            help_button.displayClick(mouseX);
            menu = 1;
        }
    }

    /**
     * Displays the first menu screen.
     * This method sets the background image to the specified 'intromenu' color,
     * displays the introboard image, and handles the functionality of the back button.
     */
    public void menuOne(){
        background(intromenu);
        //back_button.drawbox();
        image(introboard, 0, 0, 750, 500);
        image(back, 150, 50, 50, 30);
        if (back_button.isClicked(mouseX, mouseY, mousePressed)) {
            play_button.displayClick(mouseX);
            menu = 0;
        }
    }
    /**
     * Displays the second menu screen.
     * This method sets the background color to black, displays a greeting message to the user,
     * and prompts them with a message about the simulated world. It also handles the functionality
     * of the continue button, which transitions to the next menu screen.
     */
    public void menuTwo(){
        background(0);
        textSize(50);
        fill(255);
        text("Hello", 50, 100);
        fill(255, 0, 0);
        text("         stranger...", 50, 100);
        fill(255);
        textSize(25);
        text("Welcome to this simulated world.", 50, 170);
        textSize(25);
        text("You may not have realized it right now, \nbut you have taken too much for granted.", 50, 220);

        continue_button.drawbox();
        if (continue_button.isClicked(mouseX, mouseY, mousePressed)) {
            menu = 3;
        }
    }

    /**
     * Displays the third menu screen.
     * This method sets the background color to a dark shade, displays information about movement
     * and interaction controls to the user, and provides an "OK" button to proceed to the next menu.
     */
    public void menuThree() {
        background(9);
        textSize(50);
        fill(255,0,0);
        text("Movement", 100, 100);
        image(arrow_keys, 120, 160);
        text("Interact", 410, 100);
        image(space_keys, 400, 220);
        image(mouse, 480, 120);
        ok_button.drawbox();
        if (ok_button.isClicked(mouseX, mouseY, mousePressed))
            menu = 999;
    }

    /**
     * Displays the fourth menu screen.
     * This method renders the background image of a house and displays arrow images for navigation.
     * It also handles player movement, updates hitboxes, and checks for interactions with buttons.
     * The method allows the player to enter the maze or the "Whack a Mole" game by pressing the SPACE key.
     * It also provides an option to exit the simulation.
     */
    public void menuFour() {
        image(house, mapInitialX + worldshiftX, mapInitialY + worldshiftY);
        right_arrow.resize(100, 60);
        if (mole) image(right_arrow,mapInitialX + worldshiftX+920, mapInitialY + worldshiftY+630);
        if (maze) image(left_arrow,mapInitialX + worldshiftX+10, mapInitialY + worldshiftY+630);
        image(up_arrow,mapInitialX + worldshiftX+485, mapInitialY + worldshiftY+500);
        playermovement();
        movementcheck();
        update_hitboxes(hitPhase);
        if (mazeButton.isIn(player.getPlayerX(),player.getPlayerY())) {
                
                if (maze) {
                    fill(0);
                    rect(240,150,300,200);
                    textSize(30);
                    fill(255);
                    text("   Press SPACE to \n  enter the \"Maze\" " , 250, 230);
                    if (spacePressed) {
                        menu = 11;
                        background(0,255,0);
                        player.setPlayerX(700);
                        player.setPlayerY(400);
                    }
                }
            }

            if (moleButton.isIn(player.getPlayerX(),player.getPlayerY())) {
                if (mole){
                    fill(0);
                    rect(240,150,300,200);
                    textSize(30);
                    fill(255);
                    text("    Press SPACE to \n         enter \n   \"Whack a mole\" " , 250, 210);
                    if (spacePressed) {
                        player.setPlayerX(200);
                        player.setPlayerX(400);
                        menu = 12;
                        background(0);
                    }
                }
            }

            if (exitButton.isIn(player.getPlayerX(),player.getPlayerY())) {
                fill(0);
                rect(240,100,300,200);
                textSize(30);
                fill(255);
                text("Press SPACE to exit \n    the simulation " , 250, 180);
                if (spacePressed) {
                    if (!mole && !maze) {
                            menu = 70;
                        } else menu = 13;
                    c = 255;                    
                }
            }
        player.display();

        // image(g, dy, dy, dx, dy, AMBIENT, ALT, ALPHA, ADD);
    }
    
    /**
     * Displays the eleventh menu screen.
     * This method sets the background color to green (0, 255, 0).
     * It is typically used as a transition screen when entering the "Maze" game.
     */
    public void menuEleven() {
        background(0,255,0);

    }

    /**
     * Displays the twelfth menu screen.
     * This method sets the background color to a dark shade of purple (45, 36, 64).
     * It is typically used as a transition screen when entering the "Whack a mole" game.
     */
    public void menuTwelve() {
        background(45,36,64);
    }

    /**
     * Handles the movement of the player character based on the keyboard input.
     * This method calculates the change in the player's position (dx and dy) based on the pressed arrow keys.
     * If the left arrow key is pressed, dx is decreased by the player's speed.
     * If the right arrow key is pressed, dx is increased by the player's speed.
     * If the up arrow key is pressed, dy is decreased by the player's speed.
     * If the down arrow key is pressed, dy is increased by the player's speed.
     * Finally, the player's position is updated using the calculated dx and dy values.
     */
    public void playermovement() {
        float dx = 0;
        float dy = 0;
        
        if (leftPressed) {
            dx -= player.getSpeed();
        }
        if (rightPressed) {
            dx += player.getSpeed();
        }
        if (upPressed) {
            dy -= player.getSpeed();
        }
        if (downPressed) {
            dy += player.getSpeed();
        }
        player.move(dx, dy);
    }
    /**
     * Checks the player's position and adjusts the world shift accordingly to restrict movement beyond the boundaries.
     * If the player's X-coordinate is less than 200 and the world shift in the X-direction is within the allowed range,
     * the player's X-coordinate is set to 200 and the world shift is increased by the player's speed.
     * If the player's X-coordinate is greater than 550 and the world shift in the X-direction is within the allowed range,
     * the player's X-coordinate is set to 550 and the world shift is decreased by the player's speed.
     * If the player's Y-coordinate is less than 350 and the world shift in the Y-direction is within the allowed range,
     * the player's Y-coordinate is set to 350 and the world shift is increased by the player's speed.
     * If the player's Y-coordinate is greater than 435 and the world shift in the Y-direction is within the allowed range,
     * the player's Y-coordinate is set to 435 and the world shift is decreased by the player's speed.
     */

    public void movementcheck(){
        if (player.getPlayerX() < 200) {
            if (worldshiftX <= abs(mapInitialX)-5) {
                player.setPlayerX(200); 
                worldshiftX += player.getSpeed();
            }
                       
        } 
        if (player.getPlayerX() > 550) {
            if (worldshiftX >= mapInitialX+35) {
                player.setPlayerX(550); 
                worldshiftX -= player.getSpeed();   
            }
                       
        } 
        if (player.getPlayerY() < 350) {
            if (worldshiftY <= abs(mapInitialY)-250) {
                player.setPlayerY(350);  
                worldshiftY += player.getSpeed();  
            }
                      
        } 
        if (player.getPlayerY() > 435) {
            if (worldshiftY >= mapInitialY+280) {
                player.setPlayerY(435);    
                worldshiftY -= player.getSpeed();   
            }
        } 
    }

    /**
     * Updates the positions of hitboxes based on the current menu.
     * If the menu is 4, the hitboxes for menu four are updated with their respective positions.
     * If the menu is 11, the hitboxes for menu eleven are updated with their respective positions.
     * The hitboxes are used for collision detection.
     *
     * @param menu The current menu being displayed.
     */
    public void update_hitboxes(int menu){
        if (menu == 4){
            hitboxes_1.setPositionX(mapInitialX + worldshiftX);
            hitboxes_1.setPositionY(mapInitialY + worldshiftY + 765);
            hitboxes_2.setPositionX(mapInitialX + worldshiftX);
            hitboxes_2.setPositionY(mapInitialY + worldshiftY + 550);
            hitboxes_3.setPositionX(mapInitialX + worldshiftX+1020);
            hitboxes_3.setPositionY(mapInitialY + worldshiftY + 300);
            hitboxes_4.setPositionX(mapInitialX + worldshiftX-10);
            hitboxes_4.setPositionY(mapInitialY + worldshiftY + 300);
            moleButton.setPositionX(mapInitialX + worldshiftX + 920);
            moleButton.setPositionY(mapInitialY + worldshiftY + 630);
            mazeButton.setPositionX(mapInitialX + worldshiftX + 20);
            mazeButton.setPositionY(mapInitialY + worldshiftY + 630);
            exitButton.setPositionX(mapInitialX + worldshiftX+480);
            exitButton.setPositionY(mapInitialY + worldshiftY + 500);
            checkHit(hitboxes_1.getPositionX(),hitboxes_1.getPositionY(),hitboxes_1.getBufferX(),hitboxes_1.getBufferY());
            checkHit(hitboxes_2.getPositionX(),hitboxes_2.getPositionY(),hitboxes_2.getBufferX(),hitboxes_2.getBufferY());
            checkHit(hitboxes_3.getPositionX(),hitboxes_3.getPositionY(),hitboxes_3.getBufferX(),hitboxes_3.getBufferY());
            checkHit(hitboxes_4.getPositionX(),hitboxes_4.getPositionY(),hitboxes_4.getBufferX(),hitboxes_4.getBufferY());}

        if (menu == 11) {
            checkHit(hitboxes_5.getPositionX(),hitboxes_5.getPositionY(),hitboxes_5.getBufferX(),hitboxes_5.getBufferY());
            checkHit(hitboxes_6.getPositionX(),hitboxes_6.getPositionY(),hitboxes_6.getBufferX(),hitboxes_6.getBufferY());
            checkHit(hitboxes_7.getPositionX(),hitboxes_7.getPositionY(),hitboxes_7.getBufferX(),hitboxes_7.getBufferY());
            checkHit(hitboxes_8.getPositionX(),hitboxes_8.getPositionY(),hitboxes_8.getBufferX(),hitboxes_8.getBufferY());
            checkHit(hitboxes_9.getPositionX(),hitboxes_9.getPositionY(),hitboxes_9.getBufferX(),hitboxes_9.getBufferY());
            checkHit(hitboxes_10.getPositionX(),hitboxes_10.getPositionY(),hitboxes_10.getBufferX(),hitboxes_10.getBufferY());
            checkHit(hitboxes_11.getPositionX(),hitboxes_11.getPositionY(),hitboxes_11.getBufferX(),hitboxes_11.getBufferY());
            checkHit(hitboxes_12.getPositionX(),hitboxes_12.getPositionY(),hitboxes_12.getBufferX(),hitboxes_12.getBufferY());
        }
    }

    /**
     * Checks for collision between the player and a hitbox.
     * If a collision is detected, the player's position is adjusted based on the hitbox position and size.
     *
     * @param hitBoxX   The X-coordinate of the hitbox.
     * @param hitBoxY   The Y-coordinate of the hitbox.
     * @param bufferX   The buffer value in the X-direction for the hitbox.
     * @param bufferY   The buffer value in the Y-direction for the hitbox.
     */
    public void checkHit(float hitBoxX,float hitBoxY,float bufferX,float bufferY){
        // approaching right side of hitbox
        if (player.playerX < hitBoxX + bufferX){
            if (player.playerY < hitBoxY + bufferY-16){
                if (player.playerY + player.getHeight() > hitBoxY+6 ){
                    if (player.playerX + player.getWidth() > hitBoxX+6){
                        float a = player.getPlayerX();
                        player.setPlayerX(a+=player.getSpeed());}}}}
        
        // approaching left side of hitbox
        if (player.playerX + player.getWidth() > hitBoxX){
            if (player.playerY < hitBoxY + bufferY-16){
                if (player.playerY + player.getHeight() > hitBoxY+6 ){
                    if (player.playerX < hitBoxX + bufferX - 16){
                        float a = player.getPlayerX();
                        player.setPlayerX(a-=player.getSpeed());}}}}


        // approaching bottom of hitbox
        if (player.playerY < hitBoxY + bufferY-10){
            if (player.playerX < hitBoxX + bufferX-6){
                if (player.playerX - 6 + player.getWidth() > hitBoxX){
                    if (player.playerY + player.getHeight() > hitBoxY + 10){
                    float a = player.getPlayerY();
                    player.setPlayerY(a+=player.getSpeed());   
        }}}}

        // approaching top of hitbox
        if (player.playerY + player.getHeight() > hitBoxY ){
            if (player.playerX < hitBoxX + bufferX-6){
                if (player.playerX - 6 + player.getWidth() > hitBoxX){
                    if (player.playerY < hitBoxY + bufferY-26){
                    float a = player.getPlayerY();
                    player.setPlayerY(a-=player.getSpeed());   
        }}}}
            
    }

    /**
     * Recursively counts up from the given number to 255.
     *
     * @param num The starting number.
     * @return The final count, which is 255.
     */
    public int ctd(int num) {
        if (num < 255) return ctd(num+1);
        else return num;
    }
  
}
