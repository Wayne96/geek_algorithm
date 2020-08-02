package swordOffer;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class P32 {
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public List<List<Integer>> _levelOrder(TreeNode root) {
        if (root == null) return new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        List<List<Integer>> nodes = new ArrayList<>();
        while (!queue.isEmpty()) {
            List<Integer> vals = new ArrayList<>();
            for (int i = queue.size(); i > 0; i--) {
                TreeNode node = queue.poll();
                vals.add(node.val);
                if (node.left != null) queue.add(node.left);
                if (node.right != null) queue.add(node.right);
            }
            nodes.add(vals);
        }
        return nodes;
    }
// class Solution {
//     private List<List<Integer>> list =new ArrayList<>();
//     public List<List<Integer>> levelOrder(TreeNode root) {
//         helper(root,0);
//         return list;
//     }
//     private void helper(TreeNode node,int index){//index记录树的深度
//         if (node==null)
//             return;
//         if (index==list.size()) {//如果深度超出了list的size，就说明到了最新的深度
//             List<Integer> mid = new ArrayList<>();
//             mid.add(node.val);
//             list.add(mid);
//         }
//         else{//若没超出，则添加到已有的深度
//             List<Integer> mid = list.get(index);
//             mid.add(node.val);
//             list.set(index,mid);
//         }
//         helper(node.left,index+1);//继续递归
//         helper(node.right,index+1);
//     }
// }

}
