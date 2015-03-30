

/**
 * this preformes vareos functions on the contence of an array of doubles
 * 
 * @author Aaron J. Ratcliffe
 * @version 4/22/2014
 */
public class ArrayFunctions implements ArrayFunctionsInterface
{
    
    /**
     * Constructor for objects of class Implementation
     */
    public ArrayFunctions()
    {
       //no need for constructer all methods only work on input
    }

    /**
     * this takes in an array of double and sorts them in order from gratest to least
     * 
     * @param  tempDA  an array of doubles that will be sorted
     * @return     a new array that is sorted from gratest to least
     */
    public double [] sortMe(double [] tempDA)
    {
        //creating a new array to manipulate
        double [] sortedDA = new double[tempDA.length];
        
        //finding the maximom number in the array and setting the first number in sortedDA to it
        sortedDA[0] = this.getMax(tempDA);
        
        //looping throu sortedDA and setting it equal to the next height number in temDA
        for(int sort = 1; sort < sortedDA.length; sort++){
            //looping throu tempDA and finding the next height number
            for(int temp = 0; temp < tempDA.length; temp++){
                //cheking to see if the number in the array is the next height
                if(tempDA[temp] > sortedDA[sort] && tempDA[temp] < sortedDA[sort-1]){
                    sortedDA[sort] = tempDA[temp];
                }
            }
        }
        return sortedDA;
    }
    
    /**
     * this finds the largest number in the input array of doubles
     * 
     * @param  tempDA  the array of doubles that needs to be anilized
     * @return     the largest number contand in the array
     */
    public double getMax(double [] tempDA)
    {
        double maxNumD = 0;
        
        //looping throu tempDA and finding the largest number
        for(int i = 0; i < tempDA.length; i++){
            //cheking to see if the new number is larger then the curent maximum
            if(tempDA[i] > maxNumD){
                maxNumD = tempDA[i];
            }
        }
        return maxNumD;
    }
    
    /**
     * this finds the minumim number in the imput doubles array
     * 
     * @param  tempDA  the enterd double array to be anilyzed
     * @return     the minomum number in the array
     */
    public double getMin(double [] tempDA)
    {
        double minNumD = 99999999.99;
        
        //looping throu tempDA and finding the largest number
        for(int i = 0; i < tempDA.length; i++){
            //cheking to see if the new number is larger then the curent maximum
            if(tempDA[i] < minNumD){
                minNumD = tempDA[i];
            }
        }
        return minNumD;
    }
    
    /**
     * this finds the location of the input value inside of the input array
     * 
     * @param  tempDA, searchValue  the array to be serched, the value to search for
     * @return     the location of the value in the array
     */
    public int whereAmI(double [] tempDA, double searchValue)
    {
        int location = 0;
        
        //looping throu tempDA
        for(int i = 0; i < tempDA.length; i++){
            //checking if searchValue maches the value in the curent locaiotn of tempDA
            if(tempDA[i] == searchValue){
                location = i;
            }
        }
        
        return location;
    }
    
    /**
     * This takes in a double array and gives you the sum of all its numbers
     * 
     * @param  tempDA  the input array that will be added up
     * @return     the total sum of the array
     */
    public double sumMeUp(double [] tempDA)
    {
        double arraySumD = 0.0;
        
        //looping throu tempDA and addin the numbers together
        for(int i = 0; i < tempDA.length; i++){
            arraySumD += tempDA[i];
        }
        
        return arraySumD;
    }
    
    /**
     * this takes in a double array and reversis the order of the eloments in it
     * 
     * @param  tempDA  the imput array that will be reversed
     * @return     the reversed array
     */
    public double [] reverseMe(double [] tempDA)
    {
        int sizeOfArray = tempDA.length;
        //temarary holding vareobal
        double placeHolder = 0;
        
        //looping throu the array and reversing the eloments placment
        for(int i = 0; i < sizeOfArray / 2; i++){
            //setting placeHolder to the value of the curent place in the array
            placeHolder = tempDA[i];
            //changing the eloment at the curent place to the one on the opposet end of the array
            tempDA[i] = tempDA[sizeOfArray - (1+i)];
            //setting the eloment at the oposet sid of the array to placeHolder
            tempDA[sizeOfArray - (1+i)] = placeHolder;
        }
        return tempDA;
    }
    
    /**
     * This takes in an array of doubles and prints them out
     * 
     * @param  tempDA  is an array of doubles
     * @return     void
     */
    public void printMe(double [] tempDA)
    {
        // looping throu the array
        for(int i = 0; i < tempDA.length; i++){
            //printing the input array
            System.out.print(tempDA[i] + ", ");
        }
    }
    
    /**
     * This doubles the size of the input array
     * 
     * @param  tempDA  the imput array thats size will be doubled
     * @return    the new larger array
     */
    public double [] doubleMySize(double [] tempDA)
    {
        //creating empty array twice the size of tempDA
        double [] doubledDA = new double[tempDA.length * 2];
        
        //looping throu tempDA to transfer its data to the larger array
        for(int i = 0; i < tempDA.length; i++){
            doubledDA[i] = tempDA[i];
        }
        
        return doubledDA;
    }
}
