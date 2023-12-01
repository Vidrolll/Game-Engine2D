package com.gameengine.main.util;

import java.io.BufferedInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URL;

public class Updater {
    private String fileURL;
    private String outputPath;

    public void checkForUpdates() {
        if (fileURL == null) {
            System.err.println("Update link not found!");
            return;
        }
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
    }

    public void setURL(String URL) {
        this.fileURL = URL;
    }

    public void setOutput(String outputPath) {
        this.outputPath = outputPath;
    }
}
