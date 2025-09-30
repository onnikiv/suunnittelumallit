package prototype;

import java.util.ArrayList;
import java.util.List;

public class Recommendation implements Prototype {

    private final List<Book> books;
    private String targetAudience;

    public Recommendation(String targetAudience, List<Book> books) {
        this.targetAudience = targetAudience;
        this.books = new ArrayList<>(books);
    }

    public void addBook(Book book) {
        books.add(book);
    }

    public void removeBook(Book book) {
        books.remove(book);
    }

    public List<Book> getRecommendedBooks() {
        return new ArrayList<>(books);
    }

    public String getTargetAudience() {
        return targetAudience;
    }

    public void setTargetAudience(String targetAudience) {
        this.targetAudience = targetAudience;
    }

    @Override
    public Recommendation clone() throws CloneNotSupportedException {

        List<Book> clonedBooks = new ArrayList<>();
        for (Book book : books) {
            clonedBooks.add(book.clone());
        }
        return new Recommendation(this.targetAudience, clonedBooks);
    }

    public void displayRecommendations() {
        System.out.println("\n< " + this.targetAudience + " >");
        for (Book book : books) {
            System.out.println(book.getTitle() + " by " + book.getAuthor() + " [" + book.getGenre() + "]");
        }
        System.out.println();
    }
}
