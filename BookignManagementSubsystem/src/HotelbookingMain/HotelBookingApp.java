package HotelbookingMain;


import java.util.Scanner;

import hotelbooking.BookingSystem;

public class HotelBookingApp {
    public static void main(String[] args) {
        BookingSystem bookingSystem = BookingSystem.getInstance();
        Scanner scanner = new Scanner(System.in);

        boolean running = true;
        while (running) {
            System.out.println("\nWelcome to the Hotel Booking System");
            System.out.println("1. Check Room Availability");
            System.out.println("2. Book a Room");
            System.out.println("3. Modify Booking");
            System.out.println("4. Cancel Booking");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");

            int choice = scanner.nextInt();
            scanner.nextLine(); // Consumes the newline left-over

            switch (choice) {
                case 1:
                    bookingSystem.checkRoomAvailability();
                    break;
                case 2:
                    System.out.print("Enter room number: ");
                    String roomNumber = scanner.nextLine();
                    System.out.print("Enter customer details: ");
                    String customerDetails = scanner.nextLine();
                    bookingSystem.bookRoom(roomNumber, customerDetails);
                    break;
                case 3:
                    System.out.print("Enter booking ID to modify: ");
                    String bookingId = scanner.nextLine();
                    System.out.print("Enter new room number: ");
                    String newRoomNumber = scanner.nextLine();
                    bookingSystem.modifyBooking(bookingId, newRoomNumber);
                    break;
                case 4:
                    System.out.print("Enter booking ID to cancel: ");
                    String cancelBookingId = scanner.nextLine();
                    bookingSystem.cancelBooking(cancelBookingId);
                    break;
                case 5:
                    running = false;
                    System.out.println("Exiting the system...");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
                    break;
            }
        }
        scanner.close();
    }
}

