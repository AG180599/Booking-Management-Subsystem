package hotelbooking;

import java.util.HashMap;
import java.util.Map;

import Room.DeluxeRoom;
import Room.Room;
import Room.StandardRoom;
import Room.SuiteRoom;

public class BookingSystem implements BookingManager {
    private static BookingSystem instance;
    private Map<String, Room> rooms;
    private Map<String, Boolean> bookingConfirmation;

    private BookingSystem() {
        rooms = new HashMap<>();
        bookingConfirmation = new HashMap<>();
        initializeRooms(); // Initialize some rooms for the hotel
    }

    public static BookingSystem getInstance() {
        if (instance == null) {
            instance = new BookingSystem();
        }
        return instance;
    }

    private void initializeRooms() {
        // Creating some sample rooms using specific room types
        rooms.put("101", new StandardRoom("101"));
        rooms.put("102", new DeluxeRoom("102"));
        rooms.put("201", new SuiteRoom("201"));
    }


    @Override
    public void checkRoomAvailability() {
        System.out.println("Available Rooms:");
        rooms.values().stream()
             .filter(Room::isAvailable)
             .forEach(room -> System.out.println(room));
    }

    @Override
    public void bookRoom(String roomNumber, String customerDetails) {
        Room room = rooms.get(roomNumber);
        if (room != null && room.isAvailable()) {
            room.setAvailable(false);
            bookingConfirmation.put(roomNumber, false);  // Booking is made but not confirmed
            System.out.println("Room " + roomNumber + " has been booked for " + customerDetails + ". Waiting for confirmation.");
        } else {
            System.out.println("Room " + roomNumber + " is not available.");
        }
    }

    @Override
    public void modifyBooking(String bookingId, String newRoomNumber) {
        // Simplistic assumption: bookingId is the old room number
        Room oldRoom = rooms.get(bookingId);
        Room newRoom = rooms.get(newRoomNumber);

        if (oldRoom != null && !oldRoom.isAvailable() && newRoom != null && newRoom.isAvailable()) {
            oldRoom.setAvailable(true);
            newRoom.setAvailable(false);
            bookingConfirmation.put(newRoomNumber, bookingConfirmation.get(bookingId));
            bookingConfirmation.remove(bookingId);
            System.out.println("Booking modified from Room " + bookingId + " to Room " + newRoomNumber);
        } else {
            System.out.println("Modification not possible.");
        }
    }

    @Override
    public void cancelBooking(String bookingId) {
        Room room = rooms.get(bookingId);
        if (room != null && !room.isAvailable()) {
            room.setAvailable(true);
            bookingConfirmation.remove(bookingId);
            System.out.println("Booking cancelled for Room " + bookingId);
        } else {
            System.out.println("No active booking found for Room " + bookingId);
        }
    }

    @Override
    public void confirmBooking(String bookingId) {
        if (bookingConfirmation.containsKey(bookingId) && !bookingConfirmation.get(bookingId)) {
            bookingConfirmation.put(bookingId, true);
            System.out.println("Booking confirmed for Room " + bookingId);
        } else {
            System.out.println("No active or unconfirmed booking found for Room " + bookingId);
        }
    }
}