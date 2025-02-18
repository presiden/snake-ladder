package org.prasidyo;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class SnakeTest {
    @Test
    void testSnakeInitialization() {
        Snake snake = new Snake(20, 10);
        assertEquals(20, snake.getHead(), "Snake head should be at position 20");
        assertEquals(10, snake.getTail(), "Snake tail should be at position 10");
    }
}
