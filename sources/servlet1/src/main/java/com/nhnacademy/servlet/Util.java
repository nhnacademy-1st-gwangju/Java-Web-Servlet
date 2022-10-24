package com.nhnacademy.servlet;

import javax.servlet.ServletContext;
import java.util.Optional;

public class Util {

    public static void test(ServletContext servletContext) {
        Integer counter = Optional.ofNullable((Integer) servletContext.getAttribute("counter"))
                        .orElse(0);
        servletContext.setAttribute("counter", ++counter);
    }
}
