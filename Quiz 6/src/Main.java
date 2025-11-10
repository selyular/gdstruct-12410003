public class Main {
    public static void main(String[] args) {
        Tree tree = new Tree();

        tree.insert(25);
        tree.insert(17);
        tree.insert(29);
        tree.insert(10);
        tree.insert(16);
        tree.insert(-5);
        tree.insert(60);
        tree.insert(55);

        System.out.print("In-order (ascending): ");
        tree.traverseInOrder();
        System.out.println();

        System.out.print("In-order (descending): ");
        tree.traverseInOrderDescending();
        System.out.println();

        Node minNode = tree.getMin();
        Node maxNode = tree.getMax();

        if (minNode != null) {
            System.out.println("Minimum value: " + minNode.getData());
        }
        if (maxNode != null) {
            System.out.println("Maximum value: " + maxNode.getData());
        }
    }
}
