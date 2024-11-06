package tasks3_1;

public class Triangle extends Shape{
    private String triangle = "Triangle";

    public Triangle(int x, int y, String color) {
        super(x, y, color);
    }

    @Override
    public double calculateArea(){
        return x * y / 2;
    }

    @Override
    public String getName(){
        return triangle;
    }
}
