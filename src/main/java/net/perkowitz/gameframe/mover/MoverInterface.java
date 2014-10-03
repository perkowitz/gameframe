package net.perkowitz.gameframe.mover;


import java.awt.*;

public interface MoverInterface {

    public void reset(int x, int y, Color color);
    public void step();
    public void render(net.perkowitz.gameframe.core.Frame frame);
    public boolean isDone();
    public int width();
    public int height();

}
