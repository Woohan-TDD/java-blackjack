package domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class NameTest {
    @DisplayName("생성자: 1~5자 사이의 이름을 입력받아 인스턴스 생성")
    @ValueSource(strings = {"뭐", "hello", "    hello    ", "      다섯글자야", "     hello"})
    @ParameterizedTest
    void constructor(final String name) {
        assertThat(new Name(name)).isInstanceOf(Name.class);
    }

    @DisplayName("생성자: 입력받은 이름이 null이면 예외 발생")
    @Test
    void constructor_NameIsNull_ExceptionThrown() {
        assertThatThrownBy(() -> new Name(null))
                .isInstanceOf(NullPointerException.class)
                .hasMessageContaining("이름이 null입니다");
    }

    @DisplayName("생성자: 길이가 올바르지 않은 이름을 입력받아 예외 발생")
    @ValueSource(strings = {"", "   ", "       ", "다섯자넘어유~"})
    @ParameterizedTest
    void constructor_InvalidNameLength_ExceptionThrown(final String name) {
        assertThatThrownBy(() -> new Name(name))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("이름의 길이가 올바르지 않습니다");
    }

    @DisplayName("fromComma: 콤마 단위로 이름을 입력받아 이름 리스트 생성")
    @Test
    void fromComma() {
        assertThat(Name.fromComma("a, hell, hello, 메롱, the, he")).hasSize(6);
    }
}
