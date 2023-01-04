import java.util.*;

public class SequenceTest{

public static void main(String[] args){

DoubleArraySeq c = new DoubleArraySeq();
Scanner scan = new Scanner(System.in);

int choice = 0;
int other = 0;
double item =0;
boolean run = true;
System.out.println("New objects created");



while(run == true){


System.out.println("type the number of your choice and hit enter");

System.out.println("1.	Print out to screen the sequence");
System.out.println("2.	Report the capacity of sequence");
System.out.println("3.	Set the current element location ");
System.out.println("4.	Add a number to the front of the sequence");
System.out.println("5.	Add a number to the end of the sequence");
System.out.println("6.	Add a number before the current element ");
System.out.println("7.	Add a number after the current element ");
System.out.println("12.	Quit");

choice = scan.nextInt();


      if(choice == 1){
      try{
       System.out.println();
       }
       catch(){
      
       }
      } //end 1
      
      
      
      else if(choice == 2){
      
      }
      
      
      else if(choice == 3){

   
      }//end 3
      
      else if(choice == 4){
      

      }
      
      else if(choice == 5){
      try{

      }
      catch(){
   }
      
      else if(choice == 6){
      

      }
      
      
      else if(choice == 7){   

      }
      
      
   
   
   
}//end run




}//end main
}//end class

/*
1.	Print out to screen the sequence (uses toString( ) )
2.	Report the capacity of sequence (uses getCapacity( ) )
3.	Set the current element location (uses setCurrent(int) )
4.	Add a number to the front of the sequence ( uses addFront(double) )
5.	Add a number to the end of the sequence (uses size( ), setCurrent (int) and addAfter(double) )

Note: for choices 6 and 7 the location to add the new value is referenced to where the current element is. And you will need to ask the user for the number to add.
6.	Add a number before the current element (uses addBefore(double) )
7.	Add a number after the current element (uses addAfter(double) )
8.	Delete the first number from the sequence (uses removeFront( ) )

Note: for choices 9 and 10 the location to display or delete is asked for.  This is not an index value, the user will give you a location (the first location is index zero)
9.	Delete a number at a location (uses setCurrent(int) and removeCurrent( ) )
10.	Display the value at a certain location (uses getElement(int) )
11.	Display the last element in the sequence(uses size( ), setCurrent(int) and getCurrent( ) )
12.	Quit




*/