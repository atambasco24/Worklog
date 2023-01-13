#include <iostream>
#include <fstream>
#include <string>

using namespace std;
//functions to implement
//void printBoard() -prints the board
//setDifficulty(int)  input from user that determines the number of traps on the board
//add(row, col)    adds a trap at a location:throws error if there is already a trap there-can be called from game
//remove(row, col) removes a trap at location:throws error if there is no trap-can be called from game
//moveUp();
//moveDown();
//moveLeft();
//moveRight();



int row; //contains the current row the player is in 
int col; //contains the current column the player is in

int getRow=0;
int getCol=0;

int rowsize=10; //number of rows
int colsize=10; //number of columns

int randRow;//randomly places traps
int randCol; 

#define MAX_COLS 10
#define MAX_ROWS 0

void printBoard(int r, int c, char arr[r][c]);


int main(){




char board[rowsize-1][colsize-1]; //initializes the board

for(getRow=0;getRow<rowsize;getRow++){              
   for(getCol=0;getCol<colsize;getCol++){           
      board[getRow][getCol] = '_';                   
   
   }
}

//printboard()

getRow=0;
getCol=0;
for(getRow=0;getRow<rowsize;getRow++){
  cout<<endl;
   for(getCol=0;getCol<colsize;getCol++){
   cout<<board[getRow][getCol]<<" ";
   }
}

board[5][5]='X';



return 0;
}//end main

void printBoard(int r, int c, char array[][]){



}//end printboard