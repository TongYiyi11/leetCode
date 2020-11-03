import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

/*
sliding window: no need to remove the items which are out of the window!
Just renew the start and end index of the slinding window!
HashMap is faster than ArrayList!
 */

public class t3 {
//    public int lengthOfLongestSubstring(String s){
//        int maxLength = 0;
//        ArrayList<Character> charList = new ArrayList<>();
//        int i = 0, j = 0;
//        int rep = 0;
//        for(; j < s.length(); j++){
//            char c = s.charAt(j);
//            if(charList.contains(c)){
//                int index = charList.indexOf(c);
//                maxLength = Math.max(j - i, maxLength);
//                i = Math.max(index + rep + 1, i);
//                charList.remove(index);
//                rep += 1;
//            }
//            charList.add(c);
//        }
//        maxLength = Math.max(j - i, maxLength);
//        return maxLength;
//    }

    public int lengthOfLongestSubstring(String s){
        int maxLength = 0;
        HashMap<Character, Integer> charMap = new HashMap<>();
        int i = 0, j = 0;
        for(; j < s.length(); j++){
            char c = s.charAt(j);
            if(charMap.containsKey(c)){
                maxLength = Math.max(j - i, maxLength);
                i = Math.max(charMap.get(c) + 1, i);  //notice! check if the character is within the sliding window
                charMap.replace(c, j);
            }else{
                charMap.put(c, j);
            }
        }
        maxLength = Math.max(j - i, maxLength);
        return maxLength;
    }

    public static void main(String args[]){
        t3 test = new t3();
        System.out.println(test.lengthOfLongestSubstring("abcabcbb"));
    }

}
