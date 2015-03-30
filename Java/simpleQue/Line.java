
/**
 * creates a line for a stor
 * 
 * @author Aaron Ratcliffe 
 * @version 10/2/2014
 */
public class Line
{
    //makes the queue have a haed and tail ponter
    private Customer first, last;
    private int queueLength;

    /**
     * Constructor for objects of class Line
     */
    public Line()
    {
        first = null;
        last = null;
        queueLength = 0;
    }
    
    /**
     * returns the lenght of the queue
     * 
     * @param  void
     * @return     the totale objects curently in the queue
     */
    public int getLength()
    {
        return queueLength;   
    }
    
    /**
     * returns the first item in the queue
     * 
     * @param  void
     * @return     the object that is first in line
     */
    public Customer getFirst()
    {
        return first;   
    }

    /**
     * chekes to see if the queue is empty
     * 
     * @param  void
     * @return     rather it is empty or not
     */
    public boolean isEmpty()
    {
        return first == null;   
    }
    
    /**
     * adds a customer object to the queue
     * 
     * @param  n  the new customer entering the line
     * @return     void
     */
    public void enqueue(Customer n)
    {
        queueLength++;
        if(!isEmpty()){
            last.setNext(n);
        }
        else{
            first = n;
        }
        last = n;
    }
    
    /**
     * removes a Customer object form the queue and returnes the object that was removed
     * 
     * @param  void
     * @return     the object that was removed
     */
    public Customer dequeue()
    {
        Customer temp = first;
        if(!isEmpty()){
            queueLength--;
            first = first.getNext();
        }
        return temp;
    }
    
}
