class Solution {
public:
    int maxArea(vector<int>& n) {
        int left=0;
        int right=n.size()-1;
        int maxwater=0;
        while(left<right){
            int water=min(n[left],n[right])*(right-left);
            maxwater=max(maxwater,water);
            if(n[left]<n[right]){
                left++;
            }
            else{
                right--;
            }           
        }
        return maxwater;
    }
};