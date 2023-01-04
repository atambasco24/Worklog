import java.lang.Math;

public class Queen{

private int column;   //x coord
private int row;     //y coord



//o	toString( ) which returns a string  such as “row = x, column = y”
//o	conflict( Queen )  - send in a Queen and return a Boolean to represent if queens are in conflict
//o	constructor, accessors, and mutators if needed


QueenSimulation sim = new QueenSimulation();

public Queen(int column, int row){

this.row = row;
this.column = column;

}








public boolean conflict(Queen comparator){
int altRow = this.row;
int altCol = this.column;
int rowDif = 0;
int colDif = 0;

colDif = this.column - comparator.getCol();
rowDif = this.row - comparator.getRow();


int size = sim.getN();
boolean result=false; //true if there is a conflict, false if not

if(this.column == comparator.column){
   //      System.out.println("found vertical collision between queens at " + this.column + "," + this.row + " and " + comparator.getCol() + "," + comparator.getRow());
   result = true;

}
else if(this.row == comparator.row){
 //System.out.println("found horizontal collision between queens at " + this.column + "," + this.row + " and " + comparator.getCol() + "," + comparator.getRow());

   result = true;
}

else if(Math.abs(rowDif) == Math.abs(colDif)){ 
               
  //       System.out.println("found diagonal collision between queens at " + this.column + "," + this.row + " and " + comparator.getCol() + "," + comparator.getRow());
         result= true;
         
}
else{

//System.out.println("there is no conflict");
result = false;  //if none of the cases execute, there is no conflict

}//end else

return result;

}//end conflict




public String toString(){
String answer;

answer = "[column = " + column + ", row = " + row + "]"; 
return answer;
}





public int getRow(){
return this.row;
}

public int getCol(){
return this.column;
}


public void placeAt(int x , int y){ //place a queen at given coordinates



column = x;
row = y;


}//end placeAt





} //end queen