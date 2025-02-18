package org.prasidyo;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class DiceTest {
    @Test
    void testRollDiceReturnsValidNumber() {
        Dice dice = new Dice();
        for (int i = 0; i < 100; i++) {
            int result = dice.roll();
            assertTrue(result >= 1 && result <= 6, "Dice roll should be between 1 and 6");
        }
    }
}
