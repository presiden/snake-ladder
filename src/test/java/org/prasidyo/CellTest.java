package org.prasidyo;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class CellTest {
    @Test
    void testSetSnake() {
        Cell cell = new Cell();
        Snake snake = new Snake(20, 10);
        cell.setSnake(snake);
        assertNotNull(cell.getSnake(), "Snake should be set");
        assertEquals(20, cell.getSnake().getHead(), "Snake head should match cell position");
        assertEquals(10, cell.getSnake().getTail(), "Snake tail should be correct");
    }

    @Test
    void testSetLadder() {
        Cell cell = new Cell();
        Ladder ladder = new Ladder(5, 15);
        cell.setLadder(ladder);
        assertNotNull(cell.getLadder(), "Ladder should be set");
        assertEquals(5, cell.getLadder().getStart(), "Ladder bottom should match cell position");
        assertEquals(15, cell.getLadder().getEnd(), "Ladder top should be correct");
    }
}
