package com.gameengine.main.ui.camera;

import com.gameengine.main.math.Vector2D;

public class Camera {
    Vector2D pos;
    Vector2D scale;

    Vector2D vel;
    Vector2D acc;

    public Camera() {
        pos = new Vector2D(0,0);
        scale = new Vector2D(1,1);
    }

    public void update() {
        vel.add(acc);
        pos.add(vel);
    }

    public Vector2D pos() {
        return pos;
    }
    public Vector2D scale() {
        return scale;
    }
}
