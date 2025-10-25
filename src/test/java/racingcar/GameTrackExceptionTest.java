package racingcar;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;


class GameTrackExceptionTest {


    @Test
    void gameTrackNullTest() {

        Assertions.assertThrows(IllegalArgumentException.class,
                () -> GameTrackException.gameTrackExceptionStart(null)
        );
    }

    @Test
    void gameTrackCountEmptyTest() {
        String countInput = "";
        Assertions.assertThrows(IllegalArgumentException.class,
                () -> GameTrackException.gameTrackExceptionStart(countInput)
        );
    }

    @Test
    void gameTrackCountFalseTest() {
        String countInput1 = "b";
        Assertions.assertThrows(IllegalArgumentException.class,
                () -> GameTrackException.gameTrackExceptionStart(countInput1)
        );

        String countInput2 = "1b";
        Assertions.assertThrows(IllegalArgumentException.class,
                () -> GameTrackException.gameTrackExceptionStart(countInput2)
        );

        String countInput3 = "b1";
        Assertions.assertThrows(IllegalArgumentException.class,
                () -> GameTrackException.gameTrackExceptionStart(countInput3)
        );
    }

    @Test
    void gameTrackStartFalseTest() {
        String countInput1 = "0";
        Assertions.assertThrows(IllegalArgumentException.class,
                () -> GameTrackException.gameTrackExceptionStart(countInput1)
        );
    }
}