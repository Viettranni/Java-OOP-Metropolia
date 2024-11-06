package tasks3_1;

public class Rectangle extends Shape {
    private String rectangle = "Rectangle";

    public Rectangle(int x, int y, String color) {
        super(x, y, color);
    }

    @Override
    public double calculateArea() {
        return x * y;
    }

    @Override
    public String getName(){
        return rectangle;
    }
}
