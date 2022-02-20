package com.revature.cardex;


import com.revature.cardex.repository.CarRepository;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.apache.catalina.Context;
import org.apache.catalina.LifecycleException;
import org.apache.catalina.startup.Tomcat;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;

//making Java read the csv file
//work backwards build from ground up
// this process is called dependency injection, carServer depends on the
//the carService, the carService depends on the carRepository, and the
//carRepository depends on the data from the cars.csv file...

/** The 3 Things we will need
 * 1. Repository
 * 2. Service
 * 3. Server
 */


public class App {
    public static void main(String[] args) throws LifecycleException {
        /**
         * 0. We will need a file to work with cars.csv
         */
        /**
         * 1. a place where our data thats flowing will gather
         * and sync.
         */
        CarRepository carRepository = new CarRepository("cars.csv");
        /**2.a location where we do business logic,and gather
         *         content the last place to call everything thats needed to run
         */
        CarService carService = new CarService(carRepository);
        /**
         3.its only job is to serve http, generic reusable server
         */

        //this constructor is in charge of handling http
        //server should handle http
        //the last thing we need is the server
        //need a tomcat class
        //dont really need the carServer class since we can call on Tomcat
        Tomcat tomcat = new Tomcat();
        tomcat.setPort(8080);
        // Set context path and root folder
        String contextPath = "/";
        String docBase = new File(".").getAbsolutePath();
        Context context = tomcat.addContext(contextPath, docBase);
        // Declare, define, and map servlets
        HttpServlet helloServlet = new HttpServlet(){
            @Override
            protected void doGet(HttpServletRequest req, HttpServletResponse resp)
                    throws ServletException, IOException {
                PrintWriter out = resp.getWriter();
                out.write("<html><title>Example</title><body><h1>Hello, World!</h1></body></html>");
                out.close();
            }
        };
        String servletName = "HelloServlet";
        String urlPattern = "/hello";
        // Register servlets with Tomcat
        Tomcat.addServlet(context, servletName, helloServlet);
        ((Context) context).addServletMappingDecoded(urlPattern, servletName);
        // Start the server
        tomcat.start();
        tomcat.getServer().await();
    }
}


