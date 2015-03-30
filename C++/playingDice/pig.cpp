/*
Program: Pig
Author: Aaron J. Ratcliffe
Lab section: L02
Date: 4/14/2014
Purpose: This program plays a simple single dice game agenst the user called pig.

Algorithm: 1)the user takes there turn using the userTurn function and detormans how manny
            times they role before holding.
           2)check to see if the user won.
           3)let the computer take its turn with the npcTurn function.
           4)check to see if the computer won.
           5)repeat the program until someone wins the game.
           6)check to see who won and print appropreat messige.
*/
#include <iostream>
#include <ctime>
#include <algorithm>

using namespace std;

//function that creates the users turn
void userTurn(int & score, bool & gameOver);

//function that exicutes the computers turn
void npcTurn(int & score, bool & gameOver);

//function that genorates the number the die lands on
int roleDice();

int main()
{
    //variobles
    int score[2] = {0};
    bool gameOver = false;

    //loops throu the turnes untill someone wins
    do{
        //you take your turn
        userTurn(score[0], gameOver);

        cout << endl;

        //the computer takes its turn
        npcTurn(score[1], gameOver);

        cout << endl;

    }while(!gameOver);

    //checks to see who won
    if(score[0] > score[1]){
        cout << "You defeated the computer with a score of " << score[0]
             << " to " << score[1] << endl;
    }
    else{
        cout << "The computer beat you with a score of " << score[1]
             << " to " << score[0] << ". \n You must be unlucky today.\n";
    }

    return 0;
}

/*
Name: userTurn
Purpose: this repeats the users turn until they ether decide to hold or they role a one
         and there temporary score becomes zero.
Param: score , gameOver  score is the total score of the user and gameOver tells weather
        or not the game has already bean won.
Return: there is no return but it dose change the param score and the param gameOver based
        on the roles.
*/
void userTurn(int & score, bool & gameOver)
{
    //temporary score for what you will make this turn
    int turnScore = 0;
    int diceFace = 0;
    char userChose = ' ';

    //checking to see if the npc has already won
    if(!gameOver){
        do{
           //rolling the dice
            diceFace = roleDice();

            //checking to see if the player has lost there turn
            if(diceFace > 1){
                //adding new points
                turnScore += diceFace;

                //providing feedback
                cout << "You rolled a " << diceFace << " your new turn score is " << turnScore << endl;

                do{
                //asking for input
                cout << "Do you wish to role again (R) or hold (H): ";
                cin >> userChose;
                //validating the input
                }while(userChose != 'R' && userChose != 'r' && userChose != 'H' && userChose != 'h');
            }
            else{
                //nugating your turn score for rolling a 1
                turnScore = 0;

                //providing failyer feedback
                cout << "You rolled a " << diceFace << " and you lost all of your turn points." << endl;
            }
        //checking to see if the player will role again
        }while((userChose == 'R' || userChose == 'r') && turnScore != 0);

        //adding the points for the turn to your total
        score += turnScore;

        //providing main score feedback
        cout << "You scored " << turnScore << " points this turn and your new main score is now " << score << endl;

        //checking to see if you won the game
        if(score >= 100){
            gameOver = true;
        }
    }
}

/*
Name: npcTurn
Purpose: this repeats the computers turn until it ether acumulates 20 points in this turn
        or it roles a one and there temporary score becomes zero.
Param: score , gameOver  score is the total score of the computer and gameOver tells weather
        or not the game has already bean won.
Return: there is no return but it dose change the param score and the param gameOver based
        on the roles.
*/
void npcTurn(int & score, bool & gameOver)
{
//temporary score for what you will make this turn
    int turnScore = 0;
    int maxTurnScore = 20;
    int diceFace = 0;

    //checking to see if the npc has already won
    if(!gameOver){
        do{
           //rolling the dice
            diceFace = roleDice();

            //checking to see if the player has lost there turn
            if(diceFace > 1){
                //adding new points
                turnScore += diceFace;

                //providing feedback
                cout << "The computer rolled " << diceFace << " it's turn score is now " << turnScore << endl;

            }
            else{
                //nugating your turn score for rolling a 1
                turnScore = 0;

                //providing failyer feedback
                cout << "The computer rolled " << diceFace << " and lost all of it's turn points." << endl;

            }
        //checking to see if the computer has taken its max turns.
        }while(turnScore < maxTurnScore && turnScore != 0);

        //adding the points for the turn to your total
        score += turnScore;

        //providing main score feedback
        cout << "The computer got " << turnScore << " points this turn and now has a main score of " << score << endl;

        //checking to see if you won the game
        if(score >= 100){
            gameOver = true;
        }
    }
}

/*
Name: roleDice
Purpose: this will genorate a random number between one and six to simulate rolling a
         standered six sided die.
Param: no parameters
Return: this returns the random number between one and six that was created in the funciton.
*/
int roleDice()
{
    //inishalizing the random number function
    srand(time(0));
    //creating and returing a random number between 1 and 6
    return (rand() % 6 + 1);
}
