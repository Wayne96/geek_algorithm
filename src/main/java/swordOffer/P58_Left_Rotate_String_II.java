package swordOffer;

public class P58_Left_Rotate_String_II {

    public static void main(String[] args) {
        P58_Left_Rotate_String_II p = new P58_Left_Rotate_String_II();
        System.out.println(p.reverseLeftWords("abc", 1));
    }

    public String reverseLeftWords(String s, int n) {
        if (s.length() == n) return s;
        return s.substring(n) + s.substring(0, n);
    }
}
