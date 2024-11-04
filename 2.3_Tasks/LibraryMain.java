public class LibraryMain {
    public static void main(String[] args) {
        Book firstBook = new Book("Five Things", "Viet", 2010);
        Book secondBook = new Book("Pumpking", "Ivan", 2020);
        Book thirdBook = new Book("Cat and Mouse", "Saed", 2018);

        Library turkuLibrary = new Library();

        turkuLibrary.addBook(firstBook);
        turkuLibrary.addBook(secondBook);
        turkuLibrary.addBook(thirdBook);

        turkuLibrary.displayBooks();

        turkuLibrary.findBooksByAuthor("Viet");
        turkuLibrary.findBooksByAuthor("someone");
    }
}
