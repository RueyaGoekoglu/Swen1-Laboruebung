package de.htwg;

public class Bmi {

    public static double calc(double weight, double height) {
        if (weight < 0) {
            throw new IllegalArgumentException("Weight can´t be negative");
        }
        if (height < 0) {
            throw new IllegalArgumentException("height can´t be negative");
        }
        return weight / (height * height);
    }

}
