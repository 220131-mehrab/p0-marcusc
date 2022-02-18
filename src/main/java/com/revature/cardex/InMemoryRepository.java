package com.revature.cardex;

import com.intellij.dvcs.repo.Repository;
import java.util.ArrayList;
import java.util.List;


public class InMemoryRepository implements Repository {
    private List<Car> classicCars;

    public InMemoryRepository() {
        classicCars = new ArrayList<>();
        classicCars.add(Car.of().CarModel(2).Car_Model("Mazda RX4").MPG("21").hp("110"));
    }

    public List<Car> getClassicCars() {return classicCars;}

    public Car getCars(String carModel) {
        Car result = null;
        for (Car cars : this.classicCars) {
            if (cars.getCarModel().equals(carModel)) {
                result = cars;
            }

        }
        return result;
    }
}

