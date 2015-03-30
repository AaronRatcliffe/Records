
/**
 * this contains all informaiton about a move that can be made
 * 
 * @author Aaron J. Ratcliffe
 * @version 1/31/2014
 */
public class move
{
    private int queen;
    private int position;
    private int heuristic;
    
    /**
     * Constructor for objects of class move
     */
    public move(int queen, int position)
    {
        queen = queen;
        position = position;
    }
    
    /**
     * Constructor for objects of class move
     */
    public move(int queen, int position, int heuristic)
    {
        queen = queen;
        position = position;
        heuristic = heuristic;
    }
    
    /**
     * Constructor for objects of class move
     */
    public move(move oldMove)
    {
        this.queen = oldMove.getQueen();
        this.position = oldMove.getPosition();
    }
    
    /**
     * Constructor for objects of class move
     */
    public move()
    {
        queen = -1;
        position = -1;
        heuristic = 999999999;
    }

    /**
     * gets which queen is being moved
     * 
     * @param  null
     * @return     the queen that is being moved 
     */
    public int getQueen()
    {
        return queen;
    }
    
    /**
     * changes the queen being moved
     * 
     * @param  int  the new queen you wish to set
     * @return     null
     */
    public void setQueen(int newQueen)
    {
       queen = newQueen;
    }
    
    /**
     * gets where the queen is moving
     * 
     * @param  null
     * @return     the new space the queen will go to 
     */
    public int getPosition()
    {
        return position;
    }
    
    /**
     * gets the heuristic of the move
     * 
     * @param  null
     * @return     the value of the move 
     */
    public int getHeuristic()
    {
        return heuristic;
    }
    
    /**
     * set the heuristic of the move
     * 
     * @param  int heuristic  what you wish to set it to
     * @return     null
     */
    public void setHeuristic(int newHeuristic)
    {
        heuristic = newHeuristic;
    }
    
    /**
     * set where the queen is moving
     * 
     * @param  int row  sets the row where the queen is moving to
     * @return     null
     */
    public void setPosition(int row)
    {
        position = row;
    }
    
    /**
     * cheks to see if this move is equsl to a difrent move
     * 
     * @param  move    oldMove
     * @return     weather the move has been made befor 
     */
    public boolean equals(move oldMove)
    {
        return this.getQueen() == oldMove.getQueen() && this.getPosition() == oldMove.getPosition();
    }
    
    /**
     * prints out what the move is
     * 
     * @param  null
     * @return     string of the information about the move
     */
    public String toString()
    {
        return "Queen: "+queen+" move to "+" colum:"+queen+" row: "+position+" move heuristic: "+heuristic;
    }
}
