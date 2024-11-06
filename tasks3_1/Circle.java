package tasks3_1;

public class Circle extends Shape {
    private double radius;
    private String circle = "Circle";

    public Circle(int x, int y, double radius, String color) {
        super(x, y, color);
        this.radius = radius;
    }    

    @Override
    public double calculateArea(){
        return Math.PI * radius * radius;
    }

    @Override
    public String getName(){
        return circle;
    }
}
