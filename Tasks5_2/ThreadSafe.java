package Tasks5_2;

import java.util.ArrayList;
import java.util.List;

public class ThreadSafe {
    private List<String> listOfStrings;
    private int totalAdded;
    private int totalRemoved;
    

    public ThreadSafe() {
        this.listOfStrings = new ArrayList<>();
    }

    public void addElement(String element) {
        synchronized (listOfStrings) {
            listOfStrings.add(element);
            totalAdded++;
        }
    }

    public void removeElement(String element) {
        synchronized (listOfStrings) {
            listOfStrings.remove(element);
            totalRemoved++;
        }
    }

    public synchronized int sizeOfCollection() {
        return listOfStrings.size();
    }

    public int getAdded() {
        return totalAdded;
    }

    public int getRemoved() {
        return totalRemoved;
    }
}

class Main {
    public static void main(String[] args) throws InterruptedException{
        ThreadSafe testing = new ThreadSafe();

        Thread addElement1 = new Thread(() -> {
            for (int i = 0; i < 1000; i++) {
                testing.addElement("Element");
            }
        });

        Thread addElement2 = new Thread(() -> {
            for (int i = 1000; i < 2000; i++) {
                testing.addElement("Element");
            }
        });

        Thread removeThread = new Thread(() -> {
            for (int i = 0; i < 500; i++) {
                testing.removeElement("Element");
            }
        });

        addElement1.start();
        addElement2.start();
        removeThread.start();

        addElement1.join();
        addElement2.join();
        removeThread.join();

        System.out.println("Total elements added: " + testing.getAdded()); // Should be 2000
        System.out.println("Total elements removed: " + testing.getRemoved()); 
        System.out.println("Final size of the collection: " + testing.sizeOfCollection());
    }
}