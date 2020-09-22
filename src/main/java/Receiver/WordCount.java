package Receiver;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.StringTokenizer;
public class WordCount {
	private WordCount(){}
	public static Map<String,Integer> wordCount=new HashMap<String,Integer>();
	public static PriorityQueue<String> Tokenizer(String review){
		PriorityQueue<String> setOfWordsInReview=new PriorityQueue<String>();
		StringTokenizer st=new StringTokenizer(review," ");
		while(st.hasMoreTokens()) {
			String s=st.nextToken();
			setOfWordsInReview.add(s);
		}
		return setOfWordsInReview;
	}
	public static void countOccuranceOfWord(String review) {
		PriorityQueue<String> wordQueue=new PriorityQueue<String>();
		review=review.replaceAll("[\\p{Punct}&&[^/]]+", "").toLowerCase();
		wordQueue=Tokenizer(review);
		for(String word:wordQueue){
			if(!wordCount.containsKey(word)) {
				wordCount.put(word, 1);
			}
			else{
			int count=wordCount.get(word);
			wordCount.put(word, count+1);
			}
		}
	}
}
