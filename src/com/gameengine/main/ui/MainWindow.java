package com.gameengine.main.ui;

import javax.swing.*;
import java.awt.*;

import com.gameengine.main.Game;

public class MainWindow extends Canvas {
    private final int width;
    private final int height;
    private final String gameName;
    private final Game game;
    private boolean fullscreen;
    JFrame frame;

    public MainWindow(String gameName, Game game, int width, int height) {
        this.width = width;
        this.height = height;
        this.gameName = gameName;
        this.game = game;
        createWindow();
        frame.setVisible(true);
    }

    private void createWindow() {
        frame = new JFrame(gameName);
        frame.setSize(new Dimension(width,height));
        frame.setResizable(false);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(game);
    }

    public void fullscreen() {
        Toolkit tk = Toolkit.getDefaultToolkit();
        int xSize = ((int) tk.getScreenSize().getWidth());
        int ySize = ((int) tk.getScreenSize().getHeight());
        frame.dispose();
        createWindow();
        frame.setUndecorated(!fullscreen);
        frame.setVisible(true);
        fullscreen = !fullscreen;
        if(fullscreen)
            frame.setSize(new Dimension(xSize,ySize));
        frame.setLocationRelativeTo(null);
    }
}
