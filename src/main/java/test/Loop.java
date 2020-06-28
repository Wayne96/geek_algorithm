package test;

import javax.swing.*;
import java.util.Iterator;
import java.util.PriorityQueue;
import java.util.Random;

public class Loop {

    public static void main(String[] args) {
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>();
        priorityQueue.add(1);
        priorityQueue.add(2);
        priorityQueue.add(3);
        priorityQueue.add(4);
        priorityQueue.add(5);
        priorityQueue.poll();

    }


    int[] a = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9};

    // double loop
    public void doubleLoop(int[] a) {
        for (int i = 0; i < a.length - 1; i++) {
            System.out.print(a[i] + " ");
            for (int j = i + 1; j < a.length; j++) {
                System.out.print(a[j] + " ");
            }
            break;
        }
    }

    public void tribeLoop(int[] a) {
        for (int i = 0; i < a.length - 2; i++) {
            System.out.print(a[i] + " ");
            for (int j = i + 1; j < a.length - 1; j++) {
                System.out.print(a[j] + " ");
                for (int k = j + 1; k < a.length; k++) {
                    System.out.print(a[k] + " ");
                }
                break;
            }
            break;
        }
    }


}
