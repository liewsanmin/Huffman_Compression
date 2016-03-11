import java.io.*;

/**
 * Class:           HuffmanChar
 * File:            HuffmanChar.java 
 * Description:     HuffmanChar extends HuffmanData which has several 
 *                  constructors, it holds the char and their respective
 *                  frequencies.
 * Date:            6/11/2015
 * Course:          CS 143
 * @author          San Min Liew, Hao Tu, Devin Stoen, Fnu Michael
 * @version         1.0
 * Environment:     PC, Windows 8, jdk 1.8.0_20, Netbeans 8.0.1
 * @see             javax.swing.JFrame
 */
public class HuffmanChar extends HuffmanData<Character>
        implements Serializable
{  
    //if is for txt file
    public static final int BITS_IN_BYTE = 8;
    public static final int BYTE_SIZE_NUMBER = 256;

    //if is for Unicode
    // public static final int BITS_IN_BYTE = 16;
    // public static final int BYTE_SIZE_NUMBER = 65536;
  
    /**
     * Creates a new instance of HuffmanChar
     */
    public HuffmanChar()
    {
        super();
    }
    
    /**
     *  Creates a new instance of HuffmanChar
     * @param c the char
     */
    public HuffmanChar(Character c)
    {
        super(c);
    }

    /**
     * Creates a new instance of HuffmanChar
     * @param c the char
     * @param oc the number of occurances
     */

    public HuffmanChar(Character c, int oc)
    {
        super(c, oc);
    }
    
     /**
      *  Creates a new instance of HuffmanChar
      * @param hc a HuffmanChar
      */
    public HuffmanChar(HuffmanChar hc)
    {
        super(hc.getData(), hc.getOccurances());
    }
   
    /**
     *  Creates a new instance of HuffmanChar
     * @param threeBytes an array of three bytes
     */
    public HuffmanChar(byte[] threeBytes)
    {
        super(new Character((char)threeBytes[0]),
            ((int)threeBytes[2]) >= 0 ? (int)threeBytes[2] |
                    ((int)threeBytes[1] << BITS_IN_BYTE)
            : ((BYTE_SIZE_NUMBER + (int)threeBytes[2]) +
                    ((int)threeBytes[1] << BITS_IN_BYTE)));
    }
    
    /**
     * returns the class converted to a 3-byte array
     * @return the class converted to a 3-byte array
     */
    public byte[] toThreeBytes()
    {
        byte[] ba = new byte[3];
        ba[0] = (byte)(getData().charValue());
        short oc = (short)getOccurances();
        ba[1] = (byte)(oc >> BITS_IN_BYTE);
        ba[2] = (byte)(oc & (byte)(-1));
        return ba; 
    }
}
