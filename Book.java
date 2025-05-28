public class Book implements MediaItem, Rentable {
    private String title;
    private String author;
    private int publicationYear;
    private String isbn;
    private boolean available;

    public Book(String title, String author, int publicationYear, String isbn) {
        this.title = title;
        this.author = author;
        this.publicationYear = publicationYear;
        this.isbn = isbn;
        this.available = true;
    }

    @Override
    public String getTitle() {
        return title;
    }

    @Override
    public int getYear() {
        return publicationYear;
    }

    @Override
    public String getDisplayString() {
        return "Book: " + title + " by " + author + " (" + publicationYear + "), ISBN: " + isbn;
    }

    @Override
    public boolean isAvailable() {
        return available;
    }

    @Override
    public boolean rent() {
        if (available) {
            available = false;
            return true;
        }
        return false;
    }

    @Override
    public void returnItem() {
        available = true;
    }
}
