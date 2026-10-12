import java.util.ArrayList;
import java.util.List;

public class BinaryTree {
    static class Node {
        int data;
        Node left, right;
        Node(int data) {
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }
    Node root;
    public Node buildTree(int[] arr, int i) {
        if (i >= arr.length) {
            return null;
        }

        Node curr = new Node(arr[i]);
        curr.left = buildTree(arr, 2 * i + 1);
        curr.right = buildTree(arr, 2 * i + 2);
        return curr;
    }

    public List<Integer> getInorder() {
        List<Integer> res = new ArrayList<>();
        inorderHelper(this.root, res);
        return res;
    }

    private void inorderHelper(Node node, List<Integer> res) {
        if (node == null) return;
        inorderHelper(node.left, res);
        res.add(node.data);
        inorderHelper(node.right, res);
    }

    public List<Integer> getPreorder() {
        List<Integer> res = new ArrayList<>();
        preorderHelper(this.root, res);
        return res;
    }

    private void preorderHelper(Node node, List<Integer> res) {
        if (node == null) return;
        res.add(node.data);
        preorderHelper(node.left, res);
        preorderHelper(node.right, res);
    }

    public List<Integer> getPostorder() {
        List<Integer> res = new ArrayList<>();
        postorderHelper(this.root, res);
        return res;
    }

    private void postorderHelper(Node node, List<Integer> res) {
        if (node == null) return;
        postorderHelper(node.left, res);
        postorderHelper(node.right, res);
        res.add(node.data);
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5, 6, 7};

        BinaryTree tree = new BinaryTree();
        tree.root = tree.buildTree(arr, 0);

        List<Integer> inOrder = tree.getInorder();
        List<Integer> preOrder = tree.getPreorder();
        List<Integer> postOrder = tree.getPostorder();

        System.out.println("Inorder:   " + inOrder);  
        System.out.println("Preorder:  " + preOrder);  
        System.out.println("Postorder: " + postOrder); 
    }
}