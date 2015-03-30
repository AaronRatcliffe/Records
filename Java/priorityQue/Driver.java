import java.util.Random;
/**
 * this simulates the line at a single register of a retail stor over the course of one hower.
 * 
 * @author Aaron J. Ratcliffe
 * @version 11/16/2014
 */
public class Driver
{
    public static void main(String args[]){
        //the overall products and variables
        int numServiced = 0;
        int maxLineLength = 0;
        PriorityQueue queue = new PriorityQueue();
        PriorityCustomer beingServed = null;
        int atRegister = 0;
        //repeating the prosses every minit for one hour
        for(int i = 0; i < 60; i++){
            //creating a 25% chance for a new customer to be created
            if(new Random().nextInt(4) == 1){
                queue.addElement(new PriorityCustomer());
                if(queue.getLength() + atRegister > maxLineLength){
                    maxLineLength ++;
                }
                System.out.println("New customer added!  Queue length is now "+(queue.getLength()
                                    + atRegister));
            }

            if(beingServed != null){
                //cheking if the curent cumtomer is done being served
                if(beingServed.getServiceTime() == 0){
                    numServiced++;
                    beingServed = null;
                    atRegister = 0;
                    System.out.println("Customer serviced and removed from the queue." + 
                        " Queue length is now "+queue.getLength());
                }
                else{
                    beingServed.decServiceTime();
                }
            }

            if(!queue.isEmpty() && beingServed == null){
                beingServed = queue.removeMax();
                atRegister = 1;
            }
            System.out.println(" ------------------------------------------------------------ ");
        }
        //give final sumation
        System.out.println("\nThere were "+numServiced+" customers sucsefully served in the last houre\n"
            +" and the maximum lenght of the line was "+maxLineLength+".");
    }
}
