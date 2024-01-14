package org.fasttrackit.ex1;

public class TemperatureConversion {
    public static double fahrenheitToCelsius(double temperature) {
        double convertedToCelsius = (temperature - 32)*5/9;
        double scale = Math.pow(10, 9);
        return Math.round(convertedToCelsius * scale) / scale;
    }

    public static double celsiusToFahrenheit(double temperature) {
        double convertedToFahrenheit = temperature * 9/5 + 32;
        return convertedToFahrenheit;
    }
}