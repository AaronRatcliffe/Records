import java.util.Scanner;
/**
 * it is the program that creates a LenghtConverter object inorder to get the ralitive lenghts of a 
 * mesherment in sevral mesherment forms.
 * 
 * @author Aaron J. Ratcliffe
 * @version 2/2/2014
 */
public class Driver
{
    /**
     * this askes the user for there input asto what the lenght and mesherment type they are starting
     * with aswell as what they wish to convert it into. it then creates an object of LenghtConverter 
     * pluges in the input and then desplays the result and akes wether the user would like 
     * to run the program aggen.
     */
    public static void main(String [] arg)
    {
        // initialise instance variables
        Scanner s = new Scanner(System.in);
        char type;
        char changeTo;
        double length;
        double changeLength = 0.0;
        char repeat;
        char runProgram;
        
        //loop for reruning the program
        do{
            //ask the user for input
            System.out.println("Input the first letter of the type of measuerment you are using (I/F/C/M): ");
            type = s.nextLine().charAt(0);
            System.out.println("Input the lenght of your measuerment: ");
            length = s.nextDouble();
            s.nextLine();
            System.out.println("Input the first letter of the type of measuerment you wont to convert to (I/F/C/M): ");
            changeTo = s.nextLine().charAt(0);
            
            //creates LengthConverter object
            LengthConverter lConverter = new LengthConverter(length, type);
            
            //alters the object to get the measurement output that you wonted 
            changeLength = lConverter.getLength(changeTo);
           
            //gives you your output of the measurement
            System.out.println("You started with " + length + "/" + type);
            System.out.println("You have " + changeLength + "/" + changeTo);
            
            //chekes if you wish to do a nother convertion
            System.out.println("Do yo wish to change to another mesurement (y/n): ");
            repeat = s.nextLine().charAt(0);
            
            while(repeat == 'y' || repeat == 'Y'){
                System.out.println("Input the first letter of the type of measuerment you wont to convert to (I/F/C/M): ");
                changeTo = s.nextLine().charAt(0);
                //changes to another measurement
                lConverter.setLength(length, type);
                //prints the changed measurement
                changeLength = lConverter.getLength(changeTo);
                System.out.println("You started with " + length + "/" + type);
                System.out.println("You have " + changeLength + "/" + changeTo);
                
                System.out.println("Do yo wish to change another measurment (y/n): ");
                repeat = s.nextLine().charAt(0);
            }
            
            //chekes if you wish run the program aggen with a difrent measurement amount.
            System.out.println("Do yo wish to run the program aggen with a difrent measurement (y/n): ");
            runProgram = s.nextLine().charAt(0);
        }while(runProgram == 'y' || runProgram == 'Y');
    }
}
