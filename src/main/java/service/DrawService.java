package service;

import java.util.List;

import domain.card.CardDeck;
import domain.participant.Dealer;
import domain.participant.Player;
import domain.participant.PlayerDecision;

public class DrawService {
    public void drawInitialCards(final CardDeck cardDeck, final Dealer dealer, final List<Player> players) {
        dealer.hitAtFirst(cardDeck);
        for (final Player player : players) {
            player.hitAtFirst(cardDeck);
        }
    }

    public void drawDealer(final CardDeck cardDeck, final Dealer dealer) {
        dealer.hit(cardDeck);
    }

    public void drawPlayer(final CardDeck cardDeck, final Player player, final String decision) {
        PlayerDecision playerDecision = PlayerDecision.of(decision);
        playerDecision.act(cardDeck, player);
    }
}
