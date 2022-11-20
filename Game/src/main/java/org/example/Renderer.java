package org.example;

import java.io.IOException;
import java.util.List;

public class Renderer {

    private Renderer(){
    }

    private static Renderer mapObject;

    public static Renderer getInstance(){
        if(mapObject == null){
            mapObject = new Renderer();
        }
        return mapObject;
    }
    public static void clearScreen(){


        try {

            if (System.getProperty("os.name").contains("Windows"))

                new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();

            else

                Runtime.getRuntime().exec("clear");

        } catch (IOException | InterruptedException ex) {}


    }

    public void renderMap(Map map, int level,Player player,List<Bot> bots){
        for(int i =0;i<map.getHeight(level);i++) {
            for(int j=0;j< map.getWidth(level);j++) {
                if(map.isWall(i,j,level)){
                    System.out.print("#");
                }
                else if (i == player.getY() && j == player.getX()) {
                    System.out.print("O");
                }
                else if(isBots(j,i,bots)) {
                    System.out.print("B");
                }
                else if(map.isBullet(i,j,level)) {
                    System.out.print(".");
                }
                else {
                    System.out.print(" ");
                }
            }
            System.out.println();
        }
    }

    private boolean isBots(int x, int y, List<Bot> bots) {
        for (Bot bot: bots)
            if ((bot.getX() == x && bot.getY() == y))
                return true;
        return false;
    }

}
