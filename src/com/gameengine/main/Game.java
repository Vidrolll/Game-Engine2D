package com.gameengine.main;

import com.gameengine.main.ui.MainWindow;
import com.gameengine.main.ui.RenderHandler;
import com.gameengine.main.ui.camera.Camera;

import java.awt.*;
import java.awt.image.BufferStrategy;
import java.nio.Buffer;

public class Game extends Canvas implements Runnable {
    private boolean running;
    String gameName;
    MainWindow window;
    Thread thread;

    RenderHandler rh;

    public Game(String gameName) {
        this.gameName = gameName;
        rh = new RenderHandler(this);
    }

    @Override
    public void run() {
        double ticks = 60.0;
        double tickTime = 1000000000 / ticks;
        double delta = 0;
        long lastTime = System.nanoTime();
        while(running) {
            long now = System.nanoTime();
            delta += (now-lastTime) / tickTime;
            lastTime = now;
            while(delta >= 1) {
                update();
                render();
                delta--;
            }
        }
        stop();
    }

    public synchronized void start() {
        thread = new Thread(this);
        running = true;
        thread.start();
    }
    public synchronized void stop() {
        try {
            thread.join();
            running = false;
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public void update() {

    }
    public void render() {
        BufferStrategy bs = this.getBufferStrategy();
        if(bs == null) {
            this.createBufferStrategy(2);
            return;
        }
        Graphics2D g = (Graphics2D)bs.getDrawGraphics();
        rh.render(g);
        g.dispose();
        g = (Graphics2D)bs.getDrawGraphics();
        drawGUI(g);
        g.dispose();
        bs.show();
    }

    public  void drawBackground(Graphics2D g) {}
    public  void drawForeground(Graphics2D g) {}
    public  void drawGUI(Graphics2D g) {}

    public void createWindow(int width, int height) {
        window = new MainWindow(gameName,this,width,height);
    }
    public void fullscreen() {
        window.fullscreen();
    }
}
