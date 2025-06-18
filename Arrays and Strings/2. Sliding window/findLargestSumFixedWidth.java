// Given an integer array nums and an integer k,
// find the sum of the subarray with the largest sum whose length is k.
// example nums = [3, -1, 4, 12, -8, 5, 6]  k = 4
// ans = 18 (first four elements)

// Time O(n)
// space O(1)

public int findLargestSumFixedWidth(int[] nums, int k) {
    int curr = 0;
    for (int i = 0; i < k; i++) {   // calculate the sum of the first window
        curr += nums[i];
    }
    int ans = curr;
    for (int i = k; i < nums.length; i++) {
        curr += nums[i] - nums[i - k];  // add the next element (starts at k index) and remove the first place element
        ans = Math.max(ans, curr);  // update the answer
    }
    return ans; // return the largest sum
}