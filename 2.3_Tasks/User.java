import java.util.ArrayList;

public class User {
    private String name;
    private int age;
    private ArrayList<String> borrowedBooks;

    public User(String name, int age){
        this.name = name;
        this.age = age;
        this.borrowedBooks = new ArrayList<>();
    }

  

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public ArrayList<String> getBorrowedBooks() {
        return borrowedBooks;
    }

    public void borrowBook(Book book) {
        borrowedBooks.add(book.getTitle());
        System.out.println("The user " + this.getName() + " borrowed a book: " + book.getTitle());
    }
}
