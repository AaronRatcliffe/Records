import java.util.*;
import java.io.*;
/**
 * @name Converter
 * 
 *this class takes an input string finds the numbers in it and cahnges the apropreot ones
 *into words
 * 
 * @author Aaron J. Ratcliffe 
 * @version 2/27/2014
 * @lab L06
 */
public class Converter
{
    // instance variables - replace the example below with your own
    private String startString;
    private StringBuilder stringChange;
    private String changedString;

    /**
     * Constructor for objects of class Converter with no input
     * @param no paramiter
     */
    public Converter() throws IOException
    {
        //vareobles
        String readFile = "dataIn.txt";
        String writeFile = "outSentence.txt";
        Scanner inFile;
        PrintWriter outFile;
        
        //creating objects to be used
        outFile = new PrintWriter(new File(writeFile)); 
        inFile = new Scanner(new File(readFile));
        while(inFile.hasNext())
        {
            setNewString(inFile.nextLine());
            outFile.println(toString());
            System.out.println(toString());
        }
        outFile.close();
        inFile.close();
    }

    /**
     * Constructor for objects of class Converter with the input of a string
     * @param stringIn is the string that you input that you wish to change
     */
    public Converter(String stringIn)
    {
        // initialise instance variables
        setNewString(stringIn);
    }

    /**
     * @name  setNewString(String)
     *  
     * this takes in a new string and creates a StringBuilder to alter it
     * 
     * @param  stringIn   the string that will be alterd
     * @return     there is no return
     */
    public void setNewString(String stringIn)
    {
        //setes the starting string
        startString = stringIn;
        //creates a StringBilder so the origonal can be changed
        stringChange = new StringBuilder(startString);
        convert();
    }

    /**
     * @name convert()
     * 
     * this converts a string into a string that is gromaticly corect in regard to numbers
     * 
     * @param  no paramiters
     * @return     there is no return
     */
    public void convert()
    {
        //gose throu the input string caricter by charictor
        for(int i = 0; i < stringChange.length(); i++){
            //cheks to see if the char it is cerintly on is a number
            if(Character.isDigit(stringChange.charAt(i))){
                //chekes to see if the number is at index 0
                if(i == 0 &&
                !Character.isDigit(stringChange.charAt(i + 1))){
                    changeNumberToWord(i);
                    stringChange.setCharAt(i, Character.toUpperCase(stringChange.charAt(0)));
                }
                //chekes to see if the number is at the end
                else if(i == stringChange.length() + 1 &&
                !Character.isDigit(stringChange.charAt(i - 1))){
                    changeNumberToWord(i);
                }
                //chekes to see if the number is >= 10
                else if(!Character.isDigit(stringChange.charAt(i - 1)) &&
                !Character.isDigit(stringChange.charAt(i + 1))){
                    changeNumberToWord(i);
                }
            }
        }
        changedString = new String(stringChange);
    }

    /**
     * @Name changeNumberToWord(int)
     * 
     * this takes in the digits location and changes it to its apropreot word form
     * 
     * @param  i   the charicter index that the number is located at in the string
     * @return     there is no return
     */
    public void changeNumberToWord(int i)
    {
        //determans whitch number it is and chages them to there word form
        switch (stringChange.charAt(i)) {
            case '0': stringChange.replace(i, i+1, "zero");
            break;
            case '1': stringChange.replace(i, i+1, "one");
            break;
            case '2': stringChange.replace(i, i+1, "two");
            break;
            case '3': stringChange.replace(i, i+1, "three");
            break;
            case '4': stringChange.replace(i, i+1, "four");
            break;
            case '5': stringChange.replace(i, i+1, "five");
            break;
            case '6': stringChange.replace(i, i+1, "six");
            break;
            case '7': stringChange.replace(i, i+1, "seven");
            break;
            case '8': stringChange.replace(i, i+1, "eaght");
            break;
            case '9': stringChange.replace(i, i+1, "nine");
            break;
            default: ;
        }
    }

    /**
     * @Name getChangedString()
     * 
     * this outputs the string after it has ben changed
     * 
     * @param  no paramiter
     * @return     the final string after alteration
     */
    public String getChangedString()
    {
        return changedString;
    }

    /**
     * @name getStartingString()
     * 
     *this outputs the origonal string that will be alterd
     * 
     * @param  no paramiter
     * @return     the origonal string
     */
    public String getStartString()
    {
        return startString;
    }

    /**
     * @name toString()
     * 
     * this gives you the output that you wish to print
     * 
     * @param  no param
     * @return    a formated string of the information you wonted
     */
    public String toString()
    {
        return getChangedString();
    }
}
