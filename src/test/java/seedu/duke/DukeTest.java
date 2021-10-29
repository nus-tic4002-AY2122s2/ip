package seedu.duke;

import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;


class DukeTest {
    @Test
    public void sampleTest() {
        assertTrue(true);
    }

    @Test
    public void flightCreationTask() {
        Flight testFlight = new Flight("Singapore", "Australia","2021-12-31 0800", "500");
    }
}
