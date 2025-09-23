import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

class Movies implements Comparable<Movies> {

    public String movieName;
    public double price;

    Movies(String movieName, double price) {
        this.movieName = movieName;
        this.price = price;
    }

    @Override
    public String toString() {
        return "Movie Name : " + this.movieName + " price : " + this.price;
    }

    @Override
    public int compareTo(Movies o) {
        // Example: compare by movie name lexicographically
        return this.movieName.compareTo(o.movieName);
    }

    // @Override
    // public int compareTo(Movies o) {

    //     if (this.movieName.length() == o.movieName.length()) {
    //         return 0;
    //     }
    //     if (this.movieName.length() < o.movieName.length()) {
    //         return 1;
    //     }
    //     if (this.movieName.length() > o.movieName.length()) {
    //         return -1;
    //     }
    //     return 0;

    // }
    // @Override
    // public int compareTo(Movies o) {

    //     if (this.movieName.length() == o.movieName.length()) {
    //         return 0;
    //     }
    //     if (this.movieName.length() < o.movieName.length()) {
    //         return 1;
    //     }
    //     if (this.movieName.length() > o.movieName.length()) {
    //         return -1;
    //     }
    //     return 0;

    // }


    // public int compareTo(Movies o) {

    // if (this.price == o.price) {
    // return 0;
    // }
    // if (this.price < o.price) {
    // return -1;
    // }
    // if (this.price > o.price) {
    // return 1;
    // }
    // return 0; // Default return to satisfy all code paths
    // }
  
    Comparator<Movies> sortByName = (m1, m2) -> m1.movieName.compareTo(m2.movieName);


}

public class P1_C_CompareTo {
    

    public static void main(String[] args) {

        ArrayList<Movies> movies = new ArrayList<>();
        movies.add(new Movies("KGF", 345));
        movies.add(new Movies("kantara", 753));
        movies.add(new Movies("bahubali", 34523));
        movies.add(new Movies("salaar", 345345));
        movies.add(new Movies("vedalam", 45));

        Collections.sort(movies);

        System.out.println(movies);

    }
}
