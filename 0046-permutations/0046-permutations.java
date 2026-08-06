class Solution {

    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        perm(nums, ans, 0, nums.length - 1);
        return ans;
    }
    public void perm(int[] nums, List<List<Integer>> ans, int low, int high) {
        if (low > high) {
            return;
        }
        if (low == high) {
            List<Integer> temp = new ArrayList<>();
            for (int num : nums) {
                temp.add(num);
            }
            ans.add(temp);
            return;
        }

        for (int i = low; i <= high; i++) {
            swap(nums, low, i);
            perm(nums, ans, low + 1, high);
            swap(nums, low, i);  
        }
    }
    public void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}