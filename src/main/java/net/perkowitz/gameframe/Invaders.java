package net.perkowitz.gameframe;

import com.google.common.collect.Lists;

import java.awt.*;
import java.io.File;
import java.util.List;

public class Invaders {

    public static void main(String[] args) {

        if (args.length < 5) {
            System.out.println("Usage: Invaders <image name> <invader type> <red> <green> <blue>");
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

        InvadeMover sample = new InvadeMover(type,color);
        int width = sample.width();
        int height = sample.height();

        List<Frame> frames = Lists.newArrayList();
        List<MoverInterface> movers = Lists.newArrayList();
        movers.add(new InvadeMover(type,color,GameFrame.XSIZE - width,height-1));
        movers.add(new InvadeMover(type,color,-1,height*2+1));

        int invaderGap = (GameFrame.XSIZE - width + 1) * (height + 1);
        int framesToGenerate = invaderGap;

        for (int frameIndex=0; frameIndex< framesToGenerate; frameIndex++) {
            if (frameIndex % invaderGap == 0) {
                movers.add(new InvadeMover(type,color,-1,-1));
            }
            Frame thisFrame = new Frame();
            for (MoverInterface mover : movers) {
                mover.step();
                mover.render(thisFrame);
            }
            frames.add(thisFrame);
        }

        Config config = new Config();
        config.setHoldTimeInMillis(100);

        Scene scene = new Scene(imageName,config,frames);
        scene.output();

    }
}
