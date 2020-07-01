package view;

import java.util.Arrays;

public enum YesOrNo {

    YES("y"),
    NO("n");

    private final String response;

    YesOrNo(final String response) {
        this.response = response;
    }

    public static YesOrNo of(String response) {
        return Arrays.stream(YesOrNo.values())
                .filter(yesOrNo -> yesOrNo.response.equals(response))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("유효하지 않은 답변입니다. 답변 : " + response));
    }
}
