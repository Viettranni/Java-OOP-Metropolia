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

    public boolean isBookAvailable(String title) {
        System.out.println("Checking the books availablity: ");

        for (int i = 0; i < books.size(); i++) {
            if (books.get(i).getTitle().equals(title)) {
                System.out.println("The book " + books.get(i).getTitle() + " is still available. Would you like to borrow it?");
                return true;
            }
        }
        System.out.println("The book " + title + " is not available!");
        return false;
    }

    public void getAverageBookRating() {
        double totalRatings = 0;
        int countBooks = 0;
        
        for (Book book : books) {
            double rating = book.getRating();
            totalRatings += rating;
            countBooks++;
        }

        // Checking if there are more than one book and then it calculates the average
        if (countBooks > 0) {
            double averageRating = totalRatings / countBooks;
            System.out.println("The average rating is: " + averageRating);
        } else {
            System.out.println("There are no books in the library");
        }
    }

    public void getMostReviewedBook() {
        int topReviews = 0;
        Book topBook = null;

        for (Book book : books) {
            if (book.getReviewsSize() > topReviews) {
                topReviews = book.getReviewsSize();
                topBook = book;
            }
        }

        if (topBook != null) {
            System.out.println("The book with the most reviews is: " + topBook.getTitle() + " with " + topReviews + " reviews.");
        } else {
            System.out.println("No books in the library have reviews.");
        }
    }

}
