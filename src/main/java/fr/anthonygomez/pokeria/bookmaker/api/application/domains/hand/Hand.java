package fr.anthonygomez.pokeria.bookmaker.api.application.domains.hand;

import fr.anthonygomez.pokeria.bookmaker.api.application.domains.card.Card;

public class Hand {

    private final Card card1;
    private final Card card2;
    private final boolean isSuited;

    public Hand(Card card1, Card card2) {

        this.card1 = card1;
        this.card2 = card2;

        this.isSuited = card1.suit().equals(card2.suit());

    }

    public Card getCard1() {
        return card1;
    }

    public Card getCard2() {
        return card2;
    }

    public boolean isSuited() {
        return isSuited;
    }

    @Override
    public String toString() {
        return "Hand{" +
                "card1=" + card1 +
                ", card2=" + card2 +
                ", isSuited=" + isSuited +
                '}';
    }
}
