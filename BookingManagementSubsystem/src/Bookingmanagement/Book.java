package Bookingmanagement;

import java.io.Serializable;
import java.util.Scanner;

import Room.Deluxe;
import Room.Luxury;
import Room.SuperDeluxe;

public class Book implements Serializable {
    private String bookno;
    private Transportation[][][] t;
    private Laundry[][][] l;
    private int fareTotal;
    private Customer cust;
    private double transportationCost = 0, laundryCost = 0;

    public String getBookingNumber() {
        return bookno;
    }

    public void bookNew(Customer c, Luxury ly, Deluxe dx, SuperDeluxe sdx, Transportation[][][] tr, Laundry[][][] lr, int ily, int flag1, int idx, int flag2, int isdx, int flag3) {
        cust = c;
        t = tr;
        l = lr;

        switch (c.getType()) {
            case 1: // Luxury
                if (flag1 == 1) {
                    bookLuxury(c, ly, ily, c.getLd(), c.getD());
                } else {
                    System.out.println("No Luxury Rooms Available");
                    suggestAlternativeRoomType(c, 1);
                }
                break;
            case 2: // Deluxe
                if (flag2 == 1) {
                    bookDeluxe(c, dx, idx, c.getLd(), c.getD());
                } else {
                    System.out.println("No Deluxe Rooms Available");
                    suggestAlternativeRoomType(c, 2);
                }
                break;
            case 3: // Super Deluxe
                if (flag3 == 1) {
                    bookSuperDeluxe(c, sdx, isdx, c.getLd(), c.getD());
                } else {
                    System.out.println("No Super Deluxe Rooms Available");
                    suggestAlternativeRoomType(c, 3);
                }
                break;
        }
    }

    private void suggestAlternativeRoomType(Customer c, int currentType) {
        Scanner in = new Scanner(System.in);
        System.out.println("Do you want any other room? Enter type (1-Luxury, 2-Deluxe, 3-Super Deluxe): ");
        int choice = in.nextInt();
        if (choice != currentType) {
            // Call booking method based on new choice
        }
    }

    private void bookLuxury(Customer c, Luxury ly, int ily, int ld, int d) {
        Fare fare = new Fare();
        ly.statuschange();
        bookno = ily + "lx" + ld;
        fareTotal = fare.fareCalculator(d, ly.getRate(), ld);
        transportationCost = t[ily][ld - 1][0].getTotalCost();
        laundryCost = l[ily][ld - 1][1].getTotalCost();
        bookDisplay();
    }

    private void bookDeluxe(Customer c, Deluxe dx, int idx, int ld, int d) {
        Fare fare = new Fare();
        dx.statuschange();
        bookno = idx + "dx" + ld;
        fareTotal = fare.fareCalculator(d, dx.getRate(), ld);
        transportationCost = t[idx][ld - 1][0].getTotalCost();
        laundryCost = l[idx][ld - 1][1].getTotalCost();
        bookDisplay();
    }

    private void bookSuperDeluxe(Customer c, SuperDeluxe sdx, int isdx, int ld, int d) {
        Fare fare = new Fare();
        sdx.statuschange();
        bookno = isdx + "sdx" + ld;
        fareTotal = fare.fareCalculator(d, sdx.getRate(), ld);
        transportationCost = t[isdx][ld - 1][0].getTotalCost();
        laundryCost = l[isdx][ld - 1][1].getTotalCost();
        bookDisplay();
    }

    private void bookDisplay() {
        System.out.println("Booking number: " + bookno);
        System.out.println("Customer number: " + cust.getNo());
        System.out.println("Booking Name: " + cust.getName());
        System.out.println("Fare is: " + fareTotal);
        System.out.println("Total cost of transportation is: " + transportationCost);
        System.out.println("Total cost of laundry is: " + laundryCost);
    }

    public int getFareTotal() {
        return fareTotal;
    }

    public String getCustomerName() {
        return cust.getName();
    }
}
