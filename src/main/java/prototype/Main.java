package prototype;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        Book book1 = new Book("J.K. Rowling", "Harry Potter ja Viisasten kivi", "Fantasia", 1997);
        Book book2 = new Book("J.R.R. Tolkien", "Taru sormusten herrasta", "Fantasia", 1954);
        Book book3 = new Book("Sofi Oksanen", "Puhdistus", "Draama", 2008);
        Book book4 = new Book("Mika Waltari", "Sinuhe egyptiläinen", "Draama", 1945);

        List<Book> books = new ArrayList<>();
        books.add(book1);
        books.add(book2);
        books.add(book3);
        books.add(book4);

        Recommendation mustReadRecommendation = new Recommendation("MUST READ", books);
        mustReadRecommendation.displayRecommendations();

        System.out.println("Adding a new book...");
        mustReadRecommendation.addBook(new Book("George Orwell", "Vuonna 1984", "Dystopia", 1949));
        mustReadRecommendation.displayRecommendations();

        System.out.println("Removing the first book...");
        mustReadRecommendation.removeBook(books.get(0));
        mustReadRecommendation.displayRecommendations();

        try {
            Recommendation teenRecommendation = mustReadRecommendation.clone();
            teenRecommendation.setTargetAudience("TEENS");
            teenRecommendation.removeBook(book3);
            teenRecommendation.addBook(new Book("Suzanne Collins", "Nälkäpeli", "Seikkailu", 2008));
            System.out.println("\n--- Cloned and Modified Recommendation ---");
            teenRecommendation.displayRecommendations();
            System.out.println("\n--- Original Recommendation ---");
            mustReadRecommendation.displayRecommendations();
        } catch (CloneNotSupportedException e) {
            System.out.println("Cloning failed: " + e.getMessage());
        }

    }
}
