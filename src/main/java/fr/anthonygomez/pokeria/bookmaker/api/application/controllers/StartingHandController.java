package fr.anthonygomez.pokeria.bookmaker.api.application.controllers;

import fr.anthonygomez.pokeria.bookmaker.api.application.domains.card.SuitEnum;
import fr.anthonygomez.pokeria.bookmaker.api.application.domains.card.ValueEnum;
import fr.anthonygomez.pokeria.bookmaker.api.services.card.CardDecoderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class StartingHandController {

    @Autowired
    private CardDecoderService cardDecoderService;

    @GetMapping("/starting-hand/" +
            "{starting-hand-value-symbol-1}-{starting-hand-suit-initial-1}:{starting-hand-value-symbol-2}-{starting-hand-suit-initial-2}")
    public ResponseEntity<String> get(
            @PathVariable("starting-hand-value-symbol-1") String symbolValueStartingHand1,
            @PathVariable("starting-hand-suit-initial-1") String initialSuitStartingHand1,
            @PathVariable("starting-hand-value-symbol-2") String symbolValueStartingHand2,
            @PathVariable("starting-hand-suit-initial-2") String initialSuitStartingHand2) {

        ValueEnum valueEnumStartingHand1 = cardDecoderService.findValueEnumFromSymbol(symbolValueStartingHand1);
        SuitEnum suiteEnumStartingHand1 = cardDecoderService.findSuitEnumFromInitial(initialSuitStartingHand1);

        ValueEnum valueEnumStartingHand2 = cardDecoderService.findValueEnumFromSymbol(symbolValueStartingHand2);
        SuitEnum suiteEnumStartingHand2 = cardDecoderService.findSuitEnumFromInitial(initialSuitStartingHand2);

        return ResponseEntity.ok("Your starting hand is " + valueEnumStartingHand1 + suiteEnumStartingHand1 + "+" +
                valueEnumStartingHand2 + suiteEnumStartingHand2);
    }

}
