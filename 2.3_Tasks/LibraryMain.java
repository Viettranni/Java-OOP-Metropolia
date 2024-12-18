public class LibraryMain {
    public static void main(String[] args) {
        // Creating new books
        Book firstBook = new Book("Five Things", "Viet", 2010);
        Book secondBook = new Book("Pumpking", "Ivan", 2020);
        Book thirdBook = new Book("Cat and Mouse", "Saed", 2018);
        Book fourthBook = new Book("Micky Moo", "Pavel", 1999);

        // Creating new users
        User firstUser = new User("Viet", 24);
        User secondUser = new User("Alice", 25);

        Library turkuLibrary = new Library();

        // Adding books to the library
        turkuLibrary.addBook(firstBook);
        turkuLibrary.addBook(secondBook);
        turkuLibrary.addBook(thirdBook);

        // Adding the users to the library "Database"
        turkuLibrary.addUser(firstUser);
        turkuLibrary.addUser(secondUser);

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

        // Setting and displaying the rating
        secondBook.setRating(4.3);
        System.out.println("Rating for '" + secondBook.getTitle() + "': " + secondBook.getRating());

        // Setting and displaying the review
        secondBook.setReview("The book is awesome!");
        secondBook.setReview("The book is fantastic!");
        thirdBook.setReview("The book is scary!");
        secondBook.displayReviews();

        // Calculating the AVG rating of the library
        turkuLibrary.getAverageBookRating();

        // Get most revied book from the turku library
        turkuLibrary.getMostReviewedBook();

        // Users doing their thing
        firstUser.borrowBook(secondBook);
        secondUser.borrowBook(thirdBook);
        secondUser.borrowBook(fourthBook);

        // Display the users and what they borrowed
        turkuLibrary.displayUsers();

    }
}
