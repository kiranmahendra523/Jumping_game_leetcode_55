class Solution {
    public boolean canJump(int[] nums) {
        if(nums.length==1){
            return true;
        }
        if(nums[0]==0){
            return false;
        }
        
        boolean []dp = new boolean[nums.length];
        dp[0] = true;
        for(int i=0;i<nums.length;i++){
            if(nums[i]==0){
                int flag=1;
                int k=0;
                int l = 2;
                for(k=i-1;k>=0;k--){
                    if(nums[k]>=l){
                       flag=0; 
                       break; 
                    }
                    l++;
                }
                if(flag==1){
                    return false;
                }
                continue;
            }
            for(int j=1;j<=nums[i]&&j<nums.length&&(i+j)<nums.length;j++){
                if(nums[i+j]!=0||(i+j)==nums.length-1){
                    dp[i+j] = true;
                }
                if(dp[nums.length-1]){
                    return true;
                }
            }
        }
        return false;
    }
}
