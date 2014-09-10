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
            System.out.println("  Color weights between 0 and 1.");
            System.out.println("  For rainbow, set all color weights to 0.");
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

        List<Color> colorKeys = Lists.newArrayList();
        colorKeys.add(Color.red);
        colorKeys.add(Color.orange);
        colorKeys.add(Color.yellow);
        colorKeys.add(Color.green);
        colorKeys.add(Color.blue);
        colorKeys.add(Color.magenta);
        colorKeys.add(Color.red);
        List<Color> colors = GameFrame.colorKeyFrame(colorKeys,25);

        List<Frame> frames = Lists.newArrayList();
        List<MoverInterface> movers = Lists.newArrayList();

        int currentColorIndex = 0;

        Frame lastFrame = new Frame();
        for (int frameIndex=0; frameIndex< framesToGenerate; frameIndex++) {
            Frame thisFrame = Frame.copyFrameAndFade(lastFrame, redFade, greenFade, blueFade);

            if (frameIndex < framesToGenerate -2*GameFrame.YSIZE) {  // stop adding and leave time for a fadeout
                int x = (int)Math.floor(Math.random()*GameFrame.XSIZE);

                Color color = colors.get(currentColorIndex);
                currentColorIndex = (currentColorIndex+1) % colors.size();
                if (redWeight > 0 || greenWeight > 0 || blueWeight > 0) {
                    color = new Color((float)Math.random()*redWeight,(float)Math.random()*greenWeight,(float)Math.random()*blueWeight);
                }
                movers.add(new StraightMover(x, -1, color, StraightMover.DIRECTION_SOUTH, false));
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
