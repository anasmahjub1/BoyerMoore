/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package boyermoore;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;

/**
 *
 * @author AnasMahjub
 * whatsUpp : 00972594255556
 */
public class BoyerMooreClass {


    public int search(String text, String pattern) {

        int pattern_length = pattern.length(); //m
        int text_length = text.length(); //n 
        int skip;
        for (int i = 0; i <= text_length - pattern_length; i += skip) {
            skip = 0;
            for (int j = pattern_length - 1; j >= 0; j--) {

                if (pattern.charAt(j) != text.charAt(i + j)) {

                    String[][] shift = drow_shift_table(pattern);
                    String[][] suffix = drow_suffix_table(pattern);
                    int shift_back = pattern_length;
                    int suffix_back = 0;
                    
                     Character[] arrayOfChar = getCharArray(pattern.toCharArray());

                    for (int k = arrayOfChar.length - 1; k >= 0; k--) {

                        if (shift[k][0].equals(text.charAt(j) + "")) {
                            shift_back = Integer.parseInt(shift[k][1]);

                        }

                    }
                    for (int k = pattern_length - 1; k >= 0; k--) {

                        if (suffix[k][0].equals(text.substring(k, pattern_length) + "")) {
                            suffix_back = Integer.parseInt(suffix[k][1]);

                        }
                    }

                    skip = Math.abs(shift_back - suffix_back);

                    break;
                }
            }
            if (skip == 0) {
                return i;    // found
            }
        }
        return -1;                       // not found
    }


    public String[][] drow_suffix_table(String pattern) {

        int pattern_length = pattern.length();
        String[][] suffix = new String[pattern_length][2];

        for (int i = 0; i <= pattern_length - 1; i++) {

            suffix[i][0] = pattern.substring(i, pattern_length);

            int index = pattern.indexOf(suffix[i][0]);
            int val = pattern_length;

            if (index == i) {
                val = pattern_length;
            } else if (suffix[i][0].length() > 1) {
                val = pattern_length - index - suffix[i][0].length();
            } else {
                val = pattern_length - index - 1;

            }
            suffix[i][1] = Integer.toString(val);

        }

        return suffix;
    }

    public String[][] drow_shift_table(String pattern) {

        int pattern_length = pattern.length();
        Character[] arrayOfChar = getCharArray(pattern.toCharArray());

        String[][] shift = new String[arrayOfChar.length][2];

        for (int i = 0; i <= arrayOfChar.length - 1; i++) {
            shift[i][0] = String.valueOf(arrayOfChar[i]);
            shift[i][1] = pattern_length - pattern.indexOf(shift[i][0]) - 1 + "";
        }
        return shift;
    }

    private Character[] getCharArray(char[] array) {
        HashSet<Character> set = new HashSet<>();
        for (int i = 0; i < array.length; i++) {
            set.add(array[i]);
        }

        return set.toArray(new Character[set.size()]);
    }

}
