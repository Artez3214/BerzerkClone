package org.example;

public class Bullet extends Entity{
    
    public Bullet(int x, int y, int dx, int dy,Map maps,int level) {
        super(x, y, dx, dy);
        int[][] map;
        map = maps.getMapLevel(level);
        if(dx == 0 && dy == 1){
            y+=1;
        }
        else  if(dx == 0 && dy == -1){
            y-=1;
        }
        else  if(dx == 1 && dy == 0){
            x+=1;
        }
        else  if(dx == -1 && dy == 0){
            x-=1;
        }
        map[y][x]= 2;
        maps.setMapLevel(map,level);
    }

}
