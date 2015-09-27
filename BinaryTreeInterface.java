/*
 * BinaryTreeInterface.java
 *
 * Created on May 21, 2007, 1:17 PM
 */

package huffman;

/**
 * @author Carranno
 */
public interface BinaryTreeInterface < T > extends TreeInterface<T>,
    TreeIteratorInterface<T>
{
    /** Task: Sets an existing binary tree to a new one-node binary tree.
    * @param rootData an object that is the data in the new trees root
    */
    public void setTree (T rootData);

    /** Task: Sets an existing binary tree to a new binary tree.
    * @param rootData an object that is the data in the new trees root
    * @param leftTree the left subtree of the new tree
    * @param rightTree the right subtree of the new tree */
    public void setTree (T rootData, BinaryTreeInterface < T > leftTree,
            BinaryTreeInterface < T > rightTree);

}

