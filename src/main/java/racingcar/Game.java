package racingcar;


import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Game {

    private final List<Car> cars;
    private final int lastTrack;

    private final List<Car> winerCar = new ArrayList<>();

    public Game(List<Car> cars, int lastTrack) {
        this.cars = cars;
        this.lastTrack = lastTrack;
    }

    public void gameStart() {
        for (int i = 0; i < lastTrack; i++) {
            car();
        }
    }

    public void gameEnd() {
        Car winer = cars.stream()
                .max(Comparator.comparingInt(Car::getMoveCarCount))
                .orElse(null);

        if (winer == null) {
            System.out.println("잘못된 값을 입력 하셧습니다.");
            throw new IllegalArgumentException();
        }

        for (Car car : cars) {
            int moveCarCount = car.getMoveCarCount();

            if (winer.getMoveCarCount() == moveCarCount) {
                winerCar.add(car);
            }
        }

        System.out.print("최종 우승자 : ");
        String winersName = "";
        for (int i = 0; i < winerCar.size(); i++) {
            Car car = winerCar.get(i);
            winersName = car.getCarName();

            System.out.print(winersName);

            if (i != (winerCar.size() -1)) {
                System.out.print(", ");
            }
        }

    }

    private void car() {
        for (Car car : cars) {
            car.start();
            car.carShow();
        }
        System.out.println();
    }
}
