import java.util.*;

/**
 * Class:           BinaryTree
 * File:            BinaryTree.java 
 * Description:     This class holds data for the binary tree which has 
 *                  HuffmanTree as the child.
 * Date:            6/11/2015
 * Course:          CS 143
 * @author          San Min Liew, Hao Tu, Devin Stoen, Fnu Michael
 * @version         1.0
 * Environment:     PC, Windows 8, jdk 1.8.0_20, Netbeans 8.0.1
 * @see             javax.swing.JFrame
 */
public class BinaryTree<T> implements BinaryTreeInterface<T> ,
    java.io.Serializable
{
    private BinaryNodeInterface<T> root;
    
    /**
     * default constructor
     */
    public BinaryTree ()
    {
        root = null;
    } // end default constructor

    /**
     * constructor
     * @param rootData data for root node
     */
    public BinaryTree (T rootData)
    {
        root = new BinaryNode < T > (rootData);
    } // end constructor

    /**
     * constructor
     * @param rootData data for root node
     * @param leftTree left subtree to attach
     * @param rightTree right subtree to attach
     */
    public BinaryTree (T rootData, BinaryTree<T> leftTree,
            BinaryTree<T> rightTree)
    {
        privateSetTree (rootData, leftTree, rightTree);
    } // end constructor

    /**
     * sets the root node
     * @param rootData data for root node
     */
    public void setTree (T rootData)
    {
        root = new BinaryNode < T > (rootData);
    } // end setTree

    /**
     * sets the root node
     * @param rootData data for root node
     * @param leftTree left subtree to attach
     * @param leftTree right subtree to attach
     */
    public void setTree (T rootData, BinaryTreeInterface < T > leftTree,
            BinaryTreeInterface < T > rightTree)
    {
        privateSetTree (rootData, (BinaryTree < T > ) leftTree,
                (BinaryTree < T > ) rightTree);
    } // end setTree

    /**
     * Creates a copy of the tree
     * @return copy of the tree
     */
    public BinaryNodeInterface<T> copy ()
    {
        BinaryNode < T > newRoot = new BinaryNode <T> (root.getData());
        if (root.getLeftChild() != null)
            newRoot.setLeftChild((BinaryNode <T>)root.getLeftChild().copy());
        if (root.getRightChild() != null)
            newRoot.setRightChild((BinaryNode <T>)root.getRightChild().copy());
        return newRoot;
    } // end copy

    /*
     * gets the tree height
     * @return height of tree
     */
    public int getHeight()
    {
        return root.getHeight();
    } // end getHeight
    
    /*
     * gets the number of nodes
     * @return numberOfNodes
     */
    public int getNumberOfNodes()
    {
        return root.getNumberOfNodes();
    } // end getNumberOfNodes
    
    /**
     * Privately sets the tree, a helper method 
     * @param rootData the root data
     * @param leftTree the left tree 
     * @param rightTree the right data
     */
    private void privateSetTree(T rootData, BinaryTree < T > leftTree,
            BinaryTree < T > rightTree)
    {
        root = new BinaryNode < T > (rootData);
        if ((leftTree != null) && !leftTree.isEmpty ())
            root.setLeftChild (leftTree.root.copy ());
        if ((rightTree != null) && !rightTree.isEmpty ())
            root.setRightChild (rightTree.root.copy ());
    } // end privateSetTree

    /**
     * gets the root data
     * @return the rootData
     */
    public T getRootData ()
    {
        T rootData = null;
        if (root != null)
            rootData = root.getData ();
        return rootData;
    } // end getRootData

    /**
     * checks if root node is empty
     * @return true is root node is empty
     */
    public boolean isEmpty ()
    {
        return root == null;
    } // end isEmpty

    /**
     * clears the root, set it equal to null
     */
    public void clear ()
    {
        root = null;
    } // end clear

    /**
     * sets the root data to a new value
     * @param rootData data to be set
     */
    protected void setRootData (T rootData)
    {
        root.setData (rootData);
    } // end setRootData

    /**
     * sets the root node with a new root node
     * @param rootNode the new node replace
     */
    protected void setRootNode (BinaryNodeInterface < T > rootNode)
    {
        root = rootNode;
    } // end setRootNode

    /**
     * gets the root node
     * @return the root node
     */
    protected BinaryNodeInterface<T> getRootNode ()
    {
        return root;
    } // end getRootNode
    
    /**
     * traverse the nodes inOrder for testing purposes.
     */
    public void inorderTraverse ()
    {
        Stack< BinaryNodeInterface<T>> nodeStack =
                new Stack<BinaryNodeInterface<T>>();
        BinaryNodeInterface < T > currentNode = root;
        while (!nodeStack.isEmpty () || (currentNode != null))
        {
            // find leftmost node with no left child
            while (currentNode != null)
            {
                nodeStack.push (currentNode);
                currentNode = currentNode.getLeftChild ();
            } // end while
            // visit leftmost node, then traverse its right subtree
            if (!nodeStack.isEmpty ())
            {
                BinaryNodeInterface < T > nextNode = nodeStack.pop ();
                assert nextNode != null; // since nodeStack was not empty
                // before the pop
                System.out.println (nextNode.getData ());
                currentNode = nextNode.getRightChild ();
            } // end if
        } // end while
    } 

    /**
     *  internal iterator
     */
    private class InorderIterator implements Iterator<T>
    {
        private Stack<BinaryNodeInterface<T>> nodeStack;
        private BinaryNodeInterface < T > currentNode;

        /**
         *  default constructor
         */
        public InorderIterator ()
        {
            nodeStack = new Stack< BinaryNodeInterface<T>>();
            currentNode = root;
        }

        /**
         * returns true if there is a next element; false otherwise
         * @return true if there is a next element; false otherwise
         */
        public boolean hasNext ()
        {
            return !nodeStack.isEmpty () || (currentNode != null);
        }

        /**
         * returns the next element and moves forward
         * @return the next element
         */
        public T next ()
        {
            BinaryNodeInterface < T > nextNode = null;
            // find leftmost node with no left child
            while (currentNode != null)
            {
                nodeStack.push (currentNode);
                currentNode = currentNode.getLeftChild ();
            } // end while
            // get leftmost node, then move to its right subtree
            if (!nodeStack.isEmpty ())
            {
                nextNode = nodeStack.pop ();
                assert nextNode != null; // since nodeStack was not empty
                // before the pop
                currentNode = nextNode.getRightChild ();
            }
            else
                throw new NoSuchElementException ();
            return nextNode.getData ();
        } // end next

        /**
         * unsupported
         */
        public void remove ()
        {
            throw new UnsupportedOperationException ();
        }
    }

   /**
    * returns a new iterator over the class
    * @return a new iterator
    */
   public InorderIterator getInOrderIterator()
   {
       return new InorderIterator();
   }
}

