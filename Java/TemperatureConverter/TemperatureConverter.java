
/**
 * this class creates an object that converts tempiture from one form to another.
 * 
 * @author Aaron Ratcliffe
 * @version 1/15/2014
 */
public class TemperatureConverter
{
    // instance variables
    private double F;
    private double C;

    /**
     * Constructor for objects of class TemperatureConverter
     */
    public TemperatureConverter(double temp, char type)
    {
        if(type == 'C' || type =='c')
        {
            C = temp;
            F = (C * 9.0) / 5 + 32;
        }
        else if(type == 'F' || type == 'f')
        {
            F = temp;
            C = (F - 32) * 5 / 9.0;
        }
        else{
        C = 0;
        F = 0;
        }
    }
    
    public void setCelcius(double temp){
        C = temp;
        F = 9.0/5.0 * C + 32;
        return;
    }
    
    public double getFahrenheit(){
        return F;
    }
    
    public double getCelcius(){
        return C;
    }
}
