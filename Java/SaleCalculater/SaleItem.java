
/**
 * creates an object of an item on sale.
 * 
 * @author Aaron J. Ratcliffe
 * @version 2/23/2014
 */
public class SaleItem
{
    // instance variables
    double taxRate;
    double itemPrice;
    double discountPercent;
    

    /**
     * Constructor for objects of class SaleItem that sets taxRate to 7.5% , the price to 0, 
     *       and the discount precent to 10%
     */
    public SaleItem()
    {
        // sets the felds to defalt values
        taxRate = 0.075;
        itemPrice = 0.0;
        discountPercent = 0.1;
    }
    
    /**
     * Constructor for objects of class SaleItem that takes three poramiters
     * 
     * @param price, tax, discount  the price of item, the tax precent on item, the discount precent
     *         on the item.
     */
    public SaleItem(double price, double tax, double discount)
    {
        // sets felds to input values divided by 100
        taxRate = tax / 100;
        itemPrice = price;
        discountPercent = discount / 100;
    }

    /**
     * sets the item price to the input value
     * 
     * @param  price   changes the item price
     * @return     no return
     */
    public void setPrice(double price)
    {
        itemPrice = price;
    }
    
    /**
     * this sets the discount percnet of the item
     * 
     * @param  discount   a sample parameter for a method
     * @return     no return
     */
    public void setDiscountPercent(double discount)
    {
        discountPercent = discount / 100;
    }
    
    /**
     * this sets the amout of tax on the item.
     * 
     * @param  tax  the precentege of tax on the item
     * @return     no return 
     */
    public void setTaxRate(double tax)
    {
        taxRate = tax / 100;
    }
    
    /**
     * this calculates and returns the final price of the item the you have to pay
     * 
     * @param  no paramiters
     * @return     the total you have to pay
     */
    public double getFinalPrice()
    {
        // vareobles
        double finalPrice;
        double preTax;
        
        //calculations
        preTax = getDiscountPrice();
        finalPrice = preTax + preTax * taxRate;
       
        return finalPrice;
    }
    
    /**
     * this takes the origonal price and aplies the discount to it
     * 
     * @param  no paramiters
     * @return     the price of the item befor tax 
     */
    public double getDiscountPrice()
    {
        // vareobles
        double subTotal;
        
        //calculations
        subTotal = itemPrice - itemPrice * discountPercent;
        
        return subTotal;
    }
    
    /**
     * this takes the origonal discount pecent and returns it
     * 
     * @param  no paramiters
     * @return     the discount percent.
     */
    public double getDiscountPercent()
    {
        return discountPercent;
    }
    
    /**
     * this takes the origonal price of the item and returns it
     * 
     * @param  no paramiters
     * @return     the price of the item to begen whith
     */
    public double getStartPrice()
    {
        return itemPrice;
    }
}
