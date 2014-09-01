package net.perkowitz.gameframe;


import com.google.common.collect.Lists;

import java.awt.*;
import java.io.File;
import java.util.List;

public class Scene {

    private String sceneName;
    private Config config;
    private List<Frame> frames;

    public Scene(String sceneName, Config config, List<Frame> frames) {
        this.sceneName = sceneName;
        this.config = config;
        this.frames = frames;
    }

    public void output() {

        File dir = new File(sceneName);
        if (!dir.exists()) {
            try{
                dir.mkdir();
            } catch(SecurityException e){
                System.err.println(e);
            }
        }

        config.output(sceneName + "/config.ini");

        for (int frameIndex=0; frameIndex<frames.size(); frameIndex++) {
            Frame frame = frames.get(frameIndex);
            frame.output(sceneName + "/" + frameIndex + ".bmp");
        }

    }

}
