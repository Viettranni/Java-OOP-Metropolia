package tasks3_1;

public class Rectangle extends Shape {
    private String rectangle = "Rectangle";

    public Rectangle(int x, int y) {
        super(x, y);
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
