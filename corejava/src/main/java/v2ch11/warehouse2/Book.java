package v2ch11.warehouse2;

/**
 * A book is a product with an ISBN number.
 *
 * @author Cay Horstmann
 * @version 1.0 2007-10-09
 */
public class Book extends Product {
    private String isbn;

    public Book(String title, String isbn, double price) {
        super(title, price);
        this.isbn = isbn;
    }

    public String getDescription() {
        return super.getDescription() + " " + isbn;
    }
}
