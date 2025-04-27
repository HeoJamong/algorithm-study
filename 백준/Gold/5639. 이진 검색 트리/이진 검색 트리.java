import java.io.*;

public class Main {
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    static class Node {
        int value;
        Node left, right;

        Node(int value) {
            this.value = value;
        }

        void insert(int val) {
            if (val < this.value) {
                if (this.left == null) {
                    this.left = new Node(val);
                } else {
                    this.left.insert(val);
                }
            } else {
                if (this.right == null) {
                    this.right = new Node(val);
                } else {
                    this.right.insert(val);
                }
            }
        }
    }

    public static void postOrder(Node node) {
        if (node == null) return;
        postOrder(node.left);
        postOrder(node.right);
        System.out.println(node.value);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));


        Node root = null;
        String input;

        while ((input = br.readLine()) != null && !input.isEmpty()) {
            int num = Integer.parseInt(input);
            if (root == null) {
                root = new Node(num);
            } else {
                root.insert(num);
            }
        }

        postOrder(root);
    }
}
