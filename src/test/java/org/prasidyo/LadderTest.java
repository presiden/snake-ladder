package org.prasidyo;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class LadderTest {
    @Test
    void testLadderInitialization() {
        Ladder ladder = new Ladder(5, 15);
        assertEquals(5, ladder.getStart(), "Ladder start should be at position 5");
        assertEquals(15, ladder.getEnd(), "Ladder end should be at position 15");
    }
}
