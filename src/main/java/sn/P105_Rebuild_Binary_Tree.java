package sn;

/**
 * @author Wendell
 * @Date 2020-6-27  11:13:28
 */
public class P105_Rebuild_Binary_Tree {

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        return reConstructBinaryTree(preorder, 0, preorder.length - 1, inorder, 0, inorder.length - 1);
    }

    //前序遍历{1,2,4,7,3,5,6,8}和中序遍历序列{4,7,2,1,5,3,8,6}
    public TreeNode reConstructBinaryTree(int[] pre, int preStart, int preEnd, int[] in, int inStart, int inEnd) {
        //确定边界？
        if (preStart > preEnd || inStart > inEnd) {
            return null;
        }
        //前序数组[0]=必为根节点
        TreeNode root = new TreeNode(pre[preStart]);

        //遍历中序数组 找当前根节点 这样就可以在中序数组中区分左右子树
        for (int i = inStart; i <= inEnd; i++) {
            //确定当前根节点在中序数组中的位置
            if (in[i] == pre[preStart]) {
                //分别确定前序和中序数组中的左右子树
                //左子树范围  前序preStart+1    preStart+i-inStart    中序inStart  i-1
                //右子树范围  前序preStart+i-inStart+1     preEnd     中序i+1      inEnd
                root.left = reConstructBinaryTree(pre, preStart + 1, preStart + i - inStart, in, inStart, i - 1);
                root.right = reConstructBinaryTree(pre, preStart + i - inStart + 1, preEnd, in, i + 1, inEnd);
                break;
            }
        }
        return root;
    }

    //Definition for a binary tree node.
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

}
