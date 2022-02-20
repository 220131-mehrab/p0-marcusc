package com.revature.cardex;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Objects;

public class Car implements Comparable<Car> {
    @JsonProperty("id")
    private int carId;
    private String carModel;
    private int mpg;
    private int horsePower;

    public Car() {
    }
    public static Car of() {
        return new Car();
    }

    public Car id(int id) {
        this.carId = id;
        return this;
    }

    public Car carModel(String model) {
        this.carModel = model;
        return this;
    }

    public Car mpg(int milesPerGallon) {
        this.mpg = milesPerGallon;
        return this;
    }

    public Car horsePower(int hp) {
        this.horsePower = hp;
        return this;
    }

    public int getCarId() {
        return carId;
    }

    public String getCarModel() {
        return carModel;
    }

    public int getMpg() {
        return mpg;
    }

    public int getHorsePower() {
        return horsePower;
    }

    @Override
    public String toString() {
        return "Car{" +
                "id=" + carId +
                "mpg=" + mpg +
                ", hp=" + horsePower + '\'' +
                ", carModel='" + carModel + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Car car = (Car) o;
        return carId == car.carId && carModel.equals(car.carModel) && mpg == car.mpg;
    }


    @Override
    public int hashCode() {
        return Objects.hash(carId, carModel, horsePower, mpg);
    }


    @Override
    public int compareTo(Car o) {
        return Integer.compare(this.carId, o.getCarId());
    }
}
