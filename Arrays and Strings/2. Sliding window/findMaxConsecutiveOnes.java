// Given a binary array nums and an integer k,
// return the maximum number of consecutive 1's in the array if you can flip at most k 0's.

// Input: nums = [1,1,1,0,0,0,1,1,1,1,0], k = 2
// Output: 6
// Explanation: [1,1,1,0,0,1,1,1,1,1,1] last two zeros from the right side can be flipped to 1s

// Time O(n)
// Space O(1)

public int findMaxConsecutiveOnes(int[] nums, int k) {
    int left = 0;   // left pointer
    int curr = 0;   // 0 counter
    int ans = 0;    // answer

    for (int right = 0; right < nums.length; right++) {     // iterate from index 0 using right pointer
        if (nums[right] == 0) {     // if 0 is encountered, increment the counter
            curr++;
        }
        while (curr > k) {          // if the counter exceeds the k (number of 0s that can be flipped at most)
            if (nums[left] == 0) {  // 2. if the left pointer value is 0
                curr--;             // decrement the counter
            }
            left++;                 // 1 & 3. move the left pointer forward
        }
        ans = Math.max(ans, right - left + 1);      // get the max sliding window width
    }
    return ans;     // return the max consecutive length
}
