package org.qmained;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

public class Main {

    public static void main(String[] args) {
        List<Thread> threads = new ArrayList<>();
        OS os = new OS();
        for (int i = 0; i < 10; i++) {
            int finalI = i;
            threads.add(new Thread(() -> {
                try {
                    Terminal terminal = new Terminal(os);
                    Thread.sleep(500 + ThreadLocalRandom.current().nextInt(500));
                    User user = new User("User " + finalI, terminal);
                    for (int j = 0; j < 15; j++) {
                        Thread.sleep(500 + ThreadLocalRandom.current().nextInt(500));
                        user.runCommand();
                    }
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }));
        }
        for (Thread thread : threads) {
            thread.start();
        }
    }

}