package com.gameengine.main.ui;

import com.gameengine.main.Game;
import com.gameengine.main.ui.camera.Camera;
import com.gameengine.main.util.RendererVariables;

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
        g.translate(RendererVariables.getCam().pos().getX() * backgroundScroll,
                RendererVariables.getCam().pos().getY() * backgroundScroll);
        game.drawBackground(g);
        g.translate(-RendererVariables.getCam().pos().getX() * backgroundScroll,
                -RendererVariables.getCam().pos().getY() * backgroundScroll);
        g.translate(RendererVariables.getCam().pos().getX(), RendererVariables.getCam().pos().getY());
        game.drawForeground(g);
    }
}
