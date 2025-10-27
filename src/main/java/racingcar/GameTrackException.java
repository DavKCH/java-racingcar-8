package racingcar;

public class GameTrackException {

    private GameTrackException() {
    }

    //null 예외
    private static void gameTrackNull(String countInput) {
        if (countInput == null) {
            System.out.println("잘못된 값을 입력 하셨습니다.");
            throw new IllegalArgumentException();
        }
    }

    // 입력시 아무것도 입력을 안햇을때 생기는 예외
    private static void gameTrackCountEmpty(String countInput) {
        countInput = countInput.trim();
        if (countInput.isEmpty()) {
            System.out.println("잘못된 값을 입력 하셨습니다.");
            throw new IllegalArgumentException();
        }
    }

    // 숫자가 아닌 다른 값을 입력 했을때 예외
    private static void gameTrackCountFalse(String countInput) {
        String trueStr = "^[0-9]*$";
        if (!countInput.matches(trueStr)) {
            System.out.println("잘못된 값을 입력 하셨습니다.");
            throw new IllegalArgumentException();
        }
    }

    // 처음에 0을 입력 했을때 예외
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
