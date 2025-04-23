import java.util.*;

/* (1) Height of a tree
(2) Count number of nodes in a tree
(3) Search a value in tree
(4) Count/Find number of leaf nodes in a tree
(5) Print nodes at a level
(6) Insert a node
(7) Sum of all nodes  */

public class Trees {
    static class TreeNode{
        int data;
        TreeNode left, right;
        TreeNode(int value){
            data = value;
            left = right = null;
        }
    }

    public static int height(TreeNode root){
        if (root==null) return 0;
        int leftHeight = height(root.left);
        int rightHeight = height(root.right);
        return Math.max(leftHeight, rightHeight)+1;
    }

    public static int countNodes(TreeNode root){
        if (root==null) return 0;
        return 1 + countNodes(root.left) + countNodes(root.right);
    }

    public static boolean searchValue(TreeNode root, int key){
        if (root==null) return false;
        if (root.data==key) return true;
        return searchValue(root.left, key) || searchValue(root.right, key);
    }

    public static int leafnodes(TreeNode root){
        if (root==null) return 0;
        if (root.left==null && root.right==null) return 1;
        return leafnodes(root.left) + leafnodes(root.right);
    }

    public static void print(TreeNode root,int level){
     if (root==null) return ;
     if (level==1) System.out.print(root.data+" ");
     else{
         print(root.left,level-1);
         print(root.right,level-1);
     }
    }

    public static void insert(TreeNode root,TreeNode x){
        if (root==null) return;

        if (root.left!=null&&root.right==null){
            root.right=x;
            return;
        }
        if (root.left==null&&root.right!=null){
            root.left=x;
            return;
        }
        insert(root.left,x);
        insert(root.right,x);
    }

    public static int sumOfNodes(TreeNode root) {
        if (root == null) return 0;
        return root.data + sumOfNodes(root.left) + sumOfNodes(root.right);
    }

    public static void main(String[] args){
        TreeNode root = new TreeNode(10);
        root.left = new TreeNode(20);
        root.right = new TreeNode(30);
        root.left.left = new TreeNode(40);
        root.right.right = new TreeNode(50);
        System.out.println("Height of a Tree: " + height(root));
        System.out.println("Number of Nodes: " + countNodes(root));
        System.out.println("Is 40 in Tree: " + searchValue(root, 40));
        System.out.println("Is 4 in Tree: " + searchValue(root, 4));
        System.out.println("No. of Leaf Nodes: " + leafnodes(root));
        System.out.print("Nodes at level 2: ");
        print(root,2);
        System.out.println();
        int node = 60;
        TreeNode x = new TreeNode(node);
        insert(root,x);
        System.out.println("New Number of Nodes: " + countNodes(root));
        System.out.println("Sum of all nodes: " + sumOfNodes(root));
    }
}