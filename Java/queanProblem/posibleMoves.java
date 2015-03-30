
/**
 * this maniges all of the moves the can be made by the agent salving the queens problem
 * 
 * @author Aaorn J. Ratcliffe
 * @version 1/31/2014
 */
public class posibleMoves
{
    private move bestMove;
    private int moveCount;
    private bord currentState;

    /**
     * Constructor for objects of class posibleMoves
     */
    public posibleMoves(bord b)
    {
        currentState = b;
        moveCount = 0;
        bestMove = new move();
        checkAllMoves();
    }
    
    /**
     * checks all posible moves that can be made and puts them into the min bestMove baced on the
     * heuristic of the bord state after each move
     * 
     * @param  null
     * @return     null
     */
    public void checkAllMoves()
    {
        bord testBord;
        int currentHeuristic = currentState.heuristic();
        int moveHeuristic;
        //going thru the columns to find the best place for each queen
        for(int column = 0; column < currentState.getNumQueens(); column++){
            //creating a duplicet bord to test the move on
            testBord = new bord(currentState);
            //seing which row the queen should be placed in
            for(int row = 0; row < currentState.getNumQueens(); row++){
                //testing the move
                testBord.makeMove(column, row);
                moveHeuristic = testBord.heuristic();
                //comparing the state with queen moved to state without queen moved
                if(moveHeuristic < currentHeuristic){
                    if(moveHeuristic < bestMove.getHeuristic()){
                        bestMove.setQueen(column);
                        bestMove.setPosition(row);
                        bestMove.setHeuristic(moveHeuristic);
                    }
                    moveCount++;
                }
            }
        }
    }
    
    /**
     * takes the top eloment of the min heap and returens it
     * 
     * @param  null
     * @return     top move in the min heap
     */
    public move nextMove()
    {
        return bestMove;
    }

    /**
     * returns the heap size
     * 
     * @param  null
     * @return     size of the min heap
     */
    public int getMoveCount()
    {
        return moveCount;
    }
    
    /**
     * returns a string of the posibleMoves class
     * 
     * @param  null
     * @return     the information form this class in string form
     */
    public String toString()
    {
        return "Neighbors found with lower Heutistic: " + moveCount;
    }
}
