package com.gameengine.main.ui;

import com.gameengine.main.Game;
import com.gameengine.main.ui.camera.Camera;

import java.awt.*;
import java.util.ArrayList;

public class RenderHandler {
    ArrayList<Camera> cameras = new ArrayList<Camera>();
    Camera currentCamera;
    Game game;

    public float backgroundScroll = 0.5f;

    public RenderHandler(Game game) {
        this.game = game;
        currentCamera = new Camera();
    }

    public void render(Graphics2D g) {
        g.translate(currentCamera.pos().getX()*backgroundScroll,
                currentCamera.pos().getY()*backgroundScroll);
        game.drawBackground(g);
        g.translate(-currentCamera.pos().getX()*backgroundScroll,
                -currentCamera.pos().getY()*backgroundScroll);
        g.translate(currentCamera.pos().getX(),currentCamera.pos().getY());
        game.drawForeground(g);
    }
}
