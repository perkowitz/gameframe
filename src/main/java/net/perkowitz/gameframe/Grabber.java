package net.perkowitz.gameframe;

import com.google.common.collect.Lists;
import net.perkowitz.gameframe.core.Config;
import net.perkowitz.gameframe.core.Frame;
import net.perkowitz.gameframe.core.Scene;
import net.perkowitz.gameframe.mover.GrabberMover;
import net.perkowitz.gameframe.mover.MoverInterface;

import java.awt.*;
import java.io.File;
import java.util.List;

public class Grabber {

    public static void main(String[] args) {

        if (args.length < 5) {
            System.out.println("Usage: Grabber <image name> <type> <red> <green> <blue>");
            System.out.println("  Color weights between 0 and 1.");
            return;
        }

        String imageName = args[0];
        Integer type = new Integer(args[1]);
        Color color = new Color(new Float(args[2]), new Float(args[3]), new Float(args[4]));

        File dir = new File(imageName);
        if (!dir.exists()) {
            try{
                dir.mkdir();
            } catch(SecurityException e){
                System.err.println(e);
            }
        }

        float fade = 0.4f;

        List<MoverInterface> movers = Lists.newArrayList();
        movers.add(new GrabberMover(0,color,3,12));
        movers.add(new GrabberMover(0,color,9,10));
        movers.add(new GrabberMover(0,color,1,20));
        movers.add(new GrabberMover(0,color,-1,6));


        movers.add(new GrabberMover(0,color,3,12));
        movers.add(new GrabberMover(0,color,7,18));
        movers.add(new GrabberMover(0,color,-3,14));
        movers.add(new GrabberMover(0,color,5,4));

        List<Frame> frames = Lists.newArrayList();
        Frame lastFrame = new Frame();
        for (int i=0; i<2; i++) {
            for (MoverInterface mover : movers) {
                Frame thisFrame = Frame.copyFrameAndFade(lastFrame, fade, fade, fade);
                mover.render(thisFrame);

                if (i > 0) { // pre-run an iteration to get the fadeout set without printing the frames
                    frames.add(thisFrame);
                }

                lastFrame = thisFrame;
            }
        }

        Config config = new Config();
        config.setHoldTimeInMillis(250);

        Scene scene = new Scene(imageName,config,frames);
        scene.output();

    }

}
