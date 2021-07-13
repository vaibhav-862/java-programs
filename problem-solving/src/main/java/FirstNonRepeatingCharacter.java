import java.util.HashMap;
import java.util.Map;

/*
    https://www.youtube.com/watch?v=5co5Gvp_-S0
 */

public class FirstNonRepeatingCharacter {

    public static void main(String[] args) {
        String s = "leetcode";

        int result = firstNonRepeatingCharBruteForce(s);
        System.out.println("Unique char's index thru brute force : " + result);

        s = "loveleetcode";
        result = firstNonRepeatingCharHashMap(s);
        System.out.println("Unique char's index thru hashmap ds : " + result);

        s = "loveleetcode";
        result = firstUniqCharIndexAlphabeticArray(s);
        System.out.println("Unique char's index thru alphabetic array : " + result);

        s = "loveleetcode";
        result = firstUniqCharIndexFunction(s);
        System.out.println("Unique char's index thru index function : " + result);
    }

    private static int firstNonRepeatingCharBruteForce(String s) {
        int result = -1;

        for(int i = 0; i < s.length(); i++) {
            boolean repetitive = false;
            for(int j = 0; j < s.length(); j++) {
                if(i != j && !repetitive) {
                    if(s.charAt(i) == s.charAt(j))
                        repetitive = true;
                }
            }
            if(!repetitive) {
                result = i;
                break;
            }
        }

        return result;
    }

    private static int firstNonRepeatingCharHashMap(String s) {
        int result = -1;

        Map<Character, Integer> map = new HashMap<>();

        for(int i = 0; i < s.length(); i++) {
            if(map.containsKey(s.charAt(i))) {
                map.put(s.charAt(i), map.get(s.charAt(i)) + 1);
            } else
                map.put(s.charAt(i), 1);
        }

        for(int i = 0; i < s.length(); i++) {
            if(map.get(s.charAt(i)) == 1) {
                result = i;
                break;
            }
        }
        return result;
    }

    private static int firstUniqCharIndexAlphabeticArray(String s) {
        int result = -1;

        int[] alphabeticArray = new int[26];

        for(int i = 0; i < s.length(); i++) {
            alphabeticArray[s.charAt(i) - 'a']++;
        }

        for(int i = 0; i < s.length(); i++) {
            if(alphabeticArray[s.charAt(i) - 'a'] == 1) {
                result = i;
                break;
            }
        }
        return result;
    }

    private static int firstUniqCharIndexFunction(String s) {
        int result = -1;

        for(int i = 0; i < s.length(); i++) {
            if(s.indexOf(s.charAt(i)) == s.lastIndexOf(s.charAt(i))) {
                result = i;
                break;
            }
        }

        return result;
    }

}
