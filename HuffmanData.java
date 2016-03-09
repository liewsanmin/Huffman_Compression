/**
 * Class:           HuffmanData
 * File:            HuffmanData.java 
 * Description:     The class for holding the data of character and
 *                  its occurring frequency.
 * Date:            6/14/2015
 * Course:          CS 143
 * @author          San Min Liew, Hao TU, Devin Stoen, Fnu Michael
 * @version         1.0
 * Environment:     PC, Windows 8, jdk 1.8.0_20, Netbeans 8.0.1
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
     * accessor for the data
     * @return data - huffchar instance
     */
    public T getData()
    {
        return data;
    }
    
    /*
     * accessor to the occurance
     * @return occurances - frequency of character
     */
    public int getOccurances()
    {
        return occurances;
    }
    
    /**
     * compares the parameter and actual HuffmanData
     * @param o the other HuffmanData
     * @return -1 if less than, 0 if equals, 1 if more than
     */
    public int compareTo(HuffmanData<T> o)
    {
        return (occurances < o.occurances)? -1
                : (occurances == o.occurances)? 0 : 1;
    }
    
    /**
     * returns the string version of class
     * @return string version of class
     */
    public String toString()
    {
        String dataString = "*";
        if(data != null)
            dataString = data.toString(); 
        return dataString + ": " + occurances + " ";
    }
}