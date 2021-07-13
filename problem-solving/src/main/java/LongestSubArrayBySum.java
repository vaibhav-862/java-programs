/*
    https://www.youtube.com/watch?v=XFPHg5KjHoo
 */
public class LongestSubArrayBySum {

    public static void main(String[] args) {
        int[] array = {1, 2, 3, 7, 5};
        int sum = 12;

        int[] array1 = {10, 5, 2, 7, 1, 9};
        int sum1 = 15;

        int[] array2 = {-5, 8, -14, 2, 4, 12};
        int sum2 = -5;

        int[] r = findLongestSubarrayBySumBruteForce(sum2, array2);
        System.out.println(r[0] + ", " + r[1]);

        int[] r1 = findLongestSubarrayBySumSlidingWindow(sum2, array2);
        System.out.println(r1[0] + ", " + r1[1]);
    }

    private static int[] findLongestSubarrayBySumBruteForce(int sum, int[] array) {
        int result[] = {-1, -1};

        for(int i = 0; i < array.length; i++) {
            int k = 0;
            for (int j = i; j < array.length; j++) {
                    k += array[j];

                    if (k == sum && result[1] - result[0] <= j - i) {
                        result[0] = i;
                        result[1] = j;
                    }
            }
        }

        return result;
    }

    private static int[] findLongestSubarrayBySumSlidingWindow(int sum, int[] array) {
        int[] result = new int[]{-1, -1};
        int left = 0;
        int right = 0;
        int current_sum = 0;

        while(right < array.length) {
             current_sum += array[right];
             while(left < right && current_sum > sum) {
                 current_sum -= array[left++];
             }
             if(current_sum == sum && result[1] - result[0] <= right - left) {
                result[0] = left;
                result[1] = right;
             }
            right++;
        }

        return result;
    }
}
