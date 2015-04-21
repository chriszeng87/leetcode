import java.util.HashSet;
import java.util.LinkedList;
import java.util.Set;

/**
 * Given two words (start and end), and a dictionary, find the length of shortest transformation sequence from start
 *  to end, such that only one letter can be changed at a time and each intermediate word must exist in the dictionary. 
 *  For example, given:

start = "hit"
end = "cog"
dict = ["hot","dot","dog","lot","log"]
One shortest transformation is "hit" -> "hot" -> "dot" -> "dog" -> "cog", the program should return its length 5.

Note:
Return 0 if there is no such transformation sequence.
All words have the same length.
All words contain only lowercase alphabetic characters.

 * @author Chris
 *
 */
public class WordLadder {
	
    public static int ladderLength(String start, String end, Set<String> dict) {
    	if (dict.size() == 0)
    		return 0;
     
    	dict.add(end);
     
    	LinkedList<String> wordQueue = new LinkedList<String>();
    	LinkedList<Integer> distanceQueue = new LinkedList<Integer>();
     
    	wordQueue.add(start);
    	distanceQueue.add(1);
     
    	//track the shortest path
    	int result = Integer.MAX_VALUE;
    	while (!wordQueue.isEmpty()) {
    		String currWord = wordQueue.pop();
    		Integer currDistance = distanceQueue.pop();
     
    		if (currWord.equals(end)) {
    			result = Math.min(result, currDistance);
    		}
     
    		System.out.println("----------currWord = " + currWord);
    		for (int i = 0; i < currWord.length(); i++) {
    			char[] currCharArr = currWord.toCharArray();
    			for (char c = 'a'; c <= 'z'; c++) {
    				currCharArr[i] = c;
     
    				String newWord = new String(currCharArr);
    				if (dict.contains(newWord)) {
//    					System.out.println("---------dict = " + dict + "  newWord = " + newWord
//    							+"  wordQueue = " + wordQueue);
    					wordQueue.add(newWord);
    					distanceQueue.add(currDistance + 1);

    					dict.remove(newWord);
    					System.out.println("---------dict = " + dict + "  newWord = " + newWord
    							+"  wordQueue = " + wordQueue + " distanceQueue = " + distanceQueue);
    				}
    			}
    		}
    		System.out.println();
    	}
     
    	if (result < Integer.MAX_VALUE)
    		return result;
    	else
    		return 0;
    }

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		//"hot","dot","dog","lot","log"
		Set<String> dict = new HashSet<String>();
		dict.add("hot");
		dict.add("dot");
		dict.add("dog");
		dict.add("lot");
		dict.add("log");
		
		int minlen = ladderLength("hit","cog",dict);

	}

}
