package swordOffer;

public class P15 {

    public int hammingWeight(int n) {
        int count = 0;
        while ((n = n >> 1) != 0) {
            count++;
        }
        return count;
    }

    public static void main(String[] args) {
        P15 p = new P15();
        System.out.println(11 ^ 1);
        System.out.println(p.hammingWeight(1));
    }
}
