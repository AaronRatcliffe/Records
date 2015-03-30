import java.util.Scanner;
/**
 * This solves the Queens problem by using a Hill climing AI for eaght queens problem 
 * but it works with any number of queens four or over.
 * 
 * @author Aaorn J. Ratcliffe
 * @version 1/29/2014
 */
public class runProblem
{
    private static int numRestarts = 0;
    private static int numMoves = 0;
    public static void main(String args[]){
        Scanner keybordIn = new Scanner(System.in);
        int numQueens = 0;
        boolean isSalved;
        //validating that the number of queens is grater then 4
        while(numQueens < 4){
        //asking for input
        System.out.println("Please enter the number of queen's you wish to salve for.(must be grater than 4)");
        numQueens = keybordIn.nextInt();
       }
       //creating bord of size numQueens
       bord bord = new bord(numQueens);
       move nextMove = new move();
       posibleMoves pMoves = new posibleMoves(bord);
       move[] oldPosition = {new move(), new move()};
       System.out.println(bord);
       System.out.println(pMoves);
       //working thru the problem untill it is slaved
       while(!bord.isSalved()){
           while(pMoves.getMoveCount() > 0){
               oldPosition[0] = new move(nextMove);
               nextMove = pMoves.nextMove();
               //cheks to see if the agent is moving one queen back and forth
              if(nextMove.equals(oldPosition[0]) || nextMove.equals(oldPosition[1])){
                  nextMove = reseat(bord);
                  oldPosition[0] = new move();
                }
                else{
                    bord.makeMove(nextMove.getQueen(),nextMove.getPosition());
                    numMoves++;
                    System.out.println("Setting new current state\n");
                }
              System.out.println(bord);
              oldPosition[1]= new move(oldPosition[0]);
              pMoves = new posibleMoves(bord);
              System.out.println(pMoves);
            }
             
           if(!bord.isSalved()){
                reseat(bord);
                pMoves = new posibleMoves(bord);
                oldPosition[0] = new move(); 
                oldPosition[1] = new move();
            }
        }
        System.out.println("Solution Found!\nState changes: " + numMoves + "\nRestarts: " + numRestarts);
    }

    /**
     * ree seats the problem
     * 
     * @param  bord   what the curent bord state is
     * @return     a reseat next move
     */
    public static move reseat(bord curentState)
    {
        numRestarts++;
        numMoves++;
        curentState.reseat();
        System.out.println("RESTART\n");
        return new move();
    }
}
