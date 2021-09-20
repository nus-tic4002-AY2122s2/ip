package tasks;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class EventTest {
    @Test
    void testGetAt_success() {
        assertEquals("20 Feb 2000 10:10:10 - 23:12:30", new Event("running", "20/02/2000 10:10:10 - 23:12:30").getAt());
    }
    @Test
    void testToString_success() {
        assertEquals("[E][-] running (at: 20 Feb 2000 10:10:10)", new Event("running", "20/02/2000 10:10:10").toString());
    }
}