// package Tasks5_2;

// public class Theatre {
//     public int amountOfSeats = 40;

//     // Using synchronized since multiple customers will try to access the amountOfSeats variable at the same time
//     // Ensured so only one thread can execute the reservingSeat method at a time
//     public synchronized void reservingSeat(int number) {
//         // Gets the name of the current customer
//         String customer = Thread.currentThread().getName();
//         if (number <= amountOfSeats) {
//             amountOfSeats -= number; 
//             System.out.println(customer + " reserved " + number + " seats. Remaining seats: " + getSeats());
//         } else {
//             System.out.println(customer + " tried to reserve " + number + " of seats but we have only " + getSeats() + " seats left..");
//         }
//     }

//     public int getSeats() {
//         return amountOfSeats;
//     }
// }

// // Seat reserver is our customer
// class SeatReserver implements Runnable {
//     private Theatre theatre;
//     private int ticketAmount;

//     public SeatReserver(Theatre theatre, int ticketAmount) {
//         this.theatre = theatre;
//         this.ticketAmount = ticketAmount;
//     }

//     @Override
//     public void run() {
//         theatre.reservingSeat(ticketAmount);
//     }
// }


// class Main {
//     private static final int customers = 40;

//     public static void main(String[] args) {
//         // Common Theatre which each customer uses
//         Theatre theatre = new Theatre();
//         Thread[] customerThreads = new Thread[customers];

//         for (int i = 0; i < customers; i++) {
//             // Generate random numbers
//             int randomTicketAmount = (int) (Math.random() * 5) + 1;

//             customerThreads[i] = new Thread(new SeatReserver(theatre, randomTicketAmount));
//             customerThreads[i].setName("Customer-" + (i + 1)); // Set a unique name
//             customerThreads[i].start();

//         }

//         // Wait for all threads to complete
//         for (Thread customerThread : customerThreads) {
//             try {
//                 customerThread.join();
//             } catch (InterruptedException e) {
//                 System.err.println("Thread interrupted: " + customerThread.getName());
//             }
//         }

//         System.out.println("All customers have attempted reservations.");
//     }
// }