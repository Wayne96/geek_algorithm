package sort;

import java.util.Arrays;

public class Heap_Sort {
    //{0, 3, 2, 3, 1, 2, 4, 5, 5, 6};
    public static void main(String[] args) {
        int[] a = {0, 7, 5, 19, 8, 4, 1, 20, 13, 16};
        Heap_Sort heap_sort = new Heap_Sort();
        heap_sort.sort(a, a.length - 1);
        System.out.println(Arrays.toString(a));
        int[] b = Arrays.copyOf(a, a.length + 1);
        Arrays.toString(b);
    }

    // 堆底层用数组实现
    // 下标为 i 的节点的左子节点是下标 2i 右子节点是 2i + 1
    // 对于完全二叉树来说，下标从 n/2+1 到 n 的节点都是叶子节点
    public void buildHeap(int[] a, int n) {
        // 从第一个非叶子节点开始堆化
        for (int i = n / 2; i >= 1; --i) {
            heapify(a, n, i);
        }
    }

    // 堆化数组 节点数 节点位置 建堆过程是O(N)
    private void heapify(int[] a, int n, int i) {
        while (true) {
            int maxPos = i;
            // 左节点位置小于节点数（即角标小于数组）
            // 根节点小于左节点 根节点换成左节点
            if (i * 2 <= n && a[i] < a[i * 2]) maxPos = i * 2;
            // 同样的角标限制条件
            // 如果左节点小于右节点 根节点换成右节点
            if (i * 2 + 1 <= n && a[maxPos] < a[i * 2 + 1]) maxPos = i * 2 + 1;
            // 如果maxPos没变 说明其左右节点都没它大
            if (maxPos == i) break;
            // 将节点值进行交换
            swap(a, i, maxPos);
            i = maxPos;
        }
    }

    public void sort(int[] a, int n) {
        // 进来的是未堆化数组 先进行堆化
        buildHeap(a, n);
        // 堆化之后保证堆中每一个节点的值都必须大于等于（或小于等于）其子树中每个节点的值
        // 从最后一个叶子节点开始 从下向上排序?
        int k = n;
        while (k > 1) {
            // 节点与根节点交换 即将最大值放到数组末尾
            // 即从小到大排序
            swap(a, 1, k);
            // --k的意思是对少去一个对元素 因为最大的值已经不再堆中了
            --k;
            // 再次堆化 将整个堆建起 保证最大值在堆顶
            // 如此往复循环直到排序完毕
            heapify(a, k, 1);
        }
    }

    private void swap(int[] a, int i, int maxPos) {
        int temp = a[i];
        a[i] = a[maxPos];
        a[maxPos] = temp;
    }
}
