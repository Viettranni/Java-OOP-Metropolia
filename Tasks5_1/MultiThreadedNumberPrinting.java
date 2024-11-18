package Tasks5_1;

public class MultiThreadedNumberPrinting {
    
    // Shared variable for managing the printing order
    private static final Object lock = new Object();
    private static int currentNumber = 1;

    public static void main(String[] args) {
        // Define the range for printing numbers
        int start = 1;
        int end = 20;

        // Create and start the even and odd printing threads
        Thread oddThread = new Thread(new OddPrinter(start, end));
        Thread evenThread = new Thread(new EvenPrinter(start, end));

        oddThread.start();
        evenThread.start();
    }

    // Odd printer thread
    static class OddPrinter implements Runnable {
        private int start;
        private int end;

        public OddPrinter(int start, int end) {
            this.start = start;
            this.end = end;
        }

        @Override
        public void run() {
            while (currentNumber <= end) {
                synchronized (lock) {
                    if (currentNumber % 2 != 0) { 
                        System.out.println("Odd Thread: " + currentNumber);
                        currentNumber++;
                        lock.notify();  // Notify the other thread to print
                    } else {
                        try {
                            lock.wait();  // Wait for the other thread to print
                        } catch (InterruptedException e) {
                            Thread.currentThread().interrupt();
                        }
                    }
                }
            }
        }
    }

    // Even printer thread
    static class EvenPrinter implements Runnable {
        private int start;
        private int end;

        public EvenPrinter(int start, int end) {
            this.start = start;
            this.end = end;
        }

        @Override
        public void run() {
            while (currentNumber <= end) {
                synchronized (lock) {
                    if (currentNumber % 2 == 0) {
                        System.out.println("Even Thread: " + currentNumber);
                        currentNumber++;
                        lock.notify();  // Notify the other thread to print
                    } else {
                        try {
                            lock.wait();  // Wait for the other thread to print
                        } catch (InterruptedException e) {
                            Thread.currentThread().interrupt();
                        }
                    }
                }
            }
        }
    }
}
