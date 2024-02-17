package racingcar.view;

import racingcar.view.validator.InputValidator;
import static racingcar.view.OutputView.*;
import static racingcar.view.UserMessage.*;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class InputView {
    private final Scanner scanner = new Scanner(System.in);
    private final InputValidator inputValidator = new InputValidator();
    public List<String> getCarNames() {
        displayMessage(USER_CAR_NAME_INPUT_PROMPT);
        String initialInput = scanner.nextLine();
        inputValidator.validateIsBlank(initialInput);

        List<String> parseCarNames = parseCarName(initialInput);
        inputValidator.validateAvailableName(parseCarNames);
        return parseCarNames;
    }

    private List<String> parseCarName (String initialInput) {
        return Arrays.stream(Arrays.stream(initialInput.split(","))
                .map(String::trim)
                .toArray(String[]::new))
                .toList();
    }

    public int getTryNumber() {
        displayMessage(USER_TRY_NUMBER_INPUT_PROMPT);
        String tryNumber = scanner.nextLine();
        inputValidator.validateTryNumber(tryNumber);

        return Integer.parseInt(tryNumber);
    }
}
