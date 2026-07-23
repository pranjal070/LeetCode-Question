class Solution {
public:
    int maximumUniqueSubarray(vector<int>& nums) {
        unordered_set<int> st;
        int sum = 0;
        int ans = 0;
        int j = 0;
        for(int i = 0; i < nums.size(); i++) {
            while(st.find(nums[i]) != st.end()) {
                st.erase(nums[j]);
                sum -= nums[j];
                j++;
            }
            st.insert(nums[i]);
            sum += nums[i];
            ans = max(ans, sum);
        }
        return ans;
    }
};