package com.revature.cardex.repository;

import com.revature.cardex.Car;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CarRepository {
    //
    private List<Car> cars;
    private InputStream file; //now it will search through each file to find car.csv
    //1. create a constructor, which is just a method that has the same name of a class and returns nothing
    public CarRepository(String filename) {
    //constructors are for constructing the fields of an application
        this.cars = new ArrayList<>();
        this.file = getClass().getClassLoader().getResourceAsStream(filename);
     //add a load method to load private file method
        load();
    }

//auto generated load method
    private void load() {
        //add scanner to load files into project
        //make everything do its one job
        //constructor constructs, loader loads
        //make sure to surround scanner with try catch
        Scanner scanner = new Scanner(this.file);
        scanner.useDelimiter("\n");
        while (scanner.hasNext()) {
            //TODO: FIX ADDING TO LIST
            //this.cars.add(scanner.next());
        }
    }
        //generate a getter for cars


    public List<Car> getCars() { return cars;}
}
