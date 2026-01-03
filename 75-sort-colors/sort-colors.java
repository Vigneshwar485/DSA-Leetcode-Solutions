class Solution {
    public void sortColors(int[] nums) {

        /*
        if i  encounter 2 swap it r and move r 
        if i encounter  0 swap it with l and move both l  and i 
        else if 1 just move i 
        Simple.......

        */
        int n = nums.length;

        int  l = 0;                                                   // temp = a
                                                                    //  a= b
                                                                    //b =temp
        int r =n -1 ;

        for(int i = 0 ;i <= r ; ){
            if(nums[i] == 2){
                int temp = nums[i];
                nums[i] = nums[r];
                nums[r] = temp;
                r--;
            }
            else if(nums[i] == 0){
                int temp = nums[i];
                nums[i] = nums[l];
                nums[l] = temp;
                l++;
                i++;

            }
            else{
                i++;
            }
        }
     

    }
}