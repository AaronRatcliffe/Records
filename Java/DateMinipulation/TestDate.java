import java.util.*;
/**
 * this testes each of the methods in the Date class
 * 
 * @author Aaron Ratcliffe
 * @version 3/26/2014
 */
public class TestDate
{
   public static void main(String [] args)
   {
       //declaring variobles
       int newDayI, newMunthI, newYearI;
       String newMunthS;
       
       //setting arrays of refrences
       Date [] date = new Date[10];
       
       //declaring objects
       Scanner keybordIn = new Scanner(System.in);
       
       //disclamer
       System.out.println("My date class only works for dates on or after 1/1/0001");
       
       //asking for input repeatedly 
       for(int i = 0; i < 4; i++){
           System.out.print("Enter the day: ");
           newDayI = keybordIn.nextInt();
           
           System.out.print("Enter the year: ");
           newYearI = keybordIn.nextInt();
           
           System.out.print("Enter the month in words or numbers: ");
           //cheking to see what form of month you enterd
           if(keybordIn.hasNextInt()){
               newMunthI = keybordIn.nextInt();
               //creating the new date
               date[i] = new Date(newMunthI, newDayI, newYearI);
            }
            else{
                newMunthS = keybordIn.next();
                //creating the new date
                date[i] = new Date(newMunthS, newDayI, newYearI);
                keybordIn.nextLine();
            }
            //testing toString and getLongDate methods
            System.out.println("Date " + (i + 1) + " is " + date[i] + " or " + date[i].getLongDate()+"\n");
        }
       //testing defalt constructer
       System.out.println("Creating a new date from defalt constructer.");
       date[4] = new Date();
       System.out.println("Date 5 is " + date[4] + "\n");
       
       //testing clone constructer
       System.out.println("Creating a new date by cloning date 2 " + date[1]+ " :");
       date[5] = new Date(date[1]);
       System.out.println("Date 6 is " + date[5]+ "\n");
       
       //testing the add method to add days to the date
       System.out.println("Enter a number of days that you wish to add to date 1 " + date[0]+ " :");
       newDayI = keybordIn.nextInt();
       date[6] = date[0].add(newDayI);
       System.out.println("You added " + newDayI + " days to the date " + date[0] 
                          + ". The new date is " + date[6]+ "\n");
                          
       //testing subtract method to subtract days off of a date
       System.out.println("Enter a number of days that you wish to subtract from date 3 " + date[2]+ " :");
       newDayI = keybordIn.nextInt();
       date[7] = date[2].subtract(newDayI);
       System.out.println("You subtracted " + newDayI + " days from the date " + date[2] 
                          + ". The new date is " + date[7]+ "\n");
                          
       //testing the isLeapYear method to see if the date occers dering a leep year
       System.out.println("The date " + date[4] + " is a leep year: " + date[4].isLeapYear()+ "\n");
       
       //testing the static isLeapYear method to see if the date occers dering a leep year
       System.out.println("Enter a year to see if it is a leap year: ");
       newYearI = keybordIn.nextInt();
       System.out.println(newYearI + " is a leep year: " + Date.isLeapYear(newYearI)+ "\n");
       
       //testing the dateDiff method to see what the difrentce is betwean two dates
       System.out.println(date[3] + " and " + date[7] + " are " + date[3].dateDiff(date[7]) 
                          + " days appart."+ "\n");
       
       //testing setYear method
       System.out.println("Input a new year to set to date 3 " + date[2] + " : ");
       date[2].setYear(keybordIn.nextInt());
       System.out.println("The new date 3 is " + date[2]+ "\n");
       
       //testing getYear method
       System.out.println("The year for date 6 " + date[5] + " is " + date[5].getYear()+ "\n");
       
       //testing setMonth method with number 
       System.out.println("Input a new month for date 4 " + date[3] + " in numerical form: ");
       date[3].setMonth(keybordIn.nextInt());
       System.out.println("The new date 4 is " + date[3]+ "\n");
       
       //testing getMonth method
       System.out.println("The month for date 4 " + date[3] + " is " + date[3].getMonth()+ "\n");
       
       //testing setMonth method with the name of the month
       System.out.println("Input a new month for date 7 " + date[6] + " in name form: ");
       date[6].setMonth(keybordIn.next());
       System.out.println("The new date 7 is " + date[6]+ "\n");
       
       //testing getMonthName method
       System.out.println("The month for date 7 " + date[6] + " is " + date[6].getMonthName()+ "\n");
       
       //testing setDay method
       System.out.println("Input a new day for date 4 " + date[3] + ": ");
       date[3].setDay(keybordIn.nextInt());
       System.out.println("The new date 4 is " + date[3]+ "\n");
       
       //testing getDay method
       System.out.println("The month for date 4 " + date[3] + " is " + date[3].getDay()+ "\n");
       
       //testing compairYear method
       System.out.println("Compairing years (-1 is < ,0 is =, 1 is >): " + date[6] + " " +
                            date[6].compairYear(date[2]) + " " + date[2]+ "\n");
                            
       //testing compairMonth method
       System.out.println("Compairing months (-1 is < ,0 is =, 1 is >): " + date[6] + " " +
                            date[6].compairMonth(date[2]) + " " + date[2]+ "\n");
                            
       //testing compairDay method
       System.out.println("Compairing days (-1 is < ,0 is =, 1 is >): " + date[6] + " " +
                            date[6].compairDay(date[2]) + " " + date[2]+ "\n");
       
       //testing equals method
       System.out.println(date[2] + " is equal to " + date[4] + ": " + date[2].equals(date[4])+ "\n");
       
       //testing compairTo method
       System.out.println("Compairing dates (-1 is < ,0 is =, 1 is >): " + date[6] + " " +
                            date[6].compairTo(date[2]) + " " + date[2]+ "\n");
       
    }
}
