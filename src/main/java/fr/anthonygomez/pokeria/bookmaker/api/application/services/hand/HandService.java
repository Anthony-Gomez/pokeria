package fr.anthonygomez.pokeria.bookmaker.api.application.services.hand;

import fr.anthonygomez.pokeria.bookmaker.api.application.domains.card.Card;
import fr.anthonygomez.pokeria.bookmaker.api.application.domains.hand.Hand;
import org.springframework.stereotype.Service;

@Service
public class HandService {

    /**
     * Get hand from cards
     *
     * @param card1 first card of hand
     * @param card2 second card of hand
     * @return Hand
     */
    public Hand getHandFromCards(Card card1, Card card2) {
        return new Hand(card1, card2);
    }

}
