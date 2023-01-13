//Andrew Tambasco

#include <iostream>
#include <fstream>
#include <string>
#include <stdio.h>      
#include <stdlib.h>
#include <time.h>
using namespace std;

//prototypes
void printBoard();
void setBoard();
void setPlayer();
void setGoal();
void makeSpace();
void setTraps();
void moveUp();
void moveDown();
void moveLeft();
void moveRight();
void aimove();

//global variables

int row;//current row the player is on
int col; //current col the player is on
char ch; //used for input
int r1;                     
int r2;                      
int r3;                      

int c1;                     
int c2;                     
int c3; 

char board[10][10];          //initializes the board

int rowsize=10;              //10x10 game board
int colsize=10;

int main(){
srand (time(NULL));
bool run = true;    //see comments in line 54 and 55
                        /////////////////////////////////////////////////////
setBoard();
setPlayer();
setGoal();                //Calls all initialization functions
setTraps();
makeSpace();
printBoard();          ///////////////////////////////////////////////////////
cout<<"To play, type w, a, s, or d, to move up, left, down, and right, respectively. Press enter to confirm the movement.";


while(run==true){             //i use "bool run" a lot. Its a general boolean I use that controls a while loop and if it should keep
                             // "running" or not. Thus, if run is false, stop running. 
cin>>ch;

if(ch=='w'){

if(board[row-1][col]=='A'){      /////////////////////////////////////
run = false;                      //detect a collision with a trap
cout<<"Game over";                //if there is a collision, end the game
return 0;                        ////////////////////////////////////////
}


moveUp();
aimove();             //enemy movement



}//end w


else if(ch=='a'){

if(board[row][col-1]=='A'){//////////////////////////////////  
run = false;             //detect a collision with a trap
cout<<"Game over";       //if there is a collision, end the game
return 0;               ////////////////////////////////////////////
}

moveLeft();               //move function
aimove();             //enemy movement

}//end a


else if(ch=='d'){

if(board[row][col+1]=='A'){////////////////////////////////////////////
run = false;               //detect a collision with a trap
cout<<"Game over";          //if there is a collision, end the game
return 0;                    /////////////////////////////////////////////
}


moveRight();          //move
aimove();
 
}//end d


else if(ch=='s'){

if(board[row+1][col]=='A'){  ///////////////////////////////////////////
run = false;                           //detect a collision with a trap
cout<<"Game over";                    //if there is a collision, end the game
return 0;                  //////////////////////////////////////////
}

moveDown();                //move
aimove();

}//end s


if(row==9 && col ==9){       //detect player reaching the goal
cout<<"You win";            //win sequence
return 0;
}
}//end while run
return 0;
}//end main



void setBoard(){           //initializes the game board
int curr_row =0;
int curr_col =0;
for(curr_row=0;curr_row<rowsize;curr_row++){              
   for(curr_col=0;curr_col<colsize;curr_col++){           
      board[curr_row][curr_col] = '_';                   
   }
}
}//end setBoard

void printBoard(){            //updates the game board
int curr_row =0;
int curr_col =0;
for(curr_row=0;curr_row<rowsize;curr_row++){ 
cout<<endl;             
   for(curr_col=0;curr_col<colsize;curr_col++){           
      cout<<board[curr_row][curr_col]<<" ";                   
    }
}
}//end printBoard

void setPlayer(){        //initializes  the player character

board[0][0]='X';
row=0;
col=0;
}

void setGoal(){       //initializes the goal actor

board[9][9] = 'O';

}

void makeSpace(){          //makes shit look nice

cout<<endl;
cout<<endl;
cout<<endl;
cout<<endl;
cout<<endl;
cout<<endl;
cout<<endl;
cout<<endl;
cout<<endl;
cout<<endl;

}

void setTraps(){            //randomly generates traps in the game board

                
                  

r1 = 1 + (rand() % 8);      ///////////////////////////////////////////////////////////////////////
r2 = 1 + (rand() % 8);
r3 = 1 + (rand() % 8);

                              // generates all the random coordinates
c1 = 1 + (rand() % 8);
c2 = 1 + (rand() % 8);
c3 = 1 + (rand() % 8);
                           /////////////////////////////////////////////////////////////////////////

board[r1][c1] = 'A';     
board[r2][c2] = 'A';
board[r3][c3] = 'A';

}




                        //moveRight, moveLeft, moveUp, and moveDown are all in charge of moving the player character when called
void moveRight(){       //in case you couldn't tell, this function is in charge of moving the player character right
                        //each move method is broken up into 2 parts, the overlap identifier, and the mover.
                        
//this is the overlap identifier                        
if(col+1>9){
board[row][col]='_'; //the overlap identifier detects when a player would move off the game board
col=-1;}              //and instead loops them back to the front or back of the gameboards column or row
                     //depending on which direction they moved off the board in
                      //it starts by detecting if moving in a direction would make the coordinates greater than the range of the board
                     //then sets the player character's location to an empty space, and sets the column or row to one greater or less than the 
                     //range of the board. This way, when the coordinates update, the updated value is in the range of the board.
                     //the function goes on to move the player character as normal
                     
//this is the mover
board[row][col+1]='X'; //whatever space the player is moving to, set that space as the player character.
board[row][col]='_';   //update the current space to a blank space
col=col+1; //updates coordinates
makeSpace(); //makes it look pretty
printBoard(); //updates the game board
                           //every move method works basically the same, just different directions.
}



void moveUp(){           //moves up
if(row-1<0){            
board[row][col]='_';    
row=10;                  

}
board[row-1][col]='X';
board[row][col]='_';
row=row-1;
makeSpace();
printBoard();
}



void moveDown(){            //moves down
if(row+1>9){
board[row][col]='_'; 
row=-1;              
}
board[row+1][col]='X';
board[row][col]='_';
row=row+1;     
makeSpace();
printBoard(); 
}



void moveLeft(){             //moves left
if(col-1<0){
board[row][col]='_';
col=10;
}
board[row][col-1]='X'; 
board[row][col]='_';
col=col-1;  
makeSpace();
printBoard(); 
}



void aimove(){
int ai1direction = 1 + (rand() % 4);
int ai2direction = 1 + (rand() % 4);
int ai3direction = 1 + (rand() % 4);

//1
if(ai1direction ==1){ // move up
   if(board[r1-1][c1]=='X' || r1 - 1 < 1){ 
      }
   else{                            
      board[r1][c1] = '_';
   board[r1-1][c1] = 'A';
   r1 = r1 -1;
  
   }
}
else if(ai1direction == 2){ //move right
 if(board[r1][c1 + 1]=='X' || c1 + 1 > 8){
 }
 else{
 board[r1][c1] = '_';
 board[r1][c1+1]='A';
 c1 = c1 + 1;
 }
}
else if(ai1direction == 3){
if(board[r1+1][c1]=='X' || r1 + 1 > 8){}
else{
board[r1][c1]='_';
board[r1+1][c1]='A';
r1=r1+1;
}
}
else if(ai1direction == 4){
if(board[r1][c1-1]=='X' || c1 -1 < 1){}
else{
board[r1][c1]='_';
board[r1][c1-1]='A';
c1=c1-1;
}

}


//2
if(ai2direction ==1){ // move up
   if(board[r2-1][c2]=='X' || r2 - 1 < 1){ 
      }
   else{                            
      board[r2][c2] = '_';
   board[r2-1][c2] = 'A';
   r2 = r2 -1;
   }
}
else if(ai2direction == 2){ //move right
 if(board[r2][c2 + 1]=='X' || c2 + 1 > 8){
 }
 else{
 board[r2][c2] = '_';
 board[r2][c2+1]='A';
 c2 = c2 + 1;
 }
}
else if(ai2direction == 3){
if(board[r2+1][c2]=='X' || r2 + 1 > 8){}
else{
board[r2][c2]='_';
board[r2+1][c2]='A';
r2=r2+1;
}
}
else if(ai2direction == 4){
if(board[r2][c2-1]=='X' || c2 -1 < 1){}
else{
board[r2][c2]='_';
board[r2][c2-1]='A';
c2=c2-1;
}

}

//3
if(ai3direction ==1){ // move up
   if(board[r3-1][c3]=='X' || r3 - 1 < 1){ 
      }
   else{                            
      board[r3][c3] = '_';
   board[r3-1][c3] = 'A';
   r3 = r3 -1;
   }
}
else if(ai3direction == 2){ //move right
 if(board[r3][c3 + 1]=='X' || c3 + 1 > 8){
 }
 else{
 board[r3][c3] = '_';
 board[r3][c3+1]='A';
 c3 = c3 + 1;
 }
}
else if(ai3direction == 3){
if(board[r3+1][c3]=='X' || r3 + 1 > 8){}
else{
board[r3][c3]='_';
board[r3+1][c3]='A';
r3=r3+1;
}
}
else if(ai3direction == 4){
if(board[r3][c3-1]=='X' || c3 -1 < 1){}
else{
board[r3][c3]='_';
board[r3][c3-1]='A';
c3=c3-1;
}

}
makeSpace();
printBoard();
}