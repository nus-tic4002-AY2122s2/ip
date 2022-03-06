import javafx.application.Application;
import javafx.stage.Stage;
import taskExecutor.TaskExecutor;
import ui.UiManager;

public class Main extends Application {
    private UiManager uiManager;
    private TaskExecutor taskExecutor;

    @Override
    public void init() throws Exception {
        uiManager = new UiManager();
        taskExecutor = new TaskExecutor();
    }

    @Override
    public void start(Stage stage) {
        uiManager.init(stage, taskExecutor);
    }
}

