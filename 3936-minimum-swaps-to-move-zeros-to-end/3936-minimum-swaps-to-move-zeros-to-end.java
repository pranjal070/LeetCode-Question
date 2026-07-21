class Solution {
    public int minimumSwaps(int[] nums) {
        int zero = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0)
                zero++;
        }
        int correct = 0;
        for (int i = nums.length - zero; i < nums.length; i++) {
            if (i >= 0 && nums[i] == 0)
                correct++;
        }
        return zero - correct;
    }
}