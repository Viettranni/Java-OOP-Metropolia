import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

import model.Pet;
import view.PetView;
import controller.PetController;

public class VirtualPetApp extends Application {

    @Override
    public void start(Stage stage) {
        double canvasWidth = 800;
        double canvasHeight = 600;

        Pet pet = new Pet(canvasWidth / 2, canvasHeight / 2);
        PetView view = new PetView(canvasWidth, canvasHeight, 
    getClass().getResource("/images/fishImage.jpeg").toExternalForm());
 
        PetController controller = new PetController(pet, view);

        Pane root = new Pane(view);
        Scene scene = new Scene(root, canvasWidth, canvasHeight);

        controller.setupHandlers(scene);

        stage.setScene(scene);
        stage.setTitle("Virtual Pet App");
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}
