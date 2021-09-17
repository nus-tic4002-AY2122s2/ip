import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class UiTest {

    @Test
    public void UiTest() {
        Ui testUi = new Ui();
        assertEquals("\t________________________________________________________________\n\t", testUi.showLine());
    }
}

