import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * This is the missile class.
 * This class will change its direction each sec and will damage the ships it is in contact with
 * 
 * @author George Lu
 * @version final 2023/4/1
 */
public class Missile extends VerticalObjects
{
    private int direction1;
    
    /**
     * This is the constructor of the Missile class
     * 
     * @param direction The direction the object travels in
     */
    public Missile(int direction)
    {
        super(direction);
        direction1 = Greenfoot.getRandomNumber(100)+40;
        setRotation(direction1);
        if(direction == -1)
        {
            setRotation(direction1+180);
        }
        timer = new SimpleTimer();
        timer.mark();
    }
    
    //This is the act method of the Missile class
    public void act()
    {
        checkLightning();
        changeDirection();
        move(2);
        hitShip();
    }
    
    //This is the main method that will changes the Missile's direction every sec.
    public void changeDirection()
    {
        if(timer.millisElapsed() > 1000)
        {
            direction1 = Greenfoot.getRandomNumber(100)+40;
            setRotation(direction1);
            if(direction == -1)
            {
                setRotation(direction1+180);
            }
            timer.mark();
        }
    }
    
    
}
