package domain.result;

import static org.assertj.core.api.Assertions.assertThat;

import java.math.BigDecimal;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import domain.participant.Dealer;
import domain.participant.Participant;

public class ParticipantProfitTest {
    @DisplayName("constructor: 인스턴스 생성")
    @Test
    void constructor() {
        Participant participant = new Dealer();
        BigDecimal profit = BigDecimal.ZERO;

        assertThat(new ParticipantProfit(participant, profit)).isInstanceOf(ParticipantProfit.class);
    }

    @DisplayName("getName: name을 반환")
    @Test
    void getName() {
        Participant participant = new Dealer();
        BigDecimal profit = BigDecimal.ZERO;
        ParticipantProfit participantProfit = new ParticipantProfit(participant, profit);

        assertThat(participantProfit.getName()).isNotNull();
    }

    @DisplayName("getProfit: profit을 반환")
    @Test
    void getProfit() {
        Participant participant = new Dealer();
        BigDecimal profit = BigDecimal.ZERO;

        ParticipantProfit participantProfit = new ParticipantProfit(participant, profit);

        assertThat(participantProfit.getProfit()).isNotNull();
    }
}
