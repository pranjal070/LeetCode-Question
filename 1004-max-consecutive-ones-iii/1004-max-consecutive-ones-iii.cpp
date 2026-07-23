class Solution {
public:
    int longestOnes(vector<int>& nums, int k) {

        int  left=0;
        int maxl=0;
        int zero=0;
        for(int i=0;i<nums.size();i++){
            if(nums[i]==0){
                zero++;
            }
            while(zero>k){
                if(nums[left]==0){
                    zero--;
                }
                left++;
            }
            maxl=max(maxl,i-left+1);
            
        }
        return maxl;

        
    }
};