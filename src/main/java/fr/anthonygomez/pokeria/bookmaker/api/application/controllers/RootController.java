package fr.anthonygomez.pokeria.bookmaker.api.application.controllers;

import fr.anthonygomez.pokeria.bookmaker.api.application.domains.card.Card;
import fr.anthonygomez.pokeria.bookmaker.api.application.domains.hand.Hand;
import fr.anthonygomez.pokeria.bookmaker.api.application.services.card.CardDecoderService;
import fr.anthonygomez.pokeria.bookmaker.api.application.services.hand.HandService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class RootController {

    @Autowired
    private CardDecoderService cardDecoderService;

    @Autowired
    private HandService handService;

    /**
     * Get starting hand cards.
     *
     * @param firstStartingCard first starting card
     * @param secondStartingCard second starting card
     * @return Cards list
     */
    @GetMapping("/{first-starting-card},{second-starting-card}")
    public ResponseEntity<Hand> get(
            @PathVariable("first-starting-card") String firstStartingCard,
            @PathVariable("second-starting-card") String secondStartingCard) {

        Card card1 = cardDecoderService.getCardFromInitialAndSymbol(firstStartingCard);
        Card card2 = cardDecoderService.getCardFromInitialAndSymbol(secondStartingCard);

        Hand hand = handService.getHandFromCards(card1, card2);

        return ResponseEntity.ok(hand);
    }

}
