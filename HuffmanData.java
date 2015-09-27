/*
 * HuffmanData.java
 *
 * Created on May 21, 2007, 2:17 PM
 */

package huffman;
import java.lang.*;

/**
 * @author pbladek
 */
public class HuffmanData<T extends Comparable<? super T>>
        implements Comparable<HuffmanData<T>>
{
    private T data;
    private int occurances = 0;
    
    /**
     * Creates a new instance of HuffmanData
     */
    public HuffmanData(){}
    
    /** Creates a new instance of HuffmanData
     * @param dataIn the data part
     */
    public HuffmanData(T dataIn)
    {
        data = dataIn;
    }
  
    /** Creates a new instance of HuffmanData
     * @param dataIn the data part
     * @param count the number of occurances
     */
    public HuffmanData(T dataIn, int count)
    {
        this(dataIn);
        occurances = count;   
    }
    
    /*
     * accessor
     * @return data
     */
    public T getData()
    {
        return data;
    }
    
    /*
     * accessor
     * @return occurances
     */
    public int getOccurances()
    {
        return occurances;
    }
    
    /**
     *
     * @param o the other HuffmanData
     * @return -1 if <, 0 if ==, 1 if >
     */

    public int compareTo(HuffmanData<T> o)
    {
        return (occurances < o.occurances)? -1
                : (occurances == o.occurances)? 0 : 1;
    }
    
    /*
     * @return strng version of class
     */
    public String toString()
    {
        String dataString = "*";
        if(data != null)
            dataString = data.toString(); 
        return dataString + ": " + occurances + " ";
    }
    
}
