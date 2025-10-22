public class Main {
    public static void main(String[] args) {
        PlayerLinkedList list = new PlayerLinkedList();

        // Create players
        Player p1 = new Player(1, "Heathcliff", 90);
        Player p2 = new Player(2, "Asuna", 85);
        Player p3 = new Player(3, "LethalBacon", 99);
        Player p4 = new Player(4, "HPDeskjet", 70);

        // Add players to list
        list.addToFront(p4);
        list.addToFront(p3);
        list.addToFront(p2);
        list.addToFront(p1);

        // Print initial list
        list.printList();
        System.out.println("Size: " + list.getSize());

        // Test contains()
        System.out.println("\nContains Asuna? " + list.contains(p2));
        System.out.println("Contains Kirito? " + list.contains(new Player(5, "Kirito", 99)));

        // Test indexOf()
        System.out.println("Index of LethalBacon: " + list.indexOf(p3));
        System.out.println("Index of HPDeskjet: " + list.indexOf(p4));
        System.out.println("Index of NonExist: " + list.indexOf(new Player(6, "Sinon", 77)));

        // Test removeFromFront()
        System.out.println("\nRemoved from front: " + list.removeFromFront());
        list.printList();
        System.out.println("Size after removal: " + list.getSize());
    }
}