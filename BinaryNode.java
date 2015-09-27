/*
 * BinaryNode.java
 *
 * Created on May 21, 2007, 1:08 PM
 */

package huffman;
import java.io.*;
/**
 *
 * @author Carrano
 */
public class  BinaryNode < T > implements BinaryNodeInterface < T >, Serializable
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
     * @param leftChild
     * @param rightChild
     */
    public BinaryNode (T dataPortion, BinaryNode < T > leftChild, BinaryNode < T > rightChild)
    {
        data = dataPortion;
        left = leftChild;
        right = rightChild;
    } // end constructor


    public T getData ()
    {
        return data;
    } // end getData


    public void setData (T newData)
    {
        data = newData;
    } // end setData


    public BinaryNodeInterface < T > getLeftChild ()
    {
        return left;
    } // end getLeftChild


    public void setLeftChild (BinaryNodeInterface < T > leftChild)
    {
        left = (BinaryNode < T > ) leftChild;
    } // end setLeftChild


    public boolean hasLeftChild ()
    {
        return left != null;
    } // end hasLeftChild


    public boolean isLeaf ()
    {
        return (left == null) && (right == null);
    } // end isLeaf


    public BinaryNodeInterface < T > getRightChild ()
    {
        return right;
    } // end getRightChild


    public void setRightChild (BinaryNodeInterface < T > rightChild)
    {
        right = (BinaryNode < T > ) rightChild;
    } // end setRightChild


    public boolean hasRightChild ()
    {
        return right != null;
    } // end hasRightChild


    // Implementations of getRightChild, setRightChild, and hasRightChild are analogous to
    // their left-child counterparts.

    public BinaryNodeInterface < T > copy ()
    {
        BinaryNode < T > newRoot = new BinaryNode < T > (data);
        if (left != null)
            newRoot.left = (BinaryNode < T > ) left.copy ();
        if (right != null)
            newRoot.right = (BinaryNode < T > ) right.copy ();
        return newRoot;
    } // end copy


//    private void privateSetTree (T rootData, BinaryTree < T > leftTree,
//            BinaryTree < T > rightTree)
//    {
//        root = new BinaryNode < T > (rootData);
//        if ((leftTree != null) && !leftTree.isEmpty ())
//            root.setLeftChild (leftTree.root.copy ());
//        if ((rightTree != null) && !rightTree.isEmpty ())
//            root.setRightChild (rightTree.root.copy ());
//    } // end privateSetTree


    public int getHeight ()
    {
        return getHeight (this); // call private getHeight
    } // end getHeight


    private int getHeight (BinaryNode < T > node)
    {
        int height = 0;
        if (node != null)
            height = 1 + Math.max (getHeight (node.left),
                    getHeight (node.right));
        return height;
    } // end getHeight


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

