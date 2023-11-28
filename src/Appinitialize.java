import javafx.application.Application;
import javafx.stage.Stage;
import methodClass.taskManager;

public class Appinitialize extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        boolean b = taskManager.getInstance().geTaskManager("idea64.exe");
        System.out.println(b);

    }
}
