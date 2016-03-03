/*
 * HuffmanChar.java
 *
 * Created on May 22, 2007, 5:26 PM
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package huffman;
import java.io.*;
/**
 *
 * @author pbladek
 */
public class HuffmanChar extends HuffmanData<Character>
        implements Serializable
{    
    /**
     * Creates a new instance of HuffmanChar
     */
    public HuffmanChar()
    {
        super();
    }
    
    /**
     *  Creates a new instance of HuffmanChar
     * @param c the character
     */
    public HuffmanChar(Character c)
    {
        super(c);
    }

    /**
     * Creates a new instance of HuffmanChar
     * @param c the character
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
            (((int)threeBytes[2] >= 0 ? (int)threeBytes[2]
            : (256 + (int)threeBytes[2])) << 8)
            | ((int)threeBytes[2] >= 0 ? (int)threeBytes[2]
            : 256 + (int)threeBytes[2]));
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
        ba[1] = (byte)(oc >> 8);
        ba[2] = (byte)(oc & (byte)(-1));
        return ba; 
    }

}
