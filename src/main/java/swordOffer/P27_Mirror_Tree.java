package swordOffer;

public class P27_Mirror_Tree {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public TreeNode mirrorTree(TreeNode root) {
        if (root != null) {
            mirrorTree(root.left);
            mirrorTree(root.right);
            swap(root);
        }
        return root;
    }

    private void swap(TreeNode root) {
        TreeNode temp = root.left;
        root.left = root.right;
        root.right = temp;
    }

}
