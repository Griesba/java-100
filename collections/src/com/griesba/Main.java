package com.griesba;

public class Main {

    private static boolean add(){
        return false;
    }

    public static void main(String[] args) {

        boolean result = false;

        for (int i = 0; i <2; i++) {
            result |= add();
        }

        Theatre theatre = new Theatre("Olympian", 8, 12);
        theatre.getSeats();
        if (theatre.reverseSeat("H11")) {
            System.out.println("Please pay");
        } else {
            System.out.println("Sorry, seat is taken");
        }
    }
}
