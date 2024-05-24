package UnitTest;

import org.junit.Before;  // JUnit 4 annotation
import org.junit.Test;
import static org.junit.Assert.*;  // JUnit 4 assertions

import Room.Luxury;  

public class RoomTest {

    private Luxury luxuryRoom;

    @Before  // JUnit 4 annotation for setup
    public void setUp() {
        luxuryRoom = new Luxury();
        luxuryRoom.set(500, true, false); // Ensure these methods exist in your Luxury class
    }

    @Test
    public void testRoomFareInitialization() {
        assertEquals("Fare should be initialized to 500", 500, luxuryRoom.getFare());
    }

    @Test
    public void testRoomStatusInitialization() {
        assertFalse("New room should not be reserved", luxuryRoom.getStatus());
    }

    @Test
    public void testRoomNameInitialization() {
        assertEquals("New room should have no allocated name", "Empty", luxuryRoom.getAllotedName());
    }

    @Test
    public void testRoomReservationStatus() {
        luxuryRoom.reserve("John Doe");
        assertTrue("Room should be marked as reserved", luxuryRoom.getStatus());
    }

    @Test
    public void testRoomReservationName() {
        luxuryRoom.reserve("John Doe");
        assertEquals("Room should be allocated to John Doe", "John Doe", luxuryRoom.getAllotedName());
    }

    @Test
    public void testRoomResetStatus() {
        luxuryRoom.reserve("John Doe");
        luxuryRoom.reset();
        assertFalse("Room should be reset to not reserved", luxuryRoom.getStatus());
    }

    @Test
    public void testRoomResetName() {
        luxuryRoom.reserve("John Doe");
        luxuryRoom.reset();
        assertEquals("Room name should be reset to 'Empty'", "Empty", luxuryRoom.getAllotedName());
    }

    @Test
    public void testChangeFare() {
        luxuryRoom.setFare(600);
        assertEquals("Room fare should be updated to 600", 600, luxuryRoom.getFare());
    }

    @Test
    public void testToggleRoomStatusOn() {
        luxuryRoom.statuschange();
        assertTrue("Room status should be toggled to reserved", luxuryRoom.getStatus());
    }

    @Test
    public void testToggleRoomStatusOff() {
        luxuryRoom.statuschange();  // Toggle on
        luxuryRoom.statuschange();  // Toggle off
        assertFalse("Room status should be toggled back to not reserved", luxuryRoom.getStatus());
    }
}
