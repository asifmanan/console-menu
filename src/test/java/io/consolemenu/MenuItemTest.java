package io.consolemenu;

import org.junit.jupiter.api.Test;

import java.util.concurrent.atomic.AtomicBoolean;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class MenuItemTest {

    @Test
    public void testConstructor() {
        Runnable action = () -> {};
        MenuItem item = new MenuItem("Item1", action);
        assertEquals("Item1", item.getDisplayName());
        assertNotNull(item.getAction());
    }

    @Test
    public void testHintConstructor() {
        Runnable action = () -> {};
        MenuItem item = new MenuItem("Item1", action, "This is a hint");
        assertEquals("This is a hint", item.getHint());
    }

    @Test
    public void testGetDisplayName() {
        Runnable action = () -> {};
        MenuItem item = new MenuItem("Item2", action);
        assertEquals("Item2", item.getDisplayName());
    }

    @Test
    public void testGetHint() {
        Runnable action = () -> {};
        MenuItem item = new MenuItem("Item1", action, "Hint here");
        assertEquals("Hint here", item.getHint());

        MenuItem itemNoHint = new MenuItem("Item2", action);
        assertNull(itemNoHint.getHint());
    }

    @Test
    public void testExecute() {
        AtomicBoolean wasRun = new AtomicBoolean(false);
        Runnable action = () -> wasRun.set(true);
        MenuItem item = new MenuItem("Item", action);
        item.execute();
        assertTrue(wasRun.get());
    }
}
