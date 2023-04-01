import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.ArrayList;

/**
 * Write a description of class FiredBullet here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class FiredBullet extends SuperSmoothMover
{
    private int random, goX, goY;
    private World w;
    private ArrayList<VerticalObjectSpawn> wos;
    public FiredBullet()
    {
        random = Greenfoot.getRandomNumber(6);
    }
    
    public void act()
    {
        
        moveToTarget();
        move(2);
    }
    
    public void moveToTarget()
    {
        goX = wos.get(random).getX();
        goY = wos.get(random).getY();
        turnTowards(goX, goY);
        setRotation(getRotation());
    }
    
    public void addedToWorld(World w)
    {
        this.w = w;
        wos = (ArrayList<VerticalObjectSpawn>)(w.getObjects(VerticalObjectSpawn.class));
        
    }
    
}
