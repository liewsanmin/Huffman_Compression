/**
 * Class:           TreeInterface
 * File:            TreeInterface.java 
 * Description:     The interface for BinaryTree class to implement
 * Date:            6/14/2015
 * Course:          CS 143
 * @author          San Min Liew, Hao TU, Devin Stoen, Michael Fnu
 * @version         1.0
 * Environment:     PC, Windows 8, jdk 1.8.0_20, Netbeans 8.0.1
 */
public interface TreeInterface<T>
{
   /**
    * get the data from the Root
    * @return  T - the data in the Root
    */
   public T getRootData();
   
   /**
    * Get the height of the tree
    * @return integer - the vertical level of the tree
    */
   public int getHeight(); 
   
   /**
    * check the amount of nodes in the tree
    * @return integer - amount of node 
    */
   public  int getNumberOfNodes();
   
   /**
    * check the tree if is empty
    * @return boolean - to show if the tree is empty
    */
   public boolean isEmpty(); 
   
   /**
    * clear what's in the tree
    */
   public void clear();   
}

