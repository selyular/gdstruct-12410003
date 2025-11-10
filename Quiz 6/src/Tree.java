public class Tree {
    private Node root;

    public void insert(int value) {
        if (root == null) {
            root = new Node(value);
        } else {
            root.insert(value);
        }
    }

    public void traverseInOrder() {
        if (root != null) {
            root.traverseInOrder();
        }
    }

    // node w min value
    public Node getMin() {
        if (root == null) {
            return null;
        }

        Node current = root;
        while (current.getLeftChild() != null) {
            current = current.getLeftChild();
        }
        return current;
    }

    // node w largest value
    public Node getMax() {
        if (root == null) {
            return null;
        }

        Node current = root;
        while (current.getRightChild() != null) {
            current = current.getRightChild();
        }
        return current;
    }

    // it go down lamaw
    public void traverseInOrderDescending() {
        if (root != null) {
            traverseInOrderDescending(root);
        }
    }

    private void traverseInOrderDescending(Node node) {
        if (node != null) {
            traverseInOrderDescending(node.getRightChild());
            System.out.print(node.getData() + " ");
            traverseInOrderDescending(node.getLeftChild());
        }
    }
}
