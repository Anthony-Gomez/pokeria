package fr.anthonygomez.pokeria.bookmaker.api.application.domains.card;

import fr.anthonygomez.pokeria.bookmaker.api.application.domains.card.enums.SuitEnum;
import fr.anthonygomez.pokeria.bookmaker.api.application.domains.card.enums.ValueEnum;

public record Card(
        ValueEnum value,
        SuitEnum suit) {

    @Override
    public String toString() {
        return "Card{" +
                "value=" + value +
                ", suit=" + suit.getSymbol() +
                '}';
    }
}
