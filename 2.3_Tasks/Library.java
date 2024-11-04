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

}
