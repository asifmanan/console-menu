import io.consolemenu.ConsoleMenu;
import io.consolemenu.Menu;
import io.consolemenu.TerminalManager;

import java.io.IOException;

public class App {
    public static void main(String[] args) {
        Menu mainList = new Menu("Main List");

        Menu learnerList = new Menu("Learners",mainList);
        learnerList.addMenuItem("View",() -> System.out.println("View Selected"));
        learnerList.addMenuItem("Add",() -> System.out.println("Add Selected"));
        learnerList.addMenuItem("Remove",() -> System.out.println("Remove Selected"));
        learnerList.addMenuItem("Edit",() -> System.out.println("Edit Selected"));

        mainList.addMenuItem("Some Option", () -> System.out.println("Some Option"));
        mainList.addMenuItem("Some Other Option", () -> System.out.println("Some Other Option"));
        mainList.addSubMenu(learnerList);

//        System.out.println(mainList.getList());
//        mainList.display();
        ConsoleMenu consoleMenu = new ConsoleMenu(mainList);
        consoleMenu.initialize();
        try{
            TerminalManager.getTerminal().close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
