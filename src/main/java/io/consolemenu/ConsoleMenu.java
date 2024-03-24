package io.consolemenu;

import org.jline.reader.LineReader;
import org.jline.terminal.Terminal;
import org.jline.utils.InfoCmp;

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
            terminal = TerminalManager.getTerminal();
            lineReader = TerminalManager.getLineReader();

//            TerminalManager.updateCompleter(menu.getItemsList());
//            lineReader = TerminalManager.getLineReader();

//            lineReader = LineReaderBuilder.builder().terminal(terminal).completer(completer).build();


        } catch (IOException e) {
            e.printStackTrace();
        }
//        if(terminal == null || lineReader == null) {
//            return;
//        }

        String line;
        terminal.flush();

        while(!menu.getBreakLoopFlag()){
            terminal.puts(InfoCmp.Capability.clear_screen);
            System.out.println("Menu Title: "+ menu.getMenuTitle());
            try {
                TerminalManager.updateCompleter(menu.getItemsList());
                lineReader = TerminalManager.getLineReader();
            } catch (IOException e) {
                e.printStackTrace();
            }
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
    }
}

