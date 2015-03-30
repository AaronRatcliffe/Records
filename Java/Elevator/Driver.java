import java.util.Scanner;
/**
 * Write a description of class Driver here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Driver
{
    // instance variables - replace the example below with your own

    /**
     * Constructor for objects of class Driver
     */
    public static void main(String[] arg)
    {
        //vareobles
        int bottem;
        int top;
        int target;
        int floor;
        char direction;
        Scanner s = new Scanner(System.in);
        //asking for input
        System.out.println("input the to floor of your bulding");
        top = s.nextInt();
        System.out.println("input the bottem floor");
        bottem = s.nextInt();
        System.out.println("input what floor you wish to go to");
        target = s.nextInt();
        //creation and calculation
        Elevator nom1 = new Elevator(top, bottem);
        nom1.goToFloor(target);
        //retreaving data and providing outpout
        direction = nom1.getDirection();
        floor = nom1.getFloor();
        System.out.println("the elevator is on floor " + floor + "and it is going " + direction);
    }
}
