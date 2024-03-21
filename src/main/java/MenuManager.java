import org.jline.reader.LineReader;
import org.jline.reader.LineReaderBuilder;
import org.jline.reader.impl.completer.StringsCompleter;
import org.jline.terminal.Terminal;
import org.jline.terminal.TerminalBuilder;

import java.io.IOException;
import java.util.Set;

public class MenuManager {
    private Set<String> completionItems;
    private ConsoleMenu mainMenu = new ConsoleMenu();
    public MenuManager(){
        this.createMenu();
    }
    public void createMenu(){
        mainMenu.addItem("Learners");
        mainMenu.addItem("Coaches");
        mainMenu.addItem("Bookings");
        mainMenu.addItem("Reports");
    }
    public void initialize(){
        Terminal terminal = null;
        try{
            terminal = TerminalBuilder.builder().dumb(true).build();

            StringsCompleter mainMenuCompleter = new StringsCompleter();
//            mainMenuCompleter

            LineReader lineReader = LineReaderBuilder.builder()
                    .terminal(terminal)
                    .build();

            String line;
            terminal.writer().println(mainMenu.displayMenu());
            terminal.flush();

            while (true) {
                line = lineReader.readLine("main>>");
                if(":q".equals(line)) {
                    break;
                }
                terminal.flush();
            }

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if(terminal != null){
                try {
                    terminal.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }

            }
        }

    }

}
