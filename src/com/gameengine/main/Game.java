package com.gameengine.main;

import com.gameengine.main.console.Console;
import com.gameengine.main.ui.MainWindow;
import com.gameengine.main.ui.RenderHandler;
import com.gameengine.main.util.RendererVariables;
import com.gameengine.main.util.Updater;

import java.awt.*;
import java.awt.image.BufferStrategy;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

public class Game extends Canvas implements Runnable {
    private boolean running;
    String gameName;
    MainWindow window;
    Thread thread;

    RenderHandler rh;
    RendererVariables rv;
    Updater up;

    public Game(String gameName) {
        this.gameName = gameName;
        rh = new RenderHandler(this);
        rv = new RendererVariables();
        up = new Updater(this);
        new Console();
        rv.updateHints();
    }

    @Retention(RetentionPolicy.RUNTIME)
    public @interface Version {
        String version() default "1.0";
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
        rv.updateHints();
    }
    public void render() {
        BufferStrategy bs = this.getBufferStrategy();
        if(bs == null) {
            this.createBufferStrategy(2);
            return;
        }
        Graphics2D g = (Graphics2D)bs.getDrawGraphics();
        g.setRenderingHints(RendererVariables.RENDERING_HINTS);
        rh.render(g);
        g.dispose();
        g = (Graphics2D)bs.getDrawGraphics();
        g.setRenderingHints(RendererVariables.RENDERING_HINTS);
        drawGUI(g);
        g.dispose();
        bs.show();
    }

    public  void drawBackground(Graphics2D g) {}
    public  void drawForeground(Graphics2D g) {}
    public  void drawGUI(Graphics2D g) {}

    public Updater getUpdater() {
        return up;
    }

    public void createWindow(int width, int height) {
        window = new MainWindow(gameName,this,width,height);
    }
    public void fullscreen() {
        window.fullscreen();
    }
}
