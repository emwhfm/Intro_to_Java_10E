/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package filewordcount;

import java.io.File;
import java.util.Scanner;

/**
 *
 * @author emwhfm
 */
public class FileWordCount {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws Exception {
        if (args.length != 1) {
            System.out.println("Usage: java FileWordCount sourceFile");
            System.exit(1);
        }
        
        // Check if source file exists
        File sourceFile = new File(args[0]);
        if (!sourceFile.exists()) {
            System.out.println("Source file " + args[0] + " does not exist");
            System.exit(2);
        }
        
        int tot_ch = 0;
        int tot_wd = 0;
        int tot_ln = 0;
        
        try (Scanner input = new Scanner(sourceFile)) {
            while (input.hasNext()) {
                String str = input.nextLine();
                // Lines
                tot_ln++;
                // Words
                String[] tmpArray = str.split(" ");
                tot_wd += tmpArray.length;
                // Chars
                tot_ch += str.length();
            }
        }
        
        System.out.println(tot_ch + " characters");
        System.out.println(tot_wd + " words");
        System.out.println(tot_ln + " lines");
    }
    
}
