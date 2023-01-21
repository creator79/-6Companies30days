class Solution {

    public int subarrayGCD(int[] nums, int k) {
          int ans=0;
        for(int i=0;i<nums.length;i++){
            int temp=nums[i];
            if(temp==k){
                ans++;
            }
            for(int j=i+1;j<nums.length;j++){
                if(nums[j]>=k){
                    temp=gcd(nums[j],temp);
                    if(temp==k){
                        ans++;
                    }
                }
                else{
                    break;
                }
            }
        }
    return ans;
    }

    private int gcd(int a, int b) {
        if (b == 0) {
            return a;
        }
        return gcd(b, a % b);
    }
}
