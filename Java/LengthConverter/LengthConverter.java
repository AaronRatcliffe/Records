
/**
 * this will create an object that will convert aney mesherment in inches, cm, and m into eachother.
 * it will acepte the input of what unit of mesherment is being input and what the mesherment is 
 * then calculate what the other mesherments are in relation to the input.
 * 
 * @author Aaron J. Ratcliffe
 * @version 2/2/2014
 */
public class LengthConverter
{
    //relations of mesherment unets
    private final double CM_TO_INCHES = 2.54;
    private final double CM_TO_M = 100;
    private final double INCHES_TO_FEET = 12;
    
    // mesherment types acsepted and converted to
    private double feet;
    private double inches;
    private double cm;
    private double m;
    
    private double desplayLength;

    /**
     * Constructor for objects of class LengthConverter that takes the unet of mesherment aswell as 
     * the length mesherd and passes it into the converter class inorder to receave all the relitive
     * mesherments.
     */
    public LengthConverter(double length, char type)
    {
        //calls the converter method to change the input data into all its relitive forms.
        converter(length, type);
    }
  
    /**
     * this takes in the input and converts the length of one type in to its equivolents in all the
     * other types.
     * 
     * @param  length  how long is the mesherment
     * @param  type     what type of mesherment it is like inches, feet, cm, m exetora
     */
    private void converter(double length, char type)
    {
        // chking what type it is
        switch(type){
            case 'I':
            case 'i':   inches = length;
                        feet = inches / INCHES_TO_FEET;
                        cm = inches * CM_TO_INCHES;
                        m = cm / CM_TO_M;
                        break;
            case 'F':
            case 'f':   feet = length;
                        inches = feet * INCHES_TO_FEET;
                        cm = inches * CM_TO_INCHES;
                        m = cm / CM_TO_M;
                        break; 
            case 'C':
            case 'c':   cm = length;
                        m = cm / CM_TO_M;
                        inches = cm / CM_TO_INCHES;
                        feet = inches * INCHES_TO_FEET;
                        break;
            case 'M':
            case 'm':   m = length;
                        cm = m * CM_TO_M;
                        inches = cm / CM_TO_INCHES;
                        feet = inches * INCHES_TO_FEET;
                        break;
            default:    inches = feet = cm = m = 0.0;
        }
    }
    
    /**
    * this method reseaves a new input for bowth the type of mesherment aswell
    * as the lenght and then re calculates all of the converted mesherments to fit the new
    * numbers.
    * 
    * @param length  is how long the new mesherment is
    * @param type   is the kind of mesherment that is being input
    */
   public void setLength(double length, char type)
   {
       //calls the converter method to do the recalculating fo the lingthes for the new input
       converter(length, type);
   }
   
   /**
    * this method takes the vareose mesherment types and acording to what you wont to see 
    * it desplayes the relitive information about the convertion
    * 
    * @param show  tells what type of mesherment you wish to see
    */
   public double getLength(char show)
   {
       // chking what type will be desplayed
        switch(show){
            case 'I':
            case 'i':   desplayLength = inches;
                        break;
            case 'F':
            case 'f':  desplayLength = feet;
                        break; 
            case 'C':
            case 'c':   desplayLength = cm;
                        break;
            case 'M':
            case 'm':   desplayLength = m;
                        break;
            default:    desplayLength = 0.0;
        }
   return desplayLength;
   }
}