/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package substitution_techniques;

import java.util.HashMap;
import java.util.Scanner;

/**
 *
 * @author Sonal L R
 */
public class EX_1D_Vignere_Cipher {
    public static void main(String[] args) {
        char[][] board = new char[26][26];
        int ascii = 65;
        for (int i = 0; i < 26; i++) {
            for (int j = 0; j < 26; j++) {
                if (ascii > 90) {
                    ascii = ascii - 26;
                }
                board[i][j] = (char) ascii;
                ascii++;
            }
            ascii++;
        }
        //print matrix
        for (char[] arr : board) {
            for (char c : arr) {
                System.out.print(c + " ");
            }
            System.out.println("");
        }
        HashMap<Character, Integer> hmap1 = new HashMap<>();
        HashMap<Integer,Character> hmap2 = new HashMap<>();
        ascii = 65;
        for (int i = 0; i < 26; i++) {
            hmap1.put((char) ascii, i);
            hmap2.put(i,(char) ascii);
            ascii++;
        }
        System.out.println(hmap1);

        Scanner sc = new Scanner(System.in).useDelimiter("\n");
        String txt = sc.next();
        String key = sc.next();

        txt = txt.replaceAll("\\s", "");
        key = key.replaceAll("\\s", "");

        //ENCRYPTION
        String cipher = "";
        for (int i = 0; i < txt.length(); i++) {
            int y = hmap1.get(txt.charAt(i));
            int x = hmap1.get(key.charAt(i));
            cipher += board[x][y];
        }
        System.out.println("Encrypted Text is :" + cipher);

        //DECRYPTION
        String res="";
        for (int i = 0; i < key.length(); i++) {
            int row = hmap1.get(key.charAt(i));
            for(int j=0;j<26;j++){
                if(board[row][j]==cipher.charAt(i)){
                    res+=hmap2.get(j);
                    break;
                }
            }
        }
        System.out.println("Decrypted Text is : "+res);
    }
}