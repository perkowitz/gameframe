package net.perkowitz.gameframe;

import com.google.common.collect.Lists;
import net.perkowitz.gameframe.mover.BoxMover;
import net.perkowitz.gameframe.mover.MoverInterface;
import net.perkowitz.gameframe.core.*;

import java.awt.*;
import java.io.File;
import java.util.List;

public class Boxes {

    public static void main(String[] args) {

        if (args.length < 1) {
            System.out.println("Usage: Boxes <image name>");
            return;
        }

        String imageName = args[0];
        Color color = Color.red;
        float fade = 0.5f;

        File dir = new File(imageName);
        if (!dir.exists()) {
            try{
                dir.mkdir();
            } catch(SecurityException e){
                System.err.println(e);
            }
        }

        List<MoverInterface> movers = Lists.newArrayList();
        for (int offset=0; offset<8; offset+=2) {
            movers.add(new BoxMover(offset,offset, GameFrame.XSIZE-offset-1,GameFrame.YSIZE-offset-1,color));
        }

        List<net.perkowitz.gameframe.core.Frame> frames = Lists.newArrayList();
        net.perkowitz.gameframe.core.Frame lastFrame = new net.perkowitz.gameframe.core.Frame();
        for (int frameIndex=0; frameIndex < 1200; frameIndex++) {
            net.perkowitz.gameframe.core.Frame thisFrame = net.perkowitz.gameframe.core.Frame.copyFrameAndFade(lastFrame, fade, fade, fade);
//            Frame frame = new Frame();

            for (MoverInterface mover : movers) {
                mover.step();
                mover.render(thisFrame);
            }
            frames.add(thisFrame);
            lastFrame = thisFrame;
        }

        Config config = new Config();
        config.setHoldTimeInMillis(100);

        Scene scene = new Scene(imageName,config,frames);
        scene.output();

    }

}
