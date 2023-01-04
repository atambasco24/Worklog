//Andrew  Tambasco


import java.util.*;


public class LargeNumberTest{
public static void main(String []args) throws InterruptedException{

boolean run = true;

String input1;
String input2;

Scanner scan = new Scanner(System.in);

      UnboundedInt c = new UnboundedInt("0");
      UnboundedInt d = new UnboundedInt("0");
      UnboundedInt sum = new UnboundedInt("0");
      UnboundedInt product = new UnboundedInt("0");
      UnboundedInt cN = new UnboundedInt("0");


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
         System.out.println(c.toString());
         System.out.println(d.toString());
         
         
      break;
   case 2:
   System.out.println("inout is 2");
            System.out.println("Input your first number");
      input1 = scan.nextLine();
      c = new UnboundedInt( input1 );
      
   System.out.println("Input your second number");
      input2 = scan.nextLine();
    d = new UnboundedInt( input2 );
 
      break;
      
   case 3:
   try{
         boolean testForEquality;
         if(c.equals(d))
            System.out.println("values are equal in value");
         else if(c.equals(d)==false){
            System.out.println("values are not equal");
         }
         break;
       }
       catch(NullPointerException e){
       System.out.println("one or more values is null");
       }
       
         
   case 4:
     
      sum = c.add(d);
      System.out.println("Linked list result is ");
     
      sum.printList();
       System.out.println("\n");
      System.out.println(sum.toString());
      System.out.println("");
      break;
      
   case 5:
      product = c.multiply(d);
      System.out.println("Linked list result is ");
     
      product.printList();
       System.out.println("\n");
      System.out.println(product.toString());
      System.out.println("");
      
      break;
   
   case 6:
   cN = c.clone();
   cN.printList();
   System.out.println("\n");
   System.out.println(cN.toString());
   System.out.println("");
   break;
   case 7:

   run = false;
   break;
   
   }



}



}//end main
}//end class