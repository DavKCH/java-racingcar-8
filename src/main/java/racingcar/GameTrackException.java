package racingcar;

public class GameTrackException {

    private GameTrackException() {
    }

    private static void gameTrackNull(String countInput) {
        if (countInput == null) {
            System.out.println("잘못된 값을 입력 하셨습니다.");
            throw new IllegalArgumentException();
        }
    }

    private static void gameTrackCountEmpty(String countInput) {
        countInput = countInput.trim();
        if (countInput.isEmpty()) {
            System.out.println("잘못된 값을 입력 하셨습니다.");
            throw new IllegalArgumentException();
        }
    }

    private static void gameTrackCountFalse(String countInput) {
        String falseStr = "^[^0-9]*$";
        if (countInput.matches(falseStr)) {
            System.out.println("잘못된 값을 입력 하셨습니다.");
            throw new IllegalArgumentException();
        }
    }

    private static  void gameTrackStartFalse(String countInput) {
        if (countInput.startsWith("0")){
            System.out.println("처음 에는 '0' 입력이 불가능 합니다.");
            throw new IllegalArgumentException();
        }
    }

    public static void gameTrackExceptionStart(String countInput) {

        gameTrackNull(countInput);
        gameTrackCountEmpty(countInput);
        gameTrackCountFalse(countInput);

        gameTrackStartFalse(countInput);
    }
}
