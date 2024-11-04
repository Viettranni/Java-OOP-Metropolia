public class LibraryMain {
    public static void main(String[] args) {
        Book firstBook = new Book("Five Things", "Viet", 2010);
        Book secondBook = new Book("Pumpking", "Ivan", 2020);
        Book thirdBook = new Book("Cat and Mouse", "Saed", 2018);
        Book fourthBook = new Book("Micky Moo", "Pavel", 1999);

        Library turkuLibrary = new Library();

        // Adding books to the library
        turkuLibrary.addBook(firstBook);
        turkuLibrary.addBook(secondBook);
        turkuLibrary.addBook(thirdBook);

        // Displaying all books
        turkuLibrary.displayBooks();

        // Finding books by specific authors
        turkuLibrary.findBooksByAuthor("Viet");
        turkuLibrary.findBooksByAuthor("someone");

        // Borrowing a book
        turkuLibrary.borrowBook("Five Things");

        // Returning a different book (for demonstration)
        turkuLibrary.returnBook(fourthBook);

        // Displaying books after borrowing and returning
        turkuLibrary.displayBooks();

        // Checking if the book is available
        turkuLibrary.isBookAvailable("Pumpking");
    }
}
