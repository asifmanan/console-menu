package io.consolemenu;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class MenuTest {

    @Test
    public void testMenuTitle() {
        Menu menu = new Menu("Test Menu");
        assertEquals("Test Menu", menu.getMenuTitle());
    }

    @Test
    public void testAddAndGetMenuItem() {
        Menu menu = new Menu("Test Menu");
        Runnable action = () -> {};
        String displayName = "Item 1";
        menu.addMenuItem(displayName, action);

        boolean foundItem = false;
        for(MenuItem item : menu.getMenuItems()){
            if(item.getDisplayName().equals("Item 1")){
                if(action == item.getAction()){
                    foundItem = true;
                }
            }
        }
        assertTrue(foundItem);
    }

    @Test
    public void testParentMenu() {
        Menu parentMenu = new Menu("Parent Menu");
        Menu childMenu = new Menu("Child Menu", parentMenu);
        assertTrue(childMenu.hasParentMenu());
    }

    @Test
    public void testAdditionOfQuitAction(){
        Menu menu = new Menu("Main");
        boolean foundQuitAction = false;
        for(MenuItem item : menu.getMenuItems()){
            if(item.getDisplayName().equals(":q")){
                foundQuitAction = true;
            }
        }
        assertTrue(foundQuitAction);
    }
    @Test
    public void testSubMenu() {
        Menu parentMenu = new Menu("Parent Menu");
        Menu subMenu = new Menu("Sub Menu");
        parentMenu.addSubMenu(subMenu);

        boolean foundSubMenu = false;
        for (MenuItem item : parentMenu.getMenuItems()) {
            if (item.getDisplayName().equals(subMenu.getMenuTitle())) {
                foundSubMenu = true;
                break;
            }
        }
        assertTrue(foundSubMenu);
    }
}
