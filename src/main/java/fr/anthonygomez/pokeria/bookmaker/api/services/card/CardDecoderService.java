package fr.anthonygomez.pokeria.bookmaker.api.services.card;

import fr.anthonygomez.pokeria.bookmaker.api.application.domains.card.Card;
import fr.anthonygomez.pokeria.bookmaker.api.application.domains.card.SuitEnum;
import fr.anthonygomez.pokeria.bookmaker.api.application.domains.card.ValueEnum;
import org.springframework.stereotype.Service;

import java.util.Arrays;

@Service
public class CardDecoderService {

    public Card getCardFromInitialAndSymbol(String initialAndSymbol) {
        String symbol = initialAndSymbol.substring(0, 1);
        String initial = initialAndSymbol.substring(1, 2);
        ValueEnum value = this.findValueEnumFromSymbol(symbol);
        SuitEnum suit = this.findSuitEnumFromInitial(initial);
        return new Card(value, suit);
    }

    private SuitEnum findSuitEnumFromInitial(String initialToFind) {
        return Arrays.stream(SuitEnum.values())
                .filter(suiteEnum -> suiteEnum.getInitial().equals(initialToFind))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException(initialToFind + " is not a suite initial"));
    }

    private ValueEnum findValueEnumFromSymbol(String symbolToFind) {
        return Arrays.stream(ValueEnum.values())
                .filter(valueEnum -> valueEnum.getSymbol().equals(symbolToFind))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException(symbolToFind + " is not a value symbol"));
    }

}
