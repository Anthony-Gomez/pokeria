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

    /**
     * Get starting hand cards.
     *
     * @param firstStartingCard first starting card
     * @param secondStartingCard second starting card
     * @return Cards list
     */
    @GetMapping("/{starting-card-1};{starting-card-2}")
    public ResponseEntity<List<Card>> get(@PathVariable("starting-card-1") String firstStartingCard,
                                          @PathVariable("starting-card-2") String secondStartingCard) {

        Card card1 = cardDecoderService.getCardFromInitialAndSymbol(firstStartingCard);
        Card card2 = cardDecoderService.getCardFromInitialAndSymbol(secondStartingCard);

        return ResponseEntity.ok(Arrays.asList(card1, card2));
    }

}
