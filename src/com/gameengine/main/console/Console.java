package com.gameengine.main.console;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;

public class Console {
    public static String COMMAND_PREFIX = "/";
    Thread thread;
    private final HashMap<String, Command> commands = new HashMap<>();

    public Console() {
        thread = new Thread(new Runnable() {
            @Override
            public void run() {
                BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
                while (true) {
                    try {
                        String line = reader.readLine();
                        if (line.startsWith(COMMAND_PREFIX)) {
                            String[] commandParams = line.substring(line.indexOf(" ") + 1).split(" ");
                            String command = line.substring(1, line.indexOf(" "));
                            if (commands.containsKey(command)) {
                                commands.get(command).command((Object[]) commandParams);
                            }
                        }
                    } catch (IOException e) {
                        throw new RuntimeException(e);
                    }

                }
            }
        });
        thread.start();

        commands.put("test", new Command() {
            @Override
            public void command(Object... params) {
                for (Object param : params) {
                    Console.log(param);
                }
            }
        });
    }

    public static void log(Object output) {
        System.out.println(output);
    }
}
