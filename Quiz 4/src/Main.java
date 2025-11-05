public class Main {

    public static void main(String[] args) {

        Player ploo = new Player(134, "Ploof", 135);
        Player wardell = new Player(530, "TSN Mardell", 640);
        Player deadlyJimmy = new Player(32, "DeadlyJimmy", 34);
        Player subroza = new Player(4931, "Subroza", 604);
        Player annieDro = new Player(6919, "C9 Annie", 593);

        SimpleHashtable hashtable = new SimpleHashtable();

        hashtable.put(ploo.getUserName(), ploo);
        hashtable.put(wardell.getUserName(), wardell);
        hashtable.put(deadlyJimmy.getUserName(), deadlyJimmy);
        hashtable.put(subroza.getUserName(), subroza);
        hashtable.put(annieDro.getUserName(), annieDro);

        System.out.println("--- Printing Hashtable Contents ---");
        hashtable.printHashtable();

        System.out.println("\n--- Testing Get Method ---");

        System.out.println(hashtable.get("Subroza"));

        System.out.println(hashtable.get("DeadlyJimmy"));

        System.out.println("\n--- Removing Subroza ---");
        Player removed = hashtable.remove("Subroza");
        System.out.println("Removed: " + removed);

        System.out.println("\n--- After Removal ---");
        hashtable.printHashtable();
    }
}
