package racingcar;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

public class CarNameException {

    private CarNameException() {
    }

    private static final String DELIMITER = ",";

    // null 예외
    private static void carNameNull(String strInput) {
        if (strInput == null) {
            System.out.println("잘못된 값을 입력 하셨습니다.");
            throw new IllegalArgumentException();
        }
    }

    // 입력시 아무것도 입력을 안햇을때 생기는 예외
    private static void carNameEmpty(String strInput) {
        strInput = strInput.trim();
        if (strInput.isEmpty()) {
            System.out.println("잘못된 값을 입력 하셨습니다.");
            throw new IllegalArgumentException();
        }
    }

    // 특수 문자 및 숫자를 입력시 예외(","제외 한글 입력 가능)
    private static void carNameFalse(String strInput) {
        String trueStr = "^[a-zA-Zㄱ-ㅎㅏ-ㅣ가-힣,]*$";
        if (!strInput.matches(trueStr)) {
            System.out.println("잘못된 값을 입력 하셨습니다.");
            throw new IllegalArgumentException();
        }
    }

    // 처음에 , 입력시 발생 하는 예외
    private static  void carNameStartFalse(String strInput) {
        if (strInput.startsWith(DELIMITER)){
            System.out.println("처음 글자로 ',' 입력이 불가능 합니다.");
            throw new IllegalArgumentException();
        }
    }

    // 마지막 글자에 , 입력시 발생 하는 예외
    private static void carNameEndFalse(String strInput) {
        String lastStrInput = strInput.substring(strInput.length()-1);
        if (lastStrInput.equals(DELIMITER)) {
            System.out.println("마지막 글자로 ',' 입력이 불가능 합니다.");
            throw new IllegalArgumentException();
        }
    }

    // 자동차 3개 이상 입력후 중간에 자동차 이름이 공백일시 발생하는 예외
    private static void carNameTrimFalse(String strInput) {
        String[] strCar = strInput.split(DELIMITER);

        for (String strName : strCar) {
            String trimName = strName.trim();
            if (trimName.isEmpty()) {
                System.out.println("자동차 이름은 공백 이 불가능 합니다.");
                throw new IllegalArgumentException();
            }
        }
    }

    // 이름 길이가 6글자 이상일때 발생하는 예외
    private static void carNameLengthFalse(String strInput) {
        String[] strCar = strInput.split(DELIMITER);
        for (String strName : strCar) {
            if (strName.length() > 5) {
                System.out.println("자동차 이름은 5글자 이하 입니다.");
                throw new IllegalArgumentException();
            }
        }
    }

    // 똑같은 이름이 2개이상일 경우 발생하는 예외
    private static void carNameDuplicate(String strInput) {
        String[] strCar = strInput.split(DELIMITER);
        List<String> list = Arrays.asList(strCar);

        HashSet<String> hashSet = new HashSet<>(list);
        if (list.size() != hashSet.size()) {
            System.out.println("자동차의 이름은 중복 할수 없습니다..");
            throw new IllegalArgumentException();
        }
    }


    public static void CarNameExceptionStart(String strInput) {

        carNameNull(strInput);
        carNameEmpty(strInput);
        carNameFalse(strInput);

        carNameStartFalse(strInput);
        carNameEndFalse(strInput);

        carNameTrimFalse(strInput);
        carNameLengthFalse(strInput);
        carNameDuplicate(strInput);
    }
}
