package task2;

import java.util.Scanner;

public class TemperatureConverter {
    public static void main(String[] args) {
        System.out.println("***************************************************");
        System.out.println("Temperature Converter");
        System.out.println("***************************************************");

        Scanner scanner = new Scanner(System.in);
        System.out.print("Please Choose the kind of temperature (Celsius OR Fahrenheit) : ");
        String temperatureKind = scanner.nextLine();

        if (!temperatureKind.equalsIgnoreCase("Celsius") && !temperatureKind.equalsIgnoreCase("Fahrenheit")) {
            System.out.println("Invalid entrance!");
            return;
        }
        System.out.print("Please Enter the Temperature : ");
        int temperature = scanner.nextInt();

        switch (temperatureKind) {
            case "Celsius" :
                toFahrenheit(temperature);
                break;
            case "Fahrenheit" :
                toCelsius(temperature);
                break;
        }
        scanner.close();
    }
    public static void toFahrenheit(int temperature){
        System.out.println(temperature + " degree Celsius is equal to " + (double)(temperature*9/5)+32 + " degree Fahrenheit");
    }
    public static void toCelsius(int temperature){
        System.out.println(temperature + " degree Fahrenheit is equal to " + (double)((temperature-32)*5/9) + " degree Celsius");
    }
}
