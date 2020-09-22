package Receiver;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.StringTokenizer;
import java.util.TreeSet;

public class WordCount {
	public static Map<String,Integer> wordCount=new HashMap<String,Integer>();
	public static Set<String> Tokenizer(String review){
		Set<String> setOfWordsInReview=new TreeSet<String>();
		StringTokenizer st=new StringTokenizer(review," ");
		while(st.hasMoreTokens()) {
			String s=st.nextToken();
			setOfWordsInReview.add(s);
		}
		return setOfWordsInReview;
	}
	public static void countOccuranceOfWord(String review) {
		Set<String> wordSet=new TreeSet<String>();
		wordSet=Tokenizer(review);
		for(String word:wordSet){
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
