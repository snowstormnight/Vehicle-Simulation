import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.ArrayList;

/**
 * Write a description of class Weapon here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Weapon extends SuperSmoothMover
{
    protected int damage;
    protected double speed;
    
    /**
     * Act - do whatever the Weapon wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act()
    {
        // Add your action code here.
    }
    
    public Weapon(int damage, double speed)
    {
        this.damage = damage;
        this.speed = speed;
    }
    
    public void damageRange()
    {
        ArrayList<BattleShip> b = (ArrayList<BattleShip>)(getObjectsInRange(50, BattleShip.class));
        if(b.size() > 0)
        {
            
        }
    }
}
