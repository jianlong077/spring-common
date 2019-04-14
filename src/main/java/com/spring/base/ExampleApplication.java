package com.spring.base;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.ComponentScan;
@SpringBootApplication
@ComponentScan(basePackages = {"com.spring.base.**"})
public class ExampleApplication extends SpringBootServletInitializer{
    public static void main(String[] args) {


        SpringApplication.run(ExampleApplication.class, args);
        //new SpringApplicationBuilder(OmsServiceApplication.class).web(true).run(args);
    }
	/*
	 * @Override protected SpringApplicationBuilder
	 * configure(SpringApplicationBuilder application) { return
	 * application.sources(ExampleApplication.class); }
	 */
}
