package fr.anthonygomez.pokeria.bookmaker.api.application.services.card;

import fr.anthonygomez.pokeria.bookmaker.api.application.domains.card.Card;
import fr.anthonygomez.pokeria.bookmaker.api.application.domains.card.enums.SuitEnum;
import fr.anthonygomez.pokeria.bookmaker.api.application.domains.card.enums.ValueEnum;
import org.springframework.stereotype.Service;

import java.util.Arrays;

@Service
public class CardDecoderService {

    /**
     * Get card from initial and symbol :
     * Define symbol with first char of initialAndSymbol arg,
     * Define initial with first char of initialAndSymbol arg,
     * Find value enum from symbol,
     * Find suite enum from initial,
     * Build card instance.
     *
     * @param initialAndSymbol Initial and symbol
     * @return Card
     */
    public Card getCardFromInitialAndSymbol(String initialAndSymbol) {
        String symbol = initialAndSymbol.substring(0, 1);
        String initial = initialAndSymbol.substring(1, 2);
        ValueEnum value = this.findValueEnumFromSymbol(symbol);
        SuitEnum suit = this.findSuitEnumFromInitial(initial);
        return new Card(value, suit);
    }

    /**
     * Find suit enum from initial arg.
     *
     * @param initialToFind Initial to find
     * @return Suite enum
     */
    private SuitEnum findSuitEnumFromInitial(String initialToFind) {
        return Arrays.stream(SuitEnum.values())
                .filter(suiteEnum -> suiteEnum.getInitial().equals(initialToFind.toUpperCase()))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException(initialToFind + " is not a suite initial"));
    }

    /**
     * Find value enum from symbol arg.
     *
     * @param symbolToFind Symbol to find
     * @return Value enum
     */
    private ValueEnum findValueEnumFromSymbol(String symbolToFind) {
        return Arrays.stream(ValueEnum.values())
                .filter(valueEnum -> valueEnum.getSymbol().equals(symbolToFind.toUpperCase()))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException(symbolToFind + " is not a value symbol"));
    }

}
