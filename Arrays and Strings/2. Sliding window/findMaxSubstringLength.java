// You are given a binary string s (a string containing only "0" and "1")
// You may choose up to one "0" and flip it to a "1"
// What is the length of the longest substring achievable that contains only "1"?

// For example, given s = "1101100111", the answer is 5
// If you perform the flip at index 2, the string becomes 1111100111

// another way to look at this problem is "what is the longest substring that contains at most one "0"?"
// solve with a sliding window where our condition is window.count("0") <= 1

// Time O(n)
// Space O(1)

public int findMaxSubstringLength(String s) {
    int left = 0;
    int curr = 0;   // current number of zeros in the window
    int ans = 0;    // to keep track of the maximum possible length

    for (int right = 0; right < s.length(); right++) {  // traverse right pointer starting at zero index
        if (s.charAt(right) == '0') {       // when string '0' is encountered
            curr++;                         // increment the zero counter
        }
        while (curr > 1) {                  // when the zero counter is two
            if (s.charAt(left) == '0') {    // 2. if left has finally reached string '0'
                curr--;                     // reduce zero count
            }
            left++;                         // 1 & 3. move the left pointer forward
        }
        ans = Math.max(ans, right - left + 1);  // right-left+1 to get the window length
    }
    return ans;     // return the maximum substring length
}
