package net.perkowitz.gameframe;

import java.awt.*;

public class StraightMover implements MoverInterface {

    public static int DIRECTION_NORTH = 0;
    public static int DIRECTION_EAST = 1;
    public static int DIRECTION_SOUTH = 2;
    public static int DIRECTION_WEST = 3;

    private int direction = DIRECTION_EAST;
    private int x;
    private int y;
    private Color color;
    private boolean loop;
    private boolean done;


    public StraightMover(int x, int y, Color color, int direction, boolean loop) {
        this.x = x;
        this.y = y;
        this.color = color;
        this.direction = direction;
        this.loop = loop;
        this.done = false;
    }

    public void reset(int x, int y, Color color) {
        this.x = x;
        this.y = y;
        this.color = color;
    }

    public void step() {
        if (direction == DIRECTION_NORTH) {
            y = y - 1;
            if (loop) {
                y = y % GameFrame.YSIZE;
            } else if (y < 0) {
                done = true;
            }
        } else if (direction == DIRECTION_EAST) {
            x = x + 1;
            if (loop) {
                x = x % GameFrame.XSIZE;
            } else if (x >= GameFrame.XSIZE) {
                done = true;
            }
        } else if (direction == DIRECTION_SOUTH) {
            y = y + 1;
            if (loop) {
                y = y % GameFrame.YSIZE;
            } else if (y >= GameFrame.YSIZE) {
                done = true;
            }
        } else if (direction == DIRECTION_WEST) {
            x = x - 1;
            if (loop) {
                x = x % GameFrame.XSIZE;
            } else if (x < 0) {
                done = true;
            }
        }
    }

    public void render(Frame frame) {
        if (!done) {
            frame.set(x,y,color);
        }
    }

    public boolean isDone() {
        return done;
    }

}
