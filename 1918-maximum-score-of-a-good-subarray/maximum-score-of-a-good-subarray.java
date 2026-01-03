class Solution {
    public int maximumScore(int[] nums, int k) {
        int n = nums.length;
        int i = k;
        int j = k;
        int res = nums[k];
        int currMin = nums[k];

        while( i > 0 || j < n - 1 ) {
            int leftValue = ( i > 0 ) ? nums[i - 1] : 0;
            int rightValue = (j < n - 1) ? nums[j + 1] : 0;

            if( leftValue > rightValue ) {
                currMin = Math.min( nums[i - 1], currMin );
                i -= 1;
            }
            else{
                currMin = Math.min( nums[j + 1], currMin );
                j += 1;
            }

            res = Math.max( res, (currMin * (j - i + 1)) );
        }
        return res;
    }
}