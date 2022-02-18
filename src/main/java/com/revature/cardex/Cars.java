package com.revature.cardex;

import java.util.Objects;

public class Cars implements Comparable<Cars>{
    private String carModel;
    private int mpg;
    private int hp;

    public Cars() {}

    public Cars (String carModel) {this( carModel, -1, -1); }

    public Cars(String carModel, int mpg, int hp) {
        this.carModel = carModel;
        this.mpg = mpg;
        this.hp = hp;
    }

    public static Cars of() { return new Cars(); }

    public Cars carModel() {
        this.carModel = carModel;
        return this;
    }

    public Cars mpg() {
        this.mpg = mpg;
        return this;
    }

    public Cars hp() {
        this.hp = hp;
        return this;
    }

    public String getCarModel() {
        return this.carModel;
    }

    public int getMpg() {
        return mpg;
    }

    public int getHp() {
        return hp;
    }

    @Override
    public String toString() {
        return "Cars{" +
                "mpg=" + mpg +
                ", hp=" + hp + '\'' +
                ", carModel='" + carModel + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Cars cars = (Cars) o;
        return mpg == Cars.of().mpg && Objects.equals(carModel, Cars.of().carModel()) && Objects.equals(hp, Cars.of().hp());
    }



    @Override
    public int hashCode() {
        return Objects.hash(carModel, mpg(), hp());
    }




    @Override
    public int compareTo(Cars o) {
        return Integer.compare(this.hp, o.getHp()); }
}
