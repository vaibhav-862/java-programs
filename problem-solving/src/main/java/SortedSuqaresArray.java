import java.util.Arrays;
/*
    https://www.youtube.com/watch?v=4eWKHLSRHPY
 */

public class SortedSuqaresArray {

    public static void main(String[] args) {
        int[] nums = {-4,-1,0,3,10};

        int[] result = sortedSquaresBruteForce(nums);

        System.out.println("Brute force result : ");
        for(int r : result)
            System.out.println(r);

        int[] nums1 = {-7,-3,2,3,11};

        result = sortedSquares(nums1);

        System.out.println("O(n) result : ");
        for(int r : result)
            System.out.println(r);
    }

    private static int[] sortedSquaresBruteForce(int[] nums) {
        int[] result = new int[nums.length];
        for(int i = 0; i < nums.length; i++) {
            result[i] = nums[i] * nums[i];
        }

        Arrays.sort(result);

        return result;
    }

    private static int[] sortedSquares(int[] nums) {
        int left = 0;
        int right = nums.length - 1;
        int[] result = new int[nums.length];

        for(int i = nums.length - 1; i >= 0; i--) {
            if (Math.abs(nums[left]) >= Math.abs(nums[right])) {
                result[i] = nums[left] * nums[left];
                left++;
            } else {
                result[i] = nums[right] * nums[right];
                right--;
            }
        }

        return result;
    }

}
