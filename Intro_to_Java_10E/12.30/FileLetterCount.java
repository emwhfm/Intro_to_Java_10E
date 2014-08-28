/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package filelettercount;

import java.io.File;
import java.util.Scanner;

/**
 *
 * @author emwhfm
 */
public class FileLetterCount {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws Exception {
        
        int[] letterArray = new int['Z' - 'A' + 1];
        
        Scanner input = new Scanner(System.in);
        System.out.print("Enter a filename: ");
        String filename = input.next();
        
        File sourceFile = new File(filename);
        if (!sourceFile.exists()) {
            System.out.println("File " + filename + " does not exist");
            System.exit(1);
        }
        
        try (Scanner infile = new Scanner(sourceFile)) {
            while (infile.hasNext()) {
                String str = infile.nextLine();
                //System.out.println(str);
                countLetters(str, letterArray);
            }
        }
        
        printResult(letterArray);
    }
    
    private static void countLetters(String str, int[] myArr)  {
        for(int i=0; i<str.length(); i++) {
            char ch = Character.toUpperCase(str.charAt(i));
            //System.out.println(ch);
            if (ch >= 'A' && ch <= 'Z') {
                myArr[ch - 'A']++;
            }
        }
    }
    
    private static void printResult(int[] myArr) {
        char ch = 'A';
        for(int i=0; i< myArr.length; i++) {            
            System.out.println("Number of " + ch++ + "'s: " + myArr[i]);
        }
    }
    
}
