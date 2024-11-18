package Tasks5_1;

import java.util.Random;

public class ParallelSum {

    public static void main(String[] args) throws InterruptedException {
        int arraySize = 100000; 
        int[] numbers = new int[arraySize];

        // Populating the array with random integers
        Random random = new Random();
        for (int i = 0; i < arraySize; i++) {
            numbers[i] = random.nextInt(100); 
        }

        // Determine the number of available processor cores
        int numThreads = Runtime.getRuntime().availableProcessors();
        System.out.println("My computer has  " + numThreads + " threads");

        // Splitting the array evenly into parts for each thread
        int chunkSize = (int) Math.ceil((double) arraySize / numThreads);
        System.out.println("We are dividing the portion so each thread handles the size of " + chunkSize);
        SumThread[] threads = new SumThread[numThreads];

        // Creating and starting threads
        for (int i = 0; i < numThreads; i++) {
            int start = i * chunkSize;
            int end = Math.min(start + chunkSize, arraySize);
            threads[i] = new SumThread(numbers, start, end); // Starts to calculate all of the numbers together
            threads[i].start();
        }

        // Wait for all threads to complete and collect their results
        int totalSum = 0;
        for (SumThread thread : threads) {
            thread.join();
            totalSum += thread.getPartialSum();
        }

        System.out.println("Total sum: " + totalSum);
    }
}

// Thread class to calculate the sum of a segment of the array
class SumThread extends Thread {
    private int[] array;
    private int start;
    private int end;
    private int partialSum;

    public SumThread(int[] array, int start, int end) {
        this.array = array;
        this.start = start;
        this.end = end;
    }

    public void run() {
        partialSum = 0;
        for (int i = start; i < end; i++) {
            partialSum += array[i];
        }
    }

    public int getPartialSum() {
        return partialSum;
    }
}

