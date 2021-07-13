
/*
    LCS Count logic : https://www.youtube.com/watch?v=sSno9rV8Rhg
    Printing LCS logic : https://www.geeksforgeeks.org/printing-longest-common-subsequence/
 */

public class LongestCommonSubsequence {

    public static void main(String[] args) {
        String text1 = "AGGTAB";
        String text2 = "GXTXAYB";

        int result = longestCommonSubsequence(text1, text2);
        System.out.println("Result : " + result);
    }

    private static int longestCommonSubsequence(String text1, String text2) {
        int m = text1.length();
        int n = text2.length();

        char[] inputArr1 = text1.toCharArray();
        char[] inputArr2 = text2.toCharArray();

        int[][] result = new int[m+1][n+1];

        for(int row = 0; row <= m; row++) {
            for (int col = 0; col <= n; col++) {
                if(row == 0 || col == 0)
                    result[row][col] = 0;
                else if(inputArr1[row - 1] == inputArr2[col - 1])
                    result[row][col] = 1 + result[row - 1][col - 1];
                else
                    result[row][col] = Math.max(result[row - 1][col], result[row][col -1]);
            }
        }

        // Following code is used to print LCS
        int resultIndex = result[m][n];
        int temp = resultIndex;

        // Create a character array to store the lcs string
        char[] lcs = new char[resultIndex + 1];
        lcs[resultIndex] = '\u0000'; // Set the terminating character

        // Start from the right-most-bottom-most corner and
        // one by one store characters in lcs[]
        int i = m;
        int j = n;

        while (i > 0 && j > 0) {
            // If current character in X[] and Y are same, then
            // current character is part of LCS
            if(inputArr1[i -1] == inputArr2[j - 1]) {
                // Put current character in result
                lcs[resultIndex - 1] = inputArr1[i - 1];

                // reduce values of i, j and index
                i--;
                j--;
                resultIndex--;
            }

            // If not same, then find the larger of two and
            // go in the direction of larger value
            else if (result[i - 1][j] > result[i][j - 1])
                i--;
            else
                j--;
        }

        // Print the lcs
        System.out.print("LCS of " + text1 + " and " + text2 + " is : ");
        for(int k = 0; k <= temp; k++)
            System.out.print(lcs[k]);

        return temp;
    }

}
