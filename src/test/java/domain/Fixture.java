package domain;

import java.util.List;

import domain.card.Card;

public class Fixture {
    public static final List<Card> CARDS = Card.values();

    public static final Name POBI = new Name("Pobi");
    public static final Name JUN = new Name("Jun");

    public static final BettingMoney THOUSAND_BETTING_MONEY = new BettingMoney(1_000);
    public static final BettingMoney HUNDRED_BETTING_MONEY = new BettingMoney(1_000_000);
}
