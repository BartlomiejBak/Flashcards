package flashcards;

import java.io.*;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Random;
import java.util.Scanner;

public class Deck {
    protected LinkedHashMap<String, String> deck;
    Scanner scanner = new Scanner(System.in);
    ArrayList<String> keys = new ArrayList<>();

    public Deck() {
        this.deck = new LinkedHashMap<>();
    }

    public void add() {
        System.out.println("The card:");
        String key = scanner.nextLine();
        if (this.deck.containsValue(key)) {
            System.out.println("The card \"" + key + "\" already exists.");
        } else {
            System.out.println("The definition of the card:");
            String def = scanner.nextLine();
            if (this.deck.containsKey(def)) {
                System.out.println("The definition \"" + def + "\" already exists.");
            } else {
                this.deck.put(key, def);
                this.keys.add(key);
                System.out.println("The pair (\"" + key + "\":\"" + def + "\") has been added.");
            }
        }
    }

    public void remove() {
        System.out.println("The card:");
        String key = scanner.nextLine();
        if (this.deck.containsKey(key)) {
            this.deck.remove(key);
            this.keys.remove(key);
            System.out.println("The card has been removed.");
        } else {
            System.out.println("Can't remove \"" + key + "\": there is no such card.");
        }
    }

    public void export() throws IOException {
        System.out.println("File name:");
        File file = new File(scanner.nextLine());
        PrintWriter writer = new PrintWriter(file);
        for (String s : this.deck.keySet()) {
            writer.println(s);
            writer.println(this.deck.get(s));
        }
        writer.close();
        System.out.println(this.deck.size() + " cards have been saved.");
    }

    public void importDeck() throws FileNotFoundException {
        System.out.println("File name:");
        File file = new File(scanner.nextLine());
        if (file.exists()) {
            Scanner reader = new Scanner(file);
            this.keys.clear();
            int newEntries = 0;
            while (reader.hasNext()) {
                String key = reader.nextLine();
                this.deck.put(key, reader.nextLine());
                this.keys.add(key);
                newEntries++;
            }
            System.out.println(newEntries + " cards have been loaded.");
        } else {
            System.out.println("File not found.");
        }
    }

    public void ask() {
        System.out.println("How many times to ask?");
        int n = Integer.parseInt(scanner.nextLine());
        Random random = new Random();
        for (int i = 0; i < n; i++) {
            int card = random.nextInt(this.deck.size());
            String key = this.keys.get(card);
            System.out.println("Print the definition of \"" + key + "\":");
            String def = scanner.nextLine();
            if (def.equals(this.deck.get(key))) {
                System.out.println("Correct answer.");
            } else if (this.deck.containsValue(def)) {
                System.out.println("Wrong answer. The correct one is \"" + this.deck.get(key) + "\", "
                        + "you've just written the definition of \"" + this.getKey(def) + "\".");
            } else {
                System.out.println("Wrong answer. The correct one is \"" + this.deck.get(key) + "\".");
            }
        }
    }

    public String getKey(String key) {
        for (String s : this.deck.keySet()) {
            if (key.equals(this.deck.get(s))) {
                key = s;
            }
        }
        return key;
    }
}
