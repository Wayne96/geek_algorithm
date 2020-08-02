package swordOffer;

import java.util.Arrays;

public class P58_Reverse_Words {

    public String reverseWords(String s) {
        String newS = s.trim();
        StringBuilder sb = new StringBuilder(newS.length());
        String[] words = newS.split(" ");
        System.out.println(Arrays.toString(words));
        for (int i = words.length - 1; i >= 0; i--) {
            if (words[i].equals("")) {
                continue;
            }
            sb.append(words[i].trim());
            if (i == 0) {
                break;
            }
            sb.append(" ");
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        P58_Reverse_Words p = new P58_Reverse_Words();
        String s = "a good   example";
        System.out.println(" good".trim());
        System.out.println(p.reverseWords(s));
    }
}
