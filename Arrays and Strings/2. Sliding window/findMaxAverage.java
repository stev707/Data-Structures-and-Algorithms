// You are given an integer array nums consisting of n elements, and an integer k
// Find a contiguous subarray whose length is equal to k that has the maximum average value and return this value.

// Input: nums = [1,12,-5,-6,50,3], k = 4
// Output: 12.75000
// Explanation: Maximum average is (12 - 5 - 6 + 50) / 4 = 51 / 4 = 12.75

// Input: nums = [5], k = 1
// Output: 5.00000

public double findMaxAverage(int[] nums, int k) {
    double sum = 0;
    for (int i = 0; i < k; i++) {
        sum += nums[i];
    }
    double result = sum;        // first sum result

    for (int i = k; i < nums.length; i++) {     // iterate from index at k, until the end of the array
        sum += nums[i] - nums[i - k];           // add new element and subtract the leftmost element
        result = Math.max(result, sum);         // get the max by comparing the first sum with the next sums
    }
    return result/k;    // calculate the average by dividing the max sum by the length k
}
