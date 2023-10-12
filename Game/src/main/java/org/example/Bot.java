package org.example;

public final class Bot extends Entity{
    public Bot(int x, int y, int dx, int dy) {
        super(x, y, dx, dy);
    }
    // This methods moves main character
    @Override
    public void moveObject(Map maps, int level){
        int min = 1;
        int max = 4;
        int b = (int)(Math.random()*(max-min+1)+min);
        if(b == 1 && !maps.isWall(getY() + 1, getX(), level)){
            setY(getY()+1);
        }
        else if(b == 2 && !maps.isWall(getY() - 1, getX(), level)){
            setY(getY()-1);
        }
        else if(b == 3 && !maps.isWall(getY() , getX()+ 1, level)){
            setX(getX()+1);
        }
        else if(b == 4 && !maps.isWall(getY() , getX()- 1, level)){
            setX(getX()-1);
        }
    }
}
