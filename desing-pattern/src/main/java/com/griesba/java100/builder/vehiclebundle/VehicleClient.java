package com.griesba.java100.builder.vehiclebundle;

import java.util.Scanner;

public class VehicleClient {
    public static void main(String[] args) {
        BundleVehicleBuilder vehicleBuilder;
        Scanner scanner = new Scanner(System.in);
        System.out.println("Do you want PDF (1) or HTML (2) bundle ?");
        int typeOfBundle = scanner.nextInt();
        switch (typeOfBundle) {
            case 1 : vehicleBuilder = new BundleVehiclePDFBuilder(); break;
            case 2 : vehicleBuilder = new BundleVehicleHTMLBuilder(); break;
            default: throw new IllegalArgumentException("Unknown bundle type");
        }
        Seller seller = new Seller(vehicleBuilder);
        Bundle bundle = seller.build("Indiana");
        bundle.print();
    }
}
