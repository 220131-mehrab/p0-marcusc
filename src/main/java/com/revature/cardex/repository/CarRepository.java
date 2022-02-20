package com.revature.cardex.repository;

import com.revature.cardex.Car;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public interface CarRepository {
    Car getCar(String name);
    List<Car> getCars();

}