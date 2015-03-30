
/**
 * this class creates an object that can convert curensy betwean dollars, euros, British Pounds, and yen.
 * 
 * @author Aaron J. Ratcliffe
 * @version 1/27/2014
 */
public class CurrencyConverter
{
    // currency types values compaird to the dollar
    public final double POUND_PER_D = 0.6064;
    public final double YEN_PER_D = 102.32;
    public final double EURO_PER_D = 0.7311;
    //currency type variables
    private double dollar;
    private double pound;
    private double yen;
    private double euro;

    /**
     * Constructor for objects of class CurrencyConverter
     * @parameter: double the amount of monney you have. char is the type of currency you have.
     */
    public CurrencyConverter(double amount, char currency)
    {

        // if section cheking to see what curency you are starting with
        convert(amount, currency);
    }
    
    /**
     * Perpus: sets the amount of a curency to the input amound
     * @poramitar: double is the amount of moey you have char is the type of money you have
     */
    public void setAmount(double amount, char currency){
        // if section cheking to see what curency you are starting with
        convert(amount, currency);
    }
    
    /**
     * Perpuse: converts the currency form one form to another
     * @poramitar: double is the amount of moey you have char is the type of money you have
     */
    public void convert(double amount, char currency){
    // if section cheking to see what curency you are starting with
        if(currency == 'd' || currency == 'D'){
            dollar = amount;
            pound = amount * POUND_PER_D;
            yen = amount * YEN_PER_D;
            euro = amount * EURO_PER_D;
        }
        else if(currency == 'p' || currency == 'P'){
            pound = amount;
            dollar = pound / POUND_PER_D;
            yen = dollar * YEN_PER_D;
            euro = dollar * EURO_PER_D;
        }
        else if(currency == 'y' || currency == 'Y'){
            yen = amount;
            dollar = yen / YEN_PER_D;
            pound = dollar * POUND_PER_D;
            euro = dollar * EURO_PER_D;
        }
        else if(currency == 'e' || currency == 'E'){
            euro = amount;
            dollar = euro / EURO_PER_D;
            pound = dollar * POUND_PER_D;
            yen = dollar * YEN_PER_D;
        }
        else{
            System.out.println("you have enternd an invalid curency type.");
        }
    }
    
    /**
     * Perpouse: returns the amount of money in the curency type of the users chose
     * @Pramiters: char the type of money you wish to get the value of
     */
    public double getAmount(char currency){
       if(currency == 'd' || currency == 'D'){
            return dollar;
        }
        else if(currency == 'p' || currency == 'P'){
            return pound;
        }
        else if(currency == 'y' || currency == 'Y'){
            return yen;
        }
        else if(currency == 'e' || currency == 'E'){
            return euro;
        }
        else{
            System.out.println("you have enternd an invalid curency type.");
            return 0.0;
        }
    }
}
