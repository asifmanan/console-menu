import io.consolemenu.Menu;

public class App {
    public static void main(String[] args) {
        Menu mainList = new Menu("Main List");

        Menu learnerList = new Menu("Learners",mainList);
        learnerList.addMenuItem("View",null);
        learnerList.addMenuItem("Add",null);
        learnerList.addMenuItem("Remove",null);
        learnerList.addMenuItem("Edit",null);

        mainList.addMenuItem("Some Option", null);
        mainList.addSubMenu(learnerList);

//        System.out.println(mainList.getList());
        mainList.display();
    }
}
