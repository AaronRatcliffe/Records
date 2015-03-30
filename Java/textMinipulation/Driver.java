import java.util.*;
import java.io.*;
/**
 * Write a description of class Driver here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Driver
{

    /**
     * Constructor for objects of class Driver
     */
    public static void main(String [] args) throws IOException
    {
        //vareobles
        String readFile;
        String writeFile = "outSentence.txt";
        Scanner inFile;
        Scanner keybordIn = new Scanner(System.in);
        PrintWriter outFile;
        Converter changeString;
        
        //asking for user input
        System.out.println("Enter the address of the file you wish to read from: ");
        readFile = keybordIn.nextLine();
        
        //creating objects to be used
        outFile = new PrintWriter(new File(writeFile)); 
        inFile = new Scanner(new File(readFile));
        changeString = new Converter(" ");
        
        while(inFile.hasNext())
        {
            changeString.setNewString(inFile.nextLine());
            outFile.println(changeString);
            System.out.println(changeString);
        }
        outFile.close();
        inFile.close();
    }
}
