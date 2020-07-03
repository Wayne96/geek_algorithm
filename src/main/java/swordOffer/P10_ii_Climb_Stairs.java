package swordOffer;

/**
 * 青蛙跳台阶
 * 递归斐波那契栈溢出就不写了
 * 还有DP没写
 */
public class P10_ii_Climb_Stairs {

    public static void main(String[] args) {
        P10_ii_Climb_Stairs p = new P10_ii_Climb_Stairs();
        for (int i = 0; i < 10; i++) {
            System.out.print(p.numWays(i) + " ");
        }
    }

    public int numWays(int n) {
        if (n == 0) return 1;
        int a = 0;
        int b = 1;
        int sum = 0;
        for (int i = 0; i < n; i++) {
            sum = (a + b) % 1000000007;
            a = b;
            b = sum;
        }
        return sum;
    }

    // 官网解
    public int _numWays(int n) {
        int a = 1, b = 1, sum;
        for (int i = 0; i < n; i++) {
            sum = (a + b) % 1000000007;
            a = b;
            b = sum;
        }
        return a;
    }

}
