package com.swiggy.tracks.config;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
/**
 * Created by raghvendra.mishra on 10/03/20.
 */
public class Launcher {

    private static final Logger logger = LogManager.getLogger(Launcher.class);

    public static void main(String[] args) {
        try {
            JettyServer server = new JettyServer();
            Thread thread = new Thread(server);
            thread.start();
        } catch (Exception e) {
            e.printStackTrace();
            logger.fatal("Error launching Application : ", e);
            System.exit(-1);
        }
    }
}
