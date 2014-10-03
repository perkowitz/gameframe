package net.perkowitz.gameframe.mover;


import java.awt.*;

public class GrabberMover implements MoverInterface {

    private int type;
    private int x = -1;
    private int y = -1;
    private Color color = Color.white;

    public GrabberMover(int type, Color color, int x, int y) {
        this.type = type;
        this.color = color;
        this.x = x;
        this.y = y;
    }

    public void reset(int x, int y, Color color) {
        this.x = x;
        this.y = y;
        this.color = color;
    }

    public void step() {

    }

    public void render(net.perkowitz.gameframe.core.Frame frame) {
        switch (type) {
            case 0:
                draw0(frame);
                return;
        }
    }

    public boolean isDone() {
        return false;
    }

    public int width() {
        return 9;
    }

    public int height() {
        return 11;
    }

    // private methods

    private void draw0(net.perkowitz.gameframe.core.Frame frame) {

        frame.set(x+6, y,color);
        frame.set(x+7, y,color);

        frame.set(x+2, y-1,color);
        frame.set(x+3, y-1,color);
        frame.set(x+6, y-1,color);

        frame.set(x+3, y-2,color);
        frame.set(x+4, y-2,color);
        frame.set(x+5, y-2,color);
        frame.set(x+6, y-2,color);

        frame.set(x+3, y-3,color);
        frame.set(x+4, y-3,color);
        frame.set(x+5, y-3,color);
        frame.set(x+6, y-3,color);

        frame.set(x, y-4,color);
        frame.set(x+1, y-4,color);
        frame.set(x+3, y-4,color);
        frame.set(x+4, y-4,color);
        frame.set(x+5, y-4,color);
        frame.set(x+6, y-4,color);
        frame.set(x+8, y-4,color);

        frame.set(x+1, y-5,color);
        frame.set(x+2, y-5,color);
        frame.set(x+3, y-5,color);
        frame.set(x+4, y-5,color);
        frame.set(x+5, y-5,color);
        frame.set(x+6, y-5,color);
        frame.set(x+7, y-5,color);
        frame.set(x+8, y-5,color);

        frame.set(x+1, y-6,color);
        frame.set(x+4, y-6,color);
        frame.set(x+5, y-6,color);
        frame.set(x+8, y-6,color);

        frame.set(x, y-7,color);
        frame.set(x+1, y-7,color);
        frame.set(x+3, y-7,color);
        frame.set(x+4, y-7,color);
        frame.set(x+5, y-7,color);
        frame.set(x+6, y-7,color);

        frame.set(x+3, y-8,color);
        frame.set(x+4, y-8,color);
        frame.set(x+5, y-8,color);
        frame.set(x+6, y-8,color);

        frame.set(x+3, y-9,color);

        frame.set(x+3, y-10,color);

    }

}