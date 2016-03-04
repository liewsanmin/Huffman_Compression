import java.io.*;

/**
 * Class:           BinaryNode
 * File:            BinaryNode.java 
 * Description:     This class has the nodes, leftNode and rightNode
 * Date:            6/11/2015
 * Course:          CS 143
 * @author          San Min Liew, Hao Tu, Devin Stoen, Fnu Michael
 * @version         1.0
 * Environment:     PC, Windows 8, jdk 1.8.0_20, Netbeans 8.0.1
 * @see             javax.swing.JFrame
 */
public class BinaryNode < T > implements BinaryNodeInterface < T >,
        Serializable
{
    private T data;
    private BinaryNode < T > left;
    private BinaryNode < T > right;
    
    /**
     * default constructor
     */
    public BinaryNode ()
    {
        this (null);  // call next constructor
    } // end default constructor

    /**
     * constructor
     * @param dataPortion the data portion
     */
    public BinaryNode (T dataPortion)
    {
        this (dataPortion, null, null); // call next constructor
    } // end constructor

    /**
     * constructor
     * @param leftChild the leftChild
     * @param rightChild the rightChild
     * @param dataPortion the data portion 
     */
    public BinaryNode (T dataPortion, BinaryNode < T > leftChild, 
                       BinaryNode < T > rightChild)
    {
        data = dataPortion;
        left = leftChild;
        right = rightChild;
    } // end constructor

    /**
     * Accessor to access data
     * @return data -- the data
     */
    public T getData ()
    {
        return data;
    } // end getData

    /**
     * Mutate the data
     * @param newData the new data to be set
     */
    public void setData (T newData)
    {
        data = newData;
    } // end setData

    /**
     * access the leftChild
     * @return left -- the leftNode
     */
    public BinaryNodeInterface < T > getLeftChild ()
    {
        return left;
    } // end getLeftChild

    /**
     * Mutates the leftChild
     * @param leftChild leftNode to be mutated
     */
    public void setLeftChild (BinaryNodeInterface < T > leftChild)
    {
        left = (BinaryNode < T > ) leftChild;
    } // end setLeftChild

    /**
     * Check if left is null or not
     * @return boolean if leftNode is false or true
     */
    public boolean hasLeftChild ()
    {
        return left != null;
    } // end hasLeftChild

    /**
     * Check if current node is leaf 
     * @return true if node is leaf
     */
    public boolean isLeaf ()
    {
        return (left == null) && (right == null);
    } // end isLeaf

    /**
     * access right child
     * @return right -- the right node
     */
    public BinaryNodeInterface < T > getRightChild ()
    {
        return right;
    } // end getRightChild

    /**
     * Sets the right child
     * @param rightChild -- right node to mutated
     */
    public void setRightChild (BinaryNodeInterface < T > rightChild)
    {
        right = (BinaryNode < T > ) rightChild;
    } // end setRightChild

    /**
     * checks if it has a right child
     * @return the right node
     */
    public boolean hasRightChild ()
    {
        return right != null;
    } // end hasRightChild

    // Implementations of getRightChild, setRightChild, and hasRightChild 
    //are analogous to their left-child counterparts.
    /**
     * Make a copy of the root node
     * @return newRoot -- the exact copy
     */
    public BinaryNodeInterface < T > copy ()
    {
        BinaryNode < T > newRoot = new BinaryNode < T > (data);
        if (left != null)
            newRoot.left = (BinaryNode < T > ) left.copy ();
        if (right != null)
            newRoot.right = (BinaryNode < T > ) right.copy ();
        return newRoot;
    } // end copy
    
    /**
     * Gets the height of tree
     * @return getHeight(this) the helper method
     */
    public int getHeight ()
    {
        return getHeight (this); // call private getHeight
    } // end getHeight

    /**
     * Gets the height of tree
     * @param node the root node
     * @return height -- the height of the tree
     */
    private int getHeight (BinaryNode < T > node)
    {
        int height = 0;
        if (node != null)
            height = 1 + Math.max (getHeight (node.left),
                    getHeight (node.right));
        return height;
    } // end getHeight

    /**
     * Gets the total number of nodes
     * @return the total number of nodes
     */
    public int getNumberOfNodes ()
    {
        int leftNumber = 0;
        int rightNumber = 0;
        if (left != null)
            leftNumber = left.getNumberOfNodes ();
        if (right != null)
            rightNumber = right.getNumberOfNodes ();
        return 1 + leftNumber + rightNumber;
    } // end getNumberOfNodes          
} // end BinaryNode

