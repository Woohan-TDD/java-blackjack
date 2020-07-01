package domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class YesOrNoTest {

    @ParameterizedTest
    @CsvSource(value = {"y,YES", "n,NO"})
    @DisplayName("정상 반환 확인")
    void of(String input, YesOrNo expected) {
        assertThat(YesOrNo.of(input)).isEqualTo(expected);
    }

    @Test
    @DisplayName("비정상 입력 예외처리")
    void validateOf() {
        assertThatThrownBy(() -> YesOrNo.of("r"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("유효하지 않은 답변입니다. 답변 : r");
    }

}