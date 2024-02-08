package org.qmained;

public class OS {

    private int operations = 0;

    public void runCommand(String command) {
        operations++;
        System.out.println("[OS]: Executed command: " + command + "." +
                "\nTotal number of operations:" + operations);
    }

}
