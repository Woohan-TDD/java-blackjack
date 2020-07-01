package domain;

import domain.card.Card;
import domain.card.Deck;
import domain.user.Dealer;
import domain.user.Player;
import domain.user.Players;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Game {

    private Deck deck;
    private Players players;
    private Dealer dealer;

    public Game(Deck deck, Players players, Dealer dealer) {
        this.deck = deck;
        this.players = players;
        this.dealer = dealer;
    }

    public void drawFirst() {
        for (int index = 0; index < 2; index++) {
            drawAll();
        }
    }

    public void drawAll() {
        List<Card> drawCards = new ArrayList<>();
        for (int index = 0; index < players.size(); index++) {
            drawCards.add(deck.deal());
        }
        players.draw(drawCards);
        dealer.draw(deck.deal());
    }

    public List<Player> getPlayers() {
        return Collections.unmodifiableList(players.getPlayers());
    }

    public Dealer getDealer() {
        return dealer;
    }
}
