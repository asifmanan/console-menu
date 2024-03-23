package io.consolemenu;

import org.jline.reader.LineReader;
import org.jline.reader.LineReaderBuilder;
import org.jline.reader.impl.completer.StringsCompleter;
import org.jline.terminal.Terminal;
import org.jline.terminal.TerminalBuilder;

import java.io.IOException;

public class ConsoleMenu {
    private final Menu menu;


    public ConsoleMenu(){
        menu = new Menu();

    }
    public ConsoleMenu(Menu menu) {
        this.menu = menu;
    }
    public void initialize(){
        Terminal terminal = null;
        LineReader lineReader = null;
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

        while(true){
            line = lineReader.readLine("main>>");
            if(":q".equals(line)){
                break;
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

