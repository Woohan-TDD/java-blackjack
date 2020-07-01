package domain.state;

import domain.card.Card;
import domain.card.Hands;

public interface State {

    State draw(Card card);

    State stay();

    Hands hands();

    boolean isFinished();

    double profit(int money);
}
