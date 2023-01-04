//Andrew Tambasco
import java.util.*;


public class UnboundedInt implements Cloneable{

private int manyNodes;
IntNode front;
IntNode back;
IntNode cursor;


public UnboundedInt(String number){   //WORKING

boolean placeLoop = true;
String partial = "";                                        //partial takes care of the section of the string to be converted to a node
String remainder = number.substring(0, number.length());    //remainder deals with anything not in partial
int digitsLeft = number.length();
int parsedInt = 0;

while(placeLoop = true){

   if(digitsLeft<=3){
  
   partial = remainder.substring(0, remainder.length());     
                                     //if the input string is less than 3 digits, everything can be placed in partial
   remainder = "";
   digitsLeft = 0;
   parsedInt = Integer.parseInt(partial);   //turn the string of 3 digits in partial into an integer
   }
      else if(digitsLeft>3){                //if there are more than 3 digits in the input string                                  
      partial = remainder.substring(remainder.length()-3, remainder.length());  //place the final 3 digits of the string in partial
      remainder = remainder.substring(0, remainder.length()-3);     //the remainder is everything else not in partial
      digitsLeft = digitsLeft -3;                                 //decrement digitsleft by 3
      parsedInt = Integer.parseInt(partial);            //turn the string of 3 digits in partial into an integer
      }
  
     
     
     if(manyNodes==0){          //if the UnboundedInt object is empty
   front = null;
   back = null;
   cursor = null;



IntNode firstNode= new IntNode(parsedInt,null); //parse int for data
front=firstNode; 

back=firstNode;
cursor=firstNode;

manyNodes++;                //make a new node and place partial in the node
} 
else{                             //otherwise
   cursor.addNodeAfter(parsedInt);  //place partial after the current node     
   cursor=cursor.getLink();
   back=cursor;
   manyNodes++;
}

  if(digitsLeft == 0){       //when there are no digits left in the original string,
   placeLoop = false;         //stop trying to place numbers
   break;
   }  


}//end while


}//end constructor





 
public UnboundedInt multiply(UnboundedInt b){
int nodeIndex = 0;
int bNodeIndex = 0;
int bOnodes = 0;
int Onodes = 0;
int total0nodes = 0;
int bignum = 0;
int smallnum = 0;
int result = 0;

UnboundedInt total = new UnboundedInt("0"); //stores the total to be returned
UnboundedInt adder = new UnboundedInt("0"); //stores value to be added to total

b.cursor = b.front;
this.cursor = this.front;
adder.cursor = adder.front;      //set all cursors to the front of each list

for(bNodeIndex = 0; bNodeIndex<b.manyNodes; bNodeIndex++){ //for every node in b
   for(nodeIndex = 0; nodeIndex<this.manyNodes; nodeIndex++){  //for every node in a
      result = b.cursor.getData() * cursor.getData();      //multiply node in a by node in b
      bignum = result / 1000;   //store bignumber
      smallnum = result % 1000; //store small number
      
      adder.cursor = adder.front;         //move cursor to the front of the list to reference the 0, link is null
                                          //as adder only contains a single node with value 0
      
             adder.cursor.addNodeAfter(smallnum);                     //place the smallnum and bignum in adder
             adder.cursor=adder.cursor.getLink();
             adder.back=adder.cursor;
             adder.manyNodes++;
             if(bignum != 0){                            //if the first 3 of the 6 digits is 0, then dont place it
                adder.cursor.addNodeAfter(bignum);        
                adder.cursor=adder.cursor.getLink();
                adder.back=adder.cursor;
                adder.manyNodes++;
            }
            else{}
      
      total0nodes = Onodes + bOnodes;  
      addZeroes(total0nodes, adder);     //see addZeroes
      
      
      total = adder.add(total);
        adder = new UnboundedInt("0"); //clear the value in adder              
      cursor = cursor.getLink();
      Onodes++;
   } // end nodes in a
   
Onodes = 0; //reset number of nodes to the left of the active node of a to 0       
cursor = front; //move the cursor of a to the front
b.cursor = b.cursor.getLink(); //advance b to the next node
bOnodes++; // number of nodes to the left of the active node in b is one more

} // end nodes in B
return total;
}//end multiply

 
 
 
 

 
 
 
 
 
 
 
 
 
 
 //returns a clone of the given object
   public UnboundedInt clone( )
   {  
      UnboundedInt answer;
      
      try
      {
         answer = (UnboundedInt) super.clone( );
      }
      catch (CloneNotSupportedException e)
      { 
         throw new RuntimeException
         ("This class does not implement Cloneable");
      }
      
      answer.front = IntNode.listCopy(front);
      
      return answer;
   }
 
 
 
 
 
 
 
 public boolean equals(Object obj){   //WORKING
 boolean result = true;
 boolean looping = true;
   if(obj instanceof UnboundedInt){                                              
      UnboundedInt tester = (UnboundedInt) obj;         //set the object to be an unboundedint                         
         if(tester.manyNodes == manyNodes){                 //if both objects have the same number of nodes               
            
            cursor = front;
            tester.cursor = tester.front;
               for(int i = 0; i<manyNodes; i++){                  //loop through the list
              
                  if(cursor.getData() != tester.cursor.getData()){ //if the data of the cursor node does not equal the data of the tester cursor node
                   
                     result = false;      //then numbers are not equal
                  }
                  else{             //otherwise
                     result = true;
                     cursor = cursor.getLink();               //move both nodes ahead by 1               
                     tester.cursor = tester.cursor.getLink();
                        if(cursor == null){                   //if moving the cursor makes us reach the end of the list
                        result = true;               //then every node of each list is equal
                        return result;
                        }
                  
                  }
               
               }
            
            
               
         }                                                              
         else{
         result = false;
         }
         }
 return result;
 }
 
 
   

//method to dynamically add the correct number of groups of 0
public void addZeroes(int groups, UnboundedInt target){

target.cursor = target.front; //ensure the target is at the front. this method is intended to be called on an UnboundedInt
                             // with list format [0]->[x]->[y]. this method adds groups of 0 at the front of the list
if(groups != 0){             // then removes the leading [0].

   for(int i = 0; i<groups; i++){     //for every group,
             target.cursor.addNodeAfter(0);     //add a node of 0 
             target.cursor=target.cursor.getLink();
             target.back=target.cursor;
             target.manyNodes++;
   }
}
else{}
target.front = target.front.getLink();
target.manyNodes--;
}









public UnboundedInt add(UnboundedInt a){
a.start();
start(); //set both cursors to node 0 of each list
int result = 0;
int carry = 0;

boolean oneCursorIsNull = false;
boolean bothCursorsAreNull = false;   //you get one guess what these do

UnboundedInt sum = new UnboundedInt("0");                                       // front -> [_0_] <-  back

while(oneCursorIsNull != true){                                   //Handles everything while both numbers have valid nodes (not null)

result = a.cursor.getData() + cursor.getData() + carry;
carry = result / 1000;
result = result % 1000;

   sum.cursor.addNodeAfter(result);
   sum.cursor=sum.cursor.getLink();
   sum.back=sum.cursor;
   sum.manyNodes++;
                 
a.advance();
advance();



if(a.cursor == null){                             //if one number is longer than the other, move on to the next
oneCursorIsNull = true;                           // while loop to continue adding to 0
}
if(cursor == null){
oneCursorIsNull = true;
}
if(a.cursor == null && cursor == null){        //this will only execute if both numbers are the same length
   bothCursorsAreNull = true;
   }
}//end while                                  

while(bothCursorsAreNull == false){          //if both numbers are the same length, this while is skipped         
   if(a.cursor == null){                     // this loop only activates if numbers are not the same length
   result = getCursorValue() + carry;
   advance();
   }
   else if(cursor == null){
   result = a.getCursorValue() + carry;
   a.advance();
   }
   
   
carry = result / 1000;                   // add nodes after
result = result % 1000;
   sum.cursor.addNodeAfter(result);
   sum.cursor=sum.cursor.getLink();
   sum.back=sum.cursor;
   sum.manyNodes++;

if(a.cursor == null && cursor == null){       //when both cursors are null, both numbers are out of numbers to add,
   bothCursorsAreNull = true;                   // so stop trying to add numbers
   }
} //end while both cursors are null



if(carry>0){                              //if theres a carry left, add it to the end of the sum

   sum.cursor.addNodeAfter(carry);
   sum.cursor=sum.cursor.getLink();
   sum.back=sum.cursor;
   sum.manyNodes++;
   carry = 0;
}



sum.cursor = sum.front;           //remove the front node
sum.cursor = sum.cursor.getLink();
sum.removeFrontNode();
sum.manyNodes--;

return sum;
} //end add
   
   
   
   
   
      
public int getCursorValue(){
return cursor.getData();
}
 
   
 
 
public String toString(){
int zeros=0;
cursor = front;

String answer = "";
String partial = "";

for(int i = 0; i < manyNodes; i++){

if(cursor.getLink() != null){
   if(cursor.getData()<100){
      zeros++;
   }
   if(cursor.getData()<10){
   zeros++;
   }
   
   
   if(zeros == 0){
   partial = cursor.getData() + "";
   }
   if(zeros == 1){
   partial = "0" + cursor.getData() + "";
   }
   if(zeros == 2){
   partial = "00" + cursor.getData();   
   }


}
else if(cursor.getLink()==null){
partial = cursor.getData() + "";
}
answer =partial + "," + answer;
cursor = cursor.getLink();
zeros = 0;
}

return answer;
} 






public String toStringNoCommas(){
int zeros=0;
cursor = front;

String answer = "";
String partial = "";

for(int i = 0; i < manyNodes; i++){

if(cursor.getLink() != null){
   if(cursor.getData()<100){
      zeros++;
   }
   if(cursor.getData()<10){
   zeros++;
   }
   
   
   if(zeros == 0){
   partial = cursor.getData() + "";
   }
   if(zeros == 1){
   partial = "0" + cursor.getData() + "";
   }
   if(zeros == 2){
   partial = "00" + cursor.getData();   
   }


}
else if(cursor.getLink()==null){
partial = cursor.getData() + "";
}
answer =partial + "" + answer;
cursor = cursor.getLink();
zeros = 0;
}

return answer;
} 



















 
 
 
public void printList(){      //EXTRA
int i = 0;
start();

for(i = 0; i<manyNodes; i++){
System.out.print("[" + getCursorValue() + "] -> ");
advance();
}

}   
   
   
   
   
   
//An explanation as to why I have this method
//when I instantiate a new linked list of object type UnboundedInt, it automatically makes a 
//singular new node if the length of the string entered at instantiation is less than or equal to 3 digits.
// adding (and multiplying) creates a new list that can be returned. Having this method eliminates a step from 
//the adding process where a new node would need to be created if the number of nodes in the resulting list is 0
// by creating a new list with one node, we can just add a node after the current node, then when the adding 
//process is done, remove the front node, and we should have a complete list of the resultant in reverse order.   
   
  
public void removeFrontNode(){         

front = front.getLink();

}  
   
   
void start( ){
this.cursor = this.front;
}
   
   
   
   
void advance( ){
cursor = cursor.getLink();
}

  


}//end class