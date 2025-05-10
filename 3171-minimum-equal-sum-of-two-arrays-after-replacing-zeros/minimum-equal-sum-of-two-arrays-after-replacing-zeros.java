class Solution {
    public long minSum(int[] nums1, int[] nums2) {
        long a = 0,b = 0;
        long c = 0,d = 0;
        for(int i=0;i<nums1.length;i++){
            a += nums1[i];
            if(nums1[i] == 0){
                c++;
            }
        }
        for(int i=0;i<nums2.length;i++){
            b += nums2[i];
            if(nums2[i] == 0){
                d++;
            }
        }
        if(a+c == d+b){
            return a+c;
        }
        else if(a+c > d+b){
            if(d>0){
                return a+c;
            }
            else{
                return -1;
            }
        }
        else{
            if(c>0){
                return d+b;
            }
            else{
                return -1;
            }
        }
    }
}