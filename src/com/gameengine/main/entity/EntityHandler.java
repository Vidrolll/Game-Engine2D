package com.gameengine.main.entity;

import java.awt.*;
import java.util.ArrayList;

public class EntityHandler {
    private final ArrayList<Entity> entities = new ArrayList<Entity>();

    public void addEntity(Entity entity) {
        entities.add(entity);
    }

    public void removeEntity(Entity entity) {
        entities.remove(entity);
    }

    public Entity getEntity(int entity) {
        return entities.get(entity);
    }

    public void clearEntities() {
        entities.clear();
    }

    public void update() {

    }

    public void render(Graphics2D g) {

    }
}
