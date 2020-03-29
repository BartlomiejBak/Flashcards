package flashcards;

/*
Class not used since stage #4
*/

public class Card {
    String term;
    String definition;

    public Card(String term, String definition) {
        this.term = term;
        this.definition = definition;
    }

    public String getTerm() {
        return term;
    }

    public String getDefinition() {
        return definition;
    }
}
