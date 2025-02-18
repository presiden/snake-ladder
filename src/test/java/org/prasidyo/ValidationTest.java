package org.prasidyo;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class ValidationTest {
    @Test
    void testInvalidSnakePosition() {
        assertTrue(Validation.invalidSnakePosition(100, 90, 100),
            "There won’t be a snake at position " + 100);
        assertTrue(Validation.invalidSnakePosition(20, 20, 100),
            "Snake head must be higher than tail");
        assertTrue(Validation.invalidSnakePosition(20, 30, 100),
            "Snake head must be higher than tail");
        assertFalse(Validation.invalidSnakePosition(50, 30, 100));
    }

    @Test
    void testSnakeHeadExists() {
        assertTrue(Validation.snakeHeadExists(new Snake(20, 10)),
                "There is already a snake head at position " + 20);
        assertFalse(Validation.snakeHeadExists(null));
    }

    @Test
    void testLadderStartExists(){
        assertTrue(Validation.ladderStartExists(new Ladder(20, 30)),
                "There is already a ladder start at position " + 20);
        assertFalse(Validation.ladderStartExists(null));
    }

    @Test
    void testInvalidLadderPosition(){
        assertTrue(Validation.invalidLadderPosition(20, 10),
                "Ladder start must be lower than end");
        assertTrue(Validation.invalidLadderPosition(20, 20),
                "Ladder start must be lower than end");
        assertFalse(Validation.invalidLadderPosition(20, 50));
    }

    @Test
    void testOutOfBoundPosition(){
        assertTrue(Validation.outOfBoundPosition(101, 100),
                "Out of bound position! Can't be less than 1 or greater than " + 100);
        assertTrue(Validation.outOfBoundPosition(0, 100),
                "Out of bound position! Can't be less than 1 or greater than " + 100);
        assertFalse(Validation.outOfBoundPosition(100, 100));
        assertFalse(Validation.outOfBoundPosition(1, 100));
    }

    @Test
    void testInfiniteLoop(){
        Cell[] cells = new Cell[101];
        for(int x = 0; x <= 100; x++){
            cells[x] = new Cell();
        }

        cells[80] = new Cell(new Snake(80, 20));
        cells[20] = new Cell(new Ladder(20, 50));
        cells[50] = new Cell(new Snake(50, 15));

        assertTrue(Validation.infiniteLoop(15, 80, cells));
        assertFalse(Validation.infiniteLoop(15, 89, cells));
    }

    @Test
    void testExistsName(){
        Player[] players = new Player[100];
        players[0] = new Player("TestPlayer");
        assertTrue(Validation.existsName("TestPlayer", players));
        assertFalse(Validation.existsName("New Player", players));
    }
}
