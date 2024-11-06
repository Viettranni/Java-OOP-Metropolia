package tasks3_1;

import java.util.ArrayList;

public class ShapeCalculator {

    public static void main(String[] args) {
        ArrayList<Shape> shapes = new ArrayList<>();
        Shape rectangle = new Rectangle(5, 3, "Green");
        Shape circle = new Circle(0, 0, 4, "Red");
        Shape triangle = new Triangle(3, 5, "Blue");

        shapes.add(rectangle);
        shapes.add(circle);
        shapes.add(triangle);

        System.out.println("Shape Calculator \n");

        for (Shape shape : shapes) {
            System.out.println("The Shape " + shape.getName() + "'s calculated Area: " + shape.calculateArea() + " and is filled with the color of " + shape.getColor());
        }
    }
}
