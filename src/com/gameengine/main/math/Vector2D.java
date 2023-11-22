package com.gameengine.main.math;

public class Vector2D {
    protected float x, y;

    public Vector2D(float x, float y) {
        this.x = x;
        this.y = y;
    }

    public float getX() {
        return x;
    }
    public float getY() {
        return y;
    }

    public void set(float x, float y) {
        this.x = x;
        this.y = y;
    }
    public void set(Vector2D vec) {
        this.x = vec.x;
        this.y = vec.y;
    }
    public void setX(float x) {
        this.x = x;
    }
    public void setX(Vector2D vec) {
        this.x = vec.x;
    }
    public void setY(float y) {
        this.y = y;
    }
    public void setY(Vector2D vec) {
        this.y = vec.y;
    }
    public void add(float x, float y) {
        this.x += x;
        this.y += y;
    }
    public void add(Vector2D vec) {
        this.x += vec.x;
        this.y += vec.y;
    }
    public void addX(float x) {
        this.x += x;
    }
    public void addX(Vector2D vec) {
        this.x += vec.x;
    }
    public void addY(float y) {
        this.y += y;
    }
    public void addY(Vector2D vec) {
        this.y += vec.y;
    }
    public void sub(float x, float y) {
        this.x -= x;
        this.y -= y;
    }
    public void sub(Vector2D vec) {
        this.x -= vec.x;
        this.y -= vec.y;
    }
    public void subX(float x) {
        this.x -= x;
    }
    public void subX(Vector2D vec) {
        this.x -= vec.x;
    }
    public void subY(float y) {
        this.y -= y;
    }
    public void subY(Vector2D vec) {
        this.y -= vec.y;
    }
    public void mul(float x, float y) {
        this.x *= x;
        this.y *= y;
    }
    public void mul(Vector2D vec) {
        this.x *= vec.x;
        this.y *= vec.y;
    }
    public void mulX(float x) {
        this.x *= x;
    }
    public void mulX(Vector2D vec) {
        this.x *= vec.x;
    }
    public void mulY(float y) {
        this.y *= y;
    }
    public void mulY(Vector2D vec) {
        this.y *= vec.y;
    }
    public void div(float x, float y) {
        this.x /= x;
        this.y /= y;
    }
    public void div(Vector2D vec) {
        this.x /= vec.x;
        this.y /= vec.y;
    }
    public void divX(float x) {
        this.x /= x;
    }
    public void divX(Vector2D vec) {
        this.x /= vec.x;
    }
    public void divY(float y) {
        this.y /= y;
    }
    public void divY(Vector2D vec) {
        this.y /= vec.y;
    }
    public float dot(Vector2D vec) {
        return (x*vec.x) + (y*vec.y);
    }
    public float dist(Vector2D vec) {
        return (float)Math.sqrt(Math.pow(getX()-vec.getX(),2)+Math.pow(getY()-vec.getY(),2));
    }
}
