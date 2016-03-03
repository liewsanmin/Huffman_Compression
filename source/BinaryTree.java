/*
 * BinaryTree.java
 *
 * Created on May 21, 2007, 1:12 PM
 */

package huffman;
import java.util.*;

/**
 * @author Carrano
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
     * @param leftTree right subtree to attach
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
     * gets the number of nodesw
     * @return numberOfNodes
     */
    public int getNumberOfNodes()
    {
        return root.getNumberOfNodes();
    } // end getNumberOfNodes
 
    private void privateSetTree(T rootData, BinaryTree < T > leftTree,
            BinaryTree < T > rightTree)
    {
        root = new BinaryNode < T > (rootData);
        if ((leftTree != null) && !leftTree.isEmpty ())
            root.setLeftChild (leftTree.root.copy ());
        if ((rightTree != null) && !rightTree.isEmpty ())
            root.setRightChild (rightTree.root.copy ());
    } // end privateSetTree


 
 // alternative version
//    private void privateSetTree (T rootData, BinaryTree < T > leftTree,
//            BinaryTree < T > rightTree)
//    {
//        root = new BinaryNode < T > (rootData);
//        if ((leftTree != null) && !leftTree.isEmpty ())
//            root.setLeftChild (leftTree.root);
//        if ((rightTree != null) && !rightTree.isEmpty ())
//        {
//            if (rightTree != leftTree)
//                root.setRightChild (rightTree.root);
//            else
//                root.setRightChild (rightTree.root.copy ());
//        } // end if
//        if ((leftTree != null) && (leftTree != this))
//            leftTree.clear ();
//        if ((rightTree != null) && (rightTree != this))
//            rightTree.clear ();
//    } // end privateSetTree
 


    public T getRootData ()
    {
        T rootData = null;
        if (root != null)
            rootData = root.getData ();
        return rootData;
    } // end getRootData


    public boolean isEmpty ()
    {
        return root == null;
    } // end isEmpty


    public void clear ()
    {
        root = null;
    } // end clear


    protected void setRootData (T rootData)
    {
        root.setData (rootData);
    } // end setRootData


    protected void setRootNode (BinaryNodeInterface < T > rootNode)
    {
        root = rootNode;
    } // end setRootNode


    protected BinaryNodeInterface<T> getRootNode ()
    {
        return root;
    } // end getRootNode
    
    public void inorderTraverse ()
    {
//        StackInterface < BinaryNodeInterface < T >> nodeStack =
//            new LinkedStack < BinaryNodeInterface < T >> ();
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

