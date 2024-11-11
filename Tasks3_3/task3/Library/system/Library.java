package Tasks3_3.task3.Library.system;

import Tasks3_3.task3.Library.model.Book;
import Tasks3_3.task3.Library.model.LibraryMember;

import java.util.List;
import java.util.ArrayList;

public class Library {
    private List<Book> books;
    private List<LibraryMember> members;

    public Library() {
        books = new ArrayList<>();
        members = new ArrayList<>();
    }

    // Method for adding a book to the library
    public void addBook(Book book) {
        books.add(book);
    }

    public void addMembers(LibraryMember member) {
        members.add(member);
    }

    public void borrowBooks(String bookTitle, String memberID) {
        Book bookToBorrow = findBookByTitle(bookTitle);
        LibraryMember member = findMemberById(memberID);

        if (bookToBorrow != null && member != null) {
            member.borrowBook(bookToBorrow);
            books.remove(bookToBorrow);
            System.out.println(member.getName() + " borrowed " + bookToBorrow.getTitle() + " successfully!");
        } else {
            System.out.println("Failed to borrow the book");
        }
    }

    public void returnBook(String bookTitle, String memberID) {
        Book bookToReturn = findBookByTitle(bookTitle);
        LibraryMember member = findMemberById(memberID);

        if (bookToReturn == null && member != null) {
            member.returnBook(bookToReturn);
            books.add(bookToReturn);
            System.out.println("Book returned successfully!");
        } else {
            System.out.println("Failed to return the book");
        }
    }

    private Book findBookByTitle(String title) {
        for (Book book : books) {
            if (book.getTitle().equalsIgnoreCase(title)) {
                return book;
            }
        }
        return null;
    }

    private LibraryMember findMemberById(String id) {
        for (LibraryMember member : members) {
            if (member.getMemberID().equals(id)) {
                return member;
            }
        }
        return null;
    }

    public void reserveBook(LibraryMember member, Book book) {
        if (!book.isReserved()) {
            book.setReserved(true);
            member.addReservedBook(book);
            System.out.println("Book reserved successfully.");
        } else {
            System.out.println("Book is already reserved.");
        }
    }

    public void cancelReservation(LibraryMember member, Book book) {
        if (book.isReserved() && member.hasReservedBook(book)) {
            book.setReserved(false);
            member.removeReservedBook(book);
            System.out.println("Reservation canceled successfully.");
        } else {
            System.out.println("Book was not reserved by this member.");
        }
    }

    public void displayReservedBooks(LibraryMember member) {
        System.out.println("Reserved books for " + member.getName() + ":");
        for (Book book : member.getReservedBooks()) {
            System.out.println(book.getTitle());
        }
    }

}
