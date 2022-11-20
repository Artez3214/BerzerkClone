package org.example;

public abstract class Entity {
    private int x;
    private int y;

    private int dx;

    private int dy;

    public Entity(int x, int y, int dx, int dy) {
        this.x = x;
        this.y = y;
        this.dx = dx;
        this.dy = dy;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public int getDx() {
        return dx;
    }

    public void setDx(int dx) {
        this.dx = dx;
    }

    public int getDy() {
        return dy;
    }

    public void setDy(int dy) {
        this.dy = dy;
    }

    public void moveObject(Map maps, int level){
        if(dy == 1 && dx ==0){
            y += 1;
        }
        else if(dy ==-1 && dx == 0){
            y -= 1;
        }
        else if(dy ==0 && dx == 1 ){
            x+=1;
        }
        else if(dy ==0 && dx == -1){

            x-=1;
        }
    }
}
