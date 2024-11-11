package Tasks3_3.task3.Library.model;

public class Book {
    private String title;
    private String author;
    private int ISBN; 

    private boolean reserved;

    public Book(String title, String author, int ISBN) {
        this.title = title;
        this.author = author;
        this.ISBN = ISBN;
        this.reserved = false;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public int getISBN() {
        return ISBN;
    }

    public boolean isReserved() {
        return reserved;
    }

    public void setReserved(boolean condition) {
        this.reserved = condition;
    }
}
