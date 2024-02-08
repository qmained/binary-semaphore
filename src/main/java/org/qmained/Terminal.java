package org.qmained;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Terminal {

    private static final Lock lock = new ReentrantLock(true);
    private static int terminalCounter = 0;
    private final int terminalNumber = terminalCounter++;
    private final OS os;

    public Terminal(OS os) {
        this.os = os;
    }

    public void connect(User user) {
        System.out.println("User " + user.getName() + " has connected to terminal " + terminalNumber);
    }

    public void runCommand(String command) {
        lock.lock();
        try {
            os.runCommand(command);
        } finally {
            lock.unlock();
        }
    }

}
