package domain;

import domain.card.Card;
import domain.card.Deck;
import domain.user.Dealer;
import domain.user.Participant;
import domain.user.Players;

import java.util.ArrayList;
import java.util.List;

public class Game {
    public static final int FIRST_DRAW_NUMBER = 2;

    private Deck deck;

    public Game(Deck deck) {
        this.deck = deck;
    }

    public void drawFirst(Players players, Dealer dealer) {
        List<Card> drawCards = new ArrayList<>();
        for (int index = 0; index < players.size() * FIRST_DRAW_NUMBER; index++) {
            drawCards.add(deck.deal());
        }
        players.firstDraw(drawCards);
        dealer.drawFirst(deck.deal(), deck.deal());
    }

    public void draw(Participant participant) {
        participant.draw(deck.deal());
    }
}
