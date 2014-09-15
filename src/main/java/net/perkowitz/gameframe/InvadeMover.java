package net.perkowitz.gameframe;


import java.awt.*;

public class InvadeMover implements MoverInterface {

    private int type;
    private int currentX = -1;
    private int currentY = -1;
    private int deltaX = 1;
    private Color color = Color.white;
    private boolean done = false;

    public InvadeMover(int type, Color color) {
        this.type = type;
        this.color = color;
    }

    public InvadeMover(int type, Color color, int startX, int startY) {
        this.type = type;
        this.color = color;
        currentX = startX;
        currentY = startY;
    }

    public void reset(int x, int y, Color color) {
        currentX = x;
        currentY = y;
        this.color = color;
    }

    public void step() {

        if (deltaX == -1 && currentX == 0) {
            deltaX = 1;
            currentY++;
        } else if (deltaX == 1 && currentX == GameFrame.XSIZE - width()) {
            deltaX = -1;
            currentY++;
        } else {
            currentX += deltaX;
        }

        if (currentY == GameFrame.YSIZE + height()) {
            done = true;
        }

    }

    public void render(Frame frame) {
        if (!done) {
            switch (type) {
                case 0:
                    draw0(frame);
                    return;
                case 1:
                    draw1(frame);
                    return;
                case 2:
                    draw2(frame);
                    return;
                case 3:
                    draw3(frame);
                    return;
            }
        }
    }

    public boolean isDone() {
        return done;
    }

    public int height() {
        return 8;
    }

    public int width() {
        switch (type) {
            case 0: return 11;
            case 1: return 8;
            case 2: return 12;
            case 3: return 16;
            default: return 11;
        }
    }

    // private methods

    private void draw0(Frame frame) {

        frame.set(currentX+3,currentY,color);
        frame.set(currentX+4,currentY,color);
        frame.set(currentX+6,currentY,color);
        frame.set(currentX+7,currentY,color);

        frame.set(currentX,currentY-1,color);
        frame.set(currentX+2,currentY-1,color);
        frame.set(currentX+8,currentY-1,color);
        frame.set(currentX+10,currentY-1,color);

        frame.set(currentX,currentY-2,color);
        frame.set(currentX+2,currentY-2,color);
        frame.set(currentX+3,currentY-2,color);
        frame.set(currentX+4,currentY-2,color);
        frame.set(currentX+5,currentY-2,color);
        frame.set(currentX+6,currentY-2,color);
        frame.set(currentX+7,currentY-2,color);
        frame.set(currentX+8,currentY-2,color);
        frame.set(currentX+10,currentY-2,color);

        frame.set(currentX,currentY-3,color);
        frame.set(currentX+1,currentY-3,color);
        frame.set(currentX+2,currentY-3,color);
        frame.set(currentX+3,currentY-3,color);
        frame.set(currentX+4,currentY-3,color);
        frame.set(currentX+5,currentY-3,color);
        frame.set(currentX+6,currentY-3,color);
        frame.set(currentX+7,currentY-3,color);
        frame.set(currentX+8,currentY-3,color);
        frame.set(currentX+9,currentY-3,color);
        frame.set(currentX+10,currentY-3,color);

        frame.set(currentX+1,currentY-4,color);
        frame.set(currentX+2,currentY-4,color);
        frame.set(currentX+4,currentY-4,color);
        frame.set(currentX+5,currentY-4,color);
        frame.set(currentX+6,currentY-4,color);
        frame.set(currentX+8,currentY-4,color);
        frame.set(currentX+9,currentY-4,color);

        frame.set(currentX+2,currentY-5,color);
        frame.set(currentX+3,currentY-5,color);
        frame.set(currentX+4,currentY-5,color);
        frame.set(currentX+5,currentY-5,color);
        frame.set(currentX+6,currentY-5,color);
        frame.set(currentX+7,currentY-5,color);
        frame.set(currentX+8,currentY-5,color);

        frame.set(currentX+3,currentY-6,color);
        frame.set(currentX+7,currentY-6,color);

        frame.set(currentX+2,currentY-7,color);
        frame.set(currentX+8,currentY-7,color);

    }

    private void draw1(Frame frame) {

        frame.set(currentX+1,currentY,color);
        frame.set(currentX+6,currentY,color);

        frame.set(currentX+0,currentY-1,color);
        frame.set(currentX+7,currentY-1,color);

        frame.set(currentX+1,currentY-2,color);
        frame.set(currentX+3,currentY-2,color);
        frame.set(currentX+4,currentY-2,color);
        frame.set(currentX+6,currentY-2,color);

        frame.set(currentX+0,currentY-3,color);
        frame.set(currentX+1,currentY-3,color);
        frame.set(currentX+2,currentY-3,color);
        frame.set(currentX+3,currentY-3,color);
        frame.set(currentX+4,currentY-3,color);
        frame.set(currentX+5,currentY-3,color);
        frame.set(currentX+6,currentY-3,color);
        frame.set(currentX+7,currentY-3,color);

        frame.set(currentX+0,currentY-4,color);
        frame.set(currentX+1,currentY-4,color);
        frame.set(currentX+3,currentY-4,color);
        frame.set(currentX+4,currentY-4,color);
        frame.set(currentX+6,currentY-4,color);
        frame.set(currentX+7,currentY-4,color);

        frame.set(currentX+1,currentY-5,color);
        frame.set(currentX+2,currentY-5,color);
        frame.set(currentX+3,currentY-5,color);
        frame.set(currentX+4,currentY-5,color);
        frame.set(currentX+5,currentY-5,color);
        frame.set(currentX+6,currentY-5,color);

        frame.set(currentX+2,currentY-6,color);
        frame.set(currentX+3,currentY-6,color);
        frame.set(currentX+4,currentY-6,color);
        frame.set(currentX+5,currentY-6,color);

        frame.set(currentX+3,currentY-7,color);
        frame.set(currentX+4,currentY-7,color);

    }

    private void draw2(Frame frame) {

        frame.set(currentX,currentY,color);
        frame.set(currentX+1,currentY,color);
        frame.set(currentX+10,currentY,color);
        frame.set(currentX+11,currentY,color);

        frame.set(currentX+2,currentY-1,color);
        frame.set(currentX+3,currentY-1,color);
        frame.set(currentX+5,currentY-1,color);
        frame.set(currentX+6,currentY-1,color);
        frame.set(currentX+8,currentY-1,color);
        frame.set(currentX+9,currentY-1,color);

        frame.set(currentX+3,currentY-2,color);
        frame.set(currentX+4,currentY-2,color);
        frame.set(currentX+7,currentY-2,color);
        frame.set(currentX+8,currentY-2,color);

        frame.set(currentX,currentY-3,color);
        frame.set(currentX+1,currentY-3,color);
        frame.set(currentX+2,currentY-3,color);
        frame.set(currentX+3,currentY-3,color);
        frame.set(currentX+4,currentY-3,color);
        frame.set(currentX+5,currentY-3,color);
        frame.set(currentX+6,currentY-3,color);
        frame.set(currentX+7,currentY-3,color);
        frame.set(currentX+8,currentY-3,color);
        frame.set(currentX+9,currentY-3,color);
        frame.set(currentX+10,currentY-3,color);
        frame.set(currentX+11,currentY-3,color);

        frame.set(currentX,currentY-4,color);
        frame.set(currentX+1,currentY-4,color);
        frame.set(currentX+2,currentY-4,color);
        frame.set(currentX+5,currentY-4,color);
        frame.set(currentX+6,currentY-4,color);
        frame.set(currentX+9,currentY-4,color);
        frame.set(currentX+10,currentY-4,color);
        frame.set(currentX+11,currentY-4,color);

        frame.set(currentX,currentY-5,color);
        frame.set(currentX+1,currentY-5,color);
        frame.set(currentX+2,currentY-5,color);
        frame.set(currentX+3,currentY-5,color);
        frame.set(currentX+4,currentY-5,color);
        frame.set(currentX+5,currentY-5,color);
        frame.set(currentX+6,currentY-5,color);
        frame.set(currentX+7,currentY-5,color);
        frame.set(currentX+8,currentY-5,color);
        frame.set(currentX+9,currentY-5,color);
        frame.set(currentX+10,currentY-5,color);
        frame.set(currentX+11,currentY-5,color);

        frame.set(currentX+1,currentY-6,color);
        frame.set(currentX+2,currentY-6,color);
        frame.set(currentX+3,currentY-6,color);
        frame.set(currentX+4,currentY-6,color);
        frame.set(currentX+5,currentY-6,color);
        frame.set(currentX+6,currentY-6,color);
        frame.set(currentX+7,currentY-6,color);
        frame.set(currentX+8,currentY-6,color);
        frame.set(currentX+9,currentY-6,color);
        frame.set(currentX+10,currentY-6,color);

        frame.set(currentX+4,currentY-7,color);
        frame.set(currentX+5,currentY-7,color);
        frame.set(currentX+6,currentY-7,color);
        frame.set(currentX+7,currentY-7,color);

    }

    private void draw3(Frame frame) {

        frame.set(currentX+3,currentY,color);
        frame.set(currentX+12,currentY,color);

        frame.set(currentX+2,currentY-1,color);
        frame.set(currentX+3,currentY-1,color);
        frame.set(currentX+4,currentY-1,color);
        frame.set(currentX+7,currentY-1,color);
        frame.set(currentX+8,currentY-1,color);
        frame.set(currentX+11,currentY-1,color);
        frame.set(currentX+12,currentY-1,color);
        frame.set(currentX+13,currentY-1,color);

        frame.set(currentX,currentY-2,color);
        frame.set(currentX+1,currentY-2,color);
        frame.set(currentX+2,currentY-2,color);
        frame.set(currentX+3,currentY-2,color);
        frame.set(currentX+4,currentY-2,color);
        frame.set(currentX+5,currentY-2,color);
        frame.set(currentX+6,currentY-2,color);
        frame.set(currentX+7,currentY-2,color);
        frame.set(currentX+8,currentY-2,color);
        frame.set(currentX+9,currentY-2,color);
        frame.set(currentX+10,currentY-2,color);
        frame.set(currentX+11,currentY-2,color);
        frame.set(currentX+12,currentY-2,color);
        frame.set(currentX+13,currentY-2,color);
        frame.set(currentX+14,currentY-2,color);
        frame.set(currentX+15,currentY-2,color);

        frame.set(currentX+1,currentY-3,color);
        frame.set(currentX+2,currentY-3,color);
        frame.set(currentX+4,currentY-3,color);
        frame.set(currentX+5,currentY-3,color);
        frame.set(currentX+7,currentY-3,color);
        frame.set(currentX+8,currentY-3,color);
        frame.set(currentX+10,currentY-3,color);
        frame.set(currentX+11,currentY-3,color);
        frame.set(currentX+13,currentY-3,color);
        frame.set(currentX+14,currentY-3,color);

        frame.set(currentX+2,currentY-4,color);
        frame.set(currentX+3,currentY-4,color);
        frame.set(currentX+4,currentY-4,color);
        frame.set(currentX+5,currentY-4,color);
        frame.set(currentX+6,currentY-4,color);
        frame.set(currentX+7,currentY-4,color);
        frame.set(currentX+8,currentY-4,color);
        frame.set(currentX+9,currentY-4,color);
        frame.set(currentX+10,currentY-4,color);
        frame.set(currentX+11,currentY-4,color);
        frame.set(currentX+12,currentY-4,color);
        frame.set(currentX+13,currentY-4,color);

        frame.set(currentX+3,currentY-5,color);
        frame.set(currentX+4,currentY-5,color);
        frame.set(currentX+5,currentY-5,color);
        frame.set(currentX+6,currentY-5,color);
        frame.set(currentX+7,currentY-5,color);
        frame.set(currentX+8,currentY-5,color);
        frame.set(currentX+9,currentY-5,color);
        frame.set(currentX+10,currentY-5,color);
        frame.set(currentX+11,currentY-5,color);
        frame.set(currentX+12,currentY-5,color);

        frame.set(currentX+5,currentY-6,color);
        frame.set(currentX+6,currentY-6,color);
        frame.set(currentX+7,currentY-6,color);
        frame.set(currentX+8,currentY-6,color);
        frame.set(currentX+9,currentY-6,color);
        frame.set(currentX+10,currentY-6,color);

    }

}