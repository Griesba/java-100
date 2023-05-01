package com.griesba.java100.patterns.abtractfactory;


import com.griesba.java100.domain.entities.Automotive;
import com.griesba.java100.domain.entities.Scooter;

import java.util.Scanner;

public class Catalogue {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Type «1» for Electrical vehicle and «2» for Gasoline vehicle : ");
        int vehicleType = scanner.nextInt();

        VehicleFactory vehicleFactory;
        if (vehicleType == 1) {
            vehicleFactory = new ElectricalVehicleFactory();
        } else if (vehicleType == 2) {
            vehicleFactory = new GasolineVehicleFactory();
        } else {
            throw new RuntimeException("Unknown vehicle type : "+ vehicleType);
        }
        Scooter[] scooters = new Scooter[3];
        for (int i = 0; i < 3; i++) {
            scooters[i] = vehicleFactory.createScooter("red" +i, "honda"+i, 240);
        }

        Automotive[] automotives = new Automotive[2];
        for (int i = 0; i < 2; i++) {
            automotives[i] = vehicleFactory.createAutomotive("black"+i, "suv"+i, 400, 3.2);
        }

        for (Scooter scooter : scooters) {
            scooter.printDetails();
        }

        for (Automotive automotive : automotives) {
            automotive.printDetails();
        }
    }
}
