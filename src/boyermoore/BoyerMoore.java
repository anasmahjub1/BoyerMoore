/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package boyermoore;

import java.util.Arrays;


/**
 *
 * @author Anas Mahjub
 * whatsUpp : 00972594255556
 */
public class BoyerMoore {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        String pat = "mhazem";
        String txt = "hazem anss hazem anas mahjub";

        BoyerMooreClass boyermoore1 = new BoyerMooreClass();

        /////////////////
        String[][] suffix = boyermoore1.drow_suffix_table(pat);
        System.out.println("----------------");
        System.out.println("- Suffix Table -");
        System.out.println("----------------");

        for (int i = pat.length() - 1; i >= 0; i--) {
            System.out.println(suffix[i][0] + " \t   " + suffix[i][1]);
        }

        /////////////////
        String[][] shift = boyermoore1.drow_shift_table(pat);
        System.out.println("----------------");
        System.out.println("-- Shift Table--");
        System.out.println("----------------");

        for (int i = 0; i <= shift.length - 1; i++) {
            System.out.println("" + shift[i][0] + " \t   " + shift[i][1]);
        }
        System.out.println("----------------");

        System.out.println("we found the pattern in index : " + boyermoore1.search(txt, pat));


    }

}
