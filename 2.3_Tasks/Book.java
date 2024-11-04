import java.util.ArrayList;

public class Book {
    private String title;
    private String author;
    private int publicationYear;
    private double rating;
    private ArrayList<String> reviews;

    public Book(String title, String author, int publicationYear) {
        this.title = title;
        this.author = author;
        this.publicationYear = publicationYear;
        this.reviews = new ArrayList<>(); 
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public int getPublicationYear() {
        return publicationYear;
    }

    public void setRating(double rating) {
        if (rating >= 0 && rating <= 5) {
            this.rating = rating;
        } else {
            System.out.println("Please give the rating within 0-5");
        }
    }

    public void setReview(String review) {
        reviews.add(review);
    }

    public double getRating() {
        return rating;
    }

    public void displayReviews() {
        System.out.println("Here are the reviews for the book: ");
        for (String review : reviews) {
            System.out.println(review);
        }
    }

    public int getReviewsSize() {
        return reviews.size();
    }


}
