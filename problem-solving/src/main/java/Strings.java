import javax.sound.midi.Soundbank;

/*
    LeetCode problem : https://leetcode.com/problems/valid-anagram/
    Valid Anagram solution : https://www.youtube.com/watch?v=IRN1VcA8CGc

    LeetCode problem : https://leetcode.com/problems/maximum-number-of-balloons/
    Max no of Balloon solution : https://www.youtube.com/watch?v=dkLoTol7Cvw

    LeetCode problem : https://leetcode.com/problems/longest-common-prefix/
    Longest Common Prefix solution : https://www.youtube.com/watch?v=bl8ue-dTxgs
 */
public class Strings {

    public static void main(String[] args) {
        //////////////////////////////////////////////////////
        //               Valid Anagrams                     //
        //////////////////////////////////////////////////////
        String s = "anagram";
        String t = "nagaram";

        boolean result = isAnagram(s, t);
        System.out.println("Both strings " + s + " and " + t + " are anagram : " + result);

        result = isAnagram("rat", "car");
        System.out.println("Strings are anagram : " + result);

        //////////////////////////////////////////////////////
        //                Maximum Balloons                  //
        //////////////////////////////////////////////////////
        int answer = maxNumberOfBalloons("nlaebolko");
        System.out.println("Maximum no of balloons in above string is : " + answer);

        answer = maxNumberOfBalloons("loonbalxballpoon");
        System.out.println("Maximum no of balloons in above string is : " + answer);

        answer = maxNumberOfBalloons("leetcode");
        System.out.println("Maximum no of balloons in above string is : " + answer);

        //////////////////////////////////////////////////////
        //                Longest Common Prefix             //
        //////////////////////////////////////////////////////
        String[] strArray = {"flower","flow","flight"};
        String prefix = longestCommonPrefix(strArray);
        System.out.println("Longest common prefix is : " + prefix);

        String[] strArray1 = {"dog","racecar","car"};
        System.out.println("Longest common prefix is : " + longestCommonPrefix(strArray1));

        //////////////////////////////////////////////////////
        //                   KMP Algorithm                  //
        //////////////////////////////////////////////////////
    }

    public static boolean isAnagram(String s, String t) {
        //brute force approach is to sort both string after making into char array
        //post sorting compare each character in both array, if all chars match return true

        if(s.length() != t.length())
            return false;

        int[] char_counts = new int[26];

        for(int i = 0; i < s.length(); i++) {
            char_counts[s.charAt(i) - 'a']++;
            char_counts[t.charAt(i) - 'a']--;
        }

        for(int count : char_counts) {
            if(count != 0)
                return false;
        }

        return true;
    }

    private static int maxNumberOfBalloons(String text) {
        int[] char_counts = new int[26];

        for(int i = 0; i < text.length(); i++) {
            char_counts[text.charAt(i) - 'a']++;
        }

        int maxNoBalloon = char_counts[1]; //b
        maxNoBalloon = Math.min(maxNoBalloon, char_counts[0]); //a
        maxNoBalloon = Math.min(maxNoBalloon, char_counts[11]/2); //l
        maxNoBalloon = Math.min(maxNoBalloon, char_counts[14]/2); //o
        maxNoBalloon = Math.min(maxNoBalloon, char_counts[13]); //n

        return maxNoBalloon;
    }

    private static String longestCommonPrefix(String[] strs) {
        if(strs.length == 0)
            return "";

        //Consider the entire first String in the array as prefix
        String prefix = strs[0];

        //Compare other String in the array with prefix
        for(int i = 1; i < strs.length; i++) {
            //Whenever prefix doesn't match with String element
            //reduce the prefix by 1 character each time
            while(strs[i].indexOf(prefix) != 0) {
                prefix = prefix.substring(0, prefix.length()-1);
            }
        }

        return prefix;
    }

}
