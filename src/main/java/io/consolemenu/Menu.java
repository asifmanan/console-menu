package io.consolemenu;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Menu {
    String menuTitle;
    List<MenuItem> menuItems = new ArrayList<>();
    Menu parentMenu;
    public Menu(){
    }
    public Menu(String menuTitle){
        this(menuTitle, null);
    }
    public Menu(String menuTitle, Menu parentMenu){
        this.menuTitle = menuTitle;
        this.parentMenu = parentMenu;
    }
    public void addMenuItem(String displayName, Runnable action) {
        menuItems.add(new MenuItem(displayName, action));
    }
    public void addSubMenu(Menu subMenu){
        menuItems.add(new MenuItem(subMenu.menuTitle, subMenu::display));
    }
    public void display(){
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("\n" + menuTitle);
            for (int i = 0; i < menuItems.size(); i++) {
                System.out.println((i + 1) + ". " + menuItems.get(i).displayName);
            }

            int choice = scanner.nextInt();
            if (choice > 0 && choice <= menuItems.size()) {
                menuItems.get(choice - 1).execute();
            } else {
                System.out.println("Invalid option. Please try again.");
            }

            if (this.parentMenu != null) {
                break; // Return to the parent menu
            }
        }
    }
    public String getList(){
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i< menuItems.size(); i++){
            if(i != 0) {
                sb.append("    |    ");
            }
            sb.append(menuItems.get(i).displayName);
        }
        return sb.toString();
    }
}
