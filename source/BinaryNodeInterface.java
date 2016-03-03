/*
 * BinaryNodeInterface.java
 *
 * Created on May 21, 2007, 1:07 PM
 */

package huffman;

/**
 *
 * @author Carrano
 */
interface BinaryNodeInterface< T >
{
    /** Task: Retrieves the data portion of the node.
    * @return the object in the data portion of the node */
    public  T getData ();
    
    /** Task: Sets the data portion of the node.
    * @param newData the data object */
    public void setData (T newData);
    
    /** Task: Retrieves the left child of the node.
    * @return the node that is this nodes left child */
    public BinaryNodeInterface < T > getLeftChild ();
    
    /** Task: Retrieves the right child of the node.
    * @return the node that is this nodes right child */
    public BinaryNodeInterface < T > getRightChild ();
    
    /** Task: Sets the nodes left child to a given node.
    * @param leftChild a node that will be the left child */
    public void setLeftChild (BinaryNodeInterface < T > leftChild);
    
    /** Task: Sets the nodes right child to a given node.
    * @param rightChild a node that will be the right child */
    public void setRightChild (BinaryNodeInterface < T > rightChild);
    
    /** Task: Detects whether the node has a left child.
    * @return true if the node has a left child */
    public boolean hasLeftChild ();
    
    /** Task: Detects whether the node has a right child.
    * @return true if the node has a right child */
    public boolean hasRightChild ();
    
    /** Task: Detects whether the node is a leaf.
    * @return true if the node is a leaf */
    public boolean isLeaf ();
    
    /** Task: Counts the nodes in the subtree rooted at this node.
    *@returnthenumberof nodes in the subtree rooted at this node */
    public int getNumberOfNodes ();
    
    /** Task: Computes the height of the subtree rooted at this node.
    * @return the height of the subtree rooted at this node */
    public int getHeight ();
    
    /** Task: Copies the subtree rooted at this node.
    * @return the root of a copy of the subtree rooted at this node */
    public BinaryNodeInterface < T > copy ();
    
} // end BinaryNodeInterface
