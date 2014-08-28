/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package hex2dec;

/**
 *
 * @author emwhfm
 */
public class HexFormatException extends Exception {
    
    private char hexChar;
    
    public HexFormatException(char hexChar) {
        super("Invalid char: " + hexChar);
        this.hexChar = hexChar;
    }
    
    public char getChar() {
        return hexChar;
    }
}
