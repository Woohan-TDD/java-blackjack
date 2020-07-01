package domain.user;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class NameTest {

    @Test
    @DisplayName("정상 생성 테스트")
    void create() {
        Name name = new Name("name");
        assertThat(name).isNotNull();
    }

    @ParameterizedTest
    @NullAndEmptySource
    @DisplayName("이름 입력에 대한 유효성 검사")
    void validate(String name) {
        assertThatThrownBy(() -> new Name(name))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("이름은 최소 한 글자 이상이어야 합니다.");
    }

}