package io.consolemenu;

public class MenuItem {
    private String displayName;
    private Runnable action;
    public MenuItem(String displayName, Runnable action){
        this.displayName = displayName;
        this.action = action;
    }
    public void execute() {
        this.action.run();
    }

    public String getDisplayName(){
        return this.displayName;
    }

}
