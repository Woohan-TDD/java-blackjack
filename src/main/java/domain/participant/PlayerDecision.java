package domain.participant;

import java.util.function.BiConsumer;
import java.util.stream.Stream;

import domain.card.CardDeck;

public enum PlayerDecision {
    HIT("y", (cardDeck, player) -> player.hit(cardDeck)),
    STAY("n", (cardDeck, player) -> player.stay());

    private final String alias;
    private final BiConsumer<CardDeck, Player> playerAction;

    PlayerDecision(final String alias, final BiConsumer<CardDeck, Player> playerAction) {
        this.alias = alias;
        this.playerAction = playerAction;
    }

    public static PlayerDecision of(final String input) {
        return Stream.of(values())
                .filter(alias -> alias.isAliasOf(input))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("존재하지 않는 입력입니다."));
    }

    public void act(final CardDeck cardDeck, final Player player) {
        playerAction.accept(cardDeck, player);
    }

    private boolean isAliasOf(final String input) {
        return alias.equals(input);
    }
}
