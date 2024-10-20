package hashing;

import java.util.HashMap;
import java.util.Map;

//Character Hashing
//using basic brut force approach
public class Hashing1 {
    public static void main(String[] args) {
        String str = "abcdedahejhhh";
        //find count of a 
        function('a', str);
    }

    private static void function(char cValue, String str) {
        int iCnt = 0;
        Map<Character, Integer> map = new HashMap<>();
        for(int i = 0; i < str.length(); i++) {
            iCnt = 0;
            for(int j = 0; j < str.length(); j++) {
                if(str.charAt(i) == str.charAt(j)) {
                    iCnt++;
                }
            }
            map.put(str.charAt(i), iCnt);
        }
        System.out.println(map);
    }
}
