import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class VerticalObjectSpawn here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class VerticalObjectSpawn extends Actor
{
    public static final Color BLACK = new Color (0, 0, 0);
    private GreenfootImage image;
    private int x, y, verticalObjects, count;
    private World w;
    
    public VerticalObjectSpawn(int x, int y)
    {
        image = new GreenfootImage(50, 35);
        image.setColor(BLACK);
        image.fill();
        setImage(image);
        this.x = x;
        this.y = y;
        count = 60;
    }
    
    public void act()
    {
        verticalObjects = Greenfoot.getRandomNumber(4);
        System.out.println(count);
        
        if(count%60 == 0)
        {
            if(verticalObjects == 0)
            {
                boolean spawnAtTop = Greenfoot.getRandomNumber(2) == 0 ? true : false;
                if (spawnAtTop){
                    w.addObject (new Supply (1), x, y);
                    System.out.println("yes");
                } else {
                    w.addObject (new Supply (-1), x, y);
                }
                
            }
            else if(verticalObjects == 1)
            {
            
                boolean spawnAtTop = Greenfoot.getRandomNumber(2) == 0 ? true : false;
                if (spawnAtTop){
                    w.addObject (new SupplyBoat (1), x, y);
                } else {
                    w.addObject (new SupplyBoat (-1), x, y);
                }
                
            }
            else if(verticalObjects == 2)
            {
                
                boolean spawnAtTop = Greenfoot.getRandomNumber(2) == 0 ? true : false;
                if (spawnAtTop){
                    w.addObject(new Bullet(1), x, y);
                } else {
                    w.addObject(new Bullet(-1), x, y);
                }
                
            }
            else if(verticalObjects == 3)
            {
                
                    boolean spawnAtTop = Greenfoot.getRandomNumber(2) == 0 ? true : false;
                    if (spawnAtTop){
                        w.addObject(new Missile(1), x, y);
                    } else {
                        w.addObject(new Missile(-1), x, y);
                    }
                
            }
        }
        
        count--;
        
    }
    
    public void addedToWorld(World w)
    {
        this.w = w;
    }
}
