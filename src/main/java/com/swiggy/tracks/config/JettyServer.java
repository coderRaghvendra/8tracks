package com.swiggy.tracks.config;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.eclipse.jetty.server.*;
import org.eclipse.jetty.server.handler.HandlerList;
import org.eclipse.jetty.servlet.ServletContextHandler;
import org.eclipse.jetty.servlet.ServletHolder;
import org.glassfish.jersey.servlet.ServletContainer;

/**
 * Created by raghvendra.mishra on 10/03/20.
 */
public class JettyServer implements Runnable {

    private static final Logger logger = LogManager.getLogger(JettyServer.class);

    @Override
    public void run() {
        try {
            Server server = new Server();
            try {
                ServletContainer container = new ServletContainer(new JerseyResourceConfig());
                ServletHolder sh = new ServletHolder(container);
                ServletContextHandler context = new ServletContextHandler(ServletContextHandler.NO_SESSIONS
                        | ServletContextHandler.NO_SECURITY);
                context.setContextPath("/");
                context.addServlet(sh, "/*");
                HandlerList handlers = new HandlerList();
                handlers.setHandlers(new Handler[] { context });
                ServerConnector httpConnector = new ServerConnector(server, new HttpConnectionFactory(new HttpConfiguration()));
                httpConnector.setPort(8080);
                httpConnector.setIdleTimeout(30000);
                Connector[] connectors = new Connector[] { httpConnector };
                server.setConnectors(connectors);
                server.setHandler(handlers);
                server.start();
                logger.info("8tracks server started on 8080");
                server.join();
            } catch (Exception e) {
                e.printStackTrace();
            }
        } catch (Exception e) {
            logger.error("Error occurred in server thread.", e);
        }
    }
}
