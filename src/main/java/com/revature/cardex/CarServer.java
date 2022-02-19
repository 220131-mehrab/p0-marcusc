package com.revature.cardex;

import org.apache.catalina.LifecycleException;
import org.apache.catalina.startup.Tomcat;

public class CarServer {
    //this constructor is in charge of handling http
    //server should handle http
    //the last thing we need is the server
    //need a tomcat class
    private Tomcat server;

    public CarServer(CarService carService) {
        this.server = new Tomcat();
        //this will load in Tomcats http stuff
        this.server.getConnector();
        //leaving blank for now
        this.server.addContext("", null);
        //finally add Servlet contextPath and name it and then pass in carService and
        //and finally .addMapping because it needs a URL.
        this.server.addServlet("", "carServlet", carService).addMapping("/");
        // also add this.server.start and surround in try catch method
        try {
            this.server.start();
        } catch (LifecycleException e) {
            e.printStackTrace();
        }
        /**
         * 1. it threw a FileNotFoundException but it kept
         * going because it handled the exception, now I
         * can go to localhost8080 and I will get a
         * blank page. they could not find my file
         */
        /**
         * 2. I have to go to Repository and tell it exactly where the
         * file will be:this.file = new File("src/main/resources/"+filename);
         * not ideal if I compile my jar it will break
         * it will say the jar doesnt have this folder anymore
         * this folder only exists when Im using gradle in my project
         */
        /**
         * 3. a better method would to pass this.file = getClass().getClassLoader().getResourceAsStream(filename);
         * also switch from app config to gradle run config
         * in the carRepository so it can search for the file and load it into the html
         *
         *
         *
         */

    }
}
