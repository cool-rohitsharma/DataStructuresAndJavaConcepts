import java.lang.*;

class Solution {
    public void rotate(int[] nums, int k) {
        int n = nums.length;
        
        k %= n;

        reverse(nums, 0, n-1); //rotate whole array
        
        reverse(nums, 0, k-1); // rotate kth array

        reverse(nums, k, n-1); // rotate k to n-1 array

    }
        private void reverse(int[] nums, int start, int end){
            //use two pointers
            while(start < end){
                int temp = nums[start];
                nums[start] = nums[end];
                nums[end] = temp;
                start++;
                end--;
        }
    }
}