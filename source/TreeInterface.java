/*
 * HuffmanData.java
 *
 * Created on May 21, 2007, 2:17 PM
 */

package huffman;

/**
 * @author Carrano
 */
public interface TreeInterface<T>
{
   public T getRootData();
   public int getHeight(); 
   public  int getNumberOfNodes();
   public boolean isEmpty(); 
   public void clear();   
}
