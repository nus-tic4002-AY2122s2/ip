package ip.duke;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class DeadlineTest {
    @Test
    public void GetBy_Test() {
        Deadline schedule = new Deadline("Finish Assignment", "2:30pm Fri");
        assertEquals("2:30pm Fri", schedule.getBy());
    }

    @Test
    public void SetId_test() {
        Deadline schedule = new Deadline("Return the book", "Monday");
        schedule.setId();
        assertEquals('D', schedule.getId());
    }

    @Test
    public void ToString_Test() {
        Deadline schedule = new Deadline("Visit the Sport Centre", "Aug 2019");
        assertEquals("Visit the Sport Centre (by: Aug 2019)", schedule.toString());
    }
}
