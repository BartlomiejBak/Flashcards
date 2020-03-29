package flashcards;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("Input the number of cards:");
        int num = Integer.parseInt(in.nextLine());
        Deck deck = new Deck(num);
        deck.fillDeck();
        deck.learn();
    }
}
