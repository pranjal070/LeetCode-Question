
class Solution {
public:
    int maximumProduct(vector<int>& nums) {
        sort(nums.begin(), nums.end());

        int n = nums.size();

        return max(nums[0] * nums[1] * nums[n - 1],
                   nums[n - 1] * nums[n - 2] * nums[n - 3]);
    }
};
// class Solution {
// public:
//     int maximumProduct(vector<int>& nums) {
//         int ans = INT_MIN;

//         for (int i = 0; i < nums.size(); i++) {
//             for (int j = i + 1; j < nums.size(); j++) {
//                 for (int k = j + 1; k < nums.size(); k++) {
//                     int product = nums[i] * nums[j] * nums[k];
//                     if (product > ans) {
//                         ans = product;
//                     }
//                 }
//             }
//         }

//         return ans;
//     }
// };