// Given an array of positive integers nums and an integer k
// find the length of the longest subarray whose sum is less than or equal to k
// example: nums = [3, 1, 2, 7, 4, 2, 1, 1, 5] and k = 8
// The longest subarray is [4, 2, 1, 1] which means the answer is 4

// Time O(n); all work inside for loop is amortized O(1)
// Space O(1); only use 3 integer variables

public int findMaxSubarrayLength(int[] nums, int k) {
    int left = 0;   // left pointer
    int curr = 0;   // current sum of the window
    int ans = 0;    // to keep track of the maximum possible length

    for (int right = 0; right < nums.length; right++) {     // right also starts at 0
        curr += nums[right];
        while (curr > k) {      // if current sum is greater than target k
            curr -= nums[left]; // subtract the left value and move the left pointer forward
            left++;             // move left pointer forward
        }
        ans = Math.max(ans, right - left + 1);  // right-left+1 is the formula to get the window length
    }
    return ans; // return the length of the longest subarray
}