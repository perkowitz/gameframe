package net.perkowitz.gameframe;

import com.google.common.collect.Lists;

import java.awt.*;
import java.io.File;
import java.util.List;

public class Falling {

    private static float redFade = 0.8f;
    private static float greenFade = 0.8f;
    private static float blueFade = 0.8f;

    public static void main(String[] args) {

        if (args.length < 5) {
            System.out.println("Usage: Falling <image name> <frames> <red> <green> <blue>");
            return;
        }

        String imageName = args[0];
        Integer framesToGenerate = new Integer(args[1]);
        Float redWeight = new Float(args[2]);
        Float greenWeight = new Float(args[3]);
        Float blueWeight = new Float(args[4]);

        File dir = new File(imageName);
        if (!dir.exists()) {
            try{
                dir.mkdir();
            } catch(SecurityException e){
                System.err.println(e);
            }
        }

        List<Frame> frames = Lists.newArrayList();
        List<MoverInterface> movers = Lists.newArrayList();

        Frame lastFrame = new Frame();
        for (int frameIndex=0; frameIndex< framesToGenerate; frameIndex++) {
            Frame thisFrame = Frame.copyFrameAndFade(lastFrame, redFade, greenFade, blueFade);

            if (frameIndex < framesToGenerate -2*GameFrame.YSIZE) {  // stop adding and leave time for a fadeout
                int zipX = (int)Math.floor(Math.random()*GameFrame.XSIZE);
                Color color = new Color((float)Math.random()*redWeight,(float)Math.random()*greenWeight,(float)Math.random()*blueWeight);
                movers.add(new StraightMover(zipX, -1, color, StraightMover.DIRECTION_SOUTH, false));
            }

            List<MoverInterface> activeMovers = Lists.newArrayList();
            for (MoverInterface mover : movers) {
                mover.step();
                mover.render(thisFrame);
                if (!mover.isDone()) {
                    activeMovers.add(mover);
                }
            }
            movers = activeMovers;
//            thisFrame.output(imageName + "/" + frameIndex + ".bmp");
            frames.add(thisFrame);
            lastFrame = thisFrame;
        }

        Config config = new Config();
        config.setHoldTimeInMillis(5);

        Scene scene = new Scene(imageName,config,frames);
        scene.output();

    }
}
