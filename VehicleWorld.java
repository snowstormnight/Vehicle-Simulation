import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.ArrayList;
/**
 * <h1>The new and vastly improved 2022 Vehicle Simulation Assignment.</h1>
 * <p> This is the first redo of the 8 year old project. Lanes are now drawn dynamically, allowing for
 *     much greater customization. Pedestrians can now move in two directions. The graphics are better
 *     and the interactions smoother.</p>
 * <p> The Pedestrians are not as dumb as before (they don't want straight into Vehicles) and the Vehicles
 *     do a somewhat better job detecting Pedestrians.</p>
 *     
 * Creadit:
 * 
 * Mario sound effect(heal):
 * https://www.aigei.com/s?tab=file&type=sound&q=%E9%A9%AC%E9%87%8C%E5%A5%A5%E5%9B%9E%E8%A1%80
 * 
 * Engine speeding up sound effect:
 * https://www.aigei.com/s?tab=file&type=sound&q=%E5%BC%95%E6%93%8E%E5%8A%A0%E9%80%9F
 * 
 * Take in supply bag sound effect:
 * https://www.aigei.com/s?tab=file&type=sound&q=%E7%94%B5%E6%A2%AF
 * 
 * Explode sound:
 * https://www.aigei.com/s?tab=file&type=sound&q=%E7%88%86%E7%82%B8
 * 
 * Ocean background sound:
 * https://www.chosic.com/download-audio/27955/
 * 
 * Rain background sound:
 * Music: https://www.chosic.com/free-music/all/
 * 
 * Thunder sound effect:
 * https://www.aigei.com/s?q=%E6%89%93%E9%9B%B7&type=sound
 * 
 * Explosion png sequence
 * https://www.google.ca/search?q=explosion+png+sequence&source=lnms&tbm=isch&sa=X&ved=2ahUKEwj8wNO7-Yn-AhXikYkEHfhcDY8Q_AUoAXoECAIQAw&biw=1102&bih=722&dpr=1.25#imgrc=zAzPCJ41IvO-wM
 * 
 * Aircraft carrier image:
 * https://www.globalsecurity.org/military/systems/ship/cve-105-schem.htm
 * 
 * Ocean background image:
 * https://www.storyblocks.com/video/stock/aerial-shot-of-calm-blue-open-ocean-beautiful-cloudly-sky-and-the-horizon-wonderful-landscape-of-coastline-and-mountains-bird-eye-view-gran-canaria-bjyz1v3i7jl6rydgt
 * 
 * Battleship image:
 * https://www.google.com/search?q=US+battleship+design+graph+above+view&tbm=isch&ved=2ahUKEwj11L30-4n-AhXoEVkFHc9xDiwQ2-cCegQIABAA&oq=US+battleship+design+graph+above+view&gs_lcp=CgNpbWcQAzoECCMQJ1DfDVjkGGDJGWgAcAB4AYABjQSIAegRkgELNC4zLjEuMS4xLjGYAQCgAQGqAQtnd3Mtd2l6LWltZ8ABAQ&sclient=img&ei=6s8oZPW3LOij5NoPz-O54AI&bih=722&biw=1536#imgrc=hsqwV628zh5UPM
 * 
 * Crusier image:
 * https://www.google.com/search?q=US+battleship+design+graph&sxsrf=APwXEdc4sVRkIacMf_ShHwSGWxlqsaNP0w:1680396265497&source=lnms&tbm=isch&sa=X&ved=2ahUKEwigoPLz-4n-AhVyj4kEHRWxBygQ_AUoAXoECAEQAw&biw=1536&bih=722&dpr=1.25#imgrc=3J7BfxA2DEsAnM
 * 
 * Small boat image:
 * From Kyle Li, my friend
 * 
 * Fired bullet image:
 * From Kyle Li, my friend
 * 
 * Heavy bullet image:
 * https://www.shutterstock.com/zh/image-photo/large-heavy-bullet-20607190
 * 
 * supply boat image:
 * https://www.google.ca/search?q=supply+boat+design++bird+view&tbm=isch&ved=2ahUKEwiq7tuL4vT9AhVzMlkFHVM-DwgQ2-cCegQIABAA&oq=supply+boat+design++bird+view&gs_lcp=CgNpbWcQA1CwA1jtC2CZDWgAcAB4AIABoAGIAZ4IkgEDMS43mAEAoAEBqgELZ3dzLXdpei1pbWfAAQE&sclient=img&ei=RbIdZOq3JvPk5NoP0_y8QA&bih=722&biw=1490#imgrc=NnqXOm4TohpsSM
 *
 * heal bag image:
 * https://pubg-archive.fandom.com/wiki/First_Aid_Kit
 *
 * Lightning image:
 * https://www.istockphoto.com/photo/thunderbolt-gm106566354-5803157
 * 
 * missile image:
 * https://www.google.ca/search?q=missile+design+image&tbm=isch&ved=2ahUKEwia0fnQ_Yn-AhXnE1kFHbjwCEcQ2-cCegQIABAA&oq=missile+design+image&gs_lcp=CgNpbWcQAzoHCAAQgAQQEzoICAAQBxAeEBNQ5gVYhwxgww1oAHAAeACAAZMCiAHdCZIBBTMuMy4ymAEAoAEBqgELZ3dzLXdpei1pbWfAAQE&sclient=img&ei=udEoZNqQBeen5NoPuOGjuAQ&bih=722&biw=1490#imgrc=T8PPGDCdJeSUoM
 * 
 * Reflection:
 * 
 * Border:
 * This will form a border that will remove all the actors that touch with it. It will include the world in.
 * 
 * Effect:
 * The effect will show up after 3 to 6 s and will stay for a short period. They have audio and visual effect. 
 * When they show up, some classes in the world will be effected.
 * 
 * Rain:
 * This effect will form a raining effect. It will spawn with a raining sound and slow down ships in the ship class except reapir boat.
 * 
 * Lightning:
 * This effect will randomly show up everywhere in the world. They will spawn with thunder sound, create certain damage to the ships -
 * and completely destroy(means remove) any vertical objects class(This is originally the pedestrian class) object from the world.
 * 
 * 
 * Checklane:
 * This is a short class for teh reapir boat to use on decide whether change lane or not. They are invisible rectangles-
 * that checks whether there is enough space for repair boat to change lane.
 * 
 * FiredBullet:
 * This is the class for the battleship use to destroy the vertical objects spawn place. They will spawn on the battleship and aim-
 * to the vertical objects spawn place and try to destroy it.
 * 
 * Ship(originally the Vehicle class):
 * This ship class is an abstract class with some basic general method for the ships in ship class. The most important method is destroy().
 * This method will check whether hp is smaller than zero; it will play an explosion animation and remove the ship after the hp reaches zero.
 * Every ships in the ship class will have a certain hp for them. The hp may be decrease if the bullet, missile, or lightning strike it.
 * When it is near any explosion, it will also decrease its hp.
 * The boat in this class(not repair boat) will also "knock down" any supply boat they hit.
 * 
 * Aircraft carrier:
 * This ship type will take in the supply bag and incrase their hp by one.
 * When they take the heal bag in, an animation will be played.
 * 
 * Battleship:
 * This ship type will shot bullets(or missiles may be better) every three seconds that aim to hit the verticalobjectsspawn place. 
 * 
 * Crusier: 
 * This is an ordinary ship type just to increase the diversity of the ship class.
 * 
 * Repairboat:
 * This ship class will heal those broken supply ship, which will allow them to keep moving, and change lane if the ships in the-
 * front is slower.
 * 
 * Verticalobjects(originally the pedestrain class):
 * This class will spawn on one of the six vertical object spawner.
 * They will travel vertically through the world.
 * If any of the verticalobjects class is hit by lightning, they will be remove from the world.
 * 
 * 
 * Bullet:
 * This class will fly stright up or down depend on the spawn position.
 * When they reach the side of the world, they will explode and cause damge to near by boat class and remove any vericalobjects class.
 * When they explode in this situation, an explode animation will be played.
 * When they hit the ship class, they will be removed and decrease the ship class's hp.
 * 
 * Missile:
 * This class wil change direction ever one sec as they fly. When they hit the ship class, they will also decrease the ship class's hp.
 * 
 * Supply:
 * This class will fly stright up or down depend on the spawn position.
 * When they reach the aircraft carrier, they will be take in and increase the aircraft carrier's hp by one.
 * 
 * Supplyboat:
 * This class will move stright up or down depend on the spawn position.
 * They will try to reach the other side, but when they are in contact with any ship class, they will sink(the image will be set as sink boat).
 * They will be repair(so they are keep moving) when they are in contact with the repairboat class.
 * 
 * VerticalObjectsSpawn:
 * This is the class where all the VerticalObjects class spawn. 
 * They will spawn VerticalObjects every 2 sec.
 * This class will move between the x-cordinate 100 and 1000.
 * When they are in contact with the FiredBullet class, their hp will be decrease. When the hp reach 0, they will be remove from the
 * class and respawn after 7 seconds.
 * 
 * Version Notes - Feb 2023
 * --> Includes grid <--> lane conversion method
 * --> Now starts with 1-way, 5 lane setup (easier)
 */
public class VehicleWorld extends World
{
    private GreenfootImage background;

    
    // Color Constants
    public static Color GREY_BORDER = new Color (108, 108, 108);
    public static Color GREY_STREET = new Color (88, 88, 88);
    public static Color YELLOW_LINE = new Color (255, 216, 0);
    
    // Instance variables / Objects
    private boolean twoWayTraffic, splitAtCenter;
    private int laneHeight, laneCount, spaceBetweenLanes;
    private int[] lanePositionsY;
    private VehicleSpawner[] laneSpawners;
    public static boolean raining;
    private VerticalObjectSpawn[] verticalSpawn;
    private GreenfootSound ocean;

    
    /**
     * Constructor for objects of class MyWorld.
     * 
     */
    public VehicleWorld()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(1100, 619, 1, false); 
        
        //delete after, no need
        setPaintOrder (Effect.class, Ship.class, VerticalObjects.class, Border.class);

        // set up background
        background = new GreenfootImage ("background.png");
        setBackground (background);
        raining = false;

        // Set critical variables
        laneCount = 8;
        laneHeight = 52;
        spaceBetweenLanes = 1;
        splitAtCenter = true;
        twoWayTraffic = true;
        
        //add border for the world
        addObject(new Border(false), 500, -500);
        addObject(new Border(false), 500, 1500);
        addObject(new Border(true), 2500, 300);
        addObject(new Border(true), -2500, 300);
        
        // Init lane spawner objects 
        laneSpawners = new VehicleSpawner[laneCount];

        // Prepare lanes method - draws the lanes
        lanePositionsY = prepareLanes (this, background, laneSpawners, 97, laneHeight, laneCount, spaceBetweenLanes, twoWayTraffic, splitAtCenter);

        
        
        
        //Use to create and add the VerticalObjectsSpawn objects
        verticalSpawn = new VerticalObjectSpawn[6];
        for(int i = 0; i < 3; i++)
        {
            verticalSpawn[i] = new VerticalObjectSpawn(220 + i*220, 30+i*20, 1);
            verticalSpawn[i+3] = new VerticalObjectSpawn(220 + i*220, 550 + i*20, -1);
            addObject(verticalSpawn[i], 220 + i*220, 30+i*20);
            addObject(verticalSpawn[i+3], 220 + i*220, 550 + i*20);
        }
        
        //To set up the background sound
        ocean = new GreenfootSound("ocean.mp3");
        ocean.setVolume(20);
    }

    //The act method of the VehicleWorld
    public void act () {
        spawn();
    }
    
    //start to play the ocean background effect when greenfoot start.
    public void started()
    {
        ocean.playLoop();
    }
    
    //This method will be played when the greenfoot stop running. The main purpose is to stop those sound effects.
    public void stopped()
    {
        ocean.stop();
        ArrayList<Effect> e = (ArrayList<Effect>) getObjects(Effect.class);
        for(Effect e1 : e)
        {
            e1.stopPlay();
        }
        ArrayList<Bullet> b = (ArrayList<Bullet>) getObjects(Bullet.class);
        for(Bullet b1 : b)
        {
            b1.explodeStop();
        }
        ArrayList<Ship> s = (ArrayList<Ship>) getObjects(Ship.class);
        for(Ship s1 : s)
        {
            s1.stopPlay();
            s1.stopExplode();
        }
        
    }
    
    //This will return a boolean about whether it is raining.
    public boolean getRain()
    {
        return raining;
    }
    
    //This will spawn most of the objects in the game. It will spawn all the ships and effect.
    private void spawn () {
        if (Greenfoot.getRandomNumber (60) == 0){
            int lane = Greenfoot.getRandomNumber(laneCount);
            int xPosition = 0;
            if(lane < 4)
            {
                xPosition = getWidth();
            }
            if(lane > 4)
            {
                xPosition = 0;
            }
            if (!laneSpawners[lane].isTouchingVehicle ()){
                int vehicleType = Greenfoot.getRandomNumber(4);
                if (vehicleType == 0){
                    addObject(new AircraftCarrier(laneSpawners[lane], lane), xPosition, lanePositionsY[lane]);
                } else if (vehicleType == 1){
                    addObject(new RepairBoat(laneSpawners[lane], lane), xPosition, lanePositionsY[lane]);
                } else if (vehicleType == 2){
                    addObject(new Cruiser(laneSpawners[lane], lane), xPosition, lanePositionsY[lane]);
                }else if (vehicleType == 3){
                    addObject(new BattleShip(laneSpawners[lane], lane), xPosition, lanePositionsY[lane]);
                }
            }
        }
        
        
        //This two blocks of code below will spawn rain and lightning.
        if (!raining && Greenfoot.getRandomNumber(300) == 0){
            addObject (new Rain(150), 550, 309);
            raining = true;
        }
        if (raining && getObjects(Rain.class).size() == 0){
            raining = false;
        }
       
       if(Greenfoot.getRandomNumber (180) == 0)
        {
            int xPoistion = Greenfoot.getRandomNumber (900) + 100;
            int yPosition = Greenfoot.getRandomNumber (300) + 100;
            addObject(new Lightning(60), xPoistion, yPosition);
        }
        

    }

    /**
     *  Given a lane number (zero-indexed), return the y position
     *  in the centre of the lane. (doesn't factor offset, so 
     *  watch your offset, i.e. with Bus).
     *  
     *  @param lane the lane number (zero-indexed)
     *  @return int the y position of the lane's center, or -1 if invalid
     */
    public int getLaneY (int lane){
        if (lane < lanePositionsY.length){
            return lanePositionsY[lane];
        } 
        return -1;
    }
    
    /**
     * Given a y-position, return the lane number (zero-indexed).
     * Note that the y-position must be valid, and you should 
     * include the offset in your calculations before calling this method.
     * For example, if a Bus is in a lane at y=100, but is offset by -20,
     * it is actually in the lane located at y=80, so you should send
     * 80 to this method, not 100.
     * 
     * @param y - the y position of the lane the Vehicle is in
     * @return int the lane number, zero-indexed
     * 
     */
    public int getLane (int y){
        for (int i = 0; i < lanePositionsY.length; i++){
            if (y == lanePositionsY[i]){
                return i;
            }
        }
        return -1;
    }
    
    public static int[] prepareLanes (World world, GreenfootImage target, VehicleSpawner[] spawners, int startY, int heightPerLane, int lanes, int spacing, boolean twoWay, boolean centreSplit, int centreSpacing)
    {
        // Declare an array to store the y values as I calculate them
        int[] lanePositions = new int[lanes];
        // Pre-calculate half of the lane height, as this will frequently be used for drawing.
        // To help make it clear, the heightOffset is the distance from the centre of the lane (it's y position)
        // to the outer edge of the lane.
        int heightOffset = heightPerLane / 2;

        // draw top border
        target.setColor (GREY_BORDER);
        target.fillRect (0, startY, target.getWidth(), spacing);

        // Main Loop to Calculate Positions and draw lanes
        for (int i = 0; i < lanes; i++){
            // calculate the position for the lane
            lanePositions[i] = startY + spacing + (i * (heightPerLane+spacing)) + heightOffset ;
            
            // draw lane
            target.setColor(GREY_STREET); 
            
            // the lane spacing - where the white or yellow lines will get drawn
            target.fillRect(0, lanePositions[i] + heightOffset, target.getWidth(), spacing);

            // Place spawners and draw lines depending on whether its 2 way and centre split
            if (twoWay && centreSplit){
                // first half of the lanes go rightward (no option for left-hand drive, sorry UK students .. ?)
                if ( i < lanes / 2){
                    spawners[i] = new VehicleSpawner(false, heightPerLane);
                    world.addObject(spawners[i], target.getWidth(), lanePositions[i]);
                } else { // second half of the lanes go leftward
                    spawners[i] = new VehicleSpawner(true, heightPerLane);
                    world.addObject(spawners[i], 0, lanePositions[i]);
                }

                // draw yellow lines if middle 
                if (i == lanes / 2){
                    target.setColor(YELLOW_LINE);
                    target.fillRect(0, lanePositions[i] - heightOffset - spacing, target.getWidth(), spacing);

                } else if (i > 0){ // draw white lines if not first lane
                    for (int j = 0; j < target.getWidth(); j += 120){
                        target.setColor (Color.WHITE);
                        target.fillRect (j, lanePositions[i] - heightOffset - spacing, 60, spacing);
                    }
                } 

            } else if (twoWay){ // not center split
                if ( i % 2 == 0){
                    spawners[i] = new VehicleSpawner(false, heightPerLane);
                    world.addObject(spawners[i], target.getWidth(), lanePositions[i]);
                } else {
                    spawners[i] = new VehicleSpawner(true, heightPerLane);
                    world.addObject(spawners[i], 0, lanePositions[i]);
                }

                // draw Grey Border if between two "Streets"
                if (i > 0){ // but not in first position
                    if (i % 2 == 0){
                        target.setColor(GREY_BORDER);
                        target.fillRect(0, lanePositions[i] - heightOffset - spacing, target.getWidth(), spacing);

                    } else { // draw dotted lines
                        for (int j = 0; j < target.getWidth(); j += 120){
                            target.setColor (YELLOW_LINE);
                            target.fillRect (j, lanePositions[i] - heightOffset - spacing, 60, spacing);
                        }
                    } 
                }
            } else { // One way traffic
                spawners[i] = new VehicleSpawner(true, heightPerLane);
                world.addObject(spawners[i], 0, lanePositions[i]);
                if (i > 0){
                    for (int j = 0; j < target.getWidth(); j += 120){
                        target.setColor (Color.WHITE);
                        target.fillRect (j, lanePositions[i] - heightOffset - spacing, 60, spacing);
                    }
                }
            }
        }
        // draws bottom border
        target.setColor (GREY_BORDER);
        target.fillRect (0, lanePositions[lanes-1] + heightOffset, target.getWidth(), spacing);

        return lanePositions;
    }

    /**
     * <p>The prepareLanes method is a static (standalone) method that takes a list of parameters about the desired roadway and then builds it.</p>
     * 
     * <p><b>Note:</b> So far, Centre-split is the only option, regardless of what values you send for that parameters.</p>
     *
     * <p>This method does three things:</p>
     * <ul>
     *  <li> Determines the Y coordinate for each lane (each lane is centered vertically around the position)</li>
     *  <li> Draws lanes onto the GreenfootImage target that is passed in at the specified / calculated positions. 
     *       (Nothing is returned, it just manipulates the object which affects the original).</li>
     *  <li> Places the VehicleSpawners (passed in via the array parameter spawners) into the World (also passed in via parameters).</li>
     * </ul>
     * 
     * <p> After this method is run, there is a visual road as well as the objects needed to spawn Vehicles. Examine the table below for an
     * in-depth description of what the roadway will look like and what each parameter/component represents.</p>
     * 
     * <pre>
     *                  <=== Start Y
     *  ||||||||||||||  <=== Top Border
     *  /------------\
     *  |            |  
     *  |      Y[0]  |  <=== Lane Position (Y) is the middle of the lane
     *  |            |
     *  \------------/
     *  [##] [##] [##| <== spacing ( where the lane lines or borders are )
     *  /------------\
     *  |            |  
     *  |      Y[1]  |
     *  |            |
     *  \------------/
     *  ||||||||||||||  <== Bottom Border
     * </pre>
     * 
     * @param world     The World that the VehicleSpawners will be added to
     * @param target    The GreenfootImage that the lanes will be drawn on, usually but not necessarily the background of the World.
     * @param spawners  An array of VehicleSpawner to be added to the World
     * @param startY    The top Y position where lanes (drawing) should start
     * @param heightPerLane The height of the desired lanes
     * @param lanes     The total number of lanes desired
     * @param spacing   The distance, in pixels, between each lane
     * @param twoWay    Should traffic flow both ways? Leave false for a one-way street (Not Yet Implemented)
     * @param centreSplit   Should the whole road be split in the middle? Or lots of parallel two-way streets? Must also be two-way street (twoWay == true) or else NO EFFECT
     * 
     */
    public static int[] prepareLanes (World world, GreenfootImage target, VehicleSpawner[] spawners, int startY, int heightPerLane, int lanes, int spacing, boolean twoWay, boolean centreSplit){
        return prepareLanes (world, target, spawners, startY, heightPerLane, lanes, spacing, twoWay, centreSplit, spacing);
    }

}
