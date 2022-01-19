package edu.nus.duke.parser;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.time.LocalDateTime;

import org.junit.jupiter.api.Test;

public class ParserTest {
    @Test
    public void parseDtTest() {
        LocalDateTime dt1 = Parser.parseDt("2021-09-23T17:26");
        LocalDateTime dt2 = LocalDateTime.of(2021, 9, 23, 17, 26);
        assertEquals(dt2, dt1);
    }

    @Test
    public void dtToStringTest() {
        LocalDateTime dt = LocalDateTime.of(2021, 9, 23, 17, 26);
        String dtText = Parser.dtToString(dt);
        assertEquals("2021-09-23T17:26", dtText);
    }
}
