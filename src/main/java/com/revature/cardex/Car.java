package com.revature.cardex;

import java.util.Objects;

public class Car implements Comparable<Car>{
    private String carModel;
    private int mpg;
    private int horsePower;

    public Car() {}

    public Car(String carModel) {this( carModel, -1, -1); }

    public Car(String carModel, int mpg, int hp) {
        this.carModel = carModel;
        this.mpg = mpg;
        this.horsePower = hp;
    }

    public static Car of() { return new Car(); }

    public Car carModel() {
        this.carModel = carModel;
        return this;
    }

    public Car mpg() {
        this.mpg = mpg;
        return this;
    }

    public Car hp() {
        this.horsePower = horsePower;
        return this;
    }

    public String getCarModel() {
        return this.carModel;
    }

    public int getMpg() {
        return mpg;
    }

    public int getHorsePower() {
        return horsePower;
    }

    @Override
    public String toString() {
        return "Cars{" +
                "mpg=" + mpg +
                ", hp=" + horsePower + '\'' +
                ", carModel='" + carModel + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Car cars = (Car) o;
        return mpg == Car.of().mpg && Objects.equals(carModel, Car.of().carModel()) && Objects.equals(horsePower, Car.of().hp());
    }



    @Override
    public int hashCode() {
        return Objects.hash(carModel, mpg(), hp());
    }




    @Override
    public int compareTo(Car o) {
        return Integer.compare(this.horsePower, o.getHorsePower()); }
}
