package com.gameengine.main.util;

import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URL;
import java.nio.channels.Channels;
import java.nio.channels.FileChannel;
import java.nio.channels.ReadableByteChannel;

public class Updater {
    private String fileURL;

    public void checkForUpdates() {
        if (fileURL == null) {
            System.err.println("Update link not found!");
            return;
        }
        try {
            URL url = new URL(fileURL);
            ReadableByteChannel readableByteChannel = Channels.newChannel(url.openStream());
            FileOutputStream fileOutputStream = new FileOutputStream("update.jar");
            FileChannel fileChannel = fileOutputStream.getChannel();
            fileChannel.transferFrom(readableByteChannel, 0, Long.MAX_VALUE);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void setURL(String URL) {
        this.fileURL = URL;
    }
}
