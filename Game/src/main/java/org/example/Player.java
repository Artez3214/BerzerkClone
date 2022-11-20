package org.example;

public final class Player extends Entity{
    private int hitPoints;

    private int points;

    public int getHitPoints() {
        return hitPoints;
    }

    public void setHitPoints(int hitPoints) {
        this.hitPoints = hitPoints;
    }

    public int getPoints() {
        return points;
    }

    public void setPoints(int points) {
        this.points = points;
    }

    public Player(int x, int y, int dx, int dy, int hitPoints, int points) {
        super(x, y, dx, dy);
        this.hitPoints = hitPoints;
        this.points = points;
    }
}
