import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Weapon here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Weapon extends SuperSmoothMover
{
    private int random, count;
    private World w;
    private GreenfootImage[] animation;
    private SimpleTimer st;
    
    public Weapon()
    {
        int random = Greenfoot.getRandomNumber(6);
        animation = new GreenfootImage[20];
        for(int i = 0; i < 20; i++)
        {
            animation[i] = new GreenfootImage("Explosion/" + (i+1) + ".png");
        }
        st = new SimpleTimer();
        st.mark();
        count = 0;
    }
    
    
    public void act()
    {
        if(random == 0)
        {
            turnTowards(215, 25);
        }
        else if(random == 1)
        {
            turnTowards(490, 25);
        }
        else if(random == 2)
        {
            turnTowards(765, 25);
        }
        else if(random == 3)
        {
            turnTowards(215, 575);
        }
        else if(random == 4)
        {
            turnTowards(490, 575);
        }
        else if(random == 4)
        {
            turnTowards(765, 575);
        }
        move(4);
        
    }
    
    public void addedToWorld()
    {
        w = getWorld();
        
        
    }
    
    public void destroyed()
    {
        if(st.millisElapsed() < 50)
            {
                return;
            }
            else if(st.millisElapsed() >= 50)
            {
                setImage(animation[count]);
                count++;
                if(count == 20)
                {
                    count = 0;
                    setImage
                }
                st.mark();
            }
    }
    
    
    
}
