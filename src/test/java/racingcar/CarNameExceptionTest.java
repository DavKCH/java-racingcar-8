package racingcar;


import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;


class CarNameExceptionTest {

    private final String DELIMITER = ",";

    @Test
    void carNameEmptyTest() {
        Car car = new Car("");
        String carName = car.getCarName();

        Assertions.assertThrows(IllegalArgumentException.class,
                () -> CarNameException.CarNameExceptionStart(carName)
        );
    }

    @Test
    void carNameNullTest() {
        Car car = new Car(null);
        String carName = car.getCarName();

        Assertions.assertThrows(IllegalArgumentException.class,
                () -> CarNameException.CarNameExceptionStart(carName)
        );
    }

    @Test
    void carNameNotTest() {
        Car car = new Car("aa12");
        String carName = car.getCarName();

        Assertions.assertThrows(IllegalArgumentException.class,
                () -> CarNameException.CarNameExceptionStart(carName)
        );
    }

    @Test
    void carNameStartOrEndTest() {

        Car car1 = new Car(",aa");
        String carName1 = car1.getCarName();
        Assertions.assertThrows(IllegalArgumentException.class,
                () -> CarNameException.CarNameExceptionStart(carName1)
        );


        Car car2 = new Car("ab,");
        String carName2 = car1.getCarName();
        Assertions.assertThrows(IllegalArgumentException.class,
                () -> CarNameException.CarNameExceptionStart(carName2)
        );
    }

    @Test
    void carNameLengthTest() {
        Car car1 = new Car("abcdef");
        String carName = car1.getCarName();

        Assertions.assertThrows(IllegalArgumentException.class,
                () -> CarNameException.CarNameExceptionStart(carName)
        );
    }

    @Test
    void carNameDuplicateTest() {
        Car car1 = new Car("aa");
        Car car2 = new Car("aa");
        String carName1 = car1.getCarName();
        String carName2 = car2.getCarName();

        Assertions.assertThrows(IllegalArgumentException.class,
                () -> CarNameException.CarNameExceptionStart(carName1 + DELIMITER +  carName2)
        );

    }

    @Test
    void carNameTrimTest() {
        Car car1 = new Car("aa");
        Car car2 = new Car(" ");
        Car car3 = new Car("bb");
        String carName1 = car1.getCarName();
        String carName2 = car2.getCarName();
        String carName3 = car3.getCarName();

        Assertions.assertThrows(IllegalArgumentException.class,
                () -> CarNameException.CarNameExceptionStart(carName1 + DELIMITER +  carName2 + DELIMITER + carName3)
        );

    }

}