import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.ArrayList;
/**
 * Write a description of class Rain here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Rain extends Effect
{
    private int duration;
    private ArrayList<Ship> ship;
    private static GreenfootSound rainSound;
    private World w;
    
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
    
    public Rain (int duration){
        this.duration = duration;
        rainSound = new GreenfootSound("Rain1.mp3");
        
    }
    
    
    
    
    
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
    
    public void stopRain()
    {
        rainSound.stop();
    }
    
    /**
     * density should be 1-100. 100 will be almost completely white
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
