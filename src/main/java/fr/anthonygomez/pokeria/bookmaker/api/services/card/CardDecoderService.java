package fr.anthonygomez.pokeria.bookmaker.api.services.card;

import fr.anthonygomez.pokeria.bookmaker.api.application.domains.card.SuitEnum;
import fr.anthonygomez.pokeria.bookmaker.api.application.domains.card.ValueEnum;
import org.springframework.stereotype.Service;

import java.util.Arrays;

@Service
public class CardDecoderService {

    public SuitEnum findSuitEnumFromInitial(String initialToFind) {
        return Arrays.stream(SuitEnum.values())
                .filter(suiteEnum -> suiteEnum.getInitial().equals(initialToFind))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException(initialToFind + " is not a suite initial"));
    }

    public ValueEnum findValueEnumFromSymbol(String symbolToFind) {
        return Arrays.stream(ValueEnum.values())
                .filter(valueEnum -> valueEnum.getSymbol().equals(symbolToFind))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException(symbolToFind + " is not a value symbol"));
    }

}
