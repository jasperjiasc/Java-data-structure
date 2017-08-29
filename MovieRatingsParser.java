/*
 * SD2x Homework #5
 * Implement the method below according to the specification in the assignment description.
 * Please be sure not to change the method signature!
 */

import java.util.List;
import java.util.PriorityQueue;
import java.util.TreeMap;

public class MovieRatingsParser {

	public static TreeMap<String, PriorityQueue<Integer>> parseMovieRatings(List<UserMovieRating> allUsersRatings) {


		/* IMPLEMENT THIS METHOD! */
		//PriorityQueue<Integer> pQueue = new PriorityQueue<Integer>();
		TreeMap<String, PriorityQueue<Integer>> tMap = new TreeMap<String, PriorityQueue<Integer>>();
		if (allUsersRatings == null || allUsersRatings.isEmpty()) return tMap;


		for (int i = 0; i < allUsersRatings.size(); i++) {
			if (allUsersRatings.get(i) == null || allUsersRatings.get(i).movie == null || allUsersRatings.get(i).movie == "" ||allUsersRatings.get(i).userRating < 0 ) {
				continue;
			}
			allUsersRatings.get(i).movie = allUsersRatings.get(i).movie.toLowerCase();
			if (!tMap.containsKey(allUsersRatings.get(i).movie)){
				PriorityQueue<Integer> pQueue = new PriorityQueue<Integer>();
				pQueue.add(allUsersRatings.get(i).userRating);
				tMap.put(allUsersRatings.get(i).movie, pQueue);
			} else {
				tMap.get(allUsersRatings.get(i).movie).add(allUsersRatings.get(i).userRating);
			}
		}
		return tMap;// this line is here only so this code will compile if you don't modify it
	}
}
