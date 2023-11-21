package math;

public class Vector2D {
    protected float x, y;

    public Vector2D(float x, float y) {
        this.x = x;
        this.y = y;
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
}
