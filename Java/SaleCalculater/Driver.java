import java.util.Scanner;
/**
 *this fiel creates a SaleItem object asces the user for input and then preforms calculaitons
 *      to determan how mutch the user should pay and wether they are due aney change.
 * 
 * @author Aaron J. Ratcliffe
 * @version 2/23/2014
 */
public class Driver
{
    /**
     * Constructor for objects of class Driver
     */
    public static void main(String[] arg)
    {
        // create vareobles
        double discountPrice;
        double finalPrice;
        double changeDue;
        double moneyPayed;
        char repeatProgram;

        //loop determans if program will repeat
        do{
            //create objects
            Scanner keybordS = new Scanner(System.in);
            SaleItem purchase = new SaleItem();

            for(int i = 1; i < 3; i++){
                //determans witch question will be asked
                if(i == 1){
                    //ask for user input
                    System.out.print("Input the price of your item: ");
                    purchase.setPrice(keybordS.nextDouble());
                }
                else{
                    //ask for user input
                    System.out.print("Input the new discont precent: ");
                    purchase.setDiscountPercent(keybordS.nextDouble());
                }
                //ask for user input
                System.out.print("How mutch money did you give them: $");
                moneyPayed = keybordS.nextDouble();

                //preform calculations
                discountPrice = purchase.getDiscountPrice();
                finalPrice = purchase.getFinalPrice();
                changeDue =  moneyPayed - finalPrice;
                
                // give output
                System.out.println("The original price of the item was $" + purchase.getStartPrice() + "\n" + 
                                    "With the discount, the price was $" + discountPrice + "\n" + 
                                    "The final price of the item is $" + finalPrice + 
                                    " and you should have $" + changeDue + " in change." );
            }
            System.out.print("Do you wish to inter a new item: (Y/N) ");
            repeatProgram = keybordS.next().charAt(0);
        }while(repeatProgram == 'y' || repeatProgram == 'Y');
    }
}
