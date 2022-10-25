package com.nhnacademy.servlet;

import lombok.extern.slf4j.Slf4j;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;

@Slf4j
public class FileDownloadServlet extends HttpServlet {

    private static final String UPLOAD_DIR = "/Users/hakhyeonsong/Downloads/test";

    // Content-type: application/octet-stream

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String fileName = req.getParameter("file");
        resp.setContentType("application/octet-stream");
        resp.setHeader("Content-Disposition", "attachment; filename=" + fileName);
        try (BufferedReader br = new BufferedReader(new FileReader(UPLOAD_DIR+"\\"+fileName))) {
            PrintWriter os = new PrintWriter(resp.getOutputStream());

            String line = "";
            while ((line = br.readLine()) != null) {
                os.println(line);
            }
        } catch (IOException e) {
            log.error("" + e);
        }
    }
}
