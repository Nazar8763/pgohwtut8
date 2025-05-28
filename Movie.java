import java.util.ArrayList;
import java.util.List;

public class Movie implements MediaItem, Rentable, Rateable {
    private String title;
    private String director;
    private int releaseYear;
    private int duration;
    private boolean available;
    private List<Integer> ratings;

    public Movie(String title, String director, int releaseYear, int duration) {
        this.title = title;
        this.director = director;
        this.releaseYear = releaseYear;
        this.duration = duration;
        this.available = true;
        this.ratings = new ArrayList<>();
    }

    @Override
    public String getTitle() {
        return title;
    }

    @Override
    public int getYear() {
        return releaseYear;
    }

    @Override
    public String getDisplayString() {
        return "Movie: " + title + " directed by " + director + " (" + releaseYear + "), Duration: " + duration + " mins";
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

    @Override
    public void addRating(int stars) {
        if (stars >= 1 && stars <= 5) {
            ratings.add(stars);
        }
    }

    @Override
    public double getAverageRating() {
        if (ratings.isEmpty()) return 0.0;
        int sum = 0;
        for (int rating : ratings) {
            sum += rating;
        }
        return Math.round((double) sum / ratings.size() * 10) / 10.0;
    }
}
