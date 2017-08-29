/*
 * SD2x Homework #5
 * Implement the methods below according to the specification in the assignment description.
 * Please be sure not to change the method signatures!
 */

import com.sun.javafx.scene.control.skin.VirtualFlow;

import java.util.*;


public class MovieRatingsProcessor {

	public static List<String> getAlphabeticalMovies(TreeMap<String, PriorityQueue<Integer>> movieRatings) {
		/* IMPLEMENT THIS METHOD! */
		public static List<String> getAlphabeticalMovies (TreeMap < String, PriorityQueue < Integer >> movieRatings){

		/* IMPLEMENT THIS METHOD! */
			List<String> arr1 = new ArrayList<String>();
			if (movieRatings == null || movieRatings.isEmpty()) return arr1;
			PriorityQueue<String> alphaMovie = new PriorityQueue<String>();
			for (Map.Entry<String, PriorityQueue<Integer>> entry : movieRatings.entrySet()) {
				alphaMovie.add(entry.getKey());
			}
			arr1 = new ArrayList<String>(alphaMovie);
			return arr1;
		}

		public static List<String> getAlphabeticalMoviesAboveRating
		(TreeMap < String, PriorityQueue < Integer >> movieRatings,int rating){
		
		/* IMPLEMENT THIS METHOD! */
			List<String> movieAboveRating = new ArrayList<String>();
			if (movieRatings == null || movieRatings.isEmpty()) return movieAboveRating;
			for (Map.Entry<String, PriorityQueue<Integer>> entry : movieRatings.entrySet()) {
				if (entry.getValue().poll() > rating) {
					movieAboveRating.add(entry.getKey());
				}
			}
			return movieAboveRating;







		/*List<String> arr1 = new ArrayList<String>();
			if (movieRatings == null || movieRatings.isEmpty()) return arr1;
			PriorityQueue<String> alphaMovie = new PriorityQueue<String>();
			for (Map.Entry<String,PriorityQueue<Integer>> entry : movieRatings.entrySet()){
				if(entry.getValue().size()>0 & entry.getValue().peek()>rating) alphaMovie.add(entry.getKey());
			}
			arr1= new ArrayList<String>(alphaMovie);
			return arr1;*/
		}

		public static TreeMap<String, Integer> removeAllRatingsBelow (TreeMap < String, PriorityQueue < Integer >> movieRatings,int rating){
			TreeMap<String, Integer> nMap = new TreeMap<String, Integer>();
			List<String> temp=new ArrayList<String>();
			if (movieRatings == null || movieRatings.isEmpty()) return nMap;
			for (Map.Entry<String, PriorityQueue<Integer>> entry : movieRatings.entrySet()) {
				int count = 0;
				while (!entry.getValue().isEmpty() && entry.getValue().peek() < rating) {
					entry.getValue().poll();
					count++;
				}
				if(count>0)	nMap.put(entry.getKey(), count);
				if(entry.getValue().isEmpty()) temp.add(entry.getKey());
			}
			if (movieRatings == null || movieRatings.isEmpty()) return nMap;
			movieRatings.remove(temp);
			return nMap;

		}

	}
}








			/*TreeMap<String,Integer> aaaa = new TreeMap<String, Integer>();
			if (movieRatings == null || movieRatings.isEmpty()) return aaaa;

			for (Map.Entry<String,PriorityQueue<Integer>> entry : movieRatings.entrySet()){
				if(entry.getValue().peek()>= rating) continue;
				int count=0;
				while(entry.getValue().size()>0 && entry.getValue().peek()< rating){
					entry.getValue().poll();
					count++;
				}
				aaaa.put(entry.getKey(),count);
				if(entry.getValue().isEmpty()) movieRatings.remove(entry.getKey());

			}

			return aaaa;
		}*/

