public class CardStack {
    private Card[] cards;
    private int top;

    public CardStack(int capacity) {
        cards = new Card[capacity];
        top = -1;
    }

    public boolean isEmpty() {
        return top == -1;
    }

    public boolean isFull() {
        return top == cards.length - 1;
    }

    public void push(Card card) {
        if (!isFull()) {
            cards[++top] = card;
        }
    }

    public Card pop() {
        if (!isEmpty()) {
            return cards[top--];
        }
        return null;
    }

    public int size() {
        return top + 1;
    }

    public void display() {
        if (isEmpty()) {
            System.out.println("(empty)");
            return;
        }
        for (int i = 0; i <= top; i++) {
            System.out.print(cards[i] + (i < top ? ", " : ""));
        }
        System.out.println();
    }
}
