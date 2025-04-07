class Solution {
    public boolean solve(int[] nums,int sum,int n,int[][] dp){
        if(sum==0) return true;

        if(sum!=0 && n==0) return false;

        if(dp[n][sum]!=-1) return dp[n][sum]==0?false:true;

        boolean exc=solve(nums,sum,n-1,dp);

        boolean inc=false;
        if(nums[n-1]<=sum) inc=solve(nums,sum-nums[n-1],n-1,dp);

        dp[n][sum]=exc || inc?1:0;
        return exc || inc;
    }
    public boolean canPartition(int[] nums) {
        int n=nums.length;
        int sum=0;

        for(int it:nums) sum+=it;

        if((sum&1)==1) return false;

        int[][] dp=new int[n+1][(sum/2)+1];
        for(int[] row:dp){
            Arrays.fill(row,-1);
        }

        return solve(nums,sum/2,n,dp);
    }
}