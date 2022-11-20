package org.example;

import java.util.List;

public class Instructions implements GameRule{

    private boolean gameOver = false;

    private boolean bulletIsFlying = false;

    private List<Bullet> bullets;

    public void setGameOver(boolean gameOver) {
        this.gameOver = gameOver;
    }

    public List<Bullet> getBullets() {
        return bullets;
    }

    public void setBullets(List<Bullet> bullets) {
        this.bullets = bullets;
    }

    public boolean isGameOver() {
        return gameOver;
    }

    public boolean isBulletIsFlying() {
        return bulletIsFlying;
    }

    public void setBulletIsFlying(boolean bulletIsFlying) {
        this.bulletIsFlying = bulletIsFlying;
    }

    public void processUserInput(int userInput, Player player, Map maps, int level) {
        switch(userInput) {
            case 'q':
                gameOver = true;
                break;
            case 'a':
                if (!maps.isWall(player.getY(), player.getX() - 1, level))
                    player.setX(player.getX()-1);
                player.setDx(-1);
                player.setDy(0);
                break;
            case 'd':
                if (!maps.isWall(player.getY() , player.getX()+ 1,level))
                    player.setX(player.getX()+1);
                player.setDx(1);
                player.setDy(0);
                break;
            case 'w':
                if (!maps.isWall(player.getY() - 1, player.getX(),level))
                    player.setY(player.getY()-1);
                player.setDy(-1);
                player.setDx(0);
                break;
            case 's':
                if (!maps.isWall(player.getY() + 1, player.getX(),level))
                    player.setY(player.getY()+1);
                player.setDy(1);
                player.setDx(0);
                break;
            case 'r':
                this.bulletIsFlying = true;
                break;
        }
    }

    @Override
    public void moveBullet(Map map, int level){
       int[][] maps;
       maps = map.getMapLevel(level);
        for (Bullet bullet: bullets){
            maps[bullet.getY()][bullet.getX()] = 0;
            if(bullet.getDy() == 1 && bullet.getDx() ==0){
                bullet.setY(bullet.getY()+1);
            }
            else if(bullet.getDy() == -1 && bullet.getDx() ==0){
                bullet.setY(bullet.getY()-1);
            }
            else if(bullet.getDy() == 0 && bullet.getDx() ==1){
                bullet.setX(bullet.getX()+1);
            }
            else if(bullet.getDy() == 0 && bullet.getDx() ==-1){
                bullet.setX(bullet.getX()-1);
            }
            maps[bullet.getY()][bullet.getX()] = 2;
            map.setMapLevel(maps,level);
        }
    }
    @Override
    public void bulletCollides(Map map, int level, List<Bot>bots, List<Bullet>bullets, Player player){
        int[][] matrix = map.getMapLevel(level);
        boolean collision= false;
        for(Bullet bullet: bullets){
             for (Bot bot: bots){
                if(bullet.getY() == bot.getY() && bullet.getX() == bot.getX()){
                    bullets.remove(bullet);
                    bots.remove(bot);
                    player.setPoints(player.getPoints()+1);
                    collision = true;
                    break;
                }
            }
             if(map.isWall(bullet.getY()+1,bullet.getX(), level) || map.isWall(bullet.getY(),bullet.getX()+1, level) || map.isWall(bullet.getY()-1,bullet.getX(), level) || map.isWall(bullet.getY(),bullet.getX()-1, level)){
                 collision = true;
                 bullets.remove(bullet);
             }
             if(collision){
                 matrix[bullet.getY()][bullet.getX()] = 0;
                 break;
             }
        }
        if(bots.isEmpty()){
            gameOver = true;
        }
        map.setMapLevel(matrix,level);

    }
    @Override
    public void playerCollides( List<Bot>bots, Player player){
        for (Bot bot: bots){
            if(player.getX() == bot.getX() && player.getY() == bot.getY()){
                player.setHitPoints(player.getHitPoints()-1);
            }
        }
        if(player.getHitPoints() == 0){
            gameOver = true;
        }
    }



}
