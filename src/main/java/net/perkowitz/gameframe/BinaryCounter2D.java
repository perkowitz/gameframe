package net.perkowitz.gameframe;

public class BinaryCounter2D {

    private int width = 1;
    private int height = 1;

    public BinaryCounter2D(int width, int height) {
        this.width = width;
        this.height = height;
    }

    public boolean[][] encode(int number) {

        boolean[][] bits = new boolean[width][height];

        int bit = 0;
        for (int y=0; y<height; y++) {
            for (int x=0; x<width; x++) {
                boolean isSet = ((number>>bit) & 1) > 0;
                bits[x][y] = isSet;
//                System.out.printf("%d, (%d,%d), %d, %s\n",number,y,x,bit,isSet);
                bit++;
            }
        }

        return bits;
    }

}
