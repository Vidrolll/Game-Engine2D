package com.gameengine.main.util;

import com.gameengine.main.console.Console;

import java.io.*;
import java.net.URL;
import java.util.Scanner;

public class Updater {
    private String fileURL;
    private String outputPath;
    private String verPath;

    public void checkForUpdates() {
        if (fileURL == null) {
            System.err.println("Update link not found!");
            return;
        }
        try {
            InputStream ver = new BufferedInputStream(new URL(verPath).openStream());
            Scanner scan1 = new Scanner(ver);
            Scanner scan2 = new Scanner(new File("res/ver.txt"));
            if (scan1.next().equals(scan2.next())) return;
            scan1.close();
            scan2.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        Console.log("test");
        try (BufferedInputStream in = new BufferedInputStream(new URL(fileURL).openStream());
             FileOutputStream fileOutputStream = new FileOutputStream(outputPath + "update.jar")) {
            byte[] dataBuffer = new byte[1024];
            int bytesRead;
            while ((bytesRead = in.read(dataBuffer, 0, 1024)) != -1) {
                fileOutputStream.write(dataBuffer, 0, bytesRead);
            }
        } catch (IOException e) {
            // handle exception
        }
        Console.log("test");
    }

    public void setURL(String URL) {
        this.fileURL = URL;
    }

    public void setVerPath(String verPath) {
        this.verPath = verPath;
    }
    public void setOutput(String outputPath) {
        this.outputPath = outputPath;
    }
}
