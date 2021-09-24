package edu.nus.duke.parser;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.time.LocalDateTime;

public class ParserTest {
    @Test
    public void parseDtTest() {
        LocalDateTime dt1 = Parser.parseDt("2021-09-23T17:26");
        LocalDateTime dt2 = LocalDateTime.of(2021,9,23,17,26);
        assertEquals(dt2, dt1);
    }
}
