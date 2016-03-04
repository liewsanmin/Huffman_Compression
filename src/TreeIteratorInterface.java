import java.util.*;

/**
 * Class:           TreeIteratorInterface
 * File:            TreeIteratorInterface.java 
 * Description:     The interface for BinaryTreeInterface to override
 * Date:            6/14/2015
 * Course:          CS 143
 * @author          San Min Liew, Hao TU, Devin Stoen, Michael Fnu
 * @version         1.0
 * Environment:     PC, Windows 8, jdk 1.8.0_20, Netbeans 8.0.1
 */
public interface TreeIteratorInterface<T>
{
    /**
     * Get the iterator that is already being sorted in order
     * @return Iterator - the sorted iterator
     */
    public Iterator<T> getInOrderIterator();
}

