package io.consolemenu;

import org.jline.reader.LineReader;
import org.jline.reader.LineReaderBuilder;
import org.jline.reader.impl.completer.StringsCompleter;
import org.jline.terminal.Terminal;
import org.jline.terminal.TerminalBuilder;

import java.io.IOException;

public class ConsoleMenu {
    private Menu menu;


    public ConsoleMenu(){
        menu = new Menu();

    }
    public ConsoleMenu(Menu menu) {
        this.menu = menu;
    }
    public void initialize(){
        Terminal terminal = null;
        LineReader lineReader = null;
//        List<String> menuItemsList = new ArrayList<>(menu.getItemsList());
//        menuItemsList.add(":q");
//        if(menu.hasParentMenu()){
//            menuItemsList.add(":b");
//        }
        try {
            terminal = TerminalBuilder.builder().build();


            StringsCompleter completer = new StringsCompleter(menu.getItemsList());

            lineReader = LineReaderBuilder.builder().terminal(terminal).completer(completer).build();


        } catch (IOException e) {
            e.printStackTrace();
        }
        if(terminal == null || lineReader == null) {
            return;
        }

        String line;
        terminal.flush();

        while(!menu.getBreakLoopFlag()){
            line = lineReader.readLine("main>>");
            if(":q".equals(line)){
                break;
            }
            for(int i = 0; i < menu.getMenuItems().size(); i++){
                if(line.trim().equals(menu.getMenuItem(i).getDisplayName().trim())){
                    menu.getMenuItem(i).execute();
                }
            }
            terminal.flush();
        }
        try{
            terminal.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}

