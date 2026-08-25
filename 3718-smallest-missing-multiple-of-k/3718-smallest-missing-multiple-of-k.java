class Solution {
    public int missingMultiple(int[] nums, int k) {
        int n = nums.length;
        for (int i = 1; i <= n + 1; i++) {
            int multiple = i * k;
            boolean found = false;
            for (int j = 0; j < n; j++) {
                if (nums[j] == multiple) {
                    found = true;
                    break;
                }
            }
            if (!found) {
                return multiple;
            }
        }
        return -1;
    }
}