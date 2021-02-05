package com.griesba;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Theatre {
    private final String theatreName;
    private List<Seat> seats = new ArrayList<>();

    public Theatre(String theatreName, int numRows, int seatsPerRow) {
        this.theatreName = theatreName;
        this.seats = seats;
        int lastRow = 'A' + (numRows - 1);
        for (char row = 'A'; row <= lastRow ; row++) {
            for (int seatNum = 1; seatNum <= seatsPerRow ; seatNum++) {
                Seat seat = new Seat(row + String.format("%02d", seatNum));
                seats.add(seat);
            }
        }
    }

    public boolean reverseSeat(String seatNumber) {
        Seat requestSeat = new Seat(seatNumber);
        int foundSeat = Collections.binarySearch(seats, requestSeat, null);
        if (foundSeat >= 0) {
            return seats.get(foundSeat).reserve();
        } else {
            System.out.println("Theatre is no seat "+ seatNumber);
            return false;
        }
/*        for (Seat seat: seats) {
            System.out.println(".");
            if(seat.getSeatNumber().equals(seatNumber)) {
                requestSeat = seat;
                break;
            }
        }

        if (requestSeat == null) {
            System.out.println("There is not seat" + seatNumber);
            return false;
        }

        return requestSeat.reserve();*/
    }

    public void getSeats() {
        seats.forEach(seat -> System.out.println(seat.getSeatNumber()));
    }

    private class Seat  implements Comparable{
        private final String seatNumber;
        private boolean reserved = false;

        public Seat(String seatNumber) {
            this.seatNumber = seatNumber;
        }

        public boolean reserve() {
            if (!this.reserved) {
                this.reserved = true;
                System.out.println("Seat " + seatNumber + " reserved");
                return true;
            } else {
                return  false;
            }
        }

        public boolean cancel() {
            if (this.reserved) {
                this.reserved = false;
                System.out.println("Reservation of seat " + seatNumber + " cancelled");
                return true;
            } else {
                return false;
            }
        }

        public String getSeatNumber () {
            return this.seatNumber;
        }

        @Override
        public int compareTo(Object o) {
            if (o == null) throw new RuntimeException("comparison with Null Object");
            if (!(o instanceof Seat)) throw new RuntimeException("comparison with mismatch class type");
            Seat other = (Seat)o;
            return seatNumber.compareToIgnoreCase(other.getSeatNumber());
        }
    }
}
