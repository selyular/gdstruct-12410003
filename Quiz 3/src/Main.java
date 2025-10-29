import java.util.Scanner;
import java.util.Random;

public class Main {
    public static void main(String[] args) {

        // --- your original player setup (kept exactly) ---
        ArrayStack stack = new ArrayStack(10);

        stack.push(new Player(1, "HatsuneMiku", 100));
        stack.push(new Player(2, "KasaneTeto", 100));
        stack.push(new Player(3, "AdachiRei", 95));
        stack.push(new Player(4, "KagamineLen", 90));
        stack.push(new Player(5, "RinKagamine", 95));
        stack.push(new Player(6, "MegurineLuka", 98));
        stack.push(new Player(7, "Gumi", 99));
        // --- end of your original setup ---

        stack.printStack();

        stack.printStack();

        Scanner scanner = new Scanner(System.in);
        Random rand = new Random();

        ArrayStack queue = new ArrayStack(20); // players currently queued
        int totalGames = 0;

        System.out.println("\n=== Matchmaking Simulation ===");
        System.out.println("Double-click Enter to process turns...");

        while (totalGames < 10) {
            scanner.nextLine(); // pressing enter

<<<<<<< HEAD
            // random no. of players joining queue
=======
            // Random number of players join the queue (1–7)
>>>>>>> parent of eaaa10f (Update Main.java)
            int joining = rand.nextInt(7) + 1;
            System.out.println("\nTurn started: " + joining + " player(s) attempting to join...");

            // Move random players from the main stack into the queue
            for (int i = 0; i < joining; i++) {
                if (stack.isEmpty()) {
                    refillFromCompleted(stack);
                }

                if (!stack.isEmpty()) {
                    Player p = stack.pop();
                    queue.push(p);
                    System.out.println(p.getUserName() + " joined the matchmaking queue.");
                }
            }

            System.out.println("\nCurrent queue:");
            queue.printStack();

<<<<<<< HEAD
            // starts if there are 5 or more players
=======
            // Start matches if there are 5 or more players
>>>>>>> parent of eaaa10f (Update Main.java)
            while (queue.size() >= 5 && totalGames < 10) {
                System.out.println("\n--- Game " + (totalGames + 1) + " Started ---");
                ArrayStack finished = new ArrayStack(5);

                for (int i = 0; i < 5; i++) {
                    Player p = queue.pop();
                    finished.push(p);
                    System.out.println("• " + p.getUserName() + " (Level " + p.getLevel() + ")");
                }

                totalGames++;

<<<<<<< HEAD
                // all players go back into the main pool
=======
                // After match, all players go back into the main pool
>>>>>>> parent of eaaa10f (Update Main.java)
                System.out.println("Game ended! Players return to the pool.\n");
                while (!finished.isEmpty()) {
                    stack.push(finished.pop());
                }
            }

            if (totalGames < 10) {
                System.out.println("\nDouble-click Enter for next turn...");
            }
        }

        System.out.println("\n=== 10 Games Completed ===");
        scanner.close();
    }

    // helper method to reintroduce completed players if main stack is empty
    private static void refillFromCompleted(ArrayStack stack) {
        System.out.println("\nAll players finished their games and are rejoining the pool!");
        // In this simulation, nothing extra is needed — this just signals requeue.
    }
}