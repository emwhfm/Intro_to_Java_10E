/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package weekhours;

/**
 *
 * @author emwhfm
 */
public class WeekHours {

    public static int[][] calcTotal(int[][] m) {
        int[][] tot = new int[m.length][2];
        
        for (int r=0; r<m.length; r++) {
            tot[r][0] = r;
            for (int k=0; k<m[0].length; k++) {
                tot[r][1] += m[r][k]; 
            }
        }
                
        return tot;
    }
    
    public static void printDecreasing(int[][] m) {
                
        //java.util.Arrays.sort(m, new ColumnComparator(1));
        
        for (int r=0; r<m.length; r++) {
            int min = 0xFFFF;
            int index = 0;
            for (int i=0; i<m.length; i++) {
                if (m[i][1] < min) {
                    min = m[i][1];
                    index = i;
                }
            }
            System.out.println("Employee " + index + " total hours: " + min);
            m[index][1] = 0XFFFF;
        }
        
    }
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        int[][] employee = { {2, 4, 3, 4, 5, 8, 8},
                             {7, 3, 4, 3, 3, 4, 4},
                             {3, 3, 4, 3, 3, 2, 2},
                             {9, 3, 4, 7, 3, 4, 1},
                             {3, 5, 4, 3, 6, 3, 8},
                             {3, 4, 4, 6, 3, 4, 4},
                             {3, 7, 4, 8, 3, 8, 4},
                             {6, 3, 5, 9, 2, 7, 9} };
        
        int[][] total = calcTotal(employee);
        //System.out.println(java.util.Arrays.toString(total[0]));
        
        printDecreasing(total);
    }
    
}
