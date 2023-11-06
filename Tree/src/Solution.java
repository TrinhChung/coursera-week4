import java.io.*;
import java.util.*;
class Node {
    Node left;
    Node right;
    int data;

    Node(int data) {
        this.data = data;
        left = null;
        right = null;
    }
}
public class Solution {

    public static boolean checkLeft(Node node, int data) {
        if (node == null) return true;
        else {
            if (node.left != null) {
                if (node.left.data > node.data || node.left.data < data) return false;
            }
            return checkLeft(node.left, data);
        }
    }
    public static boolean checkRight(Node node, int data) {
        if (node == null) return true;
        else {
            if (node.right != null) {
                if (node.right.data < node.data || node.right.data > data) return false;
            }
            return checkRight(node.right,data);
        }
    }

    public static boolean checkBST(Node root) {
        if (root == null) return true;
        else {
            if (root.left != null) {
                if (root.left.data > root.data || !checkRight(root.left, root.data)) return false;
            }
            if (root.right != null) {
                if (root.right.data < root.data || !checkLeft(root.right, root.data)) return false;
            }
            boolean checkLeft = true;
            boolean checkRight = true;
            if (root.left != null) {
                checkLeft = checkBST(root.left);
            }
            if (root.right != null) {
                checkRight = checkBST(root.right);
            }
            if (!checkLeft || !checkRight) {
                return false;
            }
            return true;
        }
    }
    public static Node insert(Node root, int data) {
        if(root == null) {
            return new Node(data);
        } else {
            Node cur;
            if(data <= root.data) {
                cur = insert(root.left, data);
                root.left = cur;
            } else {
                cur = insert(root.right, data);
                root.right = cur;
            }
            return root;
        }
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int t = scan.nextInt();
        Node root = null;
        while(t-- > 0) {
            int data = scan.nextInt();
            root = insert(root, data);
        }
        scan.close();
        boolean check = checkBST(root);
        System.out.println();
        if(check) System.out.println("Yes");
        else {
            System.out.println("No");
        }
    }
}