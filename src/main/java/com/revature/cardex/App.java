package com.revature.cardex;


import com.revature.cardex.repository.CarRepository;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.apache.catalina.Context;
import org.apache.catalina.LifecycleException;
import org.apache.catalina.servlets.DefaultServlet;
import org.apache.catalina.startup.Tomcat;
import org.eclipse.jetty.server.Connector;
import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.server.ServerConnector;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;

//making Java read the csv file
//work backwards build from ground up
// this process is called dependency injection, carServer depends on the
//the carService, the carService depends on the carRepository, and the
//carRepository depends on the data from the cars.csv file...

/**
 * The 3 Things we will need
 * 1. Repository
 * 2. Service
 * 3. Server
 */


public class App {
    public static void main(String[] args) throws LifecycleException {
        String webAppName = "carDex";
        CarRepository carRepository;
        carRepository = new SQLCarRepository();
        CarServer server = new CarServer();
        try {
            server.start();
            System.out.println("Server Started");
        } catch (Exception e) {
            System.out.println(e);
        }

    }
}


