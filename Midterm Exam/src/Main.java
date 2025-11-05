import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Random rand = new Random();

        CardStack playerDeck = new CardStack(30);
        CardStack playerHand = new CardStack(30);
        CardStack discardPile = new CardStack(30);

        String[] cardTypes = {
                "Red Card", "Blue Card", "Yellow Card", "Green Card",
                "+2 Card", "Reverse Card", "+4 Card", "Colorpick Card"
        };
        int[] cardCounts = {4, 4, 4, 4, 4, 4, 3, 3};

        Card[] allCards = new Card[30];
        int index = 0;

        // create deck
        for (int i = 0; i < cardTypes.length; i++) {
            for (int j = 0; j < cardCounts[i]; j++) {
                allCards[index++] = new Card(cardTypes[i]);
            }
        }

        // shuffles deck
        for (int i = 0; i < allCards.length; i++) {
            int swapIndex = rand.nextInt(allCards.length);
            Card temp = allCards[i];
            allCards[i] = allCards[swapIndex];
            allCards[swapIndex] = temp;
        }

        for (Card card : allCards) {
            playerDeck.push(card);
        }

        System.out.println("=== BOOTLEG UNO SIMULATOR YAYYYY ===\n");

        int turn = 1;
        while (!playerDeck.isEmpty()) {
            System.out.println("TURN " + turn++);
            int command = rand.nextInt(3); //

            switch (command) {
                case 0: // Draw x cards
                    int drawCount = rand.nextInt(5) + 1;
                    System.out.println("Command: Draw " + drawCount + " card(s)");
                    for (int i = 0; i < drawCount; i++) {
                        if (!playerDeck.isEmpty()) {
                            playerHand.push(playerDeck.pop());
                        } else {
                            System.out.println("No more cards to draw.");
                            break;
                        }
                    }
                    break;

                case 1: // discards x amnt of cards
                    int discardCount = rand.nextInt(5) + 1;
                    System.out.println("Command: Discard " + discardCount + " card(s)");
                    for (int i = 0; i < discardCount; i++) {
                        if (!playerHand.isEmpty()) {
                            discardPile.push(playerHand.pop());
                        } else {
                            System.out.println("No cards in hand to discard.");
                            break;
                        }
                    }
                    break;

                case 2: // gets x cards from discard
                    int getCount = rand.nextInt(5) + 1;
                    System.out.println("Command: Get " + getCount + " card(s) from discard pile");
                    for (int i = 0; i < getCount; i++) {
                        if (!discardPile.isEmpty()) {
                            playerHand.push(discardPile.pop());
                        } else {
                            System.out.println("No cards in discard pile to get.");
                            break;
                        }
                    }
                    break;
            }

            // Display status
            System.out.print("\nCurrent Hand: ");
            playerHand.display();
            System.out.println("Remaining in Deck: " + playerDeck.size());
            System.out.println("Cards in Discard Pile: " + discardPile.size());

            System.out.println("\nPress ENTER for next turn...");
            sc.nextLine();
            System.out.println();
        }

        System.out.println("=== GAME OVER ===");
        System.out.println("Deck is empty!");
        sc.close();
    }
}