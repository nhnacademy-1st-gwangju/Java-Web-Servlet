package com.nhnacademy.board.initializer;

import com.nhnacademy.board.domain.ConcreteUser;
import com.nhnacademy.board.domain.PostRepository;
import com.nhnacademy.board.domain.UserRepository;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import javax.servlet.ServletContainerInitializer;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.HandlesTypes;
import java.util.Set;

@HandlesTypes({
        javax.servlet.http.HttpServlet.class,
        javax.servlet.Filter.class,
        javax.servlet.ServletContextListener.class,
        javax.servlet.http.HttpSessionListener.class
})
public class WebAppInitializer implements ServletContainerInitializer {

    @Override
    public void onStartup(Set<Class<?>> set, ServletContext servletContext) throws ServletException {
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext("com.nhnacademy.board.config");

        ConcreteUser adminUser = new ConcreteUser();
        adminUser.setId("admin");
        adminUser.setPassword("12345");
        adminUser.setName("관리자");

        UserRepository userRepository = applicationContext.getBean(UserRepository.class);
        userRepository.add(adminUser);

        PostRepository postRepository = applicationContext.getBean(PostRepository.class);

        servletContext.setAttribute("userRepository", userRepository);
        servletContext.setAttribute("postRepository", postRepository);

        servletContext.setInitParameter("counterFileName", "counter.dat");
    }
}
