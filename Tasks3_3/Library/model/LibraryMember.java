package Tasks3_3.Library.model;
import java.util.List;
import java.util.ArrayList;


public class LibraryMember {
    private String name;
    private String memberID;
    private List<Book> borrowedBooks;

    public LibraryMember(String name, String memberID) {
        this.name = name;
        this.memberID = memberID;
        this.borrowedBooks = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public String getMemberID() {
        return memberID;
    }

    public void borrowBook(Book book) {
        borrowedBooks.add(book);
    }

    public void returnBook(Book book) {
        borrowedBooks.remove(book);
    } 

}
