public class Calculator {
    private int currentValue;

    // Constructor to initialize the calculator
    public Calculator() {
        this.currentValue = 0;
    }

    // Method to reset the calculator to zero
    public void reset() {
        this.currentValue = 0;
    }

    // Method to add a positive integer to the calculator
    // Throws an exception if the integer is negative
    public void add(int number) throws IllegalArgumentException {
        if (number < 0) {
            throw new IllegalArgumentException("Negative integers are not allowed.");
        }
        this.currentValue += number;
    }

    // Method to get the current value of the calculator
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

