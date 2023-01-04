
import java.util.*;

public class QueenSimulation{

static int size=0; 
static int colToPlace; //when placing a new queen, what column should it be placed in



public static void main(String []args){

int curCol=1;
int curRow=1;
int select = 0;
boolean detect = false;
boolean run = true;
int solutionCount = 0;
Queen a = new Queen(1,1);
Queen report = new Queen(0,0);
boolean validInput = false;

Scanner scan = new Scanner(System.in);

while(validInput == false){
System.out.println("input a number between 3 and 14");
select = scan.nextInt();
if(select<4 || select > 13){
   System.out.println("numbers exceed boundary values");
   }
   else{
   validInput = true;
   size = select;
   break;
   }
}


LinkedStack<Queen> solution = new LinkedStack(); //solution is stored here
                        //(a) refers to the Queen object that changes values to be placed into the list
                        //initialize (a) 
                        //start with (a) queen at 1, 1
                        //push (a) onto stack
                        //move to next column (current coords should be 2, 1)
                        // set (a) to new coords
                           //loop
                            //test (a) against every queen in the list, moving the index to reference each queen in the list (b)
                            // store the results as true or false in an array of size equal to the number of items in the stack
                            
                            // if all values in the array are false, there are no collisions with the new queen and it can be placed
                            // push (a) to stack and move to next column (column++), and reset row
                                 //if advancing the column would exceed the size of the board, it means that there is a queen placed in every column
                                      //and we have found a solution. do not advance column and continue.
                                      //if a solution is found, set (a) to the top queen in the stack, and pop that Queen. move to the next row and repeat
                                       
                                      
                            //if a collision is found, then move (a) to the next row in the same column 
                              // if row would exceed size (N) and a queen has not been placed in that column, 
                              //backtrack to the column before current, start at the queen placed in that column. 
                              //repeat if adding 1 to the row would exceed the size of the board
                             
                              
                              
a.placeAt(1, 1);
solution.push(a);     // !!!!! push is a reference to the object, not the data of the object, so changing (a) after pushing it also changes the
curCol++;             //value in the list
a = new Queen(0,0);         //after (a) gets pushed in a stack, it needs to reference a new queen object
a.placeAt(curCol,curRow);


while(run == true){

   boolean[] collisions = new boolean[solution.size()]; //the number of the current column is equal to the number of tests to run
 
   //store the result of each collision test in an array of size equal to the number of nodes in the list
   for(int i = 0; i < solution.size(); i++){ //test our mover queen against every queen in the list
      collisions[i] = a.conflict(solution.itemAt(i)); //store either true or false in the array
   }
   
   
   
   
   
        
     //parse the array for true values. if there is a true value, set the flag (detect)
      
   for(int m = 0; m<collisions.length; m++){ //for every space in the array
         
       if(collisions[m] == true){ //if the current queens in the list collide with another
    
            detect = true;        //then the array contains a true value for collisions
       }
       else{ //otherwise 
            } //continue parsing towards the end of the array
   } 
         
   
   
   
   
   
   
   
   if(detect == true){  // if the array contains a collision, we dont need to check the column as we arent placing a queen
   
      if(curRow +1 >size){ //if advancing the row would exceed the dimensions of the board, or is at the last value,
   
         while(curRow + 1 > size){//then there are no possible places for a queen in that row, thus the queen prior must be wrong
           
             a=solution.pop();//set (a) to the top queen in the stack and remove it
            
            if(a.getRow()==size && a.getCol()==1){      //if the queen removed is at col 1 row size 
               System.out.println("number of solutions for N = "+ size + " is " + solutionCount);
               System.exit(0);     //we're done parsing, end
            }
            else{ //if the removed queen is not at the last row of the first column
               curRow = a.getRow(); //set the coords to the current queen (a) top queen in the stack
               curCol = a.getCol();
            }
         }//end while
         
         
         
         curRow++; //by nature this statement will only execute when it will not overflow, in which case we can skip to the end
         a.placeAt(curCol, curRow);
         }
         else {
            curRow++;
            a.placeAt(curCol, curRow);
         }           
             
             
   } //end detect is true
           
          
   else if(detect == false){ //if the array does not contain a collision
      a.placeAt(curCol, curRow); //put (a) at the current value
      solution.push(a); //put the queen in the stack
      a = new Queen(0,0); //make (a) reference a new queen
     
     
     
      if(curCol + 1 > size){//if advancing the column would exceed the size of the board
                                //solution has been found
                                //report the solution
         
         System.out.println("SOLUTION #" + solutionCount);
         solutionCount++;
         
                  for(int i = 0; i<solution.size(); i++){  //report is the object that stores the solution
            report = solution.itemAt(i);
            System.out.println( report.toString());
         } 
                                              //remove the last queen in the stack
         a=solution.pop(); //set a equal to the just removed queen
         curRow=a.getRow();
         curCol = a.getCol();
         //do not advance column
         //if next row exceeds boundaries
         /////////////////////////////////////////////////////////////////////  
                  
            if(curRow+1>size){
               while(curRow+1>size){
                  a=solution.pop();
                  if(a.getRow()==size && a.getCol()==1){      //if the queen removed is at col 1 row 4 
                     System.out.println("number of solutions for N = "+ size + " is " + solutionCount);
                     System.exit(0);     //we're done parsing, end
                     }
                  else{  //if the removed queen is not at the last row of the first column
                     curRow = a.getRow(); //set the coords to the current queen (a) top queen in the stack
                        curCol = a.getCol();
                  }
                      
                        
               }//end while
                           
               curRow++; //by nature this statement will only execute when it will not overflow, in which case we can skip to the end
               a.placeAt(curCol, curRow);       
               }//current row exceeds size
                          
                                
            else{ //if advancing row does not exceed the dimensions 
               curRow++;
               a.placeAt(curCol, curRow);
               }   
            ////////////////////////////////////////////////////////////////////////////
            
         
            } //end current col exceeds size
     
     
     
      else if(curCol + 1<=size){ //advancing the column will not exceed the size of the board
      curCol++;
      curRow = 1;
      a.placeAt(curCol, curRow);
      //advance the column
      //reset row
      //a references new position       
                
      }                    
                            
      }//end detect else  
      
           
   detect = false;
    
      
   }//end run
}//end main



public static void printArray(boolean[] array){  //extra debugging tool, used to print the contents of the true/false array.

for(int i = 0; i<array.length; i++){
System.out.println(array[i]);
}

}






public int getN(){ //returns the size of the board and number of queens
   
   
return this.size; 
} //end getN



}// end QueenSim