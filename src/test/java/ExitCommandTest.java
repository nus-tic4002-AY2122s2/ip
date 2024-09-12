import duke.ExitCommand;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ExitCommandTest {
    @Test
    void exitCommand_Return_ExitIsTrue_ByDefault_Test() {
        assertEquals(true,new ExitCommand().isExit());
    }
}
