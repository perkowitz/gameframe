package net.perkowitz.gameframe;

import com.google.common.collect.Lists;

import java.awt.*;
import java.io.File;
import java.util.List;

public class Binary {

    public static void main(String[] args) {

        if (args.length < 1) {
            System.out.println("Usage: Binary <image name>");
            return;
        }

        String imageName = args[0];
        Color color = Color.red;
        Color color2 = new Color(0.2f,0f,0f);

        File dir = new File(imageName);
        if (!dir.exists()) {
            try{
                dir.mkdir();
            } catch(SecurityException e){
                System.err.println(e);
            }
        }

        int bitSize = 4;
        int dimX = GameFrame.XSIZE / bitSize;
        int dimY = GameFrame.YSIZE / bitSize;
        BinaryCounter2D counter = new BinaryCounter2D(dimX,dimY);
        List<Frame> frames = Lists.newArrayList();
        for (int c=0; c<Math.min(Math.pow(2,dimX*dimY),256); c++) {

            Frame frame = new Frame();

            boolean[][] bits = counter.encode(c);
            for (int y=0; y<dimY; y++) {
                for (int x=0; x<dimX; x++) {
                    if (bits[x][y]) {
                        frame.filledBox(x*bitSize+1,y*bitSize+1,(x+1)*bitSize-2,(y+1)*bitSize-2,color2);
                        frame.box(x*bitSize+1,y*bitSize+1,(x+1)*bitSize-2,(y+1)*bitSize-2,color);
                    } else {
                        frame.filledBox(x*bitSize+1,y*bitSize+1,(x+1)*bitSize-2,(y+1)*bitSize-2,color2);
                    }
                }
            }

            frames.add(frame);
        }

        Config config = new Config();
        config.setHoldTimeInMillis(1000);

        Scene scene = new Scene(imageName,config,frames);
        scene.output();

    }

}
