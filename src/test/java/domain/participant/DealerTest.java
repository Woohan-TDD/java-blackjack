package domain.participant;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class DealerTest {
    @DisplayName("constructor: 딜러 인스턴스 생성")
    @Test
    void constructor() {
        assertThat(new Dealer()).isInstanceOf(Dealer.class);
    }
}
