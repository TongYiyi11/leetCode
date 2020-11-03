import java.util.*;

public class t17 {
    Map<String, List> table = new HashMap<>();
    public t17(){
        table.put("2", Arrays.asList("a", "b", "c"));
        table.put("3", Arrays.asList("d", "e", "f"));
        table.put("4", Arrays.asList("g", "h", "i"));
        table.put("5", Arrays.asList("j", "k", "l"));
        table.put("6", Arrays.asList("m", "n", "o"));
        table.put("7", Arrays.asList("p", "q", "r", "s"));
        table.put("8", Arrays.asList("t", "u", "v"));
        table.put("9", Arrays.asList("w", "x", "y", "z"));
    }

    public List<String> letterCombinations(String digits){
        List<String> ans = new ArrayList<>();

        if(digits.length() <= 0){
            return ans;
        }

        //note! there's no need to add the combined string to the table
        Map<Integer, String> checkMap = new TreeMap<>();
        for(String key: table.keySet()){
            if(key.length() == 1) continue;
            int startIdx = 0;
            while(digits.indexOf(key, startIdx) != -1){
                checkMap.put(digits.indexOf(key, startIdx), key);
                startIdx = digits.indexOf(key) + key.length();
            }
        }

        List<String> currList;
        int i = 0;
        String currStr, prevStr = "";
        ans.add("");
        while(i < digits.length()){
            if(checkMap.containsKey(i)){
                currStr = checkMap.get(i);
            }else{
                currStr = digits.substring(i, i + 1);
            }
            currList = table.get(currStr);

            int count = ans.size();
            for(int s = 0; s < count; s++){
                String str = ans.remove(0);
                for(String ss: currList){
                    ans.add(str + ss);
                }
            }
            String key = prevStr + currStr;
            if(!table.containsKey(key)){
                table.put(key, ans);
            }
            i += currStr.length();
            prevStr = currStr;
        }

        return ans;
    }

    public static void main(String[] args){
        t17 test = new t17();
        System.out.println(test.letterCombinations("22"));
    }
}
