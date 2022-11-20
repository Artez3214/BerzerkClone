package org.example;

import java.util.List;

public interface GameRule {
    public void moveBullet(Map map, int level);
    public void bulletCollides(Map map, int level, List<Bot> bots, List<Bullet>bullets, Player player);
    public void playerCollides( List<Bot>bots, Player player);
}
