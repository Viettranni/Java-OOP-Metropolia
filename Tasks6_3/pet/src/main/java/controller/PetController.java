package controller;

import javafx.animation.AnimationTimer;
import javafx.scene.Scene;

import model.Pet;
import view.PetView;
import controller.PetController;

public class PetController {
    private final Pet pet;
    private final PetView view;
    private double mouseX, mouseY;
    private boolean mouseInsideCanvas;

    public PetController(Pet pet, PetView view) {
        this.pet = pet;
        this.view = view;
        mouseInsideCanvas = false;
    }

    public void setupHandlers(Scene scene) {
        scene.setOnMouseMoved( event -> {
            mouseX = event.getX();
            mouseY = event.getY();
            mouseInsideCanvas = true;
        });

        scene.setOnMouseExited(event -> mouseInsideCanvas = false);

        AnimationTimer timer = new AnimationTimer() {
            @Override
            public void handle(long now) {
                if (mouseInsideCanvas) {
                    pet.moveTowards(mouseX, mouseY);
                }
                view.drawPet(pet.getX(), pet.getY());
            }
        };
        timer.start();
    }
}