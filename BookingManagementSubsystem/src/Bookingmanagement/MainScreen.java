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
        initializeCustomers(c, in);
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
                    handleBooking(ly, dx, sdx, c, b, t, l, ic, in);
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
        int roomId = in.nextInt() - 1;
        if (roomId >= 0 && roomId < ly.length && ly[roomId].getStatus()) {
            ly[roomId].setStatus(false);
            System.out.println("Room booking cancelled.");
        } else {
            System.out.println("Invalid room ID or room not booked.");
        }
    }

    private static void handleService(Customer[] c, Transportation[][][] t, Laundry[][][] l, Scanner in) {
        System.out.println("Enter customer ID for service:");
        int id = in.nextInt() - 1;  // Assuming customer ID starts at 1
        if (id >= 0 && id < c.length) {
            System.out.println("Service booked for customer " + c[id].getName());
        } else {
            System.out.println("Invalid customer ID.");
        }
    }

    private static void handleBooking(Luxury[] ly, Deluxe[] dx, SuperDeluxe[] sdx, Customer[] c, Book[] b, Transportation[][][] t, Laundry[][][] l, int ic, Scanner in) {
        System.out.println("Select room type (1-Luxury, 2-Deluxe, 3-SuperDeluxe): ");
        int choice = in.nextInt();
        boolean roomBooked = false;
        if (ic >= c.length || c[ic].getName() == null || c[ic].getName().isEmpty()) {
            System.out.println("No customer information available. Please check customer initialization.");
            return;
        }
        switch (choice) {
            case 1:
                for (Luxury room : ly) {
                    if (!room.getStatus()) {
                        room.setStatus(true);
                        roomBooked = true;
                        System.out.println("Luxury room booked successfully for customer " + c[ic].getName());
                        break;
                    }
                }
                if (!roomBooked) System.out.println("No available luxury rooms.");
                break;
            case 2:
                for (Deluxe room : dx) {
                    if (!room.getStatus()) {
                        room.setStatus(true);
                        roomBooked = true;
                        System.out.println("Deluxe room booked successfully for customer " + c[ic].getName());
                        break;
                    }
                }
                if (!roomBooked) System.out.println("No available deluxe rooms.");
                break;
            case 3:
                for (SuperDeluxe room : sdx) {
                    if (!room.getStatus()) {
                        room.setStatus(true);
                        roomBooked = true;
                        System.out.println("Super Deluxe room booked successfully for customer " + c[ic].getName());
                        break;
                    }
                }
                if (!roomBooked) System.out.println("No available super deluxe rooms.");
                break;
        }
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

    private static void initializeCustomers(Customer[] c, Scanner in) {
        for (int i = 0; i < c.length; i++) {
            c[i] = new Customer();
            System.out.println("Initializing customer ID " + (i + 1));
            c[i].setInitialDetails(i, in);  // You need to ensure that this method prompts for and reads the customer's name and other details
        }
    }



    private static void administrate(Administration admin, Luxury[] ly, Deluxe[] dx, SuperDeluxe[] sdx, Scanner in) {
        System.out.println("Administration Menu:");
        System.out.println("1. Enable a room");
        System.out.println("2. Disable a room");
        System.out.println("3. Update room fare");
        System.out.println("Enter your choice:");
        
        int choice = in.nextInt();  // Get user choice for administration action

        if (choice == 1 || choice == 2 || choice == 3) {
            System.out.println("Enter room ID:");
            int roomId = in.nextInt() - 1;  // Assume room IDs start at 1

            if (choice == 1) {
                if (roomId >= 0 && roomId < ly.length) {
                    ly[roomId].setStatus(true);
                    System.out.println("Luxury room " + (roomId + 1) + " enabled.");
                } else {
                    System.out.println("Invalid room ID.");
                }
            } else if (choice == 2) {
                if (roomId >= 0 && roomId < ly.length) {
                    ly[roomId].setStatus(false);
                    System.out.println("Luxury room " + (roomId + 1) + " disabled.");
                } else {
                    System.out.println("Invalid room ID.");
                }
            } else if (choice == 3) {
                System.out.println("Enter new fare:");
                double fare = in.nextDouble();
                if (roomId >= 0 && roomId < ly.length) {
                    ly[roomId].setFare(fare);
                    System.out.println("Fare for luxury room " + (roomId + 1) + " updated to " + fare);
                } else {
                    System.out.println("Invalid room ID.");
                }
            }
        } else {
            System.out.println("Invalid option selected.");
        }
    }
}
