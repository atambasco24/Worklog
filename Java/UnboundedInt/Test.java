//Andrew  Tambasco


import java.util.*;


public class LargeNumberTest{
public static void main(String []args) throws InterruptedException{

boolean run = true;

String input1;
String input2;

Scanner scan = new Scanner(System.in);

      UnboundedInt c = null;
      UnboundedInt d = null;



while(run == true){

System.out.println("What option would you like to do?");

System.out.println("1: Display both numbers");
System.out.println("2: Input 2 new numbers");
System.out.println("3: Check if numbers are equal");
System.out.println("4: Report the sum of the two numbers");
System.out.println("5: report the multiplication of the two numbers");
System.out.println("6: create and output the clone of the first number");
System.out.println("7: quit");

Thread.sleep(250);

System.out.println("Enter a number 1-7");

      int input = Integer.parseInt(scan.nextLine());


   switch(input){
   case 1:
      System.out.println(c);
      System.out.println(d);

      break;
      
   case 2:
   System.out.println("Input your first number");
      input1 = scan.nextLine();
      c = new UnboundedInt( input1 );
      
   System.out.println("Input your second number");
      input2 = scan.nextLine();
    d = new UnboundedInt( input2 );


      break;
      
   case 3:
   {
            boolean testForEquality = c.equals( d );
      if( testForEquality )
         System.out.println( c + " is equal to " + d );
      else 
         System.out.println( c + " is not equal to " + d );
     
     
     
      break;
     }
         
         
         
         
   case 4:
     
      UnboundedInt sum = c.add( d );
      System.out.println( "the sum of " + c + " + " + d + " = " + sum );

  
      break;
      
      
      case 5:

      UnboundedInt product = c.multiply(d);
      System.out.println("the result of the first number times the second number is "+ product);
      
      break;
   case 6:
   //create and output the clone of the first number
   
      UnboundedInt copy = c.clone();
      System.out.println( "the clone of " + c + " is " + copy );   
  
break;
   
   case 7:
   run = false;
   break;
   
   
   }



}



}//end main
}//end class