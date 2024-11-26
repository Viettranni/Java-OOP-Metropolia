package view;

import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;


public class PetView  extends Canvas{
    private final Image petImage;

    public PetView(double width, double height, String imagePath) {
        super(width, height);
        petImage = new Image(imagePath);
    }

    public void drawPet(double x, double y) {
        GraphicsContext gc = getGraphicsContext2D();
        gc.clearRect(0, 0, getWidth(), getHeight());

        // Setting the size of the pet
        double petWidth = 50;  
        double petHeight = 50;

        gc.drawImage(petImage, x - petWidth / 2, y - petHeight / 2, petWidth, petHeight);
    }
}
