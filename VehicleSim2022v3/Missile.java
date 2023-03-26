import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Missile here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Missile extends VerticalObjects
{
    private int direction1;
    private SimpleTimer st;
    public Missile(int direction)
    {
        super(direction);
        direction1 = Greenfoot.getRandomNumber(100)+40;
        setRotation(direction1);
        if(direction == -1)
        {
            setRotation(direction1+180);
        }
        st = new SimpleTimer();
        st.mark();
    }
    
    public void act()
    {
        check();
        if(st.millisElapsed() > 1000)
        {
            direction1 = Greenfoot.getRandomNumber(100)+40;
            setRotation(direction1);
            if(direction == -1)
            {
                setRotation(direction1+180);
            }
            st.mark();
        }
        move(2);
    }
}
