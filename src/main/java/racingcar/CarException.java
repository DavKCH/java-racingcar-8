package racingcar;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

public class CarException {

    private CarException() {
    }

    private static final String DELIMITER = ",";

    private static void carNameNull(String strInput) {
        if (strInput == null) {
            System.out.println("잘못된 값을 입력 하셨습니다.");
            throw new IllegalArgumentException();
        }
    }

    private static void carNameEmpty(String strInput) {
        strInput = strInput.trim();
        if (strInput.isEmpty()) {
            System.out.println("잘못된 값을 입력 하셨습니다.1");
            throw new IllegalArgumentException();
        }
    }

    private static void carNameFalse(String strInput) {
        String falseStr = "^[^a-zA-Zㄱ-ㅎㅏ-ㅣ가-힣,]*$";
        if (strInput.matches(falseStr)) {
            System.out.println("잘못된 값을 입력 하셨습니다.2");
            throw new IllegalArgumentException();
        }
    }

    private static  void carNameStartFalse(String strInput) {
        if (strInput.startsWith(DELIMITER)){
            System.out.println("잘못된 값을 입력 하셨습니다.3");
            throw new IllegalArgumentException();
        }
    }

    private static void carNameEndFalse(String strInput) {
        String lastStrInput = strInput.substring(strInput.length()-1);
        if (lastStrInput.equals(DELIMITER)) {
            System.out.println("잘못된 값을 입력 하셨습니다.4");
            throw new IllegalArgumentException();
        }
    }

    private static void carNameLengthFalse(String strInput) {
        String[] strCar = strInput.split(DELIMITER);
        for (String strName : strCar) {
            if (strName.length() > 5) {
                System.out.println("자동차 이름은 5글자 이하 입니다.");
                throw new IllegalArgumentException();
            }
        }
    }


    private static void carNameDuplicate(String strInput) {
        String[] strCar = strInput.split(DELIMITER);
        List<String> list = Arrays.asList(strCar);

        HashSet<String> hashSet = new HashSet<>(list);
        if (list.size() != hashSet.size()) {
            System.out.println("잘못된 값을 입력 하셨습니다.5");
            throw new IllegalArgumentException();
        }
    }


    public static void CarNameExceptionStart(String strInput) {
        carNameNull(strInput);
        carNameEmpty(strInput);
        carNameFalse(strInput);
        carNameStartFalse(strInput);
        carNameEndFalse(strInput);
        carNameLengthFalse(strInput);
        carNameDuplicate(strInput);
    }
}
