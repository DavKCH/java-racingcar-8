package racingcar;

import camp.nextstep.edu.missionutils.Console;

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

        CarNameException.CarNameExceptionStart(strInput);

        String DELIMITER = ",";
        String[] strCar = strInput.split(DELIMITER);

        for (String car : strCar) {
            String name = car.trim();
            carCenter.add(new Car(name));
        }
    }

    private static int gameTrack(String countInput) {

        GameTrackException.gameTrackExceptionStart(countInput);

        System.out.println();
        return Integer.parseInt(countInput);
    }
}
