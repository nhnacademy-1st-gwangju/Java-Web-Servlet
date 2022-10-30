package com.nhnacademy.board.listener;

import lombok.extern.slf4j.Slf4j;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Paths;

@Slf4j
@WebListener
public class WebAppListener implements ServletContextListener {

    @Override
    public void contextInitialized(ServletContextEvent sce) {
        ServletContext servletContext = sce.getServletContext();

        String counterFileName = servletContext.getInitParameter("counterFileName");
        String counterFilePath = "/WEB-INF/classes/" + counterFileName;

        int counter = 0;

        try (DataInputStream dis = new DataInputStream(servletContext.getResourceAsStream(counterFilePath))) {
            counter = dis.readInt();
        } catch (IOException e) {
            log.error("", e);
        }

        servletContext.setAttribute("counter", counter);
        servletContext.setAttribute("lang", "ko");
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        ServletContext servletContext = sce.getServletContext();

        String counterFileName = servletContext.getInitParameter("counterFileName");
        String counterFilePath = "/WEB-INF/classes/" + counterFileName;

        int counter = (int) servletContext.getAttribute("counter");

        try (OutputStream os = Files.newOutputStream(Paths.get(servletContext.getResource(counterFilePath).toURI()));
             DataOutputStream dos = new DataOutputStream(os);
        ) {
            dos.writeInt(counter);
        } catch (IOException | URISyntaxException e) {
            log.error("" + e);
        }
    }
}
