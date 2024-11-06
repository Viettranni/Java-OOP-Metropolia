package tasks3_1;

public class Shape {
    protected int x;
    protected int y;
    protected String color;

    public Shape(int x, int y, String color) {
        this.x = x;
        this.y = y;
        this.color = color;
    }

    public double calculateArea(){
        return 0;
    }

    public String getName(){
        return null;
    }

    public String getColor(){
        return color;
    }


}
