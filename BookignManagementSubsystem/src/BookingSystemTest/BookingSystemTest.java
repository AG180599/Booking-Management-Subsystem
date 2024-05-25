// This is BookingSystemTest package
package BookingSystemTest;

import org.junit.*;

import hotelbooking.BookingSystem;

import static org.junit.Assert.*;

public class BookingSystemTest {
    private BookingSystem bookingSystem;

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
