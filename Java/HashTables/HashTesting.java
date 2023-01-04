//Andrew Tambasco
import java.util.*;
import java.io.*;


public class HashTesting{
   public static void main(String[] args){
   
   Table<Integer, String> LinearTable = new Table<Integer, String>(241); //Table stores the arrays of where the keys and elements are placed
   TableDoubleHash<Integer, String> DoubleTable= new TableDoubleHash<Integer, String>(241);
   TableChainHash<Integer, String> ChainTable = new TableChainHash<Integer, String>(241);
   try{
   Scanner read = new Scanner(new File("names.txt"));
   
   
  
   
   
  System.out.println("Name    Linear      Double       Chained"); 
   for(int i = 0; i<200; i++){
      String name = read.next();
      int key = read.nextInt();
   ChainTable.put(key, name);
   LinearTable.put(key, name);  
   DoubleTable.put(key, name);
  
   
 
   System.out.println(name + "          " + LinearTable.getCollisions(i) + "        " +DoubleTable.getCollisions(i) +"          " +ChainTable.getCollisions(i) );
    
  
   
   
   
   }//end for
   
   
   System.out.println("Average collisions per table element: Linear: " + LinearTable.getLinearAverage() + " Double: " +  DoubleTable.getDoubleAverage() + " Chain:" + ChainTable.getChainAverage() );
   
      
   }//end try
   
  
   
   
   
   catch(FileNotFoundException e){
     System.out.println("file not found");
   }
   
   }
}