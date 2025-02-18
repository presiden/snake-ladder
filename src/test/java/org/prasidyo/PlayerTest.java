package org.prasidyo;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class PlayerTest {
    @Test
    void testPlayerInitialization() {
        Player player = new Player("TestPlayer");
        assertEquals("TestPlayer", player.getName(), "Player name should match the initialized name");
        assertEquals(0, player.getPosition(), "Initial position should be 0");
    }

    @Test
    void testMovePlayer() {
        Player player = new Player("TestPlayer");
        player.setPosition(5);
        assertEquals(5, player.getPosition(), "Player position should be updated correctly");
    }
}
