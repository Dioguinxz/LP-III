package org.example;

public class CurrencyConverter {

    private double rateDolartoReal = 5;
    private double rateDolarToEuro = 0.85;
    private double rateDolarToLibra = 0.73;

    public double convertDolarToReal(double value) {
        double result = value * rateDolartoReal;
        System.out.println("The value $" + value + " is " + result + " Reais");
        return result;
    }

    public double convertDolarToEuro(double value) {
        double result = value * rateDolarToEuro;
        System.out.println("The value $" + value + " is " + result + " EUR");
        return result;
    }

    public double convertDolarToLibra(double value) {
        double result = value * rateDolarToLibra;
        System.out.println("The value $" + value + " is " + result + " GBP");
        return result;
    }

}