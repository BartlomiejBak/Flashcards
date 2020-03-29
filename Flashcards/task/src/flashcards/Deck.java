package flashcards;

import java.util.LinkedHashMap;
import java.util.Scanner;

public class Deck {
    protected int size;
    protected LinkedHashMap<String, String> deck;

    public Deck(int size) {
        this.size = size;
        this.deck = new LinkedHashMap<>();
    }

    public void fillDeck() {
        Scanner in = new Scanner(System.in);
        String key;
        String def;

        for (int i = 0; i < this.size; i++) {
            System.out.printf("The card #%d:%n", i + 1);
            key = in.nextLine();
            while (deck.containsValue(key)) {
                System.out.println("The card \"" + key + "\" already exists.");
                key = in.nextLine();
            }
            System.out.printf("The definition of the card #%d:%n", i + 1);
            def = in.nextLine();
            while (deck.containsKey(def)) {
                System.out.println("The definition \"" + def + "\" already exists.");
                def = in.nextLine();
            }
            //this solution simplifies learn() method
            deck.put(def, key);
        }
    }

    public void learn () {
        Scanner in = new Scanner(System.in);
        for (String s : deck.keySet()) {
            System.out.println("Print the definition of \"" + deck.get(s) + "\":");
            String def = in.nextLine();
            if (def.equals(s)) {
                System.out.println("Correct answer.");
            } else if (deck.containsKey(def)) {
                System.out.println("Wrong answer. The correct one is \"" + s +
                        "\", you've just written the definition of \"" + deck.get(def) + "\"");
            } else {
                System.out.println("Wrong answer. The correct one is \"" + s + "\"");
            }
        }
    }

}
