package fr.anthonygomez.pokeria.bookmaker.api.application.domains.card;

public record Card(ValueEnum value,
                   SuitEnum suit) {

    public ValueEnum getValue() {
        return value;
    }

    public SuitEnum getSuit() {
        return suit;
    }

    @Override
    public String toString() {
        return "Card{" +
                "value=" + value +
                ", suit=" + suit.getSymbol() +
                '}';
    }
}
