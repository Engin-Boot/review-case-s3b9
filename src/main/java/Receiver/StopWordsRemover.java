package Receiver;

import java.util.HashMap;
import java.util.Map;

public class StopWordsRemover {
	private StopWordsRemover(){}
	public static void removeStopWords(Map<String,Integer> wordListMap)
	{
		Map<String,Integer> tempMap=new HashMap<String,Integer>(wordListMap);
		for(String str:StopWordsFetcher.stopWordsList) {
			if(tempMap.containsKey(str)) {
				wordListMap.remove(str);
			}
		}
	}
}
