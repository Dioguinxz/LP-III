package org.example;

public class CalcIMC {
    public double CalculteIMC(double weight, double height) {
        double result = weight / (height * height);
        System.out.println("IMC: " + result);
        return result;
    }

}
