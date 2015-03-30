import java.util.Random;
/**
 * This creates a XbyX bord and places X queens on it each in its owen column as long as X > 5
 * and preforms actions need to alter or check the state of the bord
 * 
 * @author Aaron J. Ratcliffe  
 * @version 1/29/2014
 */
public class bord
{
    //bord array
    private int[][] bord;
    private int numQueens;

    /**
     * Constructor for objects of class bord with queens randomly placed equal to the number of rows
     */
    public bord(int size)
    {
        bord = new int[size][size];
        numQueens = size;
        placeQueens(size);
    }

    /**
     * Constructor for objects of class bord with 8 queens randomly placed
     */
    public bord()
    {
        bord = new int[8][8];
        numQueens = 8;
        placeQueens(8);
    }

    /**
     * Constructor for objects of class bord that is a coppy of the passed in bord
     */
    public bord(bord oldBord)
    {
        numQueens = oldBord.getNumQueens();
        bord = new int[numQueens][numQueens];
        //gose thru bowth bords and coppes the satate of the oldBrod into the bord
        for(int column = 0; column < numQueens; column++){
            bord[column][oldBord.getQueen(column)]=1;
        }
    }

    /**
     * reseats the bord to a blank state and pults the proper number of queens on it
     * 
     * @paran null
     * @return null
     */
    public void reseat()
    {
        //goting throu the colums
        for(int column = 0; column < numQueens; column++){
            //replacing the queen with a blank square
            bord[column][getQueen(column)] = 0;
        }
        placeQueens(numQueens);
    }

    /**
     * places x number of queans on the bord that already exists
     * 
     * @param  num   the number of queens that is to be placed
     * @return     null
     */
    public  void placeQueens(int num)
    {
        Random getRand = new Random();
        int rand;
        //iterates thru the colems of the 2d bord array
        for(int i = 0; i < num; i++){
            //generates a random number betwean 0 and num-1
            rand = getRand.nextInt(num);
            //places a queen on a random row in the colem
            bord[i][rand] = 1;
        }
        return;
    }

    /**
     * moves a queen in the specifide colem to the input place in the same colem
     * 
     * @param  int queen, int newPosition  the queen you are moving, where you are moving it to
     * @return     null
     */
    public  void  makeMove(int queen, int newPosition){
        bord[queen][getQueen(queen)]= 0;
        bord[queen][newPosition] = 1;
    }

    /**
     * returns the state of specifide square
     * 
     * @param  int column, int row  the column of the squere you wont, the row of the square you wont 
     * @return     what is in the squere
     */
    public  int  getSquare(int column, int row){
        return bord[column][row];
    }

    /**
     * returns the queens position
     * 
     * @param  int queen  the queen you wont to find 
     * @return     the verticul position of the queen
     */
    public  int  getQueen(int queen){
        int position = 0;
        //serches down the colem untill it finds a queen
        while(bord[queen][position] == 0){
            position++;
        }
        return position;
    }

    /**
     * returns the number of queens on the bord
     * 
     * @param  null
     * @return     the number of queens on the bord
     */
    public  int  getNumQueens(){
        return numQueens;
    }

    /**
     * gives the value of the curent bord state (the lower the better)
     * 
     * @param  null
     * @return    the number of queens in danger
     */
    public int heuristic(){
        int heuristic = 0;
        //cheking each queen to see if they are in danger
        for(int queen = 0; queen < numQueens; queen++){
            if(inDanger(queen)){
                heuristic++;
            }
        }
        return heuristic;
    }

    /**
     * cheks to see if the passed in queen is in danger
     * 
     * @param  int queen   the queen you are cheking for
     * @return    wether the queen is in danger
     */
    public  boolean inDanger(int queen){
        int queensPosition = getQueen(queen);
        //cheaking the row for other queens
        for(int column = 0; column < numQueens; column++){
            if(bord[column][queensPosition] == 1){
                if(column != queen){
                    return true;
                }
            }
        }

        //Splitting the decinding diagonal check in two acrose the diagonal acses of 0-0 to x-x
        if(queen >= queensPosition){
            //iterating throu the left right of the graph and cheking for another queen on the 
            //decending diagonal
            for(int dDiag = queen-queensPosition ; dDiag <= numQueens-1; dDiag++){
                if(bord[dDiag][dDiag -(queen-queensPosition)] == 1){
                    if(dDiag != queen){
                        return true;
                    }
                }
            }
        }else{
            //iterating thru the left half of the graph and cheaking for another queen on the 
            //decending diagonal
            for(int dDiag = 0; dDiag <= numQueens-1-(queensPosition-queen); dDiag++){
                if(bord[dDiag][dDiag + (queensPosition-queen)] == 1){
                    if(dDiag != queen){
                        return true;
                    }
                }
            }
        }

        //splitting the acinding diagonal in two acrose the diagonal acses of 0-x to x-0
        if((queen+queensPosition) <= (numQueens-1)){
            //iterating thru the top half of the graph and cheaking for other queens on the 
            //acinding diagonal
            for(int aDiag = (queensPosition + queen); aDiag >= 0; aDiag--){
                if(bord[aDiag][queensPosition+queen-aDiag] == 1){
                    if(aDiag != queen){
                        return true;
                    }
                }
            }
        }else{
            //iterating thru the bottom half of the graph and cheaking for other queens on the 
            //acinding diagonal
            for(int aDiag = numQueens-1; aDiag >= queensPosition-(numQueens-1-queen);
                aDiag--){
                if(bord[aDiag][queensPosition-(numQueens-1-queen)+(numQueens-1-aDiag)] == 1){
                    if(aDiag != queen){
                        return true;
                    }
                }
            }
        }
        return false;
    }

    /**
     * cheks to see if the bord is in a salved state
     * 
     * @param  null 
     * @return    weather the bord is sloved or not
     */
    public  boolean isSalved(){
        return this.heuristic() == 0;
    }

    /**
     * puts the curent bord into a string
     * 
     * @param  null
     * @return    the bord as a string
     */
    public  String toString(){
        String bordState = "Current Heuristic: " + this.heuristic() + "\nCurrent State\n";
        //gose thru the colems
        for(int row = 0; row < numQueens; row++){
            //gose thru the columns seting them to strings
            for(int column = 0; column < numQueens; column++){
                bordState += bord[column][row];
                if(column != numQueens-1){
                    bordState += ", ";
                }
            }
            bordState += "\n";
        }
        return bordState;
    }
}
