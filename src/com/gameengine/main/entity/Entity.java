package com.gameengine.main.entity;

import com.gameengine.main.math.Vector2D;

import java.awt.*;

public abstract class Entity {
    protected Vector2D pos;

    public Entity() {
        pos = new Vector2D();
    }

    public abstract void update();

    public abstract void render(Graphics2D g);
}
