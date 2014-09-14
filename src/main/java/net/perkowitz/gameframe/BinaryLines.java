package net.perkowitz.gameframe;

import com.google.common.collect.Lists;

import java.awt.*;
import java.io.File;
import java.util.List;

public class BinaryLines {

    public static void main(String[] args) {

        if (args.length < 1) {
            System.out.println("Usage: BinaryLines <image name>");
            return;
        }

        String imageName = args[0];
        Color color = Color.red;

        File dir = new File(imageName);
        if (!dir.exists()) {
            try{
                dir.mkdir();
            } catch(SecurityException e){
                System.err.println(e);
            }
        }

        int dimX = 6;
        int dimY = 2;
        int bitHeight = 16 / dimY;
        BinaryCounter2D counter = new BinaryCounter2D(dimX,dimY);
        List<Frame> frames = Lists.newArrayList();
        for (int c=0; c<4096; c++) {

            Frame frame = new Frame();

            boolean[][] bits = counter.encode(c);
            for (int y=0; y<dimY; y++) {
                for (int x=0; x<dimX; x++) {
                    if (bits[x][y]) {
                        frame.filledBox((dimX-x-1)*3,(dimY-y-1)*bitHeight,(dimX-x-1)*3,(dimY-y)*bitHeight-2,color);
                    } else {
                    }
                }
            }

            frames.add(frame);
        }

        Config config = new Config();
        config.setHoldTimeInMillis(250);

        Scene scene = new Scene(imageName,config,frames);
        scene.output();

    }

}
