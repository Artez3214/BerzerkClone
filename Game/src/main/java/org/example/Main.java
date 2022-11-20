package org.example;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Main {


    public static void main(String[] args) throws IOException {
        List<Bot> firstLevelBots = new ArrayList<>();
        List<Bot> secondLevelBots = new ArrayList<>();
        List<Bullet> bullets = new ArrayList<>();
        firstLevelBots.add(new Bot(35, 10, 0, 1));
        firstLevelBots.add(new Bot(5, 1, 0, -1));
        secondLevelBots.add(new Bot(10, 20, 0, 1));
        secondLevelBots.add(new Bot(40, 20, 0, -1));
        Map map = new Map();
        Renderer renderer = Renderer.getInstance();
        Player player = new Player(10,10,1,0,3,0);
        Instructions  instructions = new Instructions();
        int level = 1;
        do {
            if (level == 1) {
                calculateGame(renderer, map, instructions, player, bullets, level, firstLevelBots);
            } else if (level == 2) {
                calculateGame(renderer, map, instructions, player, bullets, level, secondLevelBots);
            }
            level = assignLevel(map, player, level);

        } while (!instructions.isGameOver());
        System.out.println("Game Over");
    }



    private static void calculateGame(Renderer renderer, Map map, Instructions instructions, Player player, List<Bullet> bullets, int level, List<Bot> botLevel) throws IOException {
        Renderer.clearScreen();
        int userInput =  readUserInput();
        instructions.processUserInput(userInput,player,map,level);
        instructions.setBullets(bullets);

        if(instructions.isBulletIsFlying()) {
            bullets.add(new Bullet(player.getX(), player.getY(), player.getDx(), player.getDy(), map, level));
            instructions.setBulletIsFlying(false);
        }
        if(!bullets.isEmpty()){
            instructions.moveBullet(map,level);
            instructions.bulletCollides(map,level,botLevel,bullets, player);
        }
        instructions.playerCollides(botLevel,player);
        moveBots(botLevel,map,level);
        renderer.renderMap(map,level,player,botLevel);

    }

    private static int assignLevel(Map map, Player player, int level){
        int[][] matrix;
        matrix = map.getMapLevel(level);
        for(int i=0 ; i< matrix[0].length;i++){
           if(matrix[player.getY()][player.getX()] == 0 && matrix.length-1 == player.getY()) {
               level = 2;
               player.setY(0);
           }
       }
        return level;
    }

    private static byte readUserInput() throws IOException {

        byte[] bytes = new byte[10];
        System.in.read(bytes);
        byte userInput = bytes[0];

        return userInput;
    }

    private static void moveBots(List<Bot> bots, Map map, int level){
        for (Bot bot: bots){
            bot.moveObject(map,level);
        }
    }
}