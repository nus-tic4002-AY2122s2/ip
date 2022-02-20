package duke.ui;

import duke.Duke;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.scene.paint.Color;

public class InputEventHandler implements EventHandler {
    private Duke duke;
    private Ui ui;

    /**
     * @param duke
     * @param ui
     */
    public InputEventHandler(Duke duke, Ui ui) {
        this.duke = duke;
        this.ui = ui;
    }

    @Override
    public void handle(Event event) {
        String a = ui.getUserInput().getText();
        if (!(a.isEmpty() || a.isBlank())) {
            ui.getDialogContainer().getChildren().add(ui.getDialogLabel(a, Color.DARKGREEN, false));
            if (ui.isAwaitingInput()) {
                if (ui.getNewDesc().isBlank() || ui.getNewDesc().isEmpty()) {
                    ui.setNewDesc(a);
                    if (ui.isEditingTodo()) {
                        ui.setAwaitingInput(false);
                    }
                } else if (ui.getNewDateStr().isBlank() || ui.getNewDateStr().isEmpty()) {
                    ui.setNewDateStr(a);
                    ui.setAwaitingInput(false);
                }
            } else {
                duke.runOnce(a);
            }
            ui.getUserInput().clear();
        }
    }
}
