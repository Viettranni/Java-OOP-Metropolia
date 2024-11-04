import java.util.ArrayList;

public class Library {
    private ArrayList<Book> books = new ArrayList<>();

    public void addBook(Book book) {
        books.add(book);
        System.out.println("Adding the book: " + book.getTitle());
    }

    public void displayBooks() {
        System.out.println("We will open the book features:");

        for (Book book : books) {
            System.out.println("The book's title: " + book.getTitle() + ", Author: " + book.getAuthor()
                    + ", Publication Year: " + book.getPublicationYear());
        }
    }

    public void findBooksByAuthor(String author) {
        boolean found = false;
        for (Book book : books) {
            if (book.getAuthor().equals(author)) {
                System.out.println("You were searching for the Author " + book.getAuthor());
                System.out.println("The details are: Title - " + book.getTitle() + ", Publication Year - " + book.getPublicationYear() + "\n");
                found = true;
            } 
        }
        if(!found) {
        System.out.println("We couldn't find any books with the author: " + author);
        }
    }

    public void borrowBook(String title) {
        System.out.println("Welcome to our Library! You came to borrow a book.");

        // Checking if the book is available
        for (int i = 0; i < books.size(); i++) {
            if (books.get(i).getTitle().equals(title)) {
                books.remove(i);
                System.out.println("The book " + books.get(i).getTitle() + " was borrowed successfully!");
                break; // Exits the loop when wound
            }
        }
    }

    public void returnBook(Book book) {
        System.out.println("Welcome to our Library! You came to return the book.");
        System.out.println("Which book would you like to return?");
        // Check if the book is already in the library
        if (books.contains(book)) {
            System.out.println("This book is already in the library, you can't return it.");
            return; // Exit if the book is already present
        }
        books.add(book);
        System.out.println("You have returned the book: " + book.getTitle());
    }

}
