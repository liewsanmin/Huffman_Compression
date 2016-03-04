
/**
 * Class:           BinaryTreeInterface
 * File:            BinaryTreeInterface.java 
 * Description:     This class is an interface for BinaryTree class
 * Date:            6/11/2015
 * Course:          CS 143
 * @author          San Min Liew, Hao Tu, Devin Stoen, Fnu Michael
 * @version         1.0
 * Environment:     PC, Windows 8, jdk 1.8.0_20, Netbeans 8.0.1
 * @see             javax.swing.JFrame
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

