package net.perkowitz.gameframe.mover;

import net.perkowitz.gameframe.core.*;

import java.awt.*;

public class BoxMover implements MoverInterface {

    private int startX = 0;
    private int startY = 0;
    private int endX = GameFrame.XSIZE-1;
    private int endY = GameFrame.YSIZE-1;
    private Color color;

    private int currentX = 0;
    private int currentY = 0;

    public BoxMover(int startX, int startY, int endX, int endY, Color color) {
        this.startX = startX;
        this.startY = startY;
        this.endX = endX;
        this.endY = endY;
        this.color = color;
        currentX = startX-1;
        currentY = startY;
    }

    public void reset(int x, int y, Color color) {
        currentX = x;
        currentY = y;
        this.color = color;
    }

    public void step() {

        if (currentY == startY && currentX < endX) {
            currentX++;
        } else if (currentX == endX && currentY < endY) {
            currentY++;
        } else if (currentY == endY && currentX > startX) {
            currentX--;
        } else if (currentX == startX && currentY > startY) {
            currentY--;
        }

    }

    public void render(net.perkowitz.gameframe.core.Frame frame) {
        frame.set(currentX,currentY,color);
    }

    public boolean isDone() {
        return false;
    }

    public int width() {
        return endX-startX+1;
    }

    public int height() {
        return endY-startY+1;
    }

}
