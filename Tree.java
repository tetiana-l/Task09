package Task09;

public class Tree {

    Node root = new Node(7);

    public void add(int value) {
        addRecursive(root, value);
    }

    private void addRecursive(Node node, int value) {

        if (value <= node.value) {
            if (node.left != null) {
                addRecursive(node.left, value);
            } else {
                node.left = new Node(value);
            }
        } else {
            if (node.right != null) {
                addRecursive(node.right, value);
            } else {
                node.right = new Node(value);
            }
        }
    }

    public void print() {
        printRecursive(root);
    }

    private void printRecursive(Node node) {
        if (node.left != null) {
            printRecursive(node.left);
        }
        System.out.println(node.value);
        if (node.right != null) {
            printRecursive(node.right);
        }
    }
}

