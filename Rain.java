import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.ArrayList;
/**
 * This is the rain class. 
 * When the rain starts, the world will be covered by a rain。
 * All the ships excpet RepairBoat will be slow down and the sound effect will be played。
 * 
 * @author George Lu
 * @version final 2023/4/1
 */
public class Rain extends Effect
{
    
    private int duration;
    private ArrayList<Ship> ship;
    private static GreenfootSound rainSound;
    private World w;
    
    /**
     * This is the act that gets all the ship objects in the world t slow down them
     * 
     * @param w This is th world rain spawn
     */
    public void addedToWorld (World w){
        ArrayList<AircraftCarrier> a =  (ArrayList<AircraftCarrier>) w.getObjects(AircraftCarrier.class);
        for (AircraftCarrier ac : a){
            ac.rainSlow();
        }
        ArrayList<BattleShip> b =  (ArrayList<BattleShip>) w.getObjects(BattleShip.class);
        for (BattleShip b1 : b){
            b1.rainSlow();
        }
        ArrayList<Cruiser> c =  (ArrayList<Cruiser>) w.getObjects(Cruiser.class);
        for (Cruiser c1 : c){
            c1.rainSlow();
        }
        this.w = w;
        
        
    }
    
    /**
     * This is the constructor for rain
     * 
     * @param duration This gives the length of time that rain should last
     */
    public Rain (int duration){
        this.duration = duration;
        rainSound = new GreenfootSound("Rain1.mp3");
        rainSound.setVolume(30);
        
    }
    
    
    //This is the act method for rain class
    public void act()
    {
        image = drawRain (w.getWidth(), w.getHeight(), 80);
        setImage(image);
        controlEffect(duration, 90, 90);
        
        duration--;
        ship =  (ArrayList<Ship>) w.getObjects(Ship.class);
        if(duration == 1)
        {
            for (Ship s : ship){
                s.getBack();
            }   
        }
        if(getWorld() != null)
        {
            rainSound.play();
        }
        
    }
    
    //This method will stop play the rain effect sound
    public void stopPlay()
    {
        rainSound.stop();
    }
    
    /**
     * The method to create the rain effect
     * 
     * @param width This is the width of the rain effect
     * @param height This is the height of the rain effect
     * @param density This is the density of the rain effect
     */
    public static GreenfootImage drawRain (int width, int height, int density){

        Color[] swatch = new Color [27];
        int blue = 0;

          
        for (int i = 0; i < swatch.length; i++){ // first half blue tones
            swatch[i] = new Color (131, 160, 184 + blue);
            blue += 1;
        }

        // The temporary image, my canvas for drawing
        GreenfootImage temp = new GreenfootImage (width, height);

        // Run this loop one time per "density"

        for (int i = 0; i < density; i++){
            for (int j = 0; j < 100; j++){ // draw 100 circles
                int randSize;
                // Choose a random colour from my swatch, and set its tranparency randomly
                int randColor = Greenfoot.getRandomNumber(swatch.length);;
                int randTrans = Greenfoot.getRandomNumber(220) + 35; // around half transparent
                temp.setColor (swatch[randColor]);

                //setTransparency(randTrans);
                // random locations for our dot
                int randX = Greenfoot.getRandomNumber (width);
                int randY = Greenfoot.getRandomNumber (height);

                randSize = Greenfoot.getRandomNumber (2) + 2;
                temp.fillOval (randX, randY, randSize, randSize);
                
            }
        }

        return temp;
    }
}
