import java.util.Random;
/**
 * this simulates the line at a single register of a retail stor over the course of one hower.
 * 
 * @author Aaron J. Ratcliffe
 * @version 10/6/2014
 */
public class Driver
{
   public static void main(String args[]){
       //the overall products and variables
       int numServiced = 0;
       int maxLineLength = 0;
       Line queue = new Line();
       //repeating the prosses every minit for one hour
       for(int i = 0; i < 60; i++){
           //creating a 25% chance for a new customer to be created
           if(new Random().nextInt(4) == 0){
               queue.enqueue(new Customer());
               if(queue.getLength() > maxLineLength){
                   maxLineLength ++;
                }
               System.out.println("New customer added!  Queue length is now "+queue.getLength());
            }
           
           if(!queue.isEmpty()){
               //updating the curent customer
               if(queue.getFirst().getServiceTime()== 0){
                   queue.dequeue();
                   numServiced++;
                   System.out.println("Customer serviced and removed from the queue." + 
                                      " Queue length is now "+queue.getLength());
                }
               else{
                   queue.getFirst().decServiceTime();
                }
           }
           System.out.println(" ------------------------------------------------------------ ");
        }
        //give final sumation
        System.out.println("\nThere were "+numServiced+" customers sucsefully served in the last houre\n"
                           +" and the maximum lenght of the line was "+maxLineLength+".");
    }
}
