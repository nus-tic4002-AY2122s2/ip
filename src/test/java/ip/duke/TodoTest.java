package ip.duke;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TodoTest {
    @Test
    public void Desc_Test() {
        Todo task = new Todo("return a book");
        assertEquals("return a book", task.getDescription());

    }

    @Test
    public void SetId_Test() {
        Todo task = new Todo("read another book");
        assertEquals('T', task.getId());
    }

    @Test
    public void ToFileString_Test() {
        Todo task = new Todo("borrow a book");
        task.setDone();
        assertEquals("T : 1 : borrow a book", task.toFileString());
    }

}
