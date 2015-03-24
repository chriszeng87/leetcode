import java.util.HashSet;
import java.util.LinkedList;

/**
 * Given two words (start and end), and a dictionary, find the length of shortest transformation sequence from start to end, such that:

Only one letter can be changed at a time
Each intermediate word must exist in the dictionary
For example,

Given:

start = "hit"
end = "cog"
dict = ["hot","dot","dog","lot","log"]
As one shortest transformation is "hit" -> "hot" -> "dot" -> "dog" -> "cog", the program should return its length 5.

Note:
Return 0 if there is no such transformation sequence.
All words have the same length.
All words contain only lowercase alphabetic characters.
 * @author Chris
 *
 */
public class WordLadder {
	
//	  public static int ladderLength(String start, String end, HashSet<String> dict) {
//		  
//	        int len=0;
//	        HashSet<String> visited = new HashSet<String>();
//	 
//	        for(int i=0; i<start.length(); i++){
//	            char[] startArr = start.toCharArray();
//	 
//	            for(char c='a'; c<='z'; c++){
//	                if(c==start.toCharArray()[i]){
//	                    continue;
//	                }
//	 
//	                startArr[i] = c;
//	                String temp = new String(startArr);
//	                if(dict.contains(temp)){
//	                    len++;
//	                    start = temp;
//	                    if(temp.equals(end)){
//	                        return len;
//	                    }
//	                }
//	            }
//	        }
//	 
//	        return len;
//	    }
	  
	  
	  /**
	   * 
	   * @param start
	   * @param end
	   * @param dict
	   * @return
	   */
	  public static int ladderLength2(String start, String end, HashSet<String> dict) {
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
					System.out.println("result = " + result);
				}
		 
				for (int i = 0; i < currWord.length(); i++) {
					char[] currCharArr = currWord.toCharArray();
					for (char c = 'a'; c <= 'z'; c++) {
						currCharArr[i] = c;
		 
						String newWord = new String(currCharArr);
						if (dict.contains(newWord)) {
							wordQueue.add(newWord);
							distanceQueue.add(currDistance + 1);
							dict.remove(newWord);
						}
					}
				}
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
		// TODO Auto-generated method stub
		String start = new String("hit");
		String end = new String("cog");
		HashSet<String> dict = new HashSet<String>();
//		dict = ["hot","dot","dog","lot","log"]
		dict.add("hot");
		dict.add("dot");
		dict.add("dog");
		dict.add("lot");
		dict.add("log");
//		System.out.println(ladderLength(start, end, dict));
		System.out.println(ladderLength2(start, end, dict));

	}

}
