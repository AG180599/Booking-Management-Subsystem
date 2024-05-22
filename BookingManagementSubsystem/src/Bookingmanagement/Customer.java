package Bookingmanagement;

import java.util.Scanner;

public class Customer {
    private int no;
    private String name;
    private String bookingno;
    private int type;  // 1 for Luxury, 2 for Deluxe, 3 for Super Deluxe
    private int ld;    // Room occupancy (1 or 2)
    private int d;     // Number of days of stay
    private boolean status;

    public Customer() {
        this.no = -1;
        this.name = "";
        this.bookingno = "";
        this.type = -1;
        this.ld = -1;
        this.d = -1;
        this.status = false;
    }

    public void setInitialDetails(int c, Scanner in) {
        this.no = c;
        System.out.println("Enter name:");
        this.name = in.nextLine();
        System.out.println("Enter room type? 1 for Luxury, 2 for Deluxe, 3 for Super Deluxe:");
        this.type = in.nextInt();
        System.out.println("Enter occupancy? 1/2:");
        this.ld = in.nextInt();
        System.out.println("Enter number of days?");
        this.d = in.nextInt();
        in.nextLine(); // Consume the newline left-over
    }

    public void setBookingNo(String b) {
        this.bookingno = b;
    }

    // Getters to access private fields
    public int getNo() {
        return this.no;
    }

    public String getName() {
        return this.name;
    }

    public String getBookingNo() {
        return this.bookingno;
    }

    public int getType() {
        return this.type;
    }

    public int getLd() {
        return this.ld;
    }

    public int getD() {
        return this.d;
    }

    public boolean getStatus() {
        return this.status;
    }

    // Example of setting status, if needed for room booking logic
    public void setStatus(boolean status) {
        this.status = status;
    }
}
