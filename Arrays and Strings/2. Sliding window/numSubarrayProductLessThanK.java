// Given an array of positive integers nums and an integer k
// return the # of subarrays where the product of all elements in subarray is strictly less than k.

// For example, given the input nums = [10, 5, 2, 6], k = 100, the answer is 8
// The subarrays with products less than k are:
// [10], [5], [2], [6], [10, 5], [5, 2], [2, 6], [5, 2, 6]

// note that if k <= 1 we can never have any valid windows, so we can just return 0 immediately.

// Time O(n)
// Space O(1)

public int numSubarrayProductLessThanK (int[] nums, int k) {
    if (k <= 1) return 0;

    int left = 0;
    int curr = 1;   // current product
    int ans = 0;

    for (int right = 0; right < nums.length; right++) {
        curr *= nums[right];        // keep multiplying the new right element
        while (curr >= k) {          // if curr breaks the condition
            curr /= nums[left];     // remove the left element by dividing it from the curr
            left++;                 // move the left pointer forward
        }
        ans += right - left + 1;    // add the current window size, which equals # of valid subarrays
    }
    return ans;         // 1 + 2 + 2 + 3 = 8
}