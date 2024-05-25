package BookingSystemTest;

import org.junit.*;

import hotelbooking.BookingSystem;

import static org.junit.Assert.*;

public class BookingSystemTest {
    private BookingSystem bookingSystem;
// this is before annotation that you have used you know
    @Before
    public void setUp() {
        bookingSystem = BookingSystem.getInstance();
    }

    @Test
    public void testSingleton() {
        BookingSystem anotherInstance = BookingSystem.getInstance();
        assertSame("Instances should be the same", bookingSystem, anotherInstance);
    }

}
