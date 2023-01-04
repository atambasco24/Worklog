// File: DoubleArraySeq.java 

// This is an assignment for students to complete after reading Chapter 3 of
// "Data Structures and Other Objects Using Java" by Michael Main.


/******************************************************************************
* This class is a homework assignment;
* A DoubleArraySeq is a collection of double numbers.
* The sequence can have a special "current element," which is specified and 
* accessed through four methods that are not available in the bag class 
* (start, getCurrent, advance and isCurrent).
*
* @note
*   (1) The capacity of one a sequence can change after it's created, but
*   the maximum capacity is limited by the amount of free memory on the 
*   machine. The constructor, addAfter, 
*   addBefore, clone, 
*   and concatenation will result in an
*   OutOfMemoryError when free memory is exhausted.
*   <p>
*   (2) A sequence's capacity cannot exceed the maximum integer 2,147,483,647
*   (Integer.MAX_VALUE). Any attempt to create a larger capacity
*   results in a failure due to an arithmetic overflow. 
*
* @note
*   This file contains only blank implementations ("stubs")
*   because this is a Programming Project for my students.
*
* @see
*   <A HREF="../../../../edu/colorado/collections/DoubleArraySeq.java">
*   Java Source Code for this class
*   (www.cs.colorado.edu/~main/edu/colorado/collections/DoubleArraySeq.java)
*   </A>
*
* @version
*   March 5, 2002
******************************************************************************/
public class DoubleArraySeq implements Cloneable
{
   // Invariant of the DoubleArraySeq class:
   //   1. The number of elements in the sequences is in the instance variable 
   //      manyItems.
   //   2. For an empty sequence (with no elements), we do not care what is 
   //      stored in any of data; for a non-empty sequence, the elements of the
   //      sequence are stored in data[0] through data[manyItems-1], and we
   //      don't care what's in the rest of data.
   //   3. If there is a current element, then it lies in data[currentIndex];
   //      if there is no current element, then currentIndex equals manyItems. 
   private double[ ] data;
   private int manyItems;
   private int currentIndex; 
   
   /**
   * Initialize an empty sequence with an initial capacity of 10.  Note that
   * the addAfter and addBefore methods work
   * efficiently (without needing more memory) until this capacity is reached.
   * @param - none
   * @postcondition
   *   This sequence is empty and has an initial capacity of 10.
   * @exception OutOfMemoryError
   *   Indicates insufficient memory for: 
   *   new double[10].
   **/   
   public DoubleArraySeq( )
   {
      data = new double[10];
   }
     

   /**
   * Initialize an empty sequence with a specified initial capacity. Note that
   * the addAfter and addBefore methods work
   * efficiently (without needing more memory) until this capacity is reached.
   * @param initialCapacity
   *   the initial capacity of this sequence
   * @precondition
   *   initialCapacity is non-negative.
   * @postcondition
   *   This sequence is empty and has the given initial capacity.
   * @exception IllegalArgumentException
   *   Indicates that initialCapacity is negative.
   * @exception OutOfMemoryError
   *   Indicates insufficient memory for: 
   *   new double[initialCapacity].
   **/   
   public DoubleArraySeq(int initialCapacity)
   {
   
      if(initialCapacity <= 0){
          throw new IllegalArgumentException("capacity is less than or equal to 0");
      }
      else{}
       
   
  
      }  
 
   /**
   * Add a new element to this sequence, after the current element. 
   * If the new element would take this sequence beyond its current capacity,
   * then the capacity is increased before adding the new element.
   * @param element
   *   the new element that is being added
   * @postcondition
   *   A new copy of the element has been added to this sequence. If there was
   *   a current element, then the new element is placed after the current
   *   element. If there was no current element, then the new element is placed
   *   at the end of the sequence. In all cases, the new element becomes the
   *   new current element of this sequence. 
   * @exception OutOfMemoryError
   *   Indicates insufficient memory for increasing the sequence's capacity.
   * @note
   *   An attempt to increase the capacity beyond
   *   Integer.MAX_VALUE will cause the sequence to fail with an
   *   arithmetic overflow.
   **/
   public void addAfter(double element)
   {
      
      double[] bigarray;                  
      
      
      if(manyItems == data.length){ //if the array is full
         bigarray = new double[data.length+1]; //create a new array that is one greater than the size of the current array
         
         if(currentIndex + 1 == data.length){ //if current index is at the last spot in the array
         System.out.println("array is full and current index is the last spot in the array");                             
            System.arraycopy(data, 0, bigarray, 0, manyItems);  //copy data to bigarray;
            bigarray[currentIndex+1] = element; //set the new node equal to the new element
            data = bigarray;
            
      }
         else if(currentIndex + 1 < data.length){ //if CurrentIndex is somewhere in the middle of the array
         System.out.println("array is full and currentindex is in the middle of the array"); //DEBUG
         System.arraycopy(data, 0, bigarray, 0, currentIndex+1); //copy everything up to where the new element should be placed
         bigarray[currentIndex+1] = element; //place the element
         System.arraycopy(data, currentIndex+1, bigarray, currentIndex+2, manyItems-(currentIndex+1));
         data = bigarray;
         }
      
      
      } // end if the array is full
            else if(manyItems < data.length){
               if(currentIndex+1 == manyItems){//if current index refers to the last value in the array
                  System.out.println("array not full and current index is the final entry in the array");
                  data[currentIndex+1] = element;
               }
               
               else if(currentIndex+1<manyItems){
               System.out.println("array not full and current index is somewhere in the middle of the array");
               
             System.arraycopy(data, currentIndex+1, data, currentIndex+2, manyItems-(currentIndex+1));
             data[currentIndex+1] = element;
               }
            } //array is not full
            
      currentIndex++;
      manyItems++;
      } //end addafter

   


   /**
   * Add a new element to this sequence, before the current element. 
   * If the new element would take this sequence beyond its current capacity,
   * then the capacity is increased before adding the new element.
   * @param element
   *   the new element that is being added
   * @postcondition
   *   A new copy of the element has been added to this sequence. If there was
   *   a current element, then the new element is placed before the current
   *   element. If there was no current element, then the new element is placed
   *   at the start of the sequence. In all cases, the new element becomes the
   *   new current element of this sequence. 
   * @exception OutOfMemoryError
   *   Indicates insufficient memory for increasing the sequence's capacity.
   * @note
   *   An attempt to increase the capacity beyond
   *   Integer.MAX_VALUE will cause the sequence to fail with an
   *   arithmetic overflow.
   **/
   public void addBefore(double element)
   {
      double bigarray[];
      
       if(manyItems == data.length){ //if the array is full
       bigarray = new double[data.length+1];
       
       
            if(currentIndex == 0){ //if currentIndex is the first element of the sequence
            System.out.println("array is full and index is first element");
            System.arraycopy(data, 0, bigarray, 1, manyItems);
            bigarray[currentIndex] = element;
            data = bigarray;
            }
            
       else if(currentIndex != 0){ //if array is full and currentindex is not the first element of the sequence
       System.out.println("array is full and currentindex is somewhere in the middle");
       System.arraycopy(data, 0, bigarray, 0, currentIndex);
       bigarray[currentIndex] = element;
       System.arraycopy(data, currentIndex, bigarray, currentIndex + 1, manyItems-(currentIndex));
       data = bigarray;
      }
      
      }//end array full
      else if(manyItems < data.length){ //if array is not full
      
            if(currentIndex == 0){ //currentindex is first element
        System.out.println("array not full and currentindex is first element");
            System.arraycopy(data, 0, data, 1, manyItems);
            data[currentIndex] = element;
           }
         else if(currentIndex != 0){
         System.out.println("array not full and currentindex is somewhere in the middle");
         System.arraycopy(data, currentIndex, data, currentIndex+1, manyItems-(currentIndex));
         data[currentIndex] = element;
         
         }
      }
      manyItems++;
   }
   
   
   /**
   * Place the contents of another sequence at the end of this sequence.
   * @param addend
   *   a sequence whose contents will be placed at the end of this sequence
   * @precondition
   *   The parameter, addend, is not null. 
   * @postcondition
   *   The elements from addend have been placed at the end of 
   *   this sequence. The current element of this sequence remains where it 
   *   was, and the addend is also unchanged.
   * @exception NullPointerException
   *   Indicates that addend is null. 
   * @exception OutOfMemoryError
   *   Indicates insufficient memory to increase the size of this sequence.
   * @note
   *   An attempt to increase the capacity beyond
   *   Integer.MAX_VALUE will cause an arithmetic overflow
   *   that will cause the sequence to fail.
   **/
   public void addAll(DoubleArraySeq addend)
   {
     double bigarray[];
     
     bigarray = new double[data.length + addend.data.length];
     
     System.arraycopy(data, 0, bigarray, 0, manyItems);
     System.arraycopy(addend.data, 0, bigarray, manyItems, addend.manyItems);
     
     data = bigarray;
      
   
   }
   /**
   * Move forward, so that the current element is now the next element in
   * this sequence.
   * @param - none
   * @precondition
   *   isCurrent() returns true. 
   * @postcondition
   *   If the current element was already the end element of this sequence 
   *   (with nothing after it), then there is no longer any current element. 
   *   Otherwise, the new element is the element immediately after the 
   *   original current element.
   * @exception IllegalStateException
   *   Indicates that there is no current element, so 
   *   advance may not be called.
   **/
   public void advance( )
   {
   
   if(isCurrent()){
      currentIndex++;
      if(currentIndex == manyItems){
          currentIndex--;
   
    }
   else{} 
    }
     
   else{
   throw new IllegalStateException("isCurrent returns false, no current element");
   }
    
    
    
   }
   
   
   /**
   * Generate a copy of this sequence.
   * @param - none
   * @return
   *   The return value is a copy of this sequence. Subsequent changes to the
   *   copy will not affect the original, nor vice versa.
   * @exception OutOfMemoryError
   *   Indicates insufficient memory for creating the clone.
   **/ 
   public DoubleArraySeq clone( )
   {  // Clone a DoubleArraySeq object.
      DoubleArraySeq answer;
      
      try
      {
         answer = (DoubleArraySeq) super.clone( );
      }
      catch (CloneNotSupportedException e)
      {  // This exception should not occur. But if it does, it would probably
         // indicate a programming error that made super.clone unavailable.
         // The most common error would be forgetting the "Implements Cloneable"
         // clause at the start of this class.
         throw new RuntimeException
         ("This class does not implement Cloneable");
      }
      
      answer.data = data.clone( );
      
      return answer;
   }
   

   /**
   * Create a new sequence that contains all the elements from one sequence
   * followed by another.
   * @param s1
   *   the first of two sequences
   * @param s2
   *   the second of two sequences
   * @precondition
   *   Neither s1 nor s2 is null.
   * @return
   *   a new sequence that has the elements of s1 followed by the
   *   elements of s2 (with no current element)
   * @exception NullPointerException.
   *   Indicates that one of the arguments is null.
   * @exception OutOfMemoryError
   *   Indicates insufficient memory for the new sequence.
   * @note
   *   An attempt to create a sequence with a capacity beyond
   *   Integer.MAX_VALUE will cause an arithmetic overflow
   *   that will cause the sequence to fail.
   **/   
   public static DoubleArraySeq concatenation(DoubleArraySeq s1, DoubleArraySeq s2)
   {
   double bigarray[];      //create a new array that we will use to store the results of the concatenation
   
   DoubleArraySeq result = new DoubleArraySeq(); //new object that the result will be stored in
   
   bigarray = new double[s1.manyItems + s2.manyItems]; //declare the size of the array, which should be the elements of Obj 1 + elements of Obj 2
   
   System.arraycopy(s1.data, 0, bigarray, 0, s1.manyItems);  //copy all of the data array of s1 into the bigarray
   System.arraycopy(s2.data, 0, bigarray, s1.manyItems, s2.manyItems); //copy all of the data array from s2 into bigarray

   result.data = bigarray;  //make the data array of the new object refer to the bigarray that now has all the elements of s1 and s2
   
   return result; //return
   
   }


   /**
   * Change the current capacity of this sequence.
   * @param newcap
   *   the new capacity for this sequence
   * @postcondition
   *   This sequence's capacity has been changed to at least minimumCapacity.
   *   If the capacity was already at or greater than minimumCapacity,
   *   then the capacity is left unchanged.
   * @exception OutOfMemoryError
   *   Indicates insufficient memory for: new int[minimumCapacity].
   **/
   public void ensureCapacity(int newcap)
   {
      double bigarray[];
   
      if(data.length >= newcap){
      System.out.println("Array length is already at or exceeding that capacity.");
      }
      else if(data.length<newcap){
      bigarray = new double[newcap];
      System.arraycopy(data, 0, bigarray, 0, manyItems);
      data = bigarray;
      
      }
   }

   
   /**
   * Accessor method to get the current capacity of this sequence. 
   * The add method works efficiently (without needing
   * more memory) until this capacity is reached.
   * @param - none
   * @return
   *   the current capacity of this sequence
   **/
   public int getCapacity( )
   {
     return data.length;
   }


   /**
   * Accessor method to get the current element of this sequence. 
   * @param - none
   * @precondition
   *   isCurrent() returns true.
   * @return
   *   the current element of this sequence
   * @exception IllegalStateException
   *   Indicates that there is no current element, so 
   *   getCurrent may not be called.
   **/
   public double getCurrent( )
   {
   if(isCurrent())
      return data[currentIndex];
   else{
   throw new IllegalStateException("no element at index location");}
   }


   /**
   * Accessor method to determine whether this sequence has a specified 
   * current element that can be retrieved with the 
   * getCurrent method. 
   * @param - none
   * @return
   *   true (there is a current element) or false (there is no current element at the moment)
   **/
   public boolean isCurrent( )      //in demoarray, data contains 4 slots. a current index of 3 corresponds to the final node in the array. currentindex should always be < manyItems.
   {
      if(currentIndex<manyItems){
         return true;
         }
      else{
      System.out.println("Current index refers to a value that exceeds the number of spots in the array. Current index is " + currentIndex + " the maximum index for this object is " + size()+ "-1");
      currentIndex = manyItems-1;
      System.out.println("currentIndex has been set to the final value of the array, which is index "+ currentIndex + " with data " + data[currentIndex]);
      }   

   return true;
   //   3. If there is a current element, then it lies in data[currentIndex];
   // if there is no current element, then currentIndex equals manyItems. 
   }
              
   /**
   * Remove the current element from this sequence.
   * @param - none
   * @precondition
   *   isCurrent() returns true.
   * @postcondition
   *   The current element has been removed from this sequence, and the 
   *   following element (if there is one) is now the new current element. 
   *   If there was no following element, then there is now no current 
   *   element.
   * @exception IllegalStateException
   *   Indicates that there is no current element, so 
   *   removeCurrent may not be called. 
   **/
   public void removeCurrent( )
   {
      double smallarray[];
   
      if(isCurrent()){
         smallarray = new double[data.length-1]; 
         System.arraycopy(data, 0, smallarray, 0, currentIndex);
         System.arraycopy(data, currentIndex + 1, smallarray, currentIndex, manyItems-(currentIndex+1));
         data = smallarray;
         manyItems--;
      }
      else
      throw new IllegalStateException("No current element");
   }
                 
   
   /**
   * Determine the number of elements in this sequence.
   * @param - none
   * @return
   *   the number of elements in this sequence
   **/ 
   public int size( )
   {
      return manyItems;
   }
   
   
   /**
   * Set the current element at the front of this sequence.
   * @param - none
   * @postcondition
   *   The front element of this sequence is now the current element (but 
   *   if this sequence has no elements at all, then there is no current 
   *   element).
   **/ 
   public void start( )
   {
     currentIndex = 0;
   }
   
   
   /**
   * Reduce the current capacity of this sequence to its actual size (i.e., the
   * number of elements it contains).
   * @param - none
   * @postcondition
   *   This sequence's capacity has been changed to its current size.
   * @exception OutOfMemoryError
   *   Indicates insufficient memory for altering the capacity. 
   **/
   public void trimToSize( )
   {
      double[ ] trimmedArray;
      
      if (data.length != manyItems)
      {
         trimmedArray = new double[manyItems];
         System.arraycopy(data, 0, trimmedArray, 0, manyItems);
         data = trimmedArray;
      }
   }
     
    
    
    /**
    * add an element to the front of this objects data[] array
    * @param element 
    *       item to be added to the front of the sequence
    * @precondition
    *       none
    * @postcondition
    *       new element has been added to the sequence at the front. 
    *       current element is the new element
    * @exception
    *
    */
     public void addFront(double element){
     double bigarray[];
     
     bigarray = new double[data.length + 1];
     System.arraycopy(data, 0, bigarray, 1, data.length);
     bigarray[0] = element;
     data = bigarray;
     manyItems++;
     currentIndex =0;
     
     }
     ///////////////////////////////////////////////////////
   /**
    * method to remove the front element of a sequence
    * @param  
    *      none
    * @precondition
    *       none
    * @postcondition
    *       front element has been removed and the new current element is the following element
    * @exception - IllegalStateException
    *       throw an IllegalStateException if there are no elements in the sequence
    *
    */
     
     ////////////////////////////////////////////////////////
     public void removeFront(){
     double smallarray[];
     
     if(data.length <=0){
     throw new IllegalStateException("no element present in array");
     }
     
     else if(data.length == 1){
     smallarray = new double[0];
     data = smallarray;
     
     }
     
     else if(data.length > 1){
     smallarray = new double[data.length-1];
     System.arraycopy(data, 1, smallarray, 0, data.length-1);
     data = smallarray;
     currentIndex=0;
     manyItems--;
     }
     }
         ///////////////////////////////////////////////////////
   /** sets the currentIndex value
    * 
    * @param - index
    *      value we want to change currentIndex to
    * @precondition
    *       none
    * @postcondition
    *       index has become the value of currentIndex
    * @exception -IllegalStateException
                 -IllegalArgumentException
    *       throw an IllegalStateException if the sequence contains no space
    *       throw an IllegalArgumentException if currentIndex is not a valid location
    */   
     
     ////////////////////////////////////////////////////////
     public void setCurrent(int index){
     if(index < manyItems){
     currentIndex = index;
     }
     else if(index >= manyItems){
     throw new IllegalArgumentException("given index is not a valid location in the array");
     }
     
     else if(data.length==0){
     throw new IllegalStateException("length of the array is 0");
     }
     }
     
          ///////////////////////////////////////////////////////
   /**  returns the element specified at location n
    * 
    * @param - n
    *      location in the array that we want to get the value of
    * @precondition
    *    none
    * @postcondition
    *    currentIndex has been changed to the value of n
    * @exception - IllegalStateException
    *            - IllegalArgumentException
    *throw an illegal state exception if the sequence is empty
    *illegal argument exception if n exceeds the size of the array
    */
     
     ////////////////////////////////////////////////////////
     public double getElement(int n){
     
     if(manyItems==0)
      throw new IllegalStateException("sequence is empty");
      
      else if(n>data.length)
         throw new IllegalArgumentException("input value exceeds length of the array of the object");
    
    currentIndex = n; 
     
    return data[n];
     
     }
          ///////////////////////////////////////////////////////
   /** method to test if two objects are DoubleArraySeq objects with the same data in the same order
    * 
    * @param  
    *      object obj
    * @precondition
    *       none
    * @postcondition
    *       obj has been tested if its data[] has the same values and order of the current object
    * @exception
    *       none
    */
     
     ////////////////////////////////////////////////////////
     
     
     public boolean equals(Object obj){
     
       boolean result=true;
     
         if(obj instanceof DoubleArraySeq){         //if the object to compare to is also a doublearrayseq object
         
            DoubleArraySeq tester = (DoubleArraySeq) obj;
            if(tester.data.length == data.length){           //AND they have arrays of the same length
              int i = 0;
                for(i=0; i<data.length; i++){              //compare all values in both arrays
                  if(data[i] != tester.data[i]){            //as soon as one of them is not true, answer should be false
                  
                  result = false;
                  
                  }
                  if(result != false && data[data.length-1] == tester.data[data.length-1]){ //if you get to the end of comparing 
                  result = true;    //both arrays and the result still is not false, if the last value comparison is true than result is true
                  }
                  else 
                     result = false;             //these other else statements ensure that if a comparison is incorrect,
                                             // we should make sure result is false
                 }
             }
             else
             result = false;
          }
          else{
          result = false;
           }
           
           return result;    
     }//end equals  

     
     
          ///////////////////////////////////////////////////////
   /** converts data[] of a DoubleArraySeq object to a string and returns that string
    * 
    * @param  
    *      none
    * @precondition
    *       none
    * @postcondition
    *       data[] has been returned as a string
    * @exception
    *    none
    */
     
     ////////////////////////////////////////////////////////
     
     public String toString(){     
     String answer = "";
     int remember = currentIndex;
     int i =0;
     start();
     
     if(manyItems == 0){
     throw new IllegalStateException("current array is empty");
     }
     else{
    for(i = 0; i<manyItems; i++){
    answer += getElement(currentIndex) + " ";
    advance(); 
    
    
    }
      
      currentIndex = remember;   
    
     }
     return answer;
     }
     
    /////////////////////////////////////////////// 


} //end
     
     
     
    
     
      
