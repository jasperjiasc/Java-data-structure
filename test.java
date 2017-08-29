import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.TreeMap;

public class test {

    public static void main(String[] args){
        UserMovieRating aaa=new UserMovieRating("movie1",5);
        UserMovieRating bbb=new UserMovieRating("movie1",8);
        UserMovieRating ccc=new UserMovieRating("movie2",6);
        List<UserMovieRating> rattings=new ArrayList<UserMovieRating>();

        rattings.add(aaa);
        rattings.add(bbb);
        rattings.add(ccc);



        TreeMap<String, PriorityQueue<Integer>> map1=MovieRatingsParser.parseMovieRatings(rattings);

        List<String> names= new ArrayList<String>();
               names= MovieRatingsProcessor.getAlphabeticalMovies(map1);


    }
}
