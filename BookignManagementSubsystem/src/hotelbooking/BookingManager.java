package hotelbooking;

public interface BookingManager {
    void checkRoomAvailability();
    void bookRoom(String roomNumber, String customerDetails);
    void modifyBooking(String bookingId, String newRoomNumber);
    void cancelBooking(String bookingId);
    void confirmBooking(String bookingId);
}

