package fr.anthonygomez.pokeria.bookmaker.api.application.controllers;

import fr.anthonygomez.pokeria.bookmaker.api.application.domains.card.Card;
import fr.anthonygomez.pokeria.bookmaker.api.services.card.CardDecoderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.Arrays;
import java.util.List;

@Controller
public class StartingHandController {

    @Autowired
    private CardDecoderService cardDecoderService;

    @GetMapping("/{starting-hand-1};{starting-hand-2}")
    public ResponseEntity<List<Card>> get(@PathVariable("starting-hand-1") String startingHand1,
                                          @PathVariable("starting-hand-2") String startingHand2) {

        Card card1 = cardDecoderService.getCardFromInitialAndSymbol(startingHand1);
        Card card2 = cardDecoderService.getCardFromInitialAndSymbol(startingHand2);

        return ResponseEntity.ok(Arrays.asList(card1, card2));
    }

}
