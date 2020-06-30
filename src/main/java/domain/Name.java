package domain;

import static java.util.stream.Collectors.toList;

import java.util.List;
import java.util.Objects;
import java.util.stream.Stream;

public class Name {
    private static final int MAX_LENGTH = 5;
    private static final int MIN_LENGTH = 1;
    private static final String NAME_DELIMITER = ",";

    private final String name;

    public Name(String name) {
        Objects.requireNonNull(name, "이름이 null입니다.");
        name = name.trim();
        validateLength(name);
        this.name = name;
    }

    public static List<Name> fromComma(final String names) {
        return Stream.of(names.split(NAME_DELIMITER))
                .map(Name::new)
                .collect(toList());
    }

    private void validateLength(final String name) {
        int length = name.length();
        if (length < MIN_LENGTH || length > MAX_LENGTH) {
            throw new IllegalArgumentException("이름의 길이가 올바르지 않습니다.\nname: " + name);
        }
    }
}
