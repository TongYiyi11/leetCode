import java.util.*;

public class t30 {
    public List<Integer> findSubstring(String s, String[] words){
        List<Integer> ans = new ArrayList<>();
        if(words.length == 0 || s.length() == 0) return ans;
        int wLen = words[0].length();
        int wNum = words.length;
        if(s.length() < wLen * wNum) return ans;
        HashMap<String, Integer> wordFrequency = new HashMap<>();
        for(String word : words){
            wordFrequency.put(word, wordFrequency.getOrDefault(word, 0) + 1);
            if(s.indexOf(word) == -1) return ans;
        }

        int left, right;
        for(int i = 0; i < wLen; i++){
            left = i;
            right = i;
            HashMap<String, Integer> subMap = new HashMap<>();
            int count = 0;
            while(right < s.length() - wLen + 1){
                String currStr = s.substring(right, right + wLen);
                right += wLen;
                if(wordFrequency.containsKey(currStr)){
                    count += 1;
                    subMap.put(currStr, subMap.getOrDefault(currStr, 0) + 1);
                    while(subMap.get(currStr) > wordFrequency.get(currStr)){
                        String removeStr = s.substring(left, left + wLen);
                        subMap.put(removeStr, subMap.getOrDefault(removeStr, 0) - 1);
                        count -= 1;
                        left += wLen;
                    }
                }else{
                    count = 0;
                    subMap.clear();
                    left = right;
                }
                if(count == wNum){
                    ans.add(left);
                    String removeStr = s.substring(left, left + wLen);
                    subMap.put(removeStr, subMap.getOrDefault(removeStr, 0) - 1);
                    left += wLen;
                    count -= 1;
                }
            }
        }
        return ans;
    }

    public static void main(String[] args){
        String s = "barfoofoobarthefoobarman";
        String[] words = new String[]{"bar", "foo", "the"};
        t30 test = new t30();
        test.findSubstring(s, words);
    }
}
