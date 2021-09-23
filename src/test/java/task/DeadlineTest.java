package task;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class DeadlineTest {
    @Test
    @DisplayName("Inserting Test Case 2 /by 2021-10-01 23:59")
    void TestToString() {
        String dateTime = "2021-10-01 23:59";
        Deadline deadline = new Deadline("To complete Deadline task", dateTime);
        Assertions.assertEquals("[D][✘]To complete Deadline task (by: 2021-10-01 23:59)", deadline.toString());
    }

}