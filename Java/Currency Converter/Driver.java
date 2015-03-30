import java.util.Scanner;
/**
 * this program akes the user for an amount of curency and thin outpouts the convertied value
 * of that curency in a difrent demonination.
 * 
 * @author Aaron J. Ratcliffe
 * @version 1/27/2014
 */
public class Driver
{
    /**
     * Constructor for objects of class Driver
     */
    public static void main(String [] arg)
    {
        // initialise instance variables
        Scanner s = new Scanner(System.in);
        char type;
        char changeTo;
        double money;
        double changeMoney = 0.0;
        char repeat;
        char runProgram;
        
        //loop for reruning the program
        do{
        //ask the user for input
        System.out.println("Input the first letter of the type of curency you are inputing (D/P/Y/E): ");
        type = s.nextLine().charAt(0);
        System.out.println("Input the amount of money you are giving: ");
        money = s.nextDouble();
        s.nextLine();
        System.out.println("Input the first letter of the type of curency you wont to convert to (D/P/Y/E): ");
        changeTo = s.nextLine().charAt(0);
        
        //creates currency converter object
        CurrencyConverter cConverter = new CurrencyConverter(money, type);
        
        //alters the object to get the curency output that you wonted 
        changeMoney = cConverter.getAmount(changeTo);
       
        //gives you your output of the curency
        System.out.println("You started with $" + money + " in " + type);
        System.out.println("You have $" + changeMoney + " in " + changeTo);
        
        //chekes if you wish to do a nother convertion
        System.out.println("Do yo wish to convert to anoter curency (y/n): ");
        repeat = s.nextLine().charAt(0);
        
        while(repeat == 'y' || repeat == 'Y'){
            System.out.println("Input the first letter of the type of curency you wont to convert to (D/P/Y/E): ");
            changeTo = s.nextLine().charAt(0);
            //changes to another curency
            cConverter.setAmount(money, type);
            //prints the changed curency
            changeMoney = cConverter.getAmount(changeTo);
            System.out.println("You started with $" + money + " in " + type);
            System.out.println("You have $" + changeMoney + " in " + changeTo);
            
            System.out.println("Do yo wish to convert to anoter curency (y/n): ");
            repeat = s.nextLine().charAt(0);
        }
        
        //chekes if you wish run the program aggen with a difrent monney amount
        System.out.println("Do yo wish to run the program aggen with a difrent amount of monney (y/n): ");
        runProgram = s.nextLine().charAt(0);
    }while(runProgram == 'y' || runProgram == 'Y');
    }
}
