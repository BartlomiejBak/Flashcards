package flashcards;

import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {
        Scanner in = new Scanner(System.in);
        Deck deck = new Deck();
        boolean exit = false;
        while (!exit) {
            System.out.println("Input the action (add, remove, import, export, ask, exit):");
            String action = in.next();
            switch (action) {
                case "add":
                    deck.add();
                    System.out.println();
                    break;
                case "remove":
                    deck.remove();
                    System.out.println();
                    break;
                case "import":
                    deck.importDeck();
                    System.out.println();
                    break;
                case "export":
                    deck.export();
                    System.out.println();
                    break;
                case "ask":
                    deck.ask();
                    System.out.println();
                    break;
                case "exit":
                    System.out.println("Bye bye!");
                    exit = true;
                    break;
                default:
                    System.out.println("Wrong command.");
                    for (String key : deck.keys) {
                        System.out.println(key);
                    }
            }
        }
    }
}
