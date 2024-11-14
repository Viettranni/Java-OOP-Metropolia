public class Calculator {
    private int currentValue;

    public Calculator() {
        this.currentValue = 0;
    }

    public void reset() {
        this.currentValue = 0;
    }


    public void add(int number) throws IllegalArgumentException {
        if (number < 0) {
            throw new IllegalArgumentException("Negative integers are not allowed.");
        }
        this.currentValue += number;
    }

    public int getCurrentValue() {
        return this.currentValue;
    }

    // Temporary main method to demonstrate the use of the Calculator class
    public static void main(String[] args) {
        Calculator calc = new Calculator();
        
        // Test the methods
        try {
            System.out.println("Initial value: " + calc.getCurrentValue());
            calc.add(10);
            System.out.println("After adding 10: " + calc.getCurrentValue());
            calc.add(20);
            System.out.println("After adding 20: " + calc.getCurrentValue());
            
            // Uncomment the line below to test exception handling
            // calc.add(-5);  // This will throw an exception

            calc.reset();
            System.out.println("After reset: " + calc.getCurrentValue());
        } catch (IllegalArgumentException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}

