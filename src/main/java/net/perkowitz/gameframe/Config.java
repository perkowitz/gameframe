package net.perkowitz.gameframe;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class Config {

    private int holdTimeInMillis = 100;
    private boolean loop = true;
    private int translateX = 0;
    private int translateY = 0;
    private boolean translateLoop = false;
    private boolean panoff = false;
    private String nextFolder = null;

    public void output(String filename) {

        try {
            BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(filename));

            // animation section
            bufferedWriter.write("[animation]");
            bufferedWriter.newLine();
            bufferedWriter.write("hold=" + holdTimeInMillis);
            bufferedWriter.newLine();
            bufferedWriter.write("loop=" + loop);
            bufferedWriter.newLine();

            // translate section
            bufferedWriter.write("[translate]");
            bufferedWriter.newLine();
            bufferedWriter.write("moveX=" + translateX);
            bufferedWriter.newLine();
            bufferedWriter.write("moveY=" + translateY);
            bufferedWriter.newLine();
            bufferedWriter.write("loop=" + translateLoop);
            bufferedWriter.newLine();
            bufferedWriter.write("panoff=" + panoff);
            bufferedWriter.newLine();

            if (nextFolder != null) {
                bufferedWriter.write("nextFolder=" + nextFolder);
                bufferedWriter.newLine();
            }

            bufferedWriter.close();

        } catch(IOException e) {
            System.err.printf("%s\n", e);
        }

    }

    // getter/setter

    public void setHoldTimeInMillis(int holdTimeInMillis) {
        this.holdTimeInMillis = holdTimeInMillis;
    }

    public void setLoop(boolean loop) {
        this.loop = loop;
    }

    public void setTranslateX(int translateX) {
        this.translateX = translateX;
    }

    public void setTranslateY(int translateY) {
        this.translateY = translateY;
    }

    public void setTranslateLoop(boolean translateLoop) {
        this.translateLoop = translateLoop;
    }

    public void setPanoff(boolean panoff) {
        this.panoff = panoff;
    }

    public void setNextFolder(String nextFolder) {
        this.nextFolder = nextFolder;
    }
}
