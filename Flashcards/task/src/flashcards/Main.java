package flashcards;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("Input the number of cards:");
        int num = in.nextInt();
        in.nextLine();
        Card[] deck = new Card[num];
        String term = "";
        String def = "";

        for (int i = 0; i < deck.length; i++) {

            System.out.printf("The card #%d:%n", i + 1);
            term = in.nextLine();
            System.out.printf("The definition of the card #%d:%n", i + 1);
            def = in.nextLine();
            deck[i] = new Card(term, def);
        }

        for (Card card : deck) {
            System.out.println("Print the definition of \"" + card.getTerm() + "\":");
            if (card.getDefinition().equals(in.nextLine())) {
                System.out.println("Correct answer");
            } else {
                System.out.println("Wrong answer. The correct one is \"" + card.getDefinition() + "\".");
            }
        }
    }
}
