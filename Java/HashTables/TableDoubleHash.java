//Andrew Tambasco
// File: Table.java
// Complete documentation is available from the Table link in:
//   http://www.cs.colorado.edu/~main/docs


/******************************************************************************
* A  Table  is an open-address hash table with a fixed capacity.
* The purpose is to show students how an open-address hash table is
* implemented. Programs should generally use java.util.Hashtable
* rather than this hash table.
*
* <dt><b>Java Source Code for this class:</b><dd>
*   <A HREF="../../../../edu/colorado/collections/Table.java">
*   http://www.cs.colorado.edu/~main/edu/colorado/collections/Table.java
*   </A>
*
* @author Michael Main 
*   <A HREF="mailto:main@colorado.edu"> (main@colorado.edu) </A>
*
******************************************************************************/
public class TableDoubleHash< K , E >
{
   // Invariant of the Table class:
   //   1. The number of items in the table is in the instance variable manyItems.
   //   2. The preferred location for an element with a given key is at index
   //      hash(key). If a collision occurs, then next-Index is used to search
   //      forward to find the next open address. When an open address is found
   //      at an index i, then the element itself is placed in data[i] and the

   //   3. An index i that is not currently used has data[i] and key[i] set to
   //      null.
   //   4. If an index i has been used at some point (now or in the past), then
   //      hasBeenUsed[i] is true; otherwise it is false.
   private int manyItems;
   private Object[ ] keys;
   private Object[ ] data;
   private int[] collisions;  //collisions[i] contains the number of collisions for the ith element to place, not the number of collisions at an index
                              //collisions[i] should always be equal to manyItems
   private boolean[ ] hasBeenUsed;   

   /**
   * Initialize an empty table with a specified capacity.
   * @param  capacity 
   *   the capacity for this new open-address hash table
   * <dt><b>Postcondition:</b><dd>
   *   This table is empty and has the specified capacity.
   * @exception OutOfMemoryError
   *   Indicates insufficient memory for the specified capacity. 
   **/   
   public TableDoubleHash(int capacity)
   {
      // The manyItems instance variable is automatically set to zero.
      // which is the correct initial value. The three arrays are allocated to
      // be the specified capacity. The boolean array is automatically
      // initialized to falses, and the other two arrays are automatically
      // initialized to all null.
      if (capacity <= 0)
         throw new IllegalArgumentException("Capacity is negative");
      keys = new Object[capacity];
      data = new Object[capacity];
      collisions = new int[capacity];
      hasBeenUsed = new boolean[capacity];
   }
   
      /**
   * Add a new element to this table, using the specified key.
   * @param  key 
   *   the non-null key to use for the new element
   * @param  element 
   *   the new element thats being added to this table
   * <dt><b>Precondition:</b><dd>
   *   If there is not already an element with the specified  key ,
   *   then this tables size must be less than its capacity 
   *   (i.e.,  size() < capacity() ). Also, neither  key 
   *   nor  element  is null.
   * <dt><b>Postcondition:</b><dd>
   *   If this table already has an object with the specified  key ,
   *   then that object is replaced by  element , and the return 
   *   value is a reference to the replaced object. Otherwise, the new 
   *    element  is added with the specified  key 
   *   and the return value is null.
   * @exception IllegalStateException
   *   Indicates that there is no room for a new object in this table.
   * @exception NullPointerException
   *   Indicates that  key  or  element  is null.   
   **/
   public E put(K key, E element)
   {
      int index = findIndex(key);   //index is the hash value of the key if it is not already in the table
      E answer;
      
      if (index != -1)
      {  // The key is already in the table.
      System.out.println("DOUBLE:key is already in the table");
         answer = (E) data[index]; //answer becomes whatever is at the index
         data[index] = element; //whatever is at the index becomes the element
         return answer;
      }
      
      else if (manyItems < data.length)
      {  // The key is not yet in this Table.
    //  System.out.println(element + " is not yet in the table");    //DEBUG WORKING
         index = hash(key);
         while (keys[index] != null) {  //while trying to place data at an index that already has data
     //         System.out.println("DOUBLE:" +element+ " had a collision at "+ index);                //DEBUG //WORKING
            index = nextIndex(index, key); //////////////////////////////////////////////////////////////
               collisions[manyItems]++;
            }
         keys[index] = key;
         data[index] = element;
         hasBeenUsed[index] = true;
         //System.out.println("DOUBLE " + element +" put at " + index + " with " + collisions[manyItems] + " collisions"); //DEBUG //WORKING
         manyItems++;
         
        
      }
      else
      {  // The table is full.
       //  throw new IllegalStateException("Table is full.");
      }
      return null;
   }
   



      
 public int getCollisions(int val){
  return collisions[val];
 
 }
      
      
   private int hash(Object key)
   // The return value is a valid index of the table  arrays. The index is
   // calculated as the remainder when the absolute value of the keys
   // hash code is divided by the size of the tables arrays.
   {
      return Math.abs(key.hashCode( )) % data.length;
   }
   
   private int hash2(Object key){
   return 1+Math.abs(key.hashCode())%(data.length-2);
   }
   
   
   /**
   * Determines whether a specified key is in this table.
   * @param  key 
   *   the non-null key to look for
   * <dt><b>Precondition:</b><dd>
   *    key  cannot be null.
   * @return
   *    true</CODE? (if this table contains an object with the specified 
   *   key);  false  otherwise. Note that key.equals( )
   *   is used to compare the  key  to the keys that are in the 
   *   table.
   * @exception NullPointerException
   *   Indicates that  key  is null.
   **/
   public boolean containsKey(K key)        //calls findIndex. If the key is in the array, return true, if not return false
   {
      return findIndex(key) != -1;
   }
   
   
   private int findIndex(K key)
 //if key is found, returns index in the array of that key. if not found, return -1  //reworded for my understanding and memory
   {
      int count = 0;
      int i = hash(key);
      
      while (count < data.length && hasBeenUsed[i])
      {
         if (key.equals(keys[i]))
            return i;    //returns hash(key)
         count++;
         i = nextIndex(i, key);
      }
      
      return -1;
   }
      
   
   /** Retrieves an object for a specified key.
   * @param  key 
   *   the non-null key to look for
   * <dt><b>Precondition:</b><dd>
   *    key  cannot be null.
   * @return
   *   a reference to the object with the specified  key</CODE (if this 
   *   table contains an such an object);  null otherwise. Note that 
   *    key.equals( )  is used to compare the  key 
   *   to the keys that are in the table.
   * @exception NullPointerException
   *   Indicates that  key  is null.
   **/
   public E get(K key)
   {
      int index = findIndex(key);
      
      if (index == -1)
         return null;
      else
         return (E) data[index];
   }
   
   
   
   private int nextIndex(int i, K key)  //can I do int as a key, or does it need to be generic, //SOLVED ITSELF?
   // The return value is normally i+1. But if i+1 is data.length, then the 
   // return value is zero instead.
   {
      if (i+1 == data.length)
         return 0;
      else
         return (i + hash2(key))%data.length;
   }
   
   

      
   
   /**
   * Removes an object for a specified key.
   * @param  key 
   *   the non-null key to look for
   * <dt><b>Precondition:</b><dd>
   *    key  cannot be null.
   * <dt><b>Postcondition:</b><dd>
   *   If an object was found with the specified key, then that
   *   object has been removed from this table and a copy of the removed object
   *   is returned; otherwise, this table is unchanged and the null reference
   *   is returned.  Note that 
   *    key.equals( )  is used to compare the  key 
   *   to the keys that are in the table.
   * @exception NullPointerException
   *   Indicates that  key  is null.
   **/
   public E remove(K key)
   {
      int index = findIndex(key);
      E answer = null;
      
      if (index != -1)
      {
         answer = (E) data[index];
         keys[index] = null;
         data[index] = null;
	 manyItems--;
      }
      
      return answer;
   }
   
   
   
    public double getDoubleAverage(){  //method that is responsible for finding and returning the average number of collisions per item
         double sum=0;
         double avg;
         for(int i = 0; i<manyItems; i++){  //for every value in the collisions array, add it to sum
            sum = sum + collisions[i];          
         }
      
       avg=(double)sum/manyItems;
       return avg;
      }
        
        
        
        
}//end class
           