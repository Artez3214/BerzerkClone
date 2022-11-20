import org.example.Instructions;
import org.example.Map;
import org.example.Player;
import org.junit.Assert;
import org.junit.Test;


import java.io.IOException;

import static org.junit.Assert.*;

public class PlayerTest {
    @Test
    public void playerLeftTest(){

        Map map = new Map();
        Player player = new Player(5,20,1,0,3,3);
        int expectedPlayerLocationX = player.getX()+1;
        Instructions instructions = new Instructions();
        instructions.processUserInput(100,player,map,1);
        Assert.assertEquals(expectedPlayerLocationX, player.getX());
    }
    @Test
    public void playerRightWallTest(){
        Map map = new Map();
        int[][] matrix = map.getMapLevel(1);
        Player player = new Player(matrix[0].length-2, 20,1,0,3,3);
        int expectedPlayerLocationX = player.getX();
        Instructions instructions = new Instructions();
        instructions.processUserInput(100,player,map,1);
        Assert.assertEquals(expectedPlayerLocationX, player.getX());
    }
    @Test
    public void playerLeftWallTest(){
        Map map = new Map();
        int[][] matrix = map.getMapLevel(1);
        Player player = new Player(1, 20,1,0,3,3);
        int expectedPlayerLocationX = player.getX();
        Instructions instructions = new Instructions();
        instructions.processUserInput(97,player,map,1);
        Assert.assertEquals(expectedPlayerLocationX, player.getX());
    }

}
