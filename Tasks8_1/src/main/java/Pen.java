public class Pen {

    public enum Color {
        RED("red"), GREEN("green"), BLUE("blue");
        private final String color;
        Color(String color) { this.color = color; };
        @Override public String toString() { return color; }
    }

    private Color currentColor;
    private Color color; // The color of the pen
    private boolean capped;

    public Pen() {
        this.currentColor = Color.RED;
        this.capped = true;
    }

    public Pen(Color color) {
        this.color = color;
    }

    public String draw() {
        return capped ? "" : "Drawing " + currentColor.toString();
    }

    public void capOff() {
        this.capped = false;
    }

    public void capOn() {
        this.capped = true;
    }

    // The color can only be changed when the cap is on
    public void changeColor(Color color) {
        if (capped) {
            this.currentColor = color;
        }
    }
}
