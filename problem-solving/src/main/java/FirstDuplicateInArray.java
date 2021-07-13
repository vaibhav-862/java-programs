import java.util.HashSet;

/*
    https://www.youtube.com/watch?v=XSdr_O-XVRQ
 */
public class FirstDuplicateInArray {

    public static void main(String[] args) {
        int[] nums = {2, 4, 3, 5, 1};

        int resultIndex = firstDuplicateBruteForce(nums);
        System.out.println("Brute force result found at index : " + resultIndex);


        nums = new int[]{2, 1, 3, 5, 3, 2};
        resultIndex = firstDuplicateHashSet(nums);
        System.out.println("Brute force result found at index : " + resultIndex);

        nums = new int[]{2, 1, 3, 5, 3, 2};
        resultIndex = firstDuplicate(nums);
        System.out.println("Brute force result found at index : " + resultIndex);
    }

    private static int firstDuplicateBruteForce(int[] nums) {
        int resultIndex = nums.length;

        for(int i = 0; i < nums.length; i++) {
            for(int j = i + 1; j < nums.length; j++) {
                if(nums[i] == nums[j] && resultIndex > j)
                    resultIndex = j;
            }
        }

        return resultIndex == nums.length ? -1 : resultIndex;
    }

    private static int firstDuplicateHashSet(int[] nums) {
        int resultIndex = -1;

        HashSet<Integer> seen = new HashSet<>();

        for(int i = 0; i < nums.length; i++) {
            if(seen.contains(nums[i])) {
                resultIndex = i;
                break;
            } else
                seen.add(nums[i]);
        }

        return resultIndex;
    }

    private static int firstDuplicate(int[] nums) {
        int resultIndex = -1;

        for(int i = 0; i < nums.length; i++) {
            if(nums[Math.abs(nums[i]) - 1] < 0) {
                resultIndex = i;
                break;
            } else
                nums[Math.abs(nums[i]) - 1] = -nums[Math.abs(nums[i]) -1];
        }

        return resultIndex;
    }

}
