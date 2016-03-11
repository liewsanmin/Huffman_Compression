import java.util.*;

/**
 * Class:           HuffmanTree
 * File:            HuffmanTree.java 
 * Description:     This class extends BinaryTree and helps build the Huffman
 *                  tree and create the full binary path for each character
 *                  in the text.
 * Date:            6/11/2015
 * Course:          CS 143
 * @author          San Min Liew, Hao Tu, Devin Stoen, Fnu Michael
 * @version         1.0
 * Environment:     PC, Windows 8, jdk 1.8.0_20, Netbeans 8.0.1
 * @see             javax.swing.JFrame
 */
public class HuffmanTree<T extends Comparable<? super T>>
        extends BinaryTree<HuffmanData<T>>
{
    private final T MARKER = null;
    SortedMap<T, String> codeMap;
    SortedMap<String, T> keyMap;
    BinaryNode<T> combinedNode;
    List<BinaryNode<HuffmanData <T>>> theList = new LinkedList<>();
    private int leafCount = 0;
    
    /**
     * Creates a new instance of HuffmanTree
     */
    public HuffmanTree() 
    {
        super();
    }
   
    /**
     * Creates a new instance of HuffmanTree
     * from an array of Huffman Data
     * @param dataArray n array of Huffman Data
     */
    public HuffmanTree(HuffmanChar[] dataArray) 
    {
        buildTree(dataArray); 
        keyMap = new TreeMap<String, T>();
        codeMap = new TreeMap<T, String>();

        for(int i = 0; i < dataArray.length; i++)
        {
            String binaryPath = findPath((HuffmanData<T>) dataArray[i], 
                                theList.get(0));
            codeMap.put((T)dataArray[i].getData(), binaryPath);
            keyMap.put(binaryPath, (T)dataArray[i].getData());
        }
    }
    
    /** 
     * creates two new HuffmanTrees and adds them to the root of this tree
     * @param left the left Binary node 
     * @param right the right Binary node
     */
    private void add(BinaryNode<HuffmanData<T>> left,
            BinaryNode<HuffmanData<T>> right)
    {
         HuffmanTree<T> leftTree = new HuffmanTree<T>();
         leftTree.setRootNode(left); 
         HuffmanTree<T> rightTree = new HuffmanTree<T>();
         rightTree.setRootNode(right);
         setTree(new HuffmanData<T>
                 (MARKER, left.getData().getOccurances()
                 + right.getData().getOccurances()), leftTree, rightTree);
    }
    
    /*
     * accessor for codeMap
     * @return codeMap the codeMap
     */
    public SortedMap<T, String> getCodeMap()
    {
        return codeMap;
    }
    
    /*
     * accessor for keyMap
     * @return keyMap the keyMap
     */
    public SortedMap<String, T> getKeyMap()
    {
        return keyMap;
    }
    
    /**
     * This method builds the Huffman Tree by using information in the dataAray
     * @param dataArray the HufmanChar array to be used for building tree
     */
    private void buildTree(HuffmanChar[] dataArray)
    {
        BinaryNode<HuffmanData<T>> combinedNode;
        boolean isAdd = false;
        
        for (int i = 0; i < dataArray.length; i++)
        {
            theList.add(new BinaryNode(dataArray[i])); // adss them to a list 
        }
        
        while (theList.size() != 1) // builds the tree from Linked list
        {
            add(theList.remove(0), theList.remove(0));
            
            // cast root to type (BinaryNode<HuffmanData<T>>)
            combinedNode = (BinaryNode<HuffmanData<T>>) getRootNode(); 
            
            if (theList.isEmpty())
                theList.add(combinedNode);
            else
            {
                isAdd = false;
                int trackSize = theList.size();
                for (int i = 0; i < theList.size() && !isAdd; i++)
                {
                    if (getRootNode().getData().compareTo
                       (theList.get(i).getData()) == -1
                        || getRootNode().getData().compareTo
                       (theList.get(i).getData()) == 0)
                    {
                        theList.add(i,combinedNode);
                        isAdd = true;
                    }
                }
                if (trackSize == theList.size())
                    theList.add(combinedNode);
            }
        }
    }
  
    /**
     * This method is used for building binary string path
     * for every leaf node in the Huffman Tree.
     * 
     * @param data The character in which a path will be built for.
     * @param root The current root in which the program will recursively 
     *             move through to find a binary path.
     * @return the binaryPath of each HuffmanChar
     */
    public String findPath(HuffmanData<T> data, 
            BinaryNodeInterface<HuffmanData<T>> root)
    {
        //actual string path the method will return for
        //specific character.
        String path = "";
        String total = "";
        if(root.getData() != null)
        {
            //the searched for character was found
            //and return the path.
            if(root.getData() == data)
            {
                return path;
            }
        }
        if(root.hasLeftChild())
        {
            //recursively call the method to move 
            //to the left of the tree.
            total = findPath(data, root.getLeftChild());
            if( total != null )
            {
                //add zero to the string to indicate there was a 
                //move to the left of the tree.
                path = path + "0";
                path = path + total;
                return path;
            }
        }
        if( root.hasRightChild() )
        {
            //recursively call the method to move 
            //to the right of the tree.
            total = findPath(data, root.getRightChild());
            if( total != null )
            {
                //add 1 to the string to indicate there was a 
                //move to the right of the tree.
                path = path + "1";
                path = path + total;
                return path;
            }
        }
        return null;  
    }
}