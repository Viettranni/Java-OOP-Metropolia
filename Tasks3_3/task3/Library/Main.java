package Tasks3_3.task3.Library;

import Tasks3_3.task3.Library.model.Book;
import Tasks3_3.task3.Library.model.LibraryMember;
import Tasks3_3.task3.Library.system.Library;

public class Main {
    public static void main(String[] args) {
        // Creating instance of the Library
        Library uniqueLibrary = new Library();

        // Adding books to the library
        Book ironman = new Book("ironman", "pekka", 41234);
        Book hulk = new Book("hulk", "arttu", 241413);
        uniqueLibrary.addBook(ironman);
        uniqueLibrary.addBook(hulk);

        // Adding members to the library
        LibraryMember viet = new LibraryMember("Viet", "41234");
        LibraryMember jenna = new LibraryMember("Jenna", "5234");
        uniqueLibrary.addMembers(viet);
        uniqueLibrary.addMembers(jenna);

        // Jenna borrows book
        uniqueLibrary.borrowBooks("hulk", "5234");

        // She tries to do that agan but will be expecting to fail
        uniqueLibrary.borrowBooks("hulk", "5234");

        // Jenna returns the book back
        uniqueLibrary.returnBook("hulk", "5234");

        // Book reservation part
        uniqueLibrary.reserveBook(jenna, hulk);

        // Book should be reserved
        uniqueLibrary.reserveBook(viet, hulk);

        // Display reservations
        uniqueLibrary.displayReservedBooks(jenna);

        // Cancelling reservations 
        uniqueLibrary.cancelReservation(jenna, hulk);
    }
}
