import java.util.ArrayList;
import java.util.List;

public class ConsoleMenu {

    private List<String> menuItems = new ArrayList<>();
    public void addItem(String item){
        menuItems.add(item);
    }
    public String displayMenu(){
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i< menuItems.size(); i++){
            if(i != 0) {
                sb.append("    |    ");
            }
            sb.append(menuItems.get(i));

        }
        return sb.toString();
    }
}

