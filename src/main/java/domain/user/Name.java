package domain.user;

public class Name {

    private final String name;

    public Name(final String name) {
        validate(name);
        this.name = name;
    }

    private void validate(final String name) {
        if (name == null || name.isEmpty()) {
            throw new IllegalArgumentException("이름은 최소 한 글자 이상이어야 합니다.");
        }
    }

    public String getName() {
        return name;
    }
}
