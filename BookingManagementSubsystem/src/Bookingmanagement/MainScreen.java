package Bookingmanagement;

import java.io.Serializable;
import java.util.Scanner;

import Room.Administration;
import Room.Deluxe;
import Room.Luxury;
import Room.SuperDeluxe;

public class MainScreen implements Serializable {
    public static void main(String[] args) {
        // Initialization of room arrays and other variables
        Luxury[] ly = new Luxury[3];
        Deluxe[] dx = new Deluxe[8];
        SuperDeluxe[] sdx = new SuperDeluxe[10];
        Customer[] c = new Customer[20];
        Laundry[][][] l = new Laundry[20][5][5];
        Transportation[][][] t = new Transportation[20][5][5];
        Book[] b = new Book[20];

        // Initialization of rooms and other entities
        initializeRooms(ly, dx, sdx);
        initializeCustomers(c);
        initializeServices(l, t);
        
        Scanner in = new Scanner(System.in);
        Administration admin = new Administration();  // Administration instance
        char ch;
        int ic = 0;
        
        while (true) {
            System.out.println("What do you want to do?");
            System.out.println("Book a room (b)");
            System.out.println("Avail a service (s)");
            System.out.println("Cancel a booked room (c)");
            System.out.println("Administrate (a)");
            System.out.println("Exit Menu (e)");
            
            ch = in.next().charAt(0);
            
            switch (ch) {
                case 'b':
                    handleBooking(ly, dx, sdx, c, b, t, l, ic);
                    ic++;
                    break;
                case 's':
                    handleService(c, t, l, in);
                    break;
                case 'c':
                    handleCancellation(ly, dx, sdx, in);
                    if (ic > 0) ic--;
                    break;
                case 'a':
                    administrate(admin, ly, dx, sdx, in);
                    break;
                case 'e':
                    in.close();
                    System.exit(0);
                    break;
                default:
                    System.out.println("Invalid option. Please try again.");
            }
        }
    }

    private static void handleCancellation(Luxury[] ly, Deluxe[] dx, SuperDeluxe[] sdx, Scanner in) {
        System.out.println("Enter room ID to cancel:");
        int roomId = in.nextInt();
        // Assuming cancellation logic
        System.out.println("Room booking cancelled.");
    }

    private static void handleService(Customer[] c, Transportation[][][] t, Laundry[][][] l, Scanner in) {
        System.out.println("Enter customer ID for service:");
        int id = in.nextInt();
        // Assuming service booking logic
        System.out.println("Service booked for customer " + c[id].getName());
    }

	private static void handleBooking(Luxury[] ly, Deluxe[] dx, SuperDeluxe[] sdx, Customer[] c, Book[] b, Transportation[][][] t, Laundry[][][] l, int ic) {
	    Scanner in = new Scanner(System.in);
	    System.out.println("Select room type (1-Luxury, 2-Deluxe, 3-SuperDeluxe): ");
	    int choice = in.nextInt();
	    switch (choice) {
	        case 1:
	            // Assuming availability check and booking logic
	            break;
	        case 2:
	            // Assuming availability check and booking logic
	            break;
	        case 3:
	            // Assuming availability check and booking logic
	            break;
	    }
	    System.out.println("Room booked successfully for customer " + c[ic].getName());
	    // Increment the customer counter elsewhere or consider the design
	}

	private static void initializeRooms(Luxury[] ly, Deluxe[] dx, SuperDeluxe[] sdx) {
	    for (int i = 0; i < ly.length; i++) {
	        ly[i] = new Luxury();
	        ly[i].set(500, true, false);  // Set parameters as rate, wifi, status
	    }
	    for (int i = 0; i < dx.length; i++) {
	        dx[i] = new Deluxe();
	        dx[i].set(300, true, false);
	    }
	    for (int i = 0; i < sdx.length; i++) {
	        sdx[i] = new SuperDeluxe();
	        sdx[i].set(800, true, false);
	    }
	}


	private static void initializeServices(Laundry[][][] l, Transportation[][][] t) {
	    for (int i = 0; i < l.length; i++) {
	        for (int j = 0; j < l[i].length; j++) {
	            for (int k = 0; k < l[i][j].length; k++) {
	                l[i][j][k] = new Laundry();
	                t[i][j][k] = new Transportation();
	            }
	        }
	    }
	}


	private static void initializeCustomers(Customer[] c) {
	    for (int i = 0; i < c.length; i++) {
	        c[i] = new Customer();
	    }
	}

	private static void administrate(Administration admin, Luxury[] ly, Deluxe[] dx, SuperDeluxe[] sdx, Scanner in) {
        System.out.println("Administration Menu:");
        System.out.println("1. Enable a room");
        System.out.println("2. Disable a room");
        System.out.println("3. Update room fare");
        
        int choice = in.nextInt();
        int roomId;
        double fare;
        
        switch (choice) {
            case 1:
                System.out.println("Enter room ID to enable:");
                roomId = in.nextInt();
                // Assuming handling enable for Luxury only for example
                admin.enableRoom(ly, roomId);
                break;
            case 2:
                System.out.println("Enter room ID to disable:");
                roomId = in.nextInt();
                // Assuming handling disable for Luxury only for example
                admin.disableRoom(ly, roomId);
                break;
            case 3:
                System.out.println("Enter room ID and new fare:");
                roomId = in.nextInt();
                fare = in.nextDouble();
                // Assuming updating fare for Luxury only for example
                admin.updateRoomFare(ly, roomId, fare);
                break;
        }
    }

    // Assuming existence of methods for handleBooking, handleService, handleCancellation
    // Add here the implementations of handleBooking, handleService, handleCancellation
}
