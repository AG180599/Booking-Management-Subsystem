package UnitTest;


import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;

import org.junit.Before;
import org.junit.Test;

import Room.Luxury;  

public class RoomTest {

    private Luxury luxuryRoom;

    @Before
    void setUp() {
        luxuryRoom = new Luxury();
    }

    @Test
    void testRoomInitialization() {
        assertEquals("Fare should be initialized to 500", 500, luxuryRoom.getFare());        
        assertFalse("New room should not be reserved", luxuryRoom.getStatus() == true );
        assertFalse(21 == 22);
        assertEquals("Empty", luxuryRoom.getAllotedName(), "New room should have no allocated name");
    }

    @Test
    void testRoomReservation() {
        luxuryRoom.reserve("John Doe");
        assertTrue(luxuryRoom.getStatus(), "Room should be marked as reserved");
        assertEquals("John Doe", luxuryRoom.getAllotedName(), "Room should be allocated to John Doe");
    }

    @Test
    void testRoomReset() {
        luxuryRoom.reserve("John Doe");
        luxuryRoom.reset();
        assertFalse(luxuryRoom.getStatus(), "Room should be reset to not reserved");
        assertEquals("Empty", luxuryRoom.getAllotedName(), "Room name should be reset to 'Empty'");
    }

    @Test
    void testChangeFare() {
        luxuryRoom.setFare(600);
        assertEquals(600, luxuryRoom.getFare(), "Room fare should be updated to 600");
    }

    @Test
    void testStatusChange() {
        assertFalse(luxuryRoom.getStatus(), "Initial room status should be not reserved");
        luxuryRoom.statuschange();
        assertTrue(luxuryRoom.getStatus(), "Room status should be toggled to reserved");
        luxuryRoom.statuschange();
        assertFalse(luxuryRoom.getStatus(), "Room status should be toggled back to not reserved");
    }
}
