import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Region;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        PresentationModel pm = new PresentationModel();
        Region rootPanel = new ColorPickerPane(pm);

        Scene scene = new Scene(rootPanel);

        primaryStage.setTitle("Color Picker");
        primaryStage.setScene(scene);

        primaryStage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }
}
