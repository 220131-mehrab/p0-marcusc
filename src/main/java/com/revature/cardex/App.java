package com.revature.cardex;


import com.revature.cardex.repository.CarRepository;
import org.apache.catalina.LifecycleException;
import org.apache.catalina.startup.Tomcat;

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
    public static void main(String[] args) {
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
        Tomcat server = new Tomcat();

            server = new Tomcat();
            //this will load in Tomcats http stuff
            server.getConnector();
            //leaving blank for now
            server.addContext("", null);
            //finally add Servlet contextPath and name it and then pass in carService and
            //and finally .addMapping because it needs a URL.
            server.addServlet("", "carServlet", carService).addMapping("/");
            // also add this.server.start and surround in try catch method
            try {
                server.start();
            } catch (LifecycleException e) {
                e.printStackTrace();
            }
            //now I dont need the carServer class anymore so I deleted it.
        }
    }


