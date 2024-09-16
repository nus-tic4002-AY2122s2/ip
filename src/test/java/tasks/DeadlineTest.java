package tasks;

import org.junit.jupiter.api.Test;
import ui.Ui;

import static org.junit.jupiter.api.Assertions.assertEquals;

class DeadlineTest {
    @Test
    void testGetBy_success() {
        Ui ui = new Ui();
        assertEquals("20 Feb 2000 10:10:10", new Deadline("running", "20/02/2000 10:10:10", ui).getBy());
    }

    @Test
    void testToString_success() {
        Ui ui = new Ui();
        assertEquals("[D][-] running (by: 20 Feb 2000 10:10:10)",
                new Deadline("running", "20/02/2000 10:10:10", ui).toString());
    }
}