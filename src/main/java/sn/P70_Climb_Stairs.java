package sn;

/**
 * Climb Stairs
 *
 * @author wendell
 * @date 2020年6月22日18:56:21
 */
public class P70_Climb_Stairs {


    //转置
    public int climbStairs(int n) {
        int a = 0;
        int b = 1;
        int sum = 0;
        for (int i = 0; i < n; i++) {
            sum = a + b;
            a = b;
            b = sum;
        }
        return sum;
    }

    //递归超时
    public int recursive_way(int n) {
        if (n == 1) {
            return 1;
        }
        if (n == 2) {
            return 2;
        }
        if (n >= 3) {
            return recursive_way(n - 1) + recursive_way(n - 2);
        }
        return -1;
    }

    //dp


}
