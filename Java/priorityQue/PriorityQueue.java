

/**
 * creates a priority line for a stor
 * 
 * @author Aaron Ratcliffe 
 * @version 11/16/2014
 */
public class PriorityQueue
{
    private PriorityCustomer [] heap;
    private int length;

    /**
     * Creates a heep array for PriorityCustomers
     */
    public PriorityQueue()
    {
        length = 0;
        heap = new PriorityCustomer[60];
    }
    
    /**
     * returns the lenght of the PriorityQueue
     * 
     * @param  void
     * @return     the totale objects curently in the queue
     */
    public int getLength()
    {
        return length;   
    }
    
    /**
     * returns the first item in the queue
     * 
     * @param  void
     * @return     the object that is first in line
     */
    public PriorityCustomer getFirst()
    {
        return heap[0];   
    }

    /**
     * chekes to see if the queue is empty
     * 
     * @param  void
     * @return     rather it is empty or not
     */
    public boolean isEmpty()
    {
        return heap[0] == null;   
    }
    
    /**
     * adds a customer object to the queue
     * 
     * @param  n  the new customer entering the line
     * @return     void
     */
    public void addElement(PriorityCustomer n)
    {
        length++;
        int currentPosition = length-1;
        if(isEmpty()){
            heap[0] = n;
        }
        else{
            //adds the new object to the bottem of the heap
            heap[currentPosition]= n;
            //ittirates throu the heap comparing it and sorting it into a max heap sturchuer
            while(currentPosition != 0 &&
            heap[currentPosition/2].getPriority() < heap[currentPosition].getPriority()){
                heap[currentPosition] = heap[currentPosition/2];
                currentPosition /=2;
                heap[currentPosition] = n;
            }
            
        }
    }
    
    /**
     * removes a PriorityCustomer object form the queue and returnes the object that was removed
     * 
     * @param  void
     * @return     the object that was removed
     */
    public PriorityCustomer removeMax()
    {
        PriorityCustomer max = heap[0];
        int currentPosition = 0;
        PriorityCustomer temp;
        if(!isEmpty()){
            //replacing the max object with the one that was last in the heap
            heap[0] = heap[length-1];
            //removing the last object in the heap
            heap[length-1] = null;
            temp = heap[0];
            length--;
            //compairing the root to each of its children untill it is in its correct place
            while(currentPosition*2+1 < length){
                int leftChild = currentPosition*2+1;
                int rightChild = currentPosition*2+2;
                int leftWeaght = heap[leftChild].getPriority();
                int rightWeaght = 0;
                int greaterChild = leftChild;
                //cheking if right child exists
                if(heap[rightChild] != null){
                    rightWeaght = heap[rightChild].getPriority();
                }
                //cheking if the right child has grater priority then the left child
                if(rightWeaght > leftWeaght){
                    greaterChild = rightChild;
                }
                //cheking if the chiled with the heighter priority has greater priority then the root
                if(heap[greaterChild].getPriority() > heap[currentPosition].getPriority()){
                    //swaping the root and the larger child
                    heap[currentPosition] = heap[greaterChild];
                    heap[greaterChild] = temp;
                    currentPosition = greaterChild;
                }
                else{
                    break;
                }
            }
        }
        return max;
    }
    
}
