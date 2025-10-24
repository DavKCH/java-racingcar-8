package racingcar;

import java.util.ArrayList;
import java.util.List;

public class CarCenter {

    private final List<Car> cars = new ArrayList<>();

    public void add(Car car) {
        cars.add(car);
    }

    public List<Car> getCars() {
        return cars;
    }
}
