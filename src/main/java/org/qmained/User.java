package org.qmained;

public class User {

    private final String name;
    private final Terminal terminal;

    public User(String name, Terminal terminal) {
        this.name = name;
        this.terminal = terminal;
        terminal.connect(this);
    }

    public void runCommand() {
        terminal.runCommand("/command " + name);
    }

    public String getName() {
        return name;
    }
}
