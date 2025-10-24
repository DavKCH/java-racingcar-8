package racingcar;

import camp.nextstep.edu.missionutils.Randoms;

public class Car {

    private final String carName;
    private int moveCarCount;

    public Car(String carName) {
        this.carName = carName;
    }

    public void start() {

        int randomValue = Randoms.pickNumberInRange(0, 9);
        moveCarCount += randomMoveStop(randomValue);

    }

    public void carShow() {
        System.out.println(carName + " : " + moveShowStr());
    }

    public String getCarName() {
        return carName;
    }

    public int getMoveCarCount() {
        return moveCarCount;
    }

    private String moveShowStr() {
        String moveStr = "";

        for (int i = 0; i < moveCarCount; i++) {
            moveStr += "-";
        }

        return moveStr;
    }


    private int randomMoveStop(int randomValue) {
        if (randomValue >= 4) { //move
            return  1;
        }
        return 0;   //stop
    }
}
