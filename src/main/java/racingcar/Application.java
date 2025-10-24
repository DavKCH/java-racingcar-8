package racingcar;

import camp.nextstep.edu.missionutils.Console;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

public class Application {

    private static final CarCenter carCenter = new CarCenter();

    public static void main(String[] args) {
        // TODO: 프로그램 구현
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        String strInput = Console.readLine();
        carNameInput(strInput);

        System.out.println("시도할 횟수는 몇 회인가요?");
        String countInput = Console.readLine();
        int lastTrack = gameTrack(countInput);

        Game game = new Game(carCenter.getCars(), lastTrack);
        game.gameStart();
        game.gameEnd();
    }

    private static void carNameInput(String strInput) {
        final String DELIMITER = ",";

        // null 예외
        if (strInput == null) {
            System.out.println("잘못된 값을 입력 하셨습니다.");
            throw new IllegalArgumentException();
        }

        strInput = strInput.trim();
        if (strInput.isEmpty()) {
            System.out.println("잘못된 값을 입력 하셨습니다.1");
            throw new IllegalArgumentException();
        }

        String falseStr = "^[^a-zA-Zㄱ-ㅎㅏ-ㅣ가-힣,]*$";
        if (strInput.matches(falseStr)) {
            System.out.println("잘못된 값을 입력 하셨습니다.2");
            throw new IllegalArgumentException();
        }

        // 처음 글자가 ","일때
        if (strInput.startsWith(DELIMITER)){
            System.out.println("잘못된 값을 입력 하셨습니다.3");
            throw new IllegalArgumentException();
        }

        // 마지막 글자가 ","일때
        String lastStrInput = strInput.substring(strInput.length()-1);
        if (lastStrInput.equals(DELIMITER)) {
            System.out.println("잘못된 값을 입력 하셨습니다.4");
            throw new IllegalArgumentException();
        }

        String[] strCar = strInput.split(DELIMITER);
        for (String strName : strCar) {
            if (strName.length() > 5) {
                System.out.println("자동차 이름은 5글자 이하 입니다.");
                throw new IllegalArgumentException();
            }
        }

        List<String> list = Arrays.asList(strCar);
        HashSet<String> hashSet = new HashSet<>(list);
        if (list.size() != hashSet.size()) {
            System.out.println("잘못된 값을 입력 하셨습니다.5");
            throw new IllegalArgumentException();
        }

        for (String name : list) {
            carCenter.add(new Car(name));
        }
    }

    private static int gameTrack(String countInput) {

        if (countInput == null) {
            System.out.println("잘못된 값을 입력 하셨습니다.");
            throw new IllegalArgumentException();
        }

        countInput = countInput.trim();
        if (countInput.isEmpty()) {
            System.out.println("잘못된 값을 입력 하셨습니다.1-1");
            throw new IllegalArgumentException();
        }

        String falseStr = "^[^0-9]*$";
        if (countInput.matches(falseStr)) {
            System.out.println("잘못된 값을 입력 하셨습니다.1-2");
            throw new IllegalArgumentException();
        }

        if(countInput.startsWith("0")) {
            System.out.println("잘못된 값을 입력 하셨습니다.1-3");
            throw new IllegalArgumentException();
        }

        System.out.println();
        return Integer.parseInt(countInput);
    }
}
