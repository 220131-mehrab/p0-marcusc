package com.revature.cardex;


import com.revature.cardex.repository.CarRepository;

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
        CarServer carServer = new CarServer(carService);
    }
}

