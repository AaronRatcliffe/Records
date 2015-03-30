
/**
 * this creates an elivater that can go aneywhere.
 * 
 * @author Aaron J. Ratcliffe
 * @version 1/22/2014
 */
public class Elevator
{
    // instance variables - replace the example below with your own
    private int floor;
    private char direction;
    private final int TOP_FLOOR;
    private final int BOTTEM_FLOOR;

    /**
     * Constructor for objects of class Elevvator
     */
    public Elevator(int topFloor, int bottemFloor)
    {
        TOP_FLOOR = topFloor;
        BOTTEM_FLOOR = bottemFloor;
        floor = BOTTEM_FLOOR; 
        direction = 'D';
    }
    
    //takes elivator to a specified floor
    public void goToFloor(int targetFloor)
    {
        int numFloors;
        //cheks that the floor destonaion is insid the bulding
        if(targetFloor >= BOTTEM_FLOOR && targetFloor <= TOP_FLOOR){
            //cheking if it should go up
            if(targetFloor > floor){
                numFloors = targetFloor - floor;
                for(int i = 0; i < numFloors; i++){
                    up();
                }
            }
            //cheking if it should go down
            else if(targetFloor < floor){
                numFloors = floor - targetFloor;
                for(int i = 0; i < numFloors; i++){
                    down();
                }
            }
            return;
        }
        else{
            return;
        }
    }
    
    //makes elivater go up one floor
    public void up()
    {
        //cheks if the elivater is going flying
        if(floor < TOP_FLOOR)
        {
            floor++;
            direction = 'U';
        }
        else{
            return;
        }
    }

    //makes elivater go down one floor
    public void down()
    {
        //cheks if the elivater is going throu the foundation.
        if(floor > BOTTEM_FLOOR)
        {
            floor--;
            direction = 'd';
        }
        else{
            return;
        }
    }
    
    public char getDirection(){
        return direction;
    }
    
    public int getFloor(){
        return floor;
    }
}
