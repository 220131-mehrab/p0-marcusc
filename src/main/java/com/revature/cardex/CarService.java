package com.revature.cardex;

import com.revature.cardex.repository.CarRepository;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;


//don't forget to add CarService constructor
//this is supposed to be in charge of displaying the list
//service should handle html
//go to maven central and get an industry standard
//server copy and paste into build.gradle
//I chose glassfish server
//making a framework so my program will be called by
//glassfish server by extending
//glassfish didnt work so Ill try Jetty
//Jetty didnt work so Ill just use Tomcat for now
// had the extends HttpServlet in the wrong place





public class CarService extends HttpServlet {
    //made private because we don't want anything accessing it directly
    private CarRepository CarRepository;

    public CarService(CarRepository dexRepository) {
        this.CarRepository = dexRepository;
    }

    public String searchForm() {
        String HTMLForm = "<Html>\n" +
                "<Head>\n" +
                "    <Title>Search Cars" +
                "</Title>\n" +
                "</Head>\n" +
                "<Body>\n" +
                "    <h1>Cardex Search</h1>\n" +
                "    <form action='cars' method='get'>\n" +
                "        <input type='name' name='searchName'/>\n" +
                "        <input type='submit' value='Search'/>\n" +
                "    " +
                "    <a href='Cars'>See Full Cardex</a>\n" +
                "</form>\n" +
                "</Body>\n" +
                "</Html>";
        return HTMLForm;
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doGet(req, resp);
        for (String cars : CarRepository.getCars()) {
            resp.getWriter().println(cars);
        }
    }
}

/**
 * the carRepository has now been brought in,
 * for String cars in the carRepository loop through the
 * entire array list and for each ln we are going to see a response.getWriter
 * that already has been created by the Servlet and then .println(cars)
 * to print out the String of cars. This will handle the Http stuff!
 * For now this is all we need,
 * 1. We have a service thats going to extend the Servlet
 * 2. then the Servlet will be fed into the Server we're about to build
 * This is a section that the tomcat server is about to run
 * instead of me calling tomcat to tell it to run
 * Im going to create this class and then give it to tomcat and say
 * here use this framework.
 */