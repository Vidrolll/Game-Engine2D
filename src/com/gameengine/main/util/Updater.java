package com.gameengine.main.util;

import com.gameengine.main.Game;

import java.io.BufferedInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.Scanner;

public class Updater {
    private String fileURL;
    private String outputPath;

    Game game;

    public Updater(Game game) {
        this.game = game;
    }

    public void checkForUpdates() {
        if (fileURL == null) {
            System.err.println("Update link not found!");
            return;
        }
        try {
            InputStream ver = new BufferedInputStream(new URL(fileURL).openStream());
            Scanner scan = new Scanner(ver);
            while (scan.hasNext()) {
                String line = scan.nextLine();
                if (line.contains("<title>")) {
                    int index1 = line.indexOf(".");
                    int index2 = line.indexOf(" ", line.indexOf("<title>"), index1);
                    int index3 = line.indexOf(":", index1);
                    if (line.substring(index2 + 1, index3).equals(game.getClass().getAnnotation(Game.Version.class).version()))
                        return;
                }
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        try (BufferedInputStream in = new BufferedInputStream(new URL(fileURL + "download/Game.Engine.jar").openStream());
             FileOutputStream fileOutputStream = new FileOutputStream(outputPath + ".jar")) {
            byte[] dataBuffer = new byte[1024];
            int bytesRead;
            while ((bytesRead = in.read(dataBuffer, 0, 1024)) != -1) {
                fileOutputStream.write(dataBuffer, 0, bytesRead);
            }
        } catch (IOException e) {
            // handle exception
        }
    }

    public void setURL(String URL) {
        this.fileURL = URL;
    }
    public void setOutput(String outputPath) {
        this.outputPath = outputPath;
    }
}
